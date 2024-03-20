<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.util.List, br.com.adocao.model.Abrigo"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Abrigos Parceiros</title>
<link rel="stylesheet" href="css/abrigo-estilo.css">
<link rel="preconnect" href="https://fonts.googleapis.com">
<link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
<link
	href="https://fonts.googleapis.com/css2?family=Epilogue:ital,wght@0,100..900;1,100..900&family=Inter:wght@100..900&family=Lilita+One&family=Teko&display=swap"
	rel="stylesheet">
<link
	href="https://fonts.googleapis.com/css2?family=Belanosima:wght@400;700&family=Mochiy+Pop+One&family=Montserrat:ital,wght@0,100;0,200;0,300;0,400;0,500;0,600;0,700;0,800;0,900;1,100;1,200;1,300;1,400;1,500;1,600;1,700;1,900&family=Poppins:ital,wght@0,100;0,200;0,300;0,400;0,500;0,600;0,700;0,800;0,900;1,100;1,200;1,300;1,400;1,500;1,600;1,700;1,800;1,900&family=Roboto:wght@300;400&display=swap"
	rel="stylesheet">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.5.1/css/all.min.css" integrity="sha512-DTOQO9RWCH3ppGqcWaEA1BIZOC6xxalwEsw9c2QQeAIftl+Vegovlnee1c9QX4TctnWMn13TZye+giMm8e2LwA==" crossorigin="anonymous" referrerpolicy="no-referrer" />
</head>
<body>
<main class="corpo">
<header>
        <div class="h1">Confira nossos abrigos parceiros:</div>
    </header>

    <div class="corpo-abrigos">
        
        <c:forEach items="${abrigos}" var="abrigo">
        
         <div class="abrigo-item">

            <h2>${abrigo.nomeFantasia}</h2>
            <div class="abrigo-endereco">
                <p>${abrigo.endereco}</p>
                <p>Santana de Parnaiba - SP</p>
                <div class="abrigo-contatos">
                    <i class="fa-solid fa-phone"></i>
                    <i class="fa-brands fa-whatsapp"></i>
                    <p class="telefoneInput">${abrigo.telefone}</p>
                </div>
            </div>
        </div>       
        
        </c:forEach>        
       
    </div>
 </main>
 <script>
//Obtém todos os elementos <p> com a classe 'telefone' e os formata
 var paragrafosTelefone = document.querySelectorAll('.telefoneInput');
 paragrafosTelefone.forEach(function(paragrafo) {
     var telefone = paragrafo.textContent;

     // Remove todos os caracteres não numéricos
     telefone = telefone.replace(/\D/g, '');

     // Formata o número de telefone
     var formattedTelefone = '(' + telefone.substring(0, 2) + ') ' + telefone.substring(2, 3) + ' ' + telefone.substring(3, 7) + '-' + telefone.substring(7);

     // Atualiza o texto do parágrafo com o número de telefone formatado
     paragrafo.textContent = formattedTelefone;
 });
</script>
	
</body>
</html>