package kz.epam.happylab.dao;

import kz.epam.happylab.entity.PSA;

import java.sql.*;
import java.sql.Date;
import java.util.*;

import static kz.epam.happylab.util.Constant.*;

public class PSADAO implements DAO<PSA> {
    private final String INSERT_QUERY = "INSERT INTO journal_psa (`probeId`, `date`, `employeeId`, `Ag`, `Al`, `As`, " +
            "`Au`, `B`, `Ba`, `Be`, `Bi`, `Cd`, `Ce`, `Co`, `Cr`, `Cu`, `Fe`, `Ga`, `Ge`, `Hf`, `In`, `La`, `Li`, " +
            "`Mn`, `Mo`, `Nb`, `Ni`, `P`, `Pb`, `Pt`, `Sb`, `Sc`, `Sn`, `Sr`, `Ta`, `Te`, `Th`, `Ti`, `Tl`, `U`, `V`, " +
            "`W`, `Y`, `Yb`, `Zn`, `Zr`) VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?," +
            "?,?,?,?,?,?,?,?,?,?,?)";
    private final String UPDATE_QUERY = "UPDATE journal_psa SET `probeId` = ?, `date` = ?, `employeeId` = ?, `Ag` = ?, " +
            "`Al` = ?, `As` = ?, `Au` = ?, `B` = ?, `Ba` = ?, `Be` = ?, `Bi` = ?, `Cd` = ?, `Ce` = ?, `Co` = ?, " +
            "`Cr` = ?, `Cu` = ?, `Fe` = ?, `Ga` = ?, `Ge` = ?, `Hf` = ?, `In` = ?, `La` = ?, `Li` = ?, `Mn` = ?, " +
            "`Mo` = ?, `Nb` = ?, `Ni` = ?, `P` = ?, `Pb` = ?, `Pt` = ?, `Sb` = ?, `Sc` = ?, `Sn` = ?, `Sr` = ?, " +
            "`Ta` = ?, `Te` = ?, `Th` = ?, `Ti` = ?, `Tl` = ?, `U` = ?, `V` = ?, `W` = ?, `Y` = ?, `Yb` = ?, `Zn` = ?, " +
            "`Zr` = ? WHERE `id` = ?";
    private final String DELETE_QUERY = "UPDATE journal_psa SET `deleted` = -1 WHERE `id` =  ?";
    private final String FINDALL_QUERY = "SELECT p.numberLab, e.lastname AS `assistant`, a.* " +
            "FROM journal_psa AS a " +
            "INNER JOIN probes AS p ON a.probeId=p.id " +
            "INNER JOIN employees AS e ON a.employeeId = e.id " +
            "WHERE a.deleted = 0 " +
            "ORDER BY p.numberLab;";
    private final String FINDBYID_QUERY = "SELECT p.numberLab, e.lastname AS `assistant`, a.* " +
            "FROM journal_psa AS a " +
            "INNER JOIN probes AS p ON a.probeId = p.id " +
            "INNER JOIN employees AS e ON a.employeeId = e.id " +
            "WHERE a.deleted = 0 " +
            "AND a.id = ? " +
            "ORDER BY p.numberLab;";

    private Connection connection;

    public PSADAO(Connection connection) {
        this.connection = connection;
    }

