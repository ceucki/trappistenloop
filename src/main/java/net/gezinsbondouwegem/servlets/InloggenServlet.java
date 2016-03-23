package net.gezinsbondouwegem.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class InloggenServlet
 */
@WebServlet("/login.htm")
public class InloggenServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final String VIEW = "/WEB-INF/JSP/login.jsp";
	private static final String REDIRECT_URL_LOGIN = "%s/alleinschrijvingen.htm?";


	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.getRequestDispatcher(VIEW).forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String login = request.getParameter("login");
		String password = request.getParameter("password");

		if (!login.isEmpty() && !password.isEmpty()) {
			if (login.equals("test") && password.equals("test")) {
				response.sendRedirect(response.encodeRedirectURL(String.format(REDIRECT_URL_LOGIN, request.getContextPath())));
			}
		}
	}

}
