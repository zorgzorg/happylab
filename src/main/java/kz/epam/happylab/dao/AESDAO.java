package kz.epam.happylab.dao;

import kz.epam.happylab.entity.AES;

import java.sql.*;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import static kz.epam.happylab.util.Constant.DATE;
import static kz.epam.happylab.util.Constant.ZERO;

public class AESDAO implements DAO<AES> {
    private final String INSERT_QUERY = "INSERT INTO journal_aes (`probeId`, `date`, `employeeId`, `Ag`, `Al`, `As`, " +
            "`B`, `Ba`, `Be`, `Bi`, `Ca`, `Cd`, `Co`, `Cr`, `Cu`, `Fe`, `K`, `Li`, `Mg`, `Mn`, `Mo`, `Na`, `Ni`, `P`, " +
            "`Pb`, `S`, `Sb`, `Se`, `Si`, `Sn`, `Sr`, `Ti`, `Tl`, `V`, `W`, `Zn`) " +
            "VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?," +
            "?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
    private final String UPDATE_QUERY = "UPDATE journal_aes SET `probeId` = ?, `date` = ?, `employeeId` = ?, `Ag`=?, " +
            "`Al`=?, `As`=?, `B`=?, `Ba`=?, `Be`=?, `Bi`=?, `Ca`=?, `Cd`=?, `Co`=?, `Cr`=?, `Cu`=?, `Fe`=?, `K`=?, " +
            "`Li`=?, `Mg`=?, `Mn`=?, `Mo`=?, `Na`=?, `Ni`=?, `P`=?, `Pb`=?, `S`=?, `Sb`=?, `Se`=?, `Si`=?, `Sn`=?, " +
            "`Sr`=?, `Ti`=?, `Tl`=?, `V`=?, `W`=?, `Zn`=? WHERE `id` = ?";
    private final String DELETE_QUERY = "UPDATE journal_aes SET `deleted` = -1 WHERE `id` =  ?";
    private final String FINDALL_QUERY = "SELECT p.numberLab, e.lastname AS `assistant`, a.* " +
            "FROM journal_aes AS a " +
            "INNER JOIN probes AS p ON a.probeId=p.id " +
            "INNER JOIN employees AS e ON a.employeeId = e.id " +
            "WHERE a.deleted = 0 " +
            "ORDER BY p.numberLab;";
    private final String FINDBYID_QUERY = "SELECT p.numberLab, e.lastname AS `assistant`, a.* " +
            "FROM journal_aes AS a " +
            "INNER JOIN probes AS p ON a.probeId = p.id " +
            "INNER JOIN employees AS e ON a.employeeId = e.id " +
            "WHERE a.deleted = 0 " +
            "AND a.id = ? " +
            "ORDER BY p.numberLab;";

    private Connection connection;

    public AESDAO(Connection connection) {
        this.connection = connection;
    }

    @Override
    public int insert(AES aes) throws SQLException {
        PreparedStatement stmt = connection.prepareStatement(INSERT_QUERY, Statement.RETURN_GENERATED_KEYS);
        stmt.setInt(1, aes.getProbeId());
        stmt.setDate(2, (Date) aes.getDate());
        stmt.setInt(3, aes.getEmployeeId());
        stmt.setDouble(4, aes.getSilver());
        stmt.setDouble(5, aes.getAluminium());
        stmt.setDouble(6, aes.getArsenic());
        stmt.setDouble(7, aes.getBoron());
        stmt.setDouble(8, aes.getBarium());
        stmt.setDouble(9, aes.getBeryllium());
        stmt.setDouble(10, aes.getBismuth());
        stmt.setDouble(11, aes.getCalcium());
        stmt.setDouble(12, aes.getCadmium());
        stmt.setDouble(13, aes.getCobalt());
        stmt.setDouble(14, aes.getChromium());
        stmt.setDouble(15, aes.getCopper());
        stmt.setDouble(16, aes.getIron());
        stmt.setDouble(17, aes.getPotassium());
        stmt.setDouble(18, aes.getLithium());
        stmt.setDouble(19, aes.getMagnesium());
        stmt.setDouble(20, aes.getManganese());
        stmt.setDouble(21, aes.getMolybdenum());
        stmt.setDouble(22, aes.getSodium());
        stmt.setDouble(23, aes.getNickel());
        stmt.setDouble(24, aes.getPhosphorus());
        stmt.setDouble(25, aes.getLead());
        stmt.setDouble(26, aes.getSulphur());
        stmt.setDouble(27, aes.getAntimony());
        stmt.setDouble(28, aes.getSelenium());
        stmt.setDouble(29, aes.getSilicon());
        stmt.setDouble(30, aes.getTin());
        stmt.setDouble(31, aes.getStrontium());
        stmt.setDouble(32, aes.getTitanium());
        stmt.setDouble(33, aes.getThallium());
        stmt.setDouble(34, aes.getVanadium());
        stmt.setDouble(35, aes.getTungsten());
        stmt.setDouble(36, aes.getZinc());
        stmt.executeUpdate();
        ResultSet keys = stmt.getGeneratedKeys();
        keys.next();
        int lastId = keys.getInt(1);
        stmt.close();
        return lastId;
    }

