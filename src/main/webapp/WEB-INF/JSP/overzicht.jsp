<%@ page contentType='text/html' pageEncoding='UTF-8' session='false'%>
<%@taglib prefix='c' uri='http://java.sun.com/jsp/jstl/core'%>

<!doctype html>
<html lang='nl'>
<head>
<meta charset="UTF-8" />
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Trappistenloop Gezinsbond Ouwegem</title>
<link rel="shortcut icon" href="../favicon.ico">
<link rel="stylesheet" type="text/css" href="styles/normalize.css" />
<link rel="stylesheet" type="text/css" href="styles/demos.css" />
<link rel="stylesheet" type="text/css" href="styles/component.css" />
<!--[if IE]>
  		<script src="http://html5shiv.googlecode.com/svn/trunk/html5.js"></script>
		<![endif]-->
</head>
<body>
	<div class="component">
		<img src='<c:url value="/images/header.jpg"/>'>
		<c:choose>
			<c:when test='${empty personenInMandje}'>
				<div class='fout'>${empty fout ? 'Geen inschrijvingen gevonden' : fout}</div>
			</c:when>
			<c:otherwise>
				<h1>Overzicht</h1>
				<form method="post">
					<table>
						<thead>
							<tr>
								<th>Naam</th>
								<th>Voornaam</th>
								<th>Activiteit</th>
								<th>Prijs</th>
								<th></th>
							</tr>
						</thead>
						<tbody>
							<c:forEach var='persoon' items='${personenInMandje}'>
								<tr>
									<td><c:out value='${persoon.naam}' /></td>
									<td><c:out value='${persoon.voornaam}' /></td>
									<td><c:out value='${persoon.activiteit.activiteit}' /></td>
									<td><c:out value="€ ${persoon.activiteit.prijs}"></c:out></td>
									<td><input type="hidden" value="${persoon.id}" name ="id" id="id"><input type='submit' value='Verwijderen' 
										id='verwijderen'>
									</td>
								</tr>
							</c:forEach>
						</tbody>
						<tfoot>
							<tr>
								<th>Totale Prijs</th>
								<th></th>
								<th></th>
								<th><c:out value="€ ${totalePrijs}"></c:out></th>
								<th></th>
							</tr>
						</tfoot>
					</table>
				</form>
			</c:otherwise>
		</c:choose>
		<div id="container_buttons">
			<a href="/Trappistenloop/index.htm"><button type="button"
					class="a_demo_one">Nog een persoon toevoegen</button></a> 
					<form method=post><input type="submit"
					class="a_demo_one" name ="bevestigen" value="Inschrijving bevestigen"/></form>
		</div>
	</div>
</body>
</html>