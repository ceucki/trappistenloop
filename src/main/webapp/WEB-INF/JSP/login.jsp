<%@ page contentType='text/html' pageEncoding='UTF-8' session='false'%>
<%@taglib prefix='c' uri='http://java.sun.com/jsp/jstl/core'%>

<!doctype html>
<html lang='nl'>
<head>
<!--   <link rel='stylesheet' href='styles/default2.css'> -->
<title>Gezinsbond Ouwegem</title>
<meta name="viewport" content="width=device-width, initial-scale=1.0">

<!-- <link rel="shortcut icon" href="../favicon.ico"> -->
<link rel="stylesheet" type="text/css" href=<c:url value="styles/demo.css"/> />
<link rel="stylesheet" type="text/css" href=<c:url value="styles/style3.css"/> />
<link rel="stylesheet" type="text/css" href=<c:url value="styles/animate-custom.css"/> />

</head>
<body>
<header>
			<nav class="codrops-demos">
				<a href="/Trappistenloop/login.htm">Inloggen</a> <a
					href="/Trappistenloop/index.htm">Inschrijven</a>
			</nav>			
		</header>
	<div class="animate form" id="wrapper">
		<form method='post' id="aanmelden" autocomplete="on">
			<label>login:<span>${fouten.login}</span> <input name='login'
				value='${param.login}' autofocus required></label> <label>Password:
				<span>${fouten.password}</span> <input name='password'
				value='${param.password}' required type="password">
			</label> <input type='submit' value='Inloggen' id='inloggen'>
		</form>
	</div>
</body>
</html>