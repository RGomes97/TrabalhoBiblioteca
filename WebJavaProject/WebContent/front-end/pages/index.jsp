<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<title>Sophia biblioteca</title>
	<meta charset="UTF-8" />
	<link rel="stylesheet" type="text/css" href="../css/style.css" />
	<link rel="stylesheet" type="text/css" href="../css/font-awesome.min.css" />
	<link href="https://fonts.googleapis.com/css?family=Abel|Roboto" rel="stylesheet">
</head>
<body class="container">
	<div class="header-title">
		<h1 class="titulo-centralizado">Faculdade Impacta de Tecnologia
		<img class="logo" src="../img/sophia.png" alt=""></h1>
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
	<!-- tab search -->
	<div class=" nav-tab-custom">
		<ul id="tabs" class="header-search nav nav-tabs">
			<li><a href="#buscaRapida" type="nav-tab">Busca rápida</a></li>
			<li><a href="#buscaCombinada" type="nav-tab">Busca combinada</a></li>
			<li class="pull-right">
				<select>
					<option>Qualquer Biblioteca</option>
					<option>Biblioteca2</option>
					<option>Crizólito Antunes de Souza</option>
				</select>
			</li>
		</ul>
		<div class="tab-content">
			<!-- content busca rapida -->
			<div class="active tab-pane" id="buscaRapida">
				<select>
					<option>Todos os campos</option>
					<option>Título</option>
					<option>Autor</option>
					<option>Assunto</option>
					<option>Editora</option>
					<option>ISBN / ISSN</option>
					<option>Série</option>
					<option>Desc. compl.</option>
				</select>
				<input type="text" placeholder="Digite aqui a sua busca">
				<button class="btn-default">Buscar</button>
				<button class="btn-default">Limpar</button>
				<input class="checkboxtext" type="checkbox">
				Registros com conteudo digital
			</div>
			<!-- content busca Combinada -->
			<div class="tab-pane" id="buscaCombinada">

			</div>

			<div class="tab-pane" id="buscaCombinada">
				<ul>
					<li>
						<select>
							<option>Todos os campos</option>
							<option>Título</option>
							<option>Autor</option>
							<option>Assunto</option>
							<option>Editora</option>
							<option>ISBN / ISSN</option>
							<option>Série</option>
							<option>Desc. compl.</option>
						</select>
						<input type="text" placeholder="Digite aqui a sua busca">
						<select>
							<option>E</option>
							<option>OU</option>
							<option>E NÃO</option>
						</select>
						<span>Ano edição</span>
							<input class="input-peq" type="text" placeholder="Ano">
							<input class="input-peq" type="text" placeholder="Ano">
					</li>
					<li>
						<select>
							<option>Todos os campos</option>
							<option>Título</option>
							<option>Autor</option>
							<option>Assunto</option>
							<option>Editora</option>
							<option>ISBN / ISSN</option>
							<option>Série</option>
							<option>Desc. compl.</option>
						</select>
						<input type="text" placeholder="Digite aqui a sua busca">
						<select>
							<option>E</option>
							<option>OU</option>
							<option>E NÃO</option>
						</select>
						<span>Material</span>
					</li>
					<li>
						<select>
							<option>Todos os campos</option>
							<option>Título</option>
							<option>Autor</option>
							<option>Assunto</option>
							<option>Editora</option>
							<option>ISBN / ISSN</option>
							<option>Série</option>
							<option>Desc. compl.</option>
						</select>
						<input type="text" placeholder="Digite aqui a sua busca">
						<select>
							<option>E</option>
							<option>OU</option>
							<option>E NÃO</option>
						</select>
						<span>Idioma</span>
					</li>
					<li>
						<select>
							<option>Todos os campos</option>
							<option>Título</option>
							<option>Autor</option>
							<option>Assunto</option>
							<option>Editora</option>
							<option>ISBN / ISSN</option>
							<option>Série</option>
							<option>Desc. compl.</option>
						</select>
						<input type="text" placeholder="Digite aqui a sua busca">
						Ordenação
						<select>
							<option>Analítica de Obras</option>
							<option>Analítica de Periódicos</option>
							<option>Apostila</option>
							<option>Artigos</option>
							<option>Atlas</option>
							<option>Bíblias</option>
							<option>Bibliografias</option>
							<option>Biografias</option>
							<option>Capítulo</option>
							<option>CD-ROM</option>
							<option>Dicionários</option>
							<option>Discos</option>
							<option>Dissertações e Teses</option>
							<option>DVD</option>
							<option>Enciclopédias</option>
							<option>Engenharia de requisitos</option>
							<option>Eventos</option>
							<option>Fascículos</option>
							<option>Fitas gravadas</option>
							<option>Folhetos</option>
							<option>Homepages</option>
							<option>Livros</option>
							<option>Mapas e Globos</option>
							<option>Monografias</option>
							<option>Normas Técnicas</option>
							<option>Outros</option>
							<option>Periódico</option>
							<option>Periódico on-line</option>
							<option>Slides</option>
							<option>TCC CD-ROM</option>
							<option>Vídeos</option>
						</select>
					</li>
				</ul>
				<span>Ultimas Aquisições</span>
				<select>
					<option>igual a</option>
					<option>menor que</option>
					<option>Maio que</option>
					<option>entre</option>
				</select>
				<span><input class="checkboxtext" type="checkbox">
				Registros com conteudo digital</span>
				<button class="btn-default">Buscar</button>
				<button class="btn-default">Limpar</button>
			</div>
		</div>
	</div>

	<!-- AQUI VAI O CONTENT -->
	<div class="header-search"></div>
	
	
</body>
</html>