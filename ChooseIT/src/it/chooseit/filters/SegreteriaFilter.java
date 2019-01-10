package it.chooseit.filters;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;

/**
 * Servlet Filter implementation class SegreteriaFilter
 */
@WebFilter("/SegreteriaFilter")
public class SegreteriaFilter implements Filter {

  FilterConfig filterConfig;

  /**
   * Default constructor. 
   */
  public SegreteriaFilter() {
    // TODO Auto-generated constructor stub
  }

  /**
   * @see Filter#destroy()
   */
  public void destroy() {
    // TODO Auto-generated method stub
  }

  /**
   * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
   */
  public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
    //prendo l'attributo ruolo nella session
    String ruolo = (String) ((HttpServletRequest) request).getSession().getAttribute("ruolo");

    if (ruolo == null) {
      ruolo = "guest";
      ((HttpServletRequest) request).getSession().setAttribute("ruolo", ruolo);
    }

    //se sono segreteria posso andare
    //se non sono segreteria allora dispatcher
    if (!ruolo.trim().equals("segreteria")) {
      RequestDispatcher dispatcher = request.getServletContext().getRequestDispatcher("/index.jsp");
      request.setAttribute("nonAutorizzato", true);
      dispatcher.forward(request, response);
      return;
    }
    // pass the request along the filter chain
    chain.doFilter(request, response);
  }

  /**
   * @see Filter#init(FilterConfig)
   */
  public void init(FilterConfig fConfig) throws ServletException {
    filterConfig = fConfig;
  }

}
