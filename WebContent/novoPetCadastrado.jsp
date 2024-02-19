<% 
String nomePet = request.getParameter("nome"); 
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Adoção Pet - Cadastro</title>
</head>
<body>
  
  Cadastro do amiguinho <%=nomePet.toUpperCase() %> efetuado com sucesso.
</body>
</html>