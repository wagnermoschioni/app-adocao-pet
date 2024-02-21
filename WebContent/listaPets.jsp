<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.util.List, br.com.adocao.model.Pet"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>


<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Listagem de Pets</title>
<link href="css/fontawesome/css/all.min.css" rel="stylesheet">
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.11.3/font/bootstrap-icons.min.css">
<link href="css/lista-estilo.css" rel="stylesheet">
<link
	href="https://fonts.googleapis.com/css2?family=Belanosima:wght@400;700&family=Mochiy+Pop+One&family=Montserrat:ital,wght@0,100;0,200;0,300;0,400;0,500;0,600;0,700;0,800;0,900;1,100;1,200;1,300;1,400;1,500;1,600;1,700;1,900&family=Poppins:ital,wght@0,100;0,200;0,300;0,400;0,500;0,600;0,700;0,800;0,900;1,100;1,200;1,300;1,400;1,500;1,600;1,700;1,800;1,900&family=Roboto:wght@300;400&display=swap"
	rel="stylesheet">
<link rel="icon" href="img/favicon.ico" type="image/x-icon">
</head>
<body class="body-lista">

	<c:if test="${ empty pets }">
		<div class="sem-pet">
			<!-- <img src="img/dog-adoteme.jpg" alt=""> -->
			<i class="bi bi-exclamation-triangle"></i>
			<h2>Não há pets cadastrados!</h2>

		</div>
	</c:if>
	
	
	<c:if test="${ not empty pets }">
	
		<main class="table">
		<section class="table_header">
				<h1>LISTA DE PETS</h1>
				<h3>Total: ${pets.size()}</h3>
			</section>
			
			<section class="table_body">
					<table>
					<thead>
						<tr>
							<th>Cód.</th>
							<th>Nome</th>
							<th>Raça</th>
							<th>Data Nasc.</th>
							<th></th>
							<th></th>
							<th></th>
						</tr>
					</thead>
					<tbody>

						<c:forEach items="${pets}" var="pet">
							<tr>

								<td>${pet.id}</td>
								<td>${ pet.nome }</td>
								<td>${ pet.raca }</td>								
								<td><fmt:formatDate value="${ pet.dataNascimento }"
										pattern="dd/MM/yyyy" /></td>
								<td><a href="#" title="Imagem do pet"><i
										class="bi bi-camera-fill foto-pet"></i></a></td>
								<td><a href="/adocao/exibePet?id=${pet.id}" title="Editar"><i
										class="bi bi-pencil-square editar-icon"></i></a></td>
								<td><a href="/adocao/removePet?id=${pet.id}"
									title="Excluir"><i class="bi bi-x-circle excluir-icon"></i></a></td>


							</tr>
						</c:forEach>

					</tbody>
					
					
					
					</table>
			
			</section>
		
		</main>
	
	
	
	</c:if>
	
	
	
	
	
	
	<!-- 
	<ul>
		<c:forEach items="${pets}" var="pet">		
			<li>${pet.id } - ${ pet.nome }  -  <fmt:formatDate value="${ pet.dataNascimento }" pattern="dd/MM/yyyy" /> 
			<a href="/adocao/exibePet?id=${pet.id}">editar</a>
			<a href="/adocao/removePet?id=${pet.id}">excluir</a></li>
		</c:forEach>
	</ul>
	 -->
</body>
</html>