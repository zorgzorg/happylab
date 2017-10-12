package kz.epam.happylab.model;

import kz.epam.happylab.action.LoginAction;
import kz.epam.happylab.dao.ProbeDAO;
import kz.epam.happylab.dao.ReportDAO;
import kz.epam.happylab.entity.Probe;
import kz.epam.happylab.entity.Report;
import kz.epam.happylab.util.ParameterRequest;
import org.apache.log4j.Logger;

import javax.servlet.http.HttpServletRequest;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Collection;
import java.util.List;

import static kz.epam.happylab.util.Constant.*;

public class ReportModel implements Model {
    private final static Logger logger = Logger.getLogger(LoginAction.class);
    private static final String ANALYSIS = "analysis";

    public ReportModel() {
    }

    @Override
    public Report show(Connection connection, HttpServletRequest request) {
        Report report = new Report();
        String analysis = getAnalysis(request);
        int recordId = ParameterRequest.getParameter(request, RECORD_ID);;
        int probeId = ParameterRequest.getParameter(request, PROBE_ID);;

        try{
            ReportDAO reportDAO = new ReportDAO(connection);
            Collection result = reportDAO.findByIdReport(recordId, analysis);
            report.setResult(result);

            String headLaboratory=reportDAO.findHeadLaboratory();
            report.setHeadLaboratory(headLaboratory);

            ProbeDAO probeDAO = new ProbeDAO(connection);
            List<Probe> probes = probeDAO.findAll();
            report.setProbes(probes);

            Probe probe = probeDAO.findByIdReport(probeId);
            report.setProbe(probe);
            report.setAnalysis(analysis);

        } catch (SQLException e) {
           logger.error(e);
        }
        return report;
    }

    @Override
    public Report add(Connection connection, HttpServletRequest request) {
        throw new UnsupportedOperationException();
    }

    @Override
    public Report edit(Connection connection, HttpServletRequest request) {
        throw new UnsupportedOperationException();
    }

    @Override
    public Report apply(Connection connection, HttpServletRequest request) {
        throw new UnsupportedOperationException();
    }

    @Override
    public Report delete(Connection connection, HttpServletRequest request) {
        throw new UnsupportedOperationException();
    }

    private String getAnalysis(HttpServletRequest request){
        String analysis=EMPTY_PARAMETER;

        if (request.getParameter(ANALYSIS) != null) {
            analysis = request.getParameter(ANALYSIS);
        }

        return  analysis;
    }
}
