package kz.epam.happylab.dao;

import kz.epam.happylab.entity.Sanpin;

import java.sql.*;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import static kz.epam.happylab.util.Constant.DATE;
import static kz.epam.happylab.util.Constant.ZERO;

public class SanpinDAO implements DAO<Sanpin> {
    private final String INSERT_QUERY = "INSERT INTO journal_sanpin (`probeId`, `date`, `employeeId`, `Ag`, `Al`, `As`, " +
            "`B`, `Ba`, `Be`, `Bi`, `Cd`, `Co`, `Cr6`, `Cr`, `Cu`, `Fe`, `Li`, `Mn`, `Mo`, `Nb`, `Na+Ka`, `Ni`, `NH3`, " +
            "`NO2`, `Pb`, `Sb`, `Se`, `SiAcid`, `Si`, `Sr`, `Te`, `Rodanide`, `Tl`, `V`, `W`, `Zn`, `odour`, `flavor`, " +
            "`chromaticity`, `turbidity`, `hydrogenIndex`, `mineralization`, `dryResidue`, `anion`, `stiffness`, " +
            "`oilProduct`, `nitrate`, `permaganate`, `sulfate`, `fluoride`, `phenolicIndex`, `chloride`, `cyanide`, " +
            "`dissolvedOxygen`, `biologicalOxygenDemand`, `chemicalOxygenDemand`, `suspendedSolid`, `pesticideLindane`, " +
            "`pesticideIsomer`, `radioactivityA`, `radioactivityB`, `polyphosphate`, `mercury`) " +
            "VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?," +
            "?,?,?,?,?,?,?,?,?,?,?,?,?)";
    private final String UPDATE_QUERY = "UPDATE journal_sanpin SET `probeId` = ?, `date` = ?, `employeeId` = ?, `Ag`=?, " +
            "`Al`=?, `As`=?, `B`=?, `Ba`=?, `Be`=?, `Bi`=?, `Cd`=?, `Co`=?, `Cr6`=?, `Cr`=?, `Cu`=?, `Fe`=?, `Li`=?, " +
            "`Mn`=?, `Mo`=?, `Nb`=?, `Na+Ka`=?, `Ni`=?, `NH3`=?, `NO2`=?, `Pb`=?, `Sb`=?, `Se`=?, `SiAcid`=?, `Si`=?, " +
            "`Sr`=?, `Te`=?, `Rodanide`=?, `Tl`=?, `V`=?, `W`=?, `Zn`=?, `odour`=?, `flavor`=?, `chromaticity`=?, " +
            "`turbidity`=?, `hydrogenIndex`=?, `mineralization`=?, `dryResidue`=?, `anion`=?, `stiffness`=?, " +
            "`oilProduct`=?, `nitrate`=?, `permaganate`=?, `sulfate`=?, `fluoride`=?, `phenolicIndex`=?, `chloride`=?, " +
            "`cyanide`=?, `dissolvedOxygen`=?, `biologicalOxygenDemand`=?, `chemicalOxygenDemand`=?, `suspendedSolid`=?, " +
            "`pesticideLindane`=?, `pesticideIsomer`=?, `radioactivityA`=?, `radioactivityB`=?, `polyphosphate`=?," +
            "`mercury`=? WHERE `id` = ?";
    private final String DELETE_QUERY = "UPDATE journal_sanpin SET `deleted` = -1 WHERE `id` =  ?";
    private final String FINDALL_QUERY = "SELECT p.numberLab, e.lastname AS `assistant`, a.* " +
            "FROM journal_sanpin AS a " +
            "INNER JOIN probes AS p ON a.probeId=p.id " +
            "INNER JOIN employees AS e ON a.employeeId = e.id " +
            "WHERE a.deleted = 0 " +
            "ORDER BY p.numberLab;";
    private final String FINDBYID_QUERY = "SELECT p.numberLab, e.lastname AS `assistant`, a.* " +
            "FROM journal_sanpin AS a " +
            "INNER JOIN probes AS p ON a.probeId = p.id " +
            "INNER JOIN employees AS e ON a.employeeId = e.id " +
            "WHERE a.deleted = 0 " +
            "AND a.id = ? " +
            "ORDER BY p.numberLab;";

    private Connection connection;

