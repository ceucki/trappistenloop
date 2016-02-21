package net.gezinsbondouwegem.servlets;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.gezinsbondouwegem.entities.Adres;
import net.gezinsbondouwegem.entities.Persoon;
import net.gezinsbondouwegem.services.ActiviteitService;
import net.gezinsbondouwegem.services.AdresService;
import net.gezinsbondouwegem.services.CityService;
import net.gezinsbondouwegem.services.PersoonService;

@WebServlet("/index.htm")
public class IndexServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;
	private static final String VIEW = "/WEB-INF/JSP/index.jsp";
	private static final String REDIRECT_URL = "%s/overzicht.htm?id=%d";
	private final transient PersoonService persoonService = new PersoonService();
	private final transient ActiviteitService activiteitService = new ActiviteitService();
	private final transient AdresService adresService = new AdresService();
	private final transient CityService cityService = new CityService();


	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setAttribute("activiteiten", activiteitService.findAlleActiviteiten());
		request.setAttribute("postcodes", cityService.findAll());
		request.getRequestDispatcher(VIEW).forward(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Map<String, String> fouten = new HashMap<>();
		String voornaam = request.getParameter("voornaam");
		if (!Persoon.isVoornaamValid(voornaam)) {
			fouten.put("voornaam", "verplicht");
		}
		String familienaam = request.getParameter("familienaam");
		if (!Persoon.isFamilienaamValid(familienaam)) {
			fouten.put("familienaam", "verplicht");
		}
		String idActiviteit = request.getParameter("activiteit");
		if (idActiviteit == null)
		{
			fouten.put("activiteit", "verplicht");
		}
		String postcode = request.getParameter("postcode");
		String gemeente = request.getParameter("gemeente");
		String street = request.getParameter("straat");
		String telefoonNr = request.getParameter("telefoonNr");
		String email = request.getParameter("email");
		
		if (fouten.isEmpty()) {
			Persoon persoon = new Persoon(voornaam, familienaam, email, telefoonNr);	
			// TODO fetch adres, huisNr
			// Adres adres = adresService.read(Long.parseLong(street));
			Adres adres = new Adres(street,"1",postcode, gemeente);
			adresService.create(adres);
			persoon.setAdres(adres);			
			persoon.setActiviteit(activiteitService.read(Long.parseLong(idActiviteit)));
			persoonService.create(persoon);
			response.sendRedirect(
					response.encodeRedirectURL(String.format(REDIRECT_URL, request.getContextPath(), persoon.getId())));
		} else {
			request.setAttribute("fouten", fouten);
			request.getRequestDispatcher(VIEW).forward(request, response);
		}

	}

}
