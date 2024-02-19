<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Adoção Pet - Cadastro</title>
</head>
<body>
	<c:if test="${ empty nome }">
	Nenhum pet informado.
	</c:if>

	<c:if test="${ not empty nome }">
	Cadastro do amiguinho ${ nome } efetuado com sucesso.
	</c:if>

</body>
</html>