    @Override
    public int insert(PSA psa) throws SQLException {
        PreparedStatement stmt = connection.prepareStatement(INSERT_QUERY, Statement.RETURN_GENERATED_KEYS);
        stmt.setInt(1, psa.getProbeId());
        stmt.setDate(2, (Date) psa.getDate());
        stmt.setInt(3, psa.getEmployeeId());
        stmt.setDouble(4, psa.getSilver());
        stmt.setDouble(5, psa.getAluminium());
        stmt.setDouble(6, psa.getArsenic());
        stmt.setDouble(7, psa.getGold());
        stmt.setDouble(8, psa.getBoron());
        stmt.setDouble(9, psa.getBarium());
        stmt.setDouble(10, psa.getBeryllium());
        stmt.setDouble(11, psa.getBismuth());
        stmt.setDouble(12, psa.getCadmium());
        stmt.setDouble(13, psa.getCerium());
        stmt.setDouble(14, psa.getCobalt());
        stmt.setDouble(15, psa.getChromium());
        stmt.setDouble(16, psa.getCopper());
        stmt.setDouble(17, psa.getIron());
        stmt.setDouble(18, psa.getGallium());
        stmt.setDouble(19, psa.getGermanium());
        stmt.setDouble(20, psa.getHafnium());
        stmt.setDouble(21, psa.getIndium());
        stmt.setDouble(22, psa.getLanthanum());
        stmt.setDouble(23, psa.getLithium());
        stmt.setDouble(24, psa.getManganese());
        stmt.setDouble(25, psa.getMolybdenum());
        stmt.setDouble(26, psa.getNiobium());
        stmt.setDouble(27, psa.getNickel());
        stmt.setDouble(28, psa.getPhosphorus());
        stmt.setDouble(29, psa.getLead());
        stmt.setDouble(30, psa.getPlatinum());
        stmt.setDouble(31, psa.getAntimony());
        stmt.setDouble(32, psa.getScandium());
        stmt.setDouble(33, psa.getTin());
        stmt.setDouble(34, psa.getStrontium());
        stmt.setDouble(35, psa.getTantalum());
        stmt.setDouble(36, psa.getTellurium());
        stmt.setDouble(37, psa.getThorium());
        stmt.setDouble(38, psa.getTitanium());
        stmt.setDouble(39, psa.getThallium());
        stmt.setDouble(40, psa.getUranium());
        stmt.setDouble(41, psa.getVanadium());
        stmt.setDouble(42, psa.getTungsten());
        stmt.setDouble(43, psa.getYttrium());
        stmt.setDouble(44, psa.getYtterbium());
        stmt.setDouble(45, psa.getZinc());
        stmt.setDouble(46, psa.getZirconium());
        stmt.executeUpdate();
        ResultSet keys = stmt.getGeneratedKeys();
        keys.next();
        int lastId = keys.getInt(1);
        stmt.close();
        return lastId;
    }

    @Override
    public void update(PSA psa) throws SQLException {
        PreparedStatement stmt = connection.prepareStatement(UPDATE_QUERY);
        stmt.setInt(1, psa.getProbeId());
        stmt.setDate(2, (Date) psa.getDate());
        stmt.setInt(3, psa.getEmployeeId());
        stmt.setDouble(4, psa.getSilver());
        stmt.setDouble(5, psa.getAluminium());
        stmt.setDouble(6, psa.getArsenic());
        stmt.setDouble(7, psa.getGold());
        stmt.setDouble(8, psa.getBoron());
        stmt.setDouble(9, psa.getBarium());
        stmt.setDouble(10, psa.getBeryllium());
        stmt.setDouble(11, psa.getBismuth());
        stmt.setDouble(12, psa.getCadmium());
        stmt.setDouble(13, psa.getCerium());
        stmt.setDouble(14, psa.getCobalt());
        stmt.setDouble(15, psa.getChromium());
        stmt.setDouble(16, psa.getCopper());
        stmt.setDouble(17, psa.getIron());
        stmt.setDouble(18, psa.getGallium());
        stmt.setDouble(19, psa.getGermanium());
        stmt.setDouble(20, psa.getHafnium());
        stmt.setDouble(21, psa.getIndium());
        stmt.setDouble(22, psa.getLanthanum());
        stmt.setDouble(23, psa.getLithium());
        stmt.setDouble(24, psa.getManganese());
        stmt.setDouble(25, psa.getMolybdenum());
        stmt.setDouble(26, psa.getNiobium());
        stmt.setDouble(27, psa.getNickel());
        stmt.setDouble(28, psa.getPhosphorus());
        stmt.setDouble(29, psa.getLead());
        stmt.setDouble(30, psa.getPlatinum());
        stmt.setDouble(31, psa.getAntimony());
        stmt.setDouble(32, psa.getScandium());
        stmt.setDouble(33, psa.getTin());
        stmt.setDouble(34, psa.getStrontium());
        stmt.setDouble(35, psa.getTantalum());
        stmt.setDouble(36, psa.getTellurium());
        stmt.setDouble(37, psa.getThorium());
        stmt.setDouble(38, psa.getTitanium());
        stmt.setDouble(39, psa.getThallium());
        stmt.setDouble(40, psa.getUranium());
        stmt.setDouble(41, psa.getVanadium());
        stmt.setDouble(42, psa.getTungsten());
        stmt.setDouble(43, psa.getYttrium());
        stmt.setDouble(44, psa.getYtterbium());
        stmt.setDouble(45, psa.getZinc());
        stmt.setDouble(46, psa.getZirconium());
        stmt.setInt(47, psa.getId());
        stmt.executeUpdate();
        stmt.close();
    }

    @Override
    public void delete(PSA psa) throws SQLException {
        PreparedStatement stmt = connection.prepareStatement(DELETE_QUERY);
        stmt.setInt(1, psa.getId());
        stmt.executeUpdate();
        stmt.close();
    }

    @Override
    public List<PSA> findAll() throws SQLException {
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
    public PSA findById(int id) throws SQLException {
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
