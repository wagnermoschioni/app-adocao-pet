<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.util.List, br.com.adocao.model.Pet"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Listagem de Pets</title>
</head>
<body>
	<ul>
		<c:forEach items="${pets}" var="pet">
			<li>${ pet.nome }</li>
		</c:forEach>
	</ul>
</body>
</html>