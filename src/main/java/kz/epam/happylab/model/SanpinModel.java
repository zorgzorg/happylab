package kz.epam.happylab.model;

import kz.epam.happylab.action.LoginAction;
import kz.epam.happylab.dao.EmployeeDAO;
import kz.epam.happylab.dao.ProbeDAO;
import kz.epam.happylab.dao.SanpinDAO;
import kz.epam.happylab.entity.Sanpin;
import kz.epam.happylab.util.DateFormatter;
import kz.epam.happylab.util.ParameterRequest;
import org.apache.log4j.Logger;

import javax.servlet.http.HttpServletRequest;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Collection;

import static kz.epam.happylab.util.Constant.*;

public class SanpinModel implements Model<Sanpin> {
    private final static Logger logger = Logger.getLogger(LoginAction.class);
    private static final String CHROMIUM6 = "Cr6";
    private static final String SODIUMK = "Na+Ka";
    private static final String AMMONIA = "NH3";
    private static final String NITRITE = "NO2";
    private static final String SILICONACID = "SiAcid";
    private static final String RODANIDEION = "Rodanide";
    private static final String ODOUR = "odour";
    private static final String FLAVOR = "flavor";
    private static final String CHROMATICITY = "chromaticity";
    private static final String TURBIDITY = "turbidity";
    private static final String HYDROGENINDEX = "hydrogenIndex";
    private static final String MINERALIZATION = "mineralization";
    private static final String DRYRESIDUE = "dryResidue";
    private static final String ANION = "anion";
    private static final String STIFFNESS = "stiffness";
    private static final String OILPRODUCT = "oilProduct";
    private static final String NITRATE = "nitrate";
    private static final String NIOBIUM = "niobium";
    private static final String PERMAGANATE = "permaganate";
    private static final String MERCURY = "mercury";
    private static final String SULFATE = "sulfate";
    private static final String TELLURIUM = "tellurium";
    private static final String FLUORIDE = "fluoride";
    private static final String PHENOLICINDEX = "phenolicIndex";
    private static final String CHLORIDE = "chloride";
    private static final String CYANIDE = "cyanide";
    private static final String DISSOLVEDOXYGEN = "dissolvedOxygen";
    private static final String BIOLOGICALOXYGENDEMAND = "biologicalOxygenDemand";
    private static final String CHEMICALOXYGENDEMAND = "chemicalOxygenDemand";
    private static final String SUSPENDEDSOLID = "suspendedSolid";
    private static final String PESTICIDELINDANE = "pesticideLindane";
    private static final String PESTICIDEISOMER = "pesticideIsomer";
    private static final String RADIOACTIVITYA = "radioactivityA";
    private static final String RADIOACTIVITYB = "radioactivityB";
    private static final String POLYPHOSPHATE = "polyphosphate";

    public SanpinModel() {
    }

    @Override
    public Sanpin show(Connection connection, HttpServletRequest request) {
        Sanpin sanpin = new Sanpin();
        try{
            SanpinDAO sanpinDAO = new SanpinDAO(connection);
            Collection journal = sanpinDAO.findAllMap();
            sanpin.setJournal(journal);
        } catch (SQLException e) {
           logger.error(e);
        }

        return sanpin;
    }

    @Override
    public Sanpin add(Connection connection, HttpServletRequest request) {
        Sanpin sanpin = new Sanpin();
        int recordId = ZERO;

        try {
            SanpinDAO sanpinDAO = new SanpinDAO(connection);
            Collection journal = sanpinDAO.create(recordId);
            sanpin.setJournal(journal);

            ProbeDAO probeDAO = new ProbeDAO(connection);
            Collection probes = probeDAO.findAll();
            sanpin.setProbes(probes);

            EmployeeDAO employeeDAO = new EmployeeDAO(connection);
            Collection employees = employeeDAO.findAllAssistant();
            sanpin.setEmployees(employees);
        } catch (SQLException e) {
           logger.error(e);
        }
        return sanpin;
    }

    @Override
    public Sanpin edit(Connection connection, HttpServletRequest request) {
        Sanpin sanpin = new Sanpin();
        int recordId = ParameterRequest.getParameter(request, RECORD_ID);

        try {
            SanpinDAO sanpinDAO = new SanpinDAO(connection);
            Collection journal = sanpinDAO.findByIdMap(recordId);
            sanpin.setJournal(journal);

            ProbeDAO probeDAO = new ProbeDAO(connection);
            Collection probes = probeDAO.findAll();
            sanpin.setProbes(probes);

            EmployeeDAO employeeDAO = new EmployeeDAO(connection);
            Collection employees = employeeDAO.findAllAssistant();
            sanpin.setEmployees(employees);
        } catch (SQLException e) {
           logger.error(e);
        }
        return sanpin;
    }

