package kz.epam.happylab.model;

import kz.epam.happylab.action.LoginAction;
import kz.epam.happylab.dao.AESDAO;
import kz.epam.happylab.dao.EmployeeDAO;
import kz.epam.happylab.dao.ProbeDAO;
import kz.epam.happylab.entity.AES;
import kz.epam.happylab.entity.Employee;
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

public class AESModel implements Model {
    private final static Logger logger = Logger.getLogger(LoginAction.class);
    private static final String CALCIUM = "Ca";
    private static final String POTASSIUM = "K";
    private static final String MAGNESIUM = "Mg";
    private static final String SODIUM = "Na";
    private static final String SULPHUR = "S";
    
    public AESModel() {
    }

    @Override
    public AES show(Connection connection, HttpServletRequest request) {
        AES  aes = new AES();
        try{
            AESDAO aesDAO = new AESDAO(connection);
            Collection journal = aesDAO.findAllMap();
            aes.setJournal(journal);
        } catch (SQLException e) {
           logger.error(e);
        }

        return aes;
    }

    @Override
    public AES add(Connection connection, HttpServletRequest request) {
        AES  aes = new AES();
        int recordId = ZERO;

        try {
            AESDAO aesDAO = new AESDAO(connection);
            Collection journal = aesDAO.create(recordId);
            aes.setJournal(journal);

            ProbeDAO probeDAO = new ProbeDAO(connection);
            List<Probe> probes = probeDAO.findAll();
            aes.setProbes(probes);

            EmployeeDAO employeeDAO = new EmployeeDAO(connection);
            List<Employee> employees = employeeDAO.findAllAssistant();
            aes.setEmployees(employees);
        } catch (SQLException e) {
           logger.error(e);
        }
        return aes;
    }

    @Override
    public AES edit(Connection connection, HttpServletRequest request) {
        AES  aes = new AES();
        int recordId = ParameterRequest.getParameter(request, RECORD_ID);

        try {
            AESDAO aesDAO = new AESDAO(connection);
            Collection journal = aesDAO.findByIdMap(recordId);
            aes.setJournal(journal);

            ProbeDAO probeDAO = new ProbeDAO(connection);
            List<Probe> probes = probeDAO.findAll();
            aes.setProbes(probes);

            EmployeeDAO employeeDAO = new EmployeeDAO(connection);
            List<Employee> employees = employeeDAO.findAllAssistant();
            aes.setEmployees(employees);
        } catch (SQLException e) {
           logger.error(e);
        }
        return aes;
    }

    @Override
    public AES apply(Connection connection, HttpServletRequest request) {
        AES  aes = new AES();
        int recordId = ParameterRequest.getParameter(request, RECORD_ID);
        String action = APPLY;

        if (request.getParameter(ACTION) != null) {
            action = request.getParameter(ACTION);
        }

        try {
            AESDAO aesDAO = new AESDAO(connection);
            aes.setId(recordId);
            aes.setProbeId(Integer.parseInt(request.getParameter(PROBE_ID).trim()));
            aes.setDate(java.sql.Date.valueOf(DateFormatter.formatDate(request.getParameter(DATE).trim())));
            aes.setEmployeeId(Integer.parseInt(request.getParameter(EMPLOYEE_ID).trim()));
            aes.setSilver(Double.parseDouble(request.getParameter(SILVER).trim()));
            aes.setAluminium(Double.parseDouble(request.getParameter(ALUMINIUM).trim()));
            aes.setArsenic(Double.parseDouble(request.getParameter(ARSENIC).trim()));
            aes.setBoron(Double.parseDouble(request.getParameter(BORON).trim()));
            aes.setBarium(Double.parseDouble(request.getParameter(BARIUM).trim()));
            aes.setBeryllium(Double.parseDouble(request.getParameter(BERYLLIUM).trim()));
            aes.setBismuth(Double.parseDouble(request.getParameter(BISMUTH).trim()));
            aes.setCalcium(Double.parseDouble(request.getParameter(CALCIUM).trim()));
            aes.setCadmium(Double.parseDouble(request.getParameter(CADMIUM).trim()));
            aes.setCobalt(Double.parseDouble(request.getParameter(COBALT).trim()));
            aes.setChromium(Double.parseDouble(request.getParameter(CHROMIUM).trim()));
            aes.setCopper(Double.parseDouble(request.getParameter(COPPER).trim()));
            aes.setIron(Double.parseDouble(request.getParameter(IRON).trim()));
            aes.setPotassium(Double.parseDouble(request.getParameter(POTASSIUM).trim()));
            aes.setLithium(Double.parseDouble(request.getParameter(LITHIUM).trim()));
            aes.setMagnesium(Double.parseDouble(request.getParameter(MAGNESIUM).trim()));
            aes.setManganese(Double.parseDouble(request.getParameter(MANGANESE).trim()));
            aes.setMolybdenum(Double.parseDouble(request.getParameter(MOLYBDENUM).trim()));
            aes.setSodium(Double.parseDouble(request.getParameter(SODIUM).trim()));
            aes.setNickel(Double.parseDouble(request.getParameter(NICKEL).trim()));
            aes.setPhosphorus(Double.parseDouble(request.getParameter(PHOSPHORUS).trim()));
            aes.setLead(Double.parseDouble(request.getParameter(LEAD).trim()));
            aes.setSulphur(Double.parseDouble(request.getParameter(SULPHUR).trim()));
            aes.setAntimony(Double.parseDouble(request.getParameter(ANTIMONY).trim()));
            aes.setSelenium(Double.parseDouble(request.getParameter(SELENIUM).trim()));
            aes.setSilicon(Double.parseDouble(request.getParameter(SILICON).trim()));
            aes.setTin(Double.parseDouble(request.getParameter(TIN).trim()));
            aes.setStrontium(Double.parseDouble(request.getParameter(STRONTIUM).trim()));
            aes.setTitanium(Double.parseDouble(request.getParameter(TITANIUM).trim()));
            aes.setThallium(Double.parseDouble(request.getParameter(THALLIUM).trim()));
            aes.setVanadium(Double.parseDouble(request.getParameter(VANADIUM).trim()));
            aes.setTungsten(Double.parseDouble(request.getParameter(TUNGSTEN).trim()));
            aes.setZinc(Double.parseDouble(request.getParameter(ZINC).trim()));

            if (recordId > ZERO) {
                aesDAO.update(aes);
            }
            else {
                recordId = aesDAO.insert(aes);
            }

            if(SAVE.equalsIgnoreCase(action)) {
                aes = show(connection, request);
            } else {
                aesDAO = new AESDAO(connection);
                Collection journal = aesDAO.findByIdMap(recordId);
                aes.setJournal(journal);

                ProbeDAO probeDAO = new ProbeDAO(connection);
                List<Probe> probes = probeDAO.findAll();
                aes.setProbes(probes);

                EmployeeDAO employeeDAO = new EmployeeDAO(connection);
                List<Employee> employees = employeeDAO.findAllAssistant();
                aes.setEmployees(employees);
            }
        } catch (SQLException e) {
           logger.error(e);
        }

        return aes;
    }

    @Override
    public AES delete(Connection connection, HttpServletRequest request) {
        AES  aes = new AES();
        int recordId = ParameterRequest.getParameter(request, RECORD_ID);

        try {
            aes.setId(recordId);
            AESDAO aesDAO = new AESDAO(connection);
            aesDAO.delete(aes);
            aes = show(connection, request);
        } catch (SQLException e) {
           logger.error(e);
        }

        return aes;
    }
}
