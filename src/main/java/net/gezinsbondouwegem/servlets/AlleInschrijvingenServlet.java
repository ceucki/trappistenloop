package net.gezinsbondouwegem.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.gezinsbondouwegem.services.PersoonService;

/**
 * Servlet implementation class AlleInschrijvingenServlet
 */
@WebServlet("/alleinschrijvingen.htm")
public class AlleInschrijvingenServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final String VIEW = "/WEB-INF/JSP/alleinschrijvingen.jsp";   
	private static final PersoonService persoonService = new PersoonService();
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AlleInschrijvingenServlet() {
        super();     
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setAttribute("allePersonen", persoonService.findAllePersonen());
		request.getRequestDispatcher(VIEW).forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
