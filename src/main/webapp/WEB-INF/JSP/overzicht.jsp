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
		<c:when test='${empty persoon}'>
			<div class='fout'>${empty fout ? 'Inschrijving niet gevonden' : fout}</div>
		</c:when>
		<c:otherwise>		
			<h1>Bedankt voor je inschrijving!</h1>
			<table>
				<thead>
					<tr>
						<th>Naam</th>
						<th>Voornaam</th>
						<th>Activiteit</th>
						<th>Prijs</th>
					</tr>
				</thead>
				<tbody>
					<tr>
						<td>${persoon.naam}</td>						
						<td>${persoon.voornaam}</td>						
						<td>${persoon.activiteit.activiteit}</td>					
						<td>${persoon.activiteit.prijs}</td>
					</tr>
				</tbody>
			</table>
		</c:otherwise>
	</c:choose>
	</div>
</body>
</html>