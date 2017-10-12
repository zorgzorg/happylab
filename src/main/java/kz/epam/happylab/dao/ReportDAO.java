package kz.epam.happylab.dao;

import java.sql.*;
import java.util.*;

import static kz.epam.happylab.util.Constant.*;

public class ReportDAO {
    private static final String PSA="psa";
    private static final String SANPIN="sanpin";
    private static final String CONTENT = "content";
    private final String FINDBYID_AES_QUERY = "SELECT p.numberLab, e.lastname AS `assistant`, a.* " +
            "FROM journal_aes AS a " +
            "INNER JOIN probes AS p ON a.probeId = p.id " +
            "INNER JOIN employees AS e ON a.employeeId = e.id " +
            "WHERE a.deleted = 0 " +
            "AND a.id = ? " +
            "ORDER BY p.numberLab";
    private final String FINDBYID_PSA_QUERY = "SELECT p.numberLab, e.lastname AS `assistant`, a.* " +
            "FROM journal_psa AS a " +
            "INNER JOIN probes AS p ON a.probeId = p.id " +
            "INNER JOIN employees AS e ON a.employeeId = e.id " +
            "WHERE a.deleted = 0 " +
            "AND a.id = ? " +
            "ORDER BY p.numberLab";
    private final String FINDBYID_SANPIN_QUERY = "SELECT p.numberLab, e.lastname AS `assistant`, a.* " +
            "FROM journal_sanpin AS a " +
            "INNER JOIN probes AS p ON a.probeId = p.id " +
            "INNER JOIN employees AS e ON a.employeeId = e.id " +
            "WHERE a.deleted = 0 " +
            "AND a.id = ? " +
            "ORDER BY p.numberLab";
    private final String FINDLIMITS_QUERY = "SELECT `limit`, `element`, `unit`,  `pdk`, `nd` FROM limits " +
            "WHERE `analysis` = ? AND `deleted` = 0 ORDER BY `id`";
    private final String FINDANALYSIS_QUERY = "SELECT `id` FROM analyses WHERE `code` LIKE ?";
    private final String FINDHEADLABORATORY_QUERY = "SELECT CONCAT(`lastname`, ' ', LEFT(`name`, 1), '. ', " +
            "LEFT(`surname`, 1), '.') AS signature FROM employees WHERE `signature` = -1;";
    private Connection connection;

    public ReportDAO(Connection connection) {
        this.connection = connection;
    }

    public int findAnalysisId(String analysis) throws SQLException {
        PreparedStatement stmt = connection.prepareStatement(FINDANALYSIS_QUERY);
        stmt.setString(1, analysis);
        ResultSet rs = stmt.executeQuery();
        int analysisId = ZERO;

        while (rs.next()) {
            analysisId = rs.getInt(ID);
        }

        rs.close();
        stmt.close();
        return analysisId;
    }

    public List<Map<String, Object>> findByIdReport(int recordId, String analysis) throws SQLException {

        int analysisId = findAnalysisId(analysis);
        String query = FINDBYID_AES_QUERY;

        if (PSA.equalsIgnoreCase(analysis)) {
            query = FINDBYID_PSA_QUERY;
        }
        if (SANPIN.equalsIgnoreCase(analysis)) {
            query = FINDBYID_SANPIN_QUERY;
            return formReportSanpin(recordId, analysisId, query);
        }

        return formReport(recordId, analysisId, query);
    }

    private List<Map<String, Object>> formReport(int recordId, int analysisId, String query) throws SQLException {

        PreparedStatement stmt = connection.prepareStatement(query);
        stmt.setInt(1, recordId);
        ResultSet rs = stmt.executeQuery();

        List<Map<String, Object>> rows = new ArrayList<>();
        ResultSetMetaData metaData = rs.getMetaData();
        int columnCount = metaData.getColumnCount();
        Map limits = getLimits(analysisId);
        Set<String> keys = limits.keySet();
        String value;

        while (rs.next()) {
            Map<String, Object> columns = new LinkedHashMap<>();
            for (String k : keys) {
                for (int i = 1; i <= columnCount; i++) {
                    if (k.equals(metaData.getColumnLabel(i))) {
                        if ((Double) rs.getObject(i) < (Double) limits.get(k)) {
                            value = "< " + limits.get(k);
                        } else {
                            value = "" + rs.getObject(i);
                        }
                        columns.put(metaData.getColumnLabel(i), value);
                    }
                    if (ASSISTANT.equals(metaData.getColumnLabel(i))) {
                        columns.put(metaData.getColumnLabel(i), rs.getObject(i));
                    }
                }
            }
            rows.add(columns);
        }

        rs.close();
        stmt.close();
        return rows;
    }

    private List<Map<String, Object>> formReportSanpin(int recordId, int analysisId, String query) throws SQLException {
        String value;
        Double limit = 0d;
        Double content = 0d;
        List<Map<String, Object>> rows = new ArrayList<>();
        Map<String, Object> result = new LinkedHashMap<>();

        PreparedStatement stmt = connection.prepareStatement(query);
        stmt.setInt(1, recordId);
        ResultSet rs = stmt.executeQuery();
        ResultSetMetaData metaData = rs.getMetaData();
        int columnCount = metaData.getColumnCount();

        while (rs.next()) {
            for (int i = 1; i <= columnCount; i++) {
                result.put(metaData.getColumnLabel(i), rs.getObject(i));
            }
        }

        stmt = connection.prepareStatement(FINDLIMITS_QUERY);
        stmt.setInt(1, analysisId);
        ResultSet limits = stmt.executeQuery();

        ResultSetMetaData metaDataLimits = limits.getMetaData();
        int columnCountLimits = metaDataLimits.getColumnCount();

        while (limits.next()) {
            Map<String, Object> columns = new LinkedHashMap<>();
            for (int i = 1; i <= columnCountLimits; i++) {
                columns.put(metaDataLimits.getColumnLabel(i), limits.getObject(i));
                if (ELEMENT.equalsIgnoreCase(metaDataLimits.getColumnLabel(i))) {
                    if(columns.get(LIMIT)!=null) {
                        limit = (Double) columns.get(LIMIT);
                    }
                    if(result.get(limits.getObject(i))!=null) {
                        content = (Double) result.get(limits.getObject(i));
                    }
                    if (content < limit) {
                        value = "< " + columns.get(LIMIT);
                    } else {
                        value = "" + result.get(limits.getObject(i));
                    }
                    columns.put(CONTENT, value);
                }
                columns.put(ASSISTANT, result.get(ASSISTANT ));
            }
            rows.add(columns);
        }

        rs.close();
        stmt.close();
        return rows;
    }

    public Map<String, Double> getLimits(int id) throws SQLException {
        Map<String, Double> limits = new LinkedHashMap<>();

        PreparedStatement stmt = connection.prepareStatement(FINDLIMITS_QUERY);
        stmt.setInt(1, id);
        ResultSet rs = stmt.executeQuery();

        while (rs.next()) {
            limits.put(rs.getString(ELEMENT), rs.getDouble(LIMIT));
        }

        rs.close();
        stmt.close();
        return limits;
    }

    public String findHeadLaboratory() throws SQLException {
        PreparedStatement stmt = connection.prepareStatement(FINDHEADLABORATORY_QUERY);
        ResultSet rs = stmt.executeQuery();
        String headLaboratory=EMPTY_PARAMETER;

        while(rs.next()){
            headLaboratory=rs.getString(SIGNATURE);
        }

        rs.close();
        stmt.close();
        return headLaboratory;
    }
}
