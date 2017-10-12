package kz.epam.happylab.util;

import javax.servlet.http.HttpServletRequest;

import static kz.epam.happylab.util.Constant.EMPTY_PARAMETER;
import static kz.epam.happylab.util.Constant.ZERO;

public class ParameterRequest {

    public static int getParameter(HttpServletRequest request, String parameterName){
        int parameter=ZERO;

        if (request.getParameter(parameterName) != null && request.getParameter(parameterName) != EMPTY_PARAMETER
                && !request.getParameter(parameterName).isEmpty()) {
            parameter = Integer.parseInt(request.getParameter(parameterName));
        }

        return  parameter;
    }
}