    public SanpinDAO(Connection connection) {
        this.connection = connection;
    }
    @Override
    public int insert(Sanpin sanpin) throws SQLException {
        PreparedStatement stmt = connection.prepareStatement(INSERT_QUERY, Statement.RETURN_GENERATED_KEYS);
        stmt.setInt(1, sanpin.getProbeId());
        stmt.setDate(2, (Date) sanpin.getDate());
        stmt.setInt(3, sanpin.getEmployeeId());
        stmt.setDouble(4, sanpin.getSilver());
        stmt.setDouble(5, sanpin.getAluminium());
        stmt.setDouble(6, sanpin.getArsenic());
        stmt.setDouble(7, sanpin.getBoron());
        stmt.setDouble(8, sanpin.getBarium());
        stmt.setDouble(9, sanpin.getBeryllium());
        stmt.setDouble(10, sanpin.getBismuth());
        stmt.setDouble(11, sanpin.getCadmium());
        stmt.setDouble(12, sanpin.getCobalt());
        stmt.setDouble(13, sanpin.getChromium6());
        stmt.setDouble(14, sanpin.getChromium());
        stmt.setDouble(15, sanpin.getCopper());
        stmt.setDouble(16, sanpin.getIron());
        stmt.setDouble(17, sanpin.getLithium());
        stmt.setDouble(18, sanpin.getManganese());
        stmt.setDouble(19, sanpin.getMolybdenum());
        stmt.setDouble(20, sanpin.getNiobium());
        stmt.setDouble(21, sanpin.getSodiumK());
        stmt.setDouble(22, sanpin.getNickel());
        stmt.setDouble(23, sanpin.getAmmonia());
        stmt.setDouble(24, sanpin.getNitrite());
        stmt.setDouble(25, sanpin.getLead());
        stmt.setDouble(26, sanpin.getAntimony());
        stmt.setDouble(27, sanpin.getSelenium());
        stmt.setDouble(28, sanpin.getSiliconAcid());
        stmt.setDouble(29, sanpin.getSilicon());
        stmt.setDouble(30, sanpin.getStrontium());
        stmt.setDouble(31, sanpin.getTellurium());
        stmt.setDouble(32, sanpin.getRodanideIon());
        stmt.setDouble(33, sanpin.getThallium());
        stmt.setDouble(34, sanpin.getVanadium());
        stmt.setDouble(35, sanpin.getTungsten());
        stmt.setDouble(36, sanpin.getZinc());
        stmt.setDouble(37, sanpin.getOdour());
        stmt.setDouble(38, sanpin.getFlavor());
        stmt.setDouble(39, sanpin.getChromaticity());
        stmt.setDouble(40, sanpin.getTurbidity());
        stmt.setDouble(41, sanpin.getHydrogenIndex());
        stmt.setDouble(42, sanpin.getMineralization());
        stmt.setDouble(43, sanpin.getDryResidue());
        stmt.setDouble(44, sanpin.getAnion());
        stmt.setDouble(45, sanpin.getStiffness());
        stmt.setDouble(46, sanpin.getOilProduct());
        stmt.setDouble(47, sanpin.getNitrate());
        stmt.setDouble(48, sanpin.getPermaganate());
        stmt.setDouble(49, sanpin.getSulfate());
        stmt.setDouble(50, sanpin.getFluoride());
        stmt.setDouble(51, sanpin.getPhenolicIndex());
        stmt.setDouble(52, sanpin.getChloride());
        stmt.setDouble(53, sanpin.getCyanide());
        stmt.setDouble(54, sanpin.getDissolvedOxygen());
        stmt.setDouble(55, sanpin.getBiologicalOxygenDemand());
        stmt.setDouble(56, sanpin.getChemicalOxygenDemand());
        stmt.setDouble(57, sanpin.getSuspendedSolid());
        stmt.setDouble(58, sanpin.getPesticideLindane());
        stmt.setDouble(59, sanpin.getPesticideIsomer());
        stmt.setDouble(60, sanpin.getRadioactivityA());
        stmt.setDouble(61, sanpin.getRadioactivityB());
        stmt.setDouble(62, sanpin.getPolyphosphate());
        stmt.setDouble(63, sanpin.getMercury());
        stmt.executeUpdate();
        ResultSet keys = stmt.getGeneratedKeys();
        keys.next();
        int lastId = keys.getInt(1);
        stmt.close();
        return lastId;
    }

