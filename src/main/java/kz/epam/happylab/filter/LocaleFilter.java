package kz.epam.happylab.filter;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class LocaleFilter implements Filter {
    private static final String LANGUAGE = "language";
    private static final String JSTL_LOCALE = "javax.servlet.jsp.jstl.fmt.locale.session";
    private static final String RU = "ru_RU";
    private String language = RU;

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        String languageParam = filterConfig.getInitParameter(LANGUAGE);

        if (languageParam != null) {
            language = languageParam;
        }
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;

        String newLanguage = request.getParameter(LANGUAGE);
        String oldLanguage = new String();

        if(request.getSession().getAttribute(LANGUAGE) != null){
            oldLanguage = request.getSession().getAttribute(LANGUAGE).toString();
        }

        if(newLanguage == null){
            newLanguage = language;
        }
        if(oldLanguage == null){
            oldLanguage = language;
        }

        if(!newLanguage.equalsIgnoreCase(oldLanguage)) {
            request.getSession().setAttribute(JSTL_LOCALE, newLanguage);
        }
        filterChain.doFilter(request, response);
    }

    @Override
    public void destroy() {

    }
}
