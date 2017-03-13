<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<head>
	<title>Sophia biblioteca</title>
	<meta charset="UTF-8" />

	<c:url value="/frontend/css/style.css" var="urlStyleCss" /> 
	<link rel="stylesheet" type="text/css" href="${ urlStyleCss }" />
	<link rel="stylesheet" type="text/css" href="<c:url value="/frontend/css/font-awesome.min.css" /> " />
	
	<link href="https://fonts.googleapis.com/css?family=Abel|Roboto" rel="stylesheet">
</head>
<body class="container">
	<div class="header-title">
		<h1 class="titulo-centralizado">Faculdade Impacta de Tecnologia
		<c:url value="/frontend/img/sophia.png" var="urlImgSophia" /> 
		<img class="logo" src="${urlImgSophia }" alt=""></h1>
	</div>

	<div class="header-wrapper">
		<div class="header-menu"><i class="fa fa-home fa-lg"></i> Home</div>
		<div class="header-menu"><i class="fa fa-search fa-lg"></i> Pesquisa</div>
		<div class="header-menu"><i class="fa fa-user-secret fa-lg"></i> Autoridades</div>
		<div class="header-menu"><i class="fa fa-shopping-basket fa-lg"></i> Minha seleção</div>
		<div class="header-menu"><i class="fa fa-tasks fa-lg"></i> Serviços</div>
		<!-- modal -->
		<div class="header-menu"><i class="fa fa-key fa-lg"></i> Login</div>
	</div>
	<div>
		<ul class="header-help">
			<li>
				<a href="" title="">Alto Contraste</a>
			</li>
			|
			<li> <!-- modal -->
				<a href="" title="">Acessibilidade</a>
			</li>
			|
			<li> <!-- modal -->
				<a href="" title="">Ajuda</a>
			</li>
		</ul>
	</div>
	

	<!-- AQUI VAI O CONTENT -->
	<div class="header-search"></div>
	
	
</body>
</html>