    @Override
    public void update(AES aes) throws SQLException {
        PreparedStatement stmt = connection.prepareStatement(UPDATE_QUERY);
        stmt.setInt(1, aes.getProbeId());
        stmt.setDate(2, (Date) aes.getDate());
        stmt.setInt(3, aes.getEmployeeId());
        stmt.setDouble(4, aes.getSilver());
        stmt.setDouble(5, aes.getAluminium());
        stmt.setDouble(6, aes.getArsenic());
        stmt.setDouble(7, aes.getBoron());
        stmt.setDouble(8, aes.getBarium());
        stmt.setDouble(9, aes.getBeryllium());
        stmt.setDouble(10, aes.getBismuth());
        stmt.setDouble(11, aes.getCalcium());
        stmt.setDouble(12, aes.getCadmium());
        stmt.setDouble(13, aes.getCobalt());
        stmt.setDouble(14, aes.getChromium());
        stmt.setDouble(15, aes.getCopper());
        stmt.setDouble(16, aes.getIron());
        stmt.setDouble(17, aes.getPotassium());
        stmt.setDouble(18, aes.getLithium());
        stmt.setDouble(19, aes.getMagnesium());
        stmt.setDouble(20, aes.getManganese());
        stmt.setDouble(21, aes.getMolybdenum());
        stmt.setDouble(22, aes.getSodium());
        stmt.setDouble(23, aes.getNickel());
        stmt.setDouble(24, aes.getPhosphorus());
        stmt.setDouble(25, aes.getLead());
        stmt.setDouble(26, aes.getSulphur());
        stmt.setDouble(27, aes.getAntimony());
        stmt.setDouble(28, aes.getSelenium());
        stmt.setDouble(29, aes.getSilicon());
        stmt.setDouble(30, aes.getTin());
        stmt.setDouble(31, aes.getStrontium());
        stmt.setDouble(32, aes.getTitanium());
        stmt.setDouble(33, aes.getThallium());
        stmt.setDouble(34, aes.getVanadium());
        stmt.setDouble(35, aes.getTungsten());
        stmt.setDouble(36, aes.getZinc());
        stmt.setInt(37, aes.getId());
        stmt.executeUpdate();
        stmt.close();
    }

    @Override
    public void delete(AES aes) throws SQLException {
        PreparedStatement stmt = connection.prepareStatement(DELETE_QUERY);
        stmt.setInt(1, aes.getId());
        stmt.executeUpdate();
        stmt.close();
    }

    @Override
    public List<AES> findAll() throws SQLException {
        throw new UnsupportedOperationException();
    }

    public List<Map<String, Object>> findAllMap() throws SQLException {
        PreparedStatement stmt = connection.prepareStatement(FINDALL_QUERY);
        ResultSet rs = stmt.executeQuery();

        List<Map<String, Object>> rows = new ArrayList<>();
        ResultSetMetaData metaData = rs.getMetaData();
        int columnCount = metaData.getColumnCount();

        while (rs.next()) {
            Map<String, Object> columns = new LinkedHashMap<>();
            for (int i = 1; i <= columnCount; i++) {
                columns.put(metaData.getColumnLabel(i), rs.getObject(i));
            }
            rows.add(columns);
        }

        rs.close();
        stmt.close();
        return rows;
    }

    @Override
    public AES findById(int id) throws SQLException {
        throw new UnsupportedOperationException();
    }

    public List<Map<String, Object>> findByIdMap(int id) throws SQLException {
        PreparedStatement stmt = connection.prepareStatement(FINDBYID_QUERY);
        stmt.setInt(1, id);
        ResultSet rs = stmt.executeQuery();

        List<Map<String, Object>> rows = new ArrayList<>();
        ResultSetMetaData metaData = rs.getMetaData();
        int columnCount = metaData.getColumnCount();

       while (rs.next()) {
            Map<String, Object> columns = new LinkedHashMap<>();
            for (int i = 1; i <= columnCount; i++) {
                columns.put(metaData.getColumnLabel(i), rs.getObject(i));
            }
            rows.add(columns);
        }

        rs.close();
        stmt.close();
        return rows;
    }

    public List<Map<String, Object>> create(int id) throws SQLException {
        PreparedStatement stmt = connection.prepareStatement(FINDBYID_QUERY);
        stmt.setInt(1, id);
        ResultSet rs = stmt.executeQuery();

        List<Map<String, Object>> rows = new ArrayList<>();
        ResultSetMetaData metaData = rs.getMetaData();
        int columnCount = metaData.getColumnCount();
        Map<String, Object> columns = new LinkedHashMap<>();

        for (int i = 1; i <= columnCount; i++) {
            if(DATE.equalsIgnoreCase(metaData.getColumnLabel(i))) {
                columns.put(metaData.getColumnLabel(i),new java.util.Date());
            } else {
                columns.put(metaData.getColumnLabel(i), ZERO);
            }
        }

        rows.add(columns);

        rs.close();
        stmt.close();
        return rows;
    }
}
