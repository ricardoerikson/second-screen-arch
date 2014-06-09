package br.ufmg.ppgee.secondscreen.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

public class LoginInterceptor extends HandlerInterceptorAdapter {

    @Override
    public boolean preHandle(HttpServletRequest request,
	    HttpServletResponse response, Object handler) throws Exception {
	HttpSession session = request.getSession();

	String uri = request.getRequestURI();
	if (uri.startsWith("/login"))
	    return true;
	if (session.getAttribute("username") != null)
	    return true;

	response.sendRedirect("/login/form");
	return false;
    }

}