    @Override
    public void update(Sanpin sanpin) throws SQLException {
        PreparedStatement stmt = connection.prepareStatement(UPDATE_QUERY);
        stmt.setInt(1, sanpin.getProbeId());
        stmt.setDate(2, (Date) sanpin.getDate());
        stmt.setInt(3, sanpin.getEmployeeId());
        stmt.setDouble(4, sanpin.getSilver());
        stmt.setDouble(5, sanpin.getAluminium());
        stmt.setDouble(6, sanpin.getArsenic());
        stmt.setDouble(7, sanpin.getBoron());
        stmt.setDouble(8, sanpin.getBarium());
        stmt.setDouble(9, sanpin.getBeryllium());
        stmt.setDouble(10, sanpin.getBismuth());
        stmt.setDouble(11, sanpin.getCadmium());
        stmt.setDouble(12, sanpin.getCobalt());
        stmt.setDouble(13, sanpin.getChromium6());
        stmt.setDouble(14, sanpin.getChromium());
        stmt.setDouble(15, sanpin.getCopper());
        stmt.setDouble(16, sanpin.getIron());
        stmt.setDouble(17, sanpin.getLithium());
        stmt.setDouble(18, sanpin.getManganese());
        stmt.setDouble(19, sanpin.getMolybdenum());
        stmt.setDouble(20, sanpin.getNiobium());
        stmt.setDouble(21, sanpin.getSodiumK());
        stmt.setDouble(22, sanpin.getNickel());
        stmt.setDouble(23, sanpin.getAmmonia());
        stmt.setDouble(24, sanpin.getNitrite());
        stmt.setDouble(25, sanpin.getLead());
        stmt.setDouble(26, sanpin.getAntimony());
        stmt.setDouble(27, sanpin.getSelenium());
        stmt.setDouble(28, sanpin.getSiliconAcid());
        stmt.setDouble(29, sanpin.getSilicon());
        stmt.setDouble(30, sanpin.getStrontium());
        stmt.setDouble(31, sanpin.getTellurium());
        stmt.setDouble(32, sanpin.getRodanideIon());
        stmt.setDouble(33, sanpin.getThallium());
        stmt.setDouble(34, sanpin.getVanadium());
        stmt.setDouble(35, sanpin.getTungsten());
        stmt.setDouble(36, sanpin.getZinc());
        stmt.setDouble(37, sanpin.getOdour());
        stmt.setDouble(38, sanpin.getFlavor());
        stmt.setDouble(39, sanpin.getChromaticity());
        stmt.setDouble(40, sanpin.getTurbidity());
        stmt.setDouble(41, sanpin.getHydrogenIndex());
        stmt.setDouble(42, sanpin.getMineralization());
        stmt.setDouble(43, sanpin.getDryResidue());
        stmt.setDouble(44, sanpin.getAnion());
        stmt.setDouble(45, sanpin.getStiffness());
        stmt.setDouble(46, sanpin.getOilProduct());
        stmt.setDouble(47, sanpin.getNitrate());
        stmt.setDouble(48, sanpin.getPermaganate());
        stmt.setDouble(49, sanpin.getSulfate());
        stmt.setDouble(50, sanpin.getFluoride());
        stmt.setDouble(51, sanpin.getPhenolicIndex());
        stmt.setDouble(52, sanpin.getChloride());
        stmt.setDouble(53, sanpin.getCyanide());
        stmt.setDouble(54, sanpin.getDissolvedOxygen());
        stmt.setDouble(55, sanpin.getBiologicalOxygenDemand());
        stmt.setDouble(56, sanpin.getChemicalOxygenDemand());
        stmt.setDouble(57, sanpin.getSuspendedSolid());
        stmt.setDouble(58, sanpin.getPesticideLindane());
        stmt.setDouble(59, sanpin.getPesticideIsomer());
        stmt.setDouble(60, sanpin.getRadioactivityA());
        stmt.setDouble(61, sanpin.getRadioactivityB());
        stmt.setDouble(62, sanpin.getPolyphosphate());
        stmt.setDouble(63, sanpin.getMercury());
        stmt.setInt(64, sanpin.getId());
        stmt.executeUpdate();
        stmt.close();
    }

    @Override
    public void delete(Sanpin sanpin) throws SQLException {
        PreparedStatement stmt = connection.prepareStatement(DELETE_QUERY);
        stmt.setInt(1, sanpin.getId());
        stmt.executeUpdate();
        stmt.close();
    }

    @Override
    public List<Sanpin> findAll() throws SQLException {
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
    public Sanpin findById(int id) throws SQLException {
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
                columns.put(metaData.getColumnLabel(i), new java.util.Date());
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
