<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Novo Pet - Formulário</title>
</head>
<body>

	<form action="/adocao/alteraPet">
		<input type="hidden" name="id" value="${pet.id}"> Nome: <input
			type="text" name="nome" value="${pet.nome }"> Data
		Nascimento: <input type="text" name="data"
			value="<fmt:formatDate value="${ pet.dataNascimento }" pattern="dd/MM/yyyy" />">
		<input type="submit" value="Alterar">
	</form>

</body>
</html>