package kz.epam.happylab.model;

import kz.epam.happylab.action.LoginAction;
import kz.epam.happylab.dao.EmployeeDAO;
import kz.epam.happylab.dao.PSADAO;
import kz.epam.happylab.dao.ProbeDAO;
import kz.epam.happylab.entity.Employee;
import kz.epam.happylab.entity.PSA;
import kz.epam.happylab.entity.Probe;
import kz.epam.happylab.util.DateFormatter;
import kz.epam.happylab.util.ParameterRequest;
import org.apache.log4j.Logger;

import javax.servlet.http.HttpServletRequest;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Collection;
import java.util.List;

import static kz.epam.happylab.util.Constant.*;

public class PSAModel implements Model {
    private final static Logger logger = Logger.getLogger(LoginAction.class);
    private static final String GOLD = "Au";
    private static final String CERIUM = "Ce";
    private static final String GALLIUM = "Ga";
    private static final String GERMANIUM = "Ge";
    private static final String HAFNIUM = "Hf";
    private static final String INDIUM = "In";
    private static final String LANTHANUM = "La";
    private static final String NIOBIUM = "Nb";
    private static final String PLATINUM = "Pt";
    private static final String SCANDIUM = "Sc";
    private static final String TANTALUM = "Ta";
    private static final String TELLURIUM = "Te";
    private static final String THORIUM = "Th";
    private static final String URANIUM = "U";
    private static final String YTTRIUM = "Y";
    private static final String YTTERBIUM = "Yb";
    private static final String ZIRCONIUM = "Zr";
    
    public PSAModel() {
    }

    @Override
    public PSA show(Connection connection, HttpServletRequest request) {
        PSA  psa = new PSA();
        try{
            PSADAO psaDAO = new PSADAO(connection);
            Collection journal = psaDAO.findAllMap();
            psa.setJournal(journal);
        } catch (SQLException e) {
           logger.error(e);
        }

        return psa;
    }

    @Override
    public PSA add(Connection connection, HttpServletRequest request) {
        PSA  psa = new PSA();
        int recordId = ZERO;

        try {
            PSADAO psaDAO = new PSADAO(connection);
            Collection journal = psaDAO.create(recordId);
            psa.setJournal(journal);

            ProbeDAO probeDAO = new ProbeDAO(connection);
            List<Probe> probes = probeDAO.findAll();
            psa.setProbes(probes);

            EmployeeDAO employeeDAO = new EmployeeDAO(connection);
            List<Employee> employees = employeeDAO.findAllAssistant();
            psa.setEmployees(employees);
        } catch (SQLException e) {
           logger.error(e);
        }
        return psa;
    }

    @Override
    public PSA edit(Connection connection, HttpServletRequest request) {
        PSA  psa = new PSA();
        int recordId = ParameterRequest.getParameter(request, RECORD_ID);

        try {
            PSADAO psaDAO = new PSADAO(connection);
            Collection journal = psaDAO.findByIdMap(recordId);
            psa.setJournal(journal);

            ProbeDAO probeDAO = new ProbeDAO(connection);
            List<Probe> probes = probeDAO.findAll();
            psa.setProbes(probes);

            EmployeeDAO employeeDAO = new EmployeeDAO(connection);
            List<Employee> employees = employeeDAO.findAllAssistant();
            psa.setEmployees(employees);
        } catch (SQLException e) {
           logger.error(e);
        }
        return psa;
    }

