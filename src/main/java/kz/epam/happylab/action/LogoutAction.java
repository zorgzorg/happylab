package kz.epam.happylab.action;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

import static kz.epam.happylab.util.Constant.LOGIN_PATH;

public class LogoutAction implements Action {
    @Override
    public String execute(HttpServletRequest request) throws ServletException, IOException {
        request.getSession().invalidate();
        return LOGIN_PATH;
    }

}
