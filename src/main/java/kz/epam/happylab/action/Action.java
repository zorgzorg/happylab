package kz.epam.happylab.action;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

public interface Action {
    String execute(HttpServletRequest request) throws ServletException, IOException;
    }
