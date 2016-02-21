<%@ page contentType='text/html' pageEncoding='UTF-8' session='false'%>
<%@taglib prefix='c' uri='http://java.sun.com/jsp/jstl/core'%>

<!doctype html>
<html lang='nl'>
<head>
<!--   <link rel='stylesheet' href='styles/default2.css'> -->
<title>Gezinsbond Ouwegem</title>
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta name="description"
	content="Login and Registration Form with HTML5 and CSS3" />
<meta name="keywords"
	content="html5, css3, form, switch, animation, :target, pseudo-class" />
<meta name="author" content="Codrops" />
<link rel="shortcut icon" href="../favicon.ico">
<link rel="stylesheet" type="text/css" href="styles/demo.css" />
<link rel="stylesheet" type="text/css" href="styles/style3.css" />
<link rel="stylesheet" type="text/css" href="styles/animate-custom.css" />

</head>
<body>
	<div class="container">

		<header>
			<h1>Inschrijven trappistenloop Gezinsbond Ouwegem</h1>
		</header>
		<section>
			<div id="container_demo">
				<a class="hiddenanchor" id="tologin"></a>
				<div id="wrapper">
					<div id="login" class="animate form">
						<form method='post' id="toevoegform" autocomplete="on">
							<h1>Inschrijving Formulier</h1>
							<label>Voornaam:<span>${fouten.voornaam}</span> <input
								name='voornaam' value='${param.voornaam}' autofocus required></label>
							<label>Familienaam: <span>${fouten.familienaam}</span> <input
								name='familienaam' value='${param.familienaam}' required></label>
							<label>Straat: <span>${fouten.straat}</span> <input
								name='straat' value='${param.straat}'></label> 
							<!--  <label>Postcode:
								<span>${fouten.postcode}</span><br> <select name="postcode" required>
									<c:forEach var='postcode' items='${postcodes}'>
										<option value='${postcode.idcities}'>${postcode.structure}</option>
									</c:forEach>
							</select>
							</label> <br> -->
							<label>Postcode: <span>${fouten.postcode}</span> <input
								name='postcode' value='${param.postcode}' required></label>
							<label>Gemeente: <span>${fouten.gemeente}</span> <input
								name='gemeente' value='${param.gemeente}' required></label>
							<label>Telefoon Nr: <span>${fouten.telNr}</span> <input
								name='telefoonNr' value='${param.telNr}'></label> 
							<label>Email:
								<span>${fouten.email}</span> <input name='email'
								value='${param.email}'>
							</label> 
							<p>
							<label>Activiteit:</label> <br><select name="activiteit">
								<c:forEach var='optie' items='${activiteiten}'>
									<option value='${optie.id}'>${optie.activiteit}:
										€${optie.prijs}</option>
								</c:forEach>
								
							</select></p> <input type='submit' value='Inschrijven' id='toevoegknop'>
						</form>
					</div>				
				</div>
			</div>
		</section>
	</div>
	
	<script>
		document.getElementById('toevoegform').onsubmit = function() {
			document.getElementById('toevoegknop').disabled = true;
		};
	</script>
</body>
</html>