    @Override
    public PSA apply(Connection connection, HttpServletRequest request) {
        PSA  psa = new PSA();
        int recordId = ParameterRequest.getParameter(request, RECORD_ID);
        String action = APPLY;

        if (request.getParameter(ACTION) != null) {
            action = request.getParameter(ACTION);
        }

        try {
            PSADAO psaDAO = new PSADAO(connection);
            psa.setId(recordId);
            psa.setProbeId(Integer.parseInt(request.getParameter(PROBE_ID).trim()));
            psa.setDate(java.sql.Date.valueOf(DateFormatter.formatDate(request.getParameter(DATE).trim())));
            psa.setEmployeeId(Integer.parseInt(request.getParameter(EMPLOYEE_ID).trim()));
            psa.setSilver(Double.parseDouble(request.getParameter(SILVER).trim()));psa.setSilver(Double.parseDouble(request.getParameter(SILVER).trim()));
            psa.setAluminium(Double.parseDouble(request.getParameter(ALUMINIUM).trim()));
            psa.setArsenic(Double.parseDouble(request.getParameter(ARSENIC).trim()));
            psa.setGold(Double.parseDouble(request.getParameter(GOLD).trim()));
            psa.setBoron(Double.parseDouble(request.getParameter(BORON).trim()));
            psa.setBarium(Double.parseDouble(request.getParameter(BARIUM).trim()));
            psa.setBeryllium(Double.parseDouble(request.getParameter(BERYLLIUM).trim()));
            psa.setBismuth(Double.parseDouble(request.getParameter(BISMUTH).trim()));
            psa.setCadmium(Double.parseDouble(request.getParameter(CADMIUM).trim()));
            psa.setCerium(Double.parseDouble(request.getParameter(CERIUM).trim()));
            psa.setCobalt(Double.parseDouble(request.getParameter(COBALT).trim()));
            psa.setChromium(Double.parseDouble(request.getParameter(CHROMIUM).trim()));
            psa.setCopper(Double.parseDouble(request.getParameter(COPPER).trim()));
            psa.setIron(Double.parseDouble(request.getParameter(IRON).trim()));
            psa.setGallium(Double.parseDouble(request.getParameter(GALLIUM).trim()));
            psa.setGermanium(Double.parseDouble(request.getParameter(GERMANIUM).trim()));
            psa.setHafnium(Double.parseDouble(request.getParameter(HAFNIUM).trim()));
            psa.setIndium(Double.parseDouble(request.getParameter(INDIUM).trim()));
            psa.setLanthanum(Double.parseDouble(request.getParameter(LANTHANUM).trim()));
            psa.setLithium(Double.parseDouble(request.getParameter(LITHIUM).trim()));
            psa.setManganese(Double.parseDouble(request.getParameter(MANGANESE).trim()));
            psa.setMolybdenum(Double.parseDouble(request.getParameter(MOLYBDENUM).trim()));
            psa.setNiobium(Double.parseDouble(request.getParameter(NIOBIUM).trim()));
            psa.setNickel(Double.parseDouble(request.getParameter(NICKEL).trim()));
            psa.setPhosphorus(Double.parseDouble(request.getParameter(PHOSPHORUS).trim()));
            psa.setLead(Double.parseDouble(request.getParameter(LEAD).trim()));
            psa.setPlatinum(Double.parseDouble(request.getParameter(PLATINUM).trim()));
            psa.setAntimony(Double.parseDouble(request.getParameter(ANTIMONY).trim()));
            psa.setScandium(Double.parseDouble(request.getParameter(SCANDIUM).trim()));
            psa.setTin(Double.parseDouble(request.getParameter(TIN).trim()));
            psa.setStrontium(Double.parseDouble(request.getParameter(STRONTIUM).trim()));
            psa.setTantalum(Double.parseDouble(request.getParameter(TANTALUM).trim()));
            psa.setTellurium(Double.parseDouble(request.getParameter(TELLURIUM).trim()));
            psa.setThorium(Double.parseDouble(request.getParameter(THORIUM).trim()));
            psa.setTitanium(Double.parseDouble(request.getParameter(TITANIUM).trim()));
            psa.setThallium(Double.parseDouble(request.getParameter(THALLIUM).trim()));
            psa.setUranium(Double.parseDouble(request.getParameter(URANIUM).trim()));
            psa.setVanadium(Double.parseDouble(request.getParameter(VANADIUM).trim()));
            psa.setTungsten(Double.parseDouble(request.getParameter(TUNGSTEN).trim()));
            psa.setYttrium(Double.parseDouble(request.getParameter(YTTRIUM).trim()));
            psa.setYtterbium(Double.parseDouble(request.getParameter(YTTERBIUM).trim()));
            psa.setZinc(Double.parseDouble(request.getParameter(ZINC).trim()));
            psa.setZirconium(Double.parseDouble(request.getParameter(ZIRCONIUM).trim()));

            if (recordId > ZERO) {
                psaDAO.update(psa);
            }
            else {
                recordId = psaDAO.insert(psa);
            }

            if(SAVE.equalsIgnoreCase(action)) {
                psa = show(connection, request);
            } else {
                Collection journal = psaDAO.findByIdMap(recordId);
                psa.setJournal(journal);

                ProbeDAO probeDAO = new ProbeDAO(connection);
                List<Probe> probes = probeDAO.findAll();
                psa.setProbes(probes);

                EmployeeDAO employeeDAO = new EmployeeDAO(connection);
                List<Employee> employees = employeeDAO.findAllAssistant();
                psa.setEmployees(employees);
            }

        } catch (SQLException e) {
           logger.error(e);
        }

        return psa;
    }

    @Override
    public PSA delete(Connection connection, HttpServletRequest request) {
        PSA  psa = new PSA();
        int recordId = ParameterRequest.getParameter(request, RECORD_ID);

        try {
            psa.setId(recordId);
            PSADAO psaDAO = new PSADAO(connection);
            psaDAO.delete(psa);
            psa = show(connection, request);
        } catch (SQLException e) {
           logger.error(e);
        }
        return psa;
    }
}
