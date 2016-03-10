package net.gezinsbondouwegem.servlets;

import java.io.IOException;
import java.sql.Date;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

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
	private static final String REDIRECT_URL_LOGIN = "%s/alleinschrijvingen.htm?";
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

		String login = request.getParameter("login");
		String password = request.getParameter("password");

		if (checkLogin(login, password)) {
			checkLogin(request, response);

		} else {

			persoontoevoegen(request, response);
		}
	}

	private void persoontoevoegen(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
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
		if (idActiviteit == null) {
			fouten.put("activiteit", "verplicht");
		}
		String postcode = request.getParameter("postcode");
		String gemeente = request.getParameter("gemeente");
		String street = request.getParameter("straat");
		String telefoonNr = request.getParameter("telefoonNr");
		String email = request.getParameter("email");

		if (fouten.isEmpty()) {
			Persoon persoon = new Persoon(voornaam, familienaam, email, telefoonNr, new Date(Calendar.getInstance().getTime().getTime()));		
			Adres adres = new Adres(street, "1", postcode, gemeente);
			adresService.create(adres);	
			persoon.setAdres(adres);
			persoon.setActiviteit(activiteitService.read(Long.parseLong(idActiviteit)));
			persoonService.create(persoon);

			Properties props = new Properties();
			props.setProperty("mail.host", "smtp.gmail.com");
			props.setProperty("mail.smtp.port", "587");
			props.setProperty("mail.smtp.auth", "true");
			props.setProperty("mail.smtp.starttls.enable", "true");

			/*
			 * Session session = Session.getInstance(props, new
			 * javax.mail.Authenticator() { protected PasswordAuthentication
			 * getPasswordAuthentication() { return new
			 * PasswordAuthentication("kristof.ceuterick@gmail.com",
			 * "7b62f39b"); } });
			 * 
			 * /* MimeMessage msg = new MimeMessage(session); try {
			 * msg.setText("testtext"); } catch (MessagingException e3) { //
			 * TODO Auto-generated catch block e3.printStackTrace(); } try {
			 * msg.setSubject("testsubject"); } catch (MessagingException e2) {
			 * // TODO Auto-generated catch block e2.printStackTrace(); } try {
			 * msg.setFrom(new InternetAddress("kristof.ceuterick@gmail.com"));
			 * } catch (AddressException e1) { // TODO Auto-generated catch
			 * block e1.printStackTrace(); } catch (MessagingException e1) { //
			 * TODO Auto-generated catch block e1.printStackTrace(); } try {
			 * msg.addRecipient(Message.RecipientType.TO, new
			 * InternetAddress("kristof.ceuterick@gmail.com")); } catch
			 * (MessagingException e) { // TODO Auto-generated catch block
			 * e.printStackTrace(); } try { Transport.send(msg); } catch
			 * (MessagingException e) { // TODO Auto-generated catch block
			 * e.printStackTrace(); }
			 */

			response.sendRedirect(
					response.encodeRedirectURL(String.format(REDIRECT_URL, request.getContextPath(), persoon.getId())));
		} else {
			request.setAttribute("fouten", fouten);
			request.getRequestDispatcher(VIEW).forward(request, response);
		}
	}

	private boolean checkLogin(String login, String password) {
		if (login == null)
			return false;

		if (password == null)
			return false;

		if (!login.isEmpty() && !password.isEmpty()) {
			if (login.equals("test") && password.equals("test")) {
				return true;
			}
		}
		return false;
	}

	private void checkLogin(HttpServletRequest request, HttpServletResponse response) throws IOException {

		response.sendRedirect(response.encodeRedirectURL(String.format(REDIRECT_URL_LOGIN, request.getContextPath())));
	}

}
