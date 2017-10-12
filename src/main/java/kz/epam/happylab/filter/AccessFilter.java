package kz.epam.happylab.filter;

import kz.epam.happylab.entity.User;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

import static kz.epam.happylab.util.Constant.*;

public class AccessFilter implements Filter {
    private static final String ADMINISTRATOR = "administrator";
    private static final String HEAD = "head";
    private static final String GUEST = "guest";
    private static final String DELIMITER = ",";

    private List<String> urlListAssistantForbidden;
    private List<String> urlListHeadForbidden;

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;
        HttpSession session = request.getSession(false);
        String url = request.getServletPath();

        if (session == null || session.getAttribute(USER) == null) {
            response.sendRedirect(request.getContextPath() + LOGIN_PATH);
        } else {
            User user = (User) session.getAttribute(USER);
            String usertype = user.getUsertype();

            if(usertype.isEmpty()) usertype = GUEST;

            if (GUEST.equalsIgnoreCase(usertype)) {
                response.sendRedirect(request.getContextPath() + LOGIN_PATH);
            }

            if (ADMINISTRATOR.equalsIgnoreCase(usertype)) {
                filterChain.doFilter(request, response);
            }

            if (HEAD.equalsIgnoreCase(usertype)) {
                if (urlListHeadForbidden.contains(url)) {
                    response.sendRedirect(request.getContextPath() + LOGIN_PATH);
                } else {
                    filterChain.doFilter(request, response);
                }
            }

            if (ASSISTANT.equalsIgnoreCase(usertype)) {
                if (urlListAssistantForbidden.contains(url)) {
                    response.sendRedirect(request.getContextPath() + LOGIN_PATH);
                } else {
                    filterChain.doFilter(request, response);
                }
            }
        }
    }

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        String urlsAssistantForbidden = filterConfig.getInitParameter(ASSISTANT);
        String urlsHeadForbidden = filterConfig.getInitParameter(HEAD);

        urlListAssistantForbidden = getForbiddenUrls(urlsAssistantForbidden);
        urlListHeadForbidden = getForbiddenUrls(urlsHeadForbidden);
    }

    private List<String> getForbiddenUrls(String urls){
        StringTokenizer token = new StringTokenizer(urls, DELIMITER);
        List<String> urlList = new ArrayList<>();

        while (token.hasMoreTokens()) {
            urlList.add(token.nextToken());
        }

        return urlList;
    }

    @Override
    public void destroy() {

    }
}
