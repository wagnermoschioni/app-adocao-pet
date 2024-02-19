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
</head>
<body>

	<c:if test="${ empty pets }">
	Não há pets cadastrados.
	</c:if>
	
	<ul>
		<c:forEach items="${pets}" var="pet">		
			<li>${pet.id } - ${ pet.nome }  -  <fmt:formatDate value="${ pet.dataNascimento }" pattern="dd/MM/yyyy" /> 
			<a href="/adocao/exibePet?id=${pet.id}">editar</a>
			<a href="/adocao/removePet?id=${pet.id}">excluir</a></li>
		</c:forEach>
	</ul>
</body>
</html>