package net.gezinsbondouwegem.servlets;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import net.gezinsbondouwegem.entities.Persoon;
import net.gezinsbondouwegem.services.PersoonService;

/**
 * Servlet implementation class OverzichtServlet
 */
@WebServlet("/overzicht.htm")
public class OverzichtServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final String VIEW = "/WEB-INF/JSP/overzicht.jsp";
	private static final String REDIRECT_URL = "%s/bevestiging.htm";
	private final PersoonService persoonDAO = new PersoonService();
	private static final String MANDJE = "mandje";

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			HttpSession session = request.getSession(false);
			if (session != null) {
				@SuppressWarnings("unchecked")
				Set<Long> mandje = (Set<Long>) session.getAttribute(MANDJE);
				if (mandje != null) {
					List<Persoon> personenInMandje = new ArrayList<>();
					BigDecimal totalePrijs = new BigDecimal(0);
					Persoon persoon;
					for (Long id : mandje) {
						persoon = persoonDAO.read(id);
						personenInMandje.add(persoon);
						BigDecimal prijs = new BigDecimal(persoon.getActiviteit().getPrijs());
						totalePrijs = totalePrijs.add(prijs);
					}
					request.setAttribute("totalePrijs", totalePrijs);
					request.setAttribute("personenInMandje", personenInMandje);

				}
			}

		} catch (NumberFormatException ex) { // request param bevat geen getal
			request.setAttribute("fout", "Nummer niet correct");
		}

		request.getRequestDispatcher(VIEW).forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();
		if (session != null) {
			
			if (request.getParameter("bevestigen") != null)
			{
				session.invalidate();				
				redirect(request,response);
				return;
			}
			
			@SuppressWarnings("unchecked")
			Set<Long> mandje = (Set<Long>) session.getAttribute(MANDJE);
			if (mandje != null) {
				Long id = Long.parseLong(request.getParameter("id"));
				if (id != null) {
					Persoon persoon = persoonDAO.read(id);

					// remove the persoon out of the database
					persoonDAO.remove(persoon);

					mandje.remove(id);
					session.setAttribute(MANDJE, mandje);
					List<Persoon> personenInMandje = new ArrayList<>();
					BigDecimal totalePrijs = new BigDecimal(0);
					for (Long idPersoon : mandje) {
						persoon = persoonDAO.read(idPersoon);
						personenInMandje.add(persoon);
						BigDecimal prijs = new BigDecimal(persoon.getActiviteit().getPrijs());
						totalePrijs = totalePrijs.add(prijs);
					}
					request.setAttribute("personenInMandje", personenInMandje);
					request.setAttribute("totalePrijs", totalePrijs);
				}			
				
			}
		}
		request.getRequestDispatcher(VIEW).forward(request, response);

	}
	
	private void redirect(HttpServletRequest request, HttpServletResponse response) throws IOException 
	{
		response.sendRedirect(String.format(REDIRECT_URL, request.getContextPath()));
	}

}