    @Override
    public Sanpin apply(Connection connection, HttpServletRequest request) {
        Sanpin sanpin = new Sanpin();
        int recordId = ParameterRequest.getParameter(request, RECORD_ID);
        String action = APPLY;

        if (request.getParameter(ACTION) != null) {
            action = request.getParameter(ACTION);
        }

        try {
            SanpinDAO sanpinDAO = new SanpinDAO(connection);
            sanpin.setId(recordId);
            sanpin.setProbeId(Integer.parseInt(request.getParameter(PROBE_ID).trim()));
            sanpin.setDate(java.sql.Date.valueOf(DateFormatter.formatDate(request.getParameter(DATE).trim())));
            sanpin.setEmployeeId(Integer.parseInt(request.getParameter(EMPLOYEE_ID).trim()));
            sanpin.setSilver(Double.parseDouble(request.getParameter(SILVER).trim()));
            sanpin.setAluminium(Double.parseDouble(request.getParameter(ALUMINIUM).trim()));
            sanpin.setArsenic(Double.parseDouble(request.getParameter(ARSENIC).trim()));
            sanpin.setBoron(Double.parseDouble(request.getParameter(BORON).trim()));
            sanpin.setBarium(Double.parseDouble(request.getParameter(BARIUM).trim()));
            sanpin.setBeryllium(Double.parseDouble(request.getParameter(BERYLLIUM).trim()));
            sanpin.setBismuth(Double.parseDouble(request.getParameter(BISMUTH).trim()));
            sanpin.setCadmium(Double.parseDouble(request.getParameter(CADMIUM).trim()));
            sanpin.setCobalt(Double.parseDouble(request.getParameter(COBALT).trim()));
            sanpin.setChromium6(Double.parseDouble(request.getParameter(CHROMIUM6).trim()));
            sanpin.setChromium(Double.parseDouble(request.getParameter(CHROMIUM).trim()));
            sanpin.setCopper(Double.parseDouble(request.getParameter(COPPER).trim()));
            sanpin.setIron(Double.parseDouble(request.getParameter(IRON).trim()));
            sanpin.setLithium(Double.parseDouble(request.getParameter(LITHIUM).trim()));
            sanpin.setManganese(Double.parseDouble(request.getParameter(MANGANESE).trim()));
            sanpin.setMolybdenum(Double.parseDouble(request.getParameter(MOLYBDENUM).trim()));
            sanpin.setNiobium(Double.parseDouble(request.getParameter(NIOBIUM).trim()));
            sanpin.setSodiumK(Double.parseDouble(request.getParameter(SODIUMK).trim()));
            sanpin.setNickel(Double.parseDouble(request.getParameter(NICKEL).trim()));
            sanpin.setAmmonia(Double.parseDouble(request.getParameter(AMMONIA).trim()));
            sanpin.setNitrite(Double.parseDouble(request.getParameter(NITRITE).trim()));
            sanpin.setLead(Double.parseDouble(request.getParameter(LEAD).trim()));
            sanpin.setAntimony(Double.parseDouble(request.getParameter(ANTIMONY).trim()));
            sanpin.setSelenium(Double.parseDouble(request.getParameter(SELENIUM).trim()));
            sanpin.setSiliconAcid(Double.parseDouble(request.getParameter(SILICONACID).trim()));
            sanpin.setSilicon(Double.parseDouble(request.getParameter(SILICON).trim()));
            sanpin.setStrontium(Double.parseDouble(request.getParameter(STRONTIUM).trim()));
            sanpin.setTellurium(Double.parseDouble(request.getParameter(TELLURIUM).trim()));
            sanpin.setRodanideIon(Double.parseDouble(request.getParameter(RODANIDEION).trim()));
            sanpin.setThallium(Double.parseDouble(request.getParameter(THALLIUM).trim()));
            sanpin.setVanadium(Double.parseDouble(request.getParameter(VANADIUM).trim()));
            sanpin.setTungsten(Double.parseDouble(request.getParameter(TUNGSTEN).trim()));
            sanpin.setZinc(Double.parseDouble(request.getParameter(ZINC).trim()));
            sanpin.setOdour(Double.parseDouble(request.getParameter(ODOUR).trim()));
            sanpin.setFlavor(Double.parseDouble(request.getParameter(FLAVOR).trim()));
            sanpin.setChromaticity(Double.parseDouble(request.getParameter(CHROMATICITY).trim()));
            sanpin.setTurbidity(Double.parseDouble(request.getParameter(TURBIDITY).trim()));
            sanpin.setHydrogenIndex(Double.parseDouble(request.getParameter(HYDROGENINDEX).trim()));
            sanpin.setMineralization(Double.parseDouble(request.getParameter(MINERALIZATION).trim()));
            sanpin.setDryResidue(Double.parseDouble(request.getParameter(DRYRESIDUE).trim()));
            sanpin.setAnion(Double.parseDouble(request.getParameter(ANION).trim()));
            sanpin.setStiffness(Double.parseDouble(request.getParameter(STIFFNESS).trim()));
            sanpin.setOilProduct(Double.parseDouble(request.getParameter(OILPRODUCT).trim()));
            sanpin.setNitrate(Double.parseDouble(request.getParameter(NITRATE).trim()));
            sanpin.setPermaganate(Double.parseDouble(request.getParameter(PERMAGANATE).trim()));
            sanpin.setMercury(Double.parseDouble(request.getParameter(MERCURY).trim()));
            sanpin.setSulfate(Double.parseDouble(request.getParameter(SULFATE).trim()));
            sanpin.setFluoride(Double.parseDouble(request.getParameter(FLUORIDE).trim()));
            sanpin.setPhenolicIndex(Double.parseDouble(request.getParameter(PHENOLICINDEX).trim()));
            sanpin.setChloride(Double.parseDouble(request.getParameter(CHLORIDE).trim()));
            sanpin.setCyanide(Double.parseDouble(request.getParameter(CYANIDE).trim()));
            sanpin.setDissolvedOxygen(Double.parseDouble(request.getParameter(DISSOLVEDOXYGEN).trim()));
            sanpin.setBiologicalOxygenDemand(Double.parseDouble(request.getParameter(BIOLOGICALOXYGENDEMAND).trim()));
            sanpin.setChemicalOxygenDemand(Double.parseDouble(request.getParameter(CHEMICALOXYGENDEMAND).trim()));
            sanpin.setSuspendedSolid(Double.parseDouble(request.getParameter(SUSPENDEDSOLID).trim()));
            sanpin.setPesticideLindane(Double.parseDouble(request.getParameter(PESTICIDELINDANE).trim()));
            sanpin.setPesticideIsomer(Double.parseDouble(request.getParameter(PESTICIDEISOMER).trim()));
            sanpin.setRadioactivityA(Double.parseDouble(request.getParameter(RADIOACTIVITYA).trim()));
            sanpin.setRadioactivityB(Double.parseDouble(request.getParameter(RADIOACTIVITYB).trim()));
            sanpin.setPolyphosphate(Double.parseDouble(request.getParameter(POLYPHOSPHATE).trim()));

            if (recordId > ZERO) {
                sanpinDAO.update(sanpin);
            }
            else {
                recordId = sanpinDAO.insert(sanpin);
            }

            if(SAVE.equalsIgnoreCase(action)) {
                sanpin = show(connection, request);
            } else {
                sanpinDAO = new SanpinDAO(connection);
                Collection journal = sanpinDAO.findByIdMap(recordId);
                sanpin.setJournal(journal);

                ProbeDAO probeDAO = new ProbeDAO(connection);
                Collection probes = probeDAO.findAll();
                sanpin.setProbes(probes);

                EmployeeDAO employeeDAO = new EmployeeDAO(connection);
                Collection employees = employeeDAO.findAllAssistant();
                sanpin.setEmployees(employees);
            }

        } catch (SQLException e) {
           logger.error(e);
        }

        return sanpin;
    }

    @Override
    public Sanpin delete(Connection connection, HttpServletRequest request) {
        Sanpin sanpin = new Sanpin();
        int recordId = ParameterRequest.getParameter(request, RECORD_ID);

        try {
            sanpin.setId(recordId);
            SanpinDAO sanpinDAO = new SanpinDAO(connection);
            sanpinDAO.delete(sanpin);
            sanpin = show(connection, request);
        } catch (SQLException e) {
           logger.error(e);
        }
        return sanpin;
    }
}
