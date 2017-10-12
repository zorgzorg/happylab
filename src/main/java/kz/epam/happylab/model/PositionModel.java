package kz.epam.happylab.model;

import kz.epam.happylab.action.LoginAction;
import kz.epam.happylab.dao.PositionDAO;
import kz.epam.happylab.entity.Position;
import kz.epam.happylab.util.ParameterRequest;
import org.apache.log4j.Logger;

import javax.servlet.http.HttpServletRequest;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import static kz.epam.happylab.util.Constant.*;

public class PositionModel implements Model {
    private final static Logger logger = Logger.getLogger(LoginAction.class);

    public PositionModel() {
    }

    @Override
    public Position show(Connection connection, HttpServletRequest request) {
        Position position = new Position();
        try{
            PositionDAO positionDAO = new PositionDAO(connection);
            List<Position> positions = positionDAO.findAll();
            position.setPositions(positions);
        } catch (SQLException e) {
           logger.error(e);
        }
        return position;
    }

    @Override
    public Position add(Connection connection, HttpServletRequest request) {
        Position position = new Position();
        position.setId(ZERO);
        return position;
    }

    @Override
    public Position edit(Connection connection, HttpServletRequest request) {
        Position position = new Position();
        int positionId = ParameterRequest.getParameter(request, POSITION_ID);

        try {
            PositionDAO positionDAO = new PositionDAO(connection);
            position = positionDAO.findById(positionId);
        } catch (SQLException e) {
           logger.error(e);
        }
        return position;
    }

    @Override
    public Position apply(Connection connection, HttpServletRequest request) {
        Position position = new Position();
        int positionId = ParameterRequest.getParameter(request, POSITION_ID);
        String action = APPLY;

        if (request.getParameter(ACTION) != null) {
            action = request.getParameter(ACTION);
        }

        try {
            PositionDAO positionDAO = new PositionDAO(connection);
            position.setId(positionId);
            position.setPosition(request.getParameter(POSITION).trim());
            position.setRemark(request.getParameter(REMARK).trim());

            if (positionId > ZERO) {
                positionDAO.update(position);
            }
            else {
                positionId = positionDAO.insert(position);
            }

            if(SAVE.equalsIgnoreCase(action)) {
                position = show(connection, request);
            } else {
                position = positionDAO.findById(positionId);
            }

        } catch (SQLException e) {
           logger.error(e);
        }

        return position;
    }

    @Override
    public Position delete(Connection connection, HttpServletRequest request) {
        Position position = new Position();
        int positionId = ParameterRequest.getParameter(request, POSITION_ID);

        try {
            position.setId(positionId);
            PositionDAO positionDAO = new PositionDAO(connection);
            positionDAO.delete(position);
            position = show(connection, request);
        } catch (SQLException e) {
           logger.error(e);
        }
        return position;
    }

}

