<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Página Inicial</title>
<link rel="stylesheet" href="css/home-estilo.css">
<link rel="preconnect" href="https://fonts.googleapis.com">
<link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
<link
	href="https://fonts.googleapis.com/css2?family=Epilogue:ital,wght@0,100..900;1,100..900&family=Inter:wght@100..900&family=Lilita+One&family=Teko&display=swap"
	rel="stylesheet">
<link
	href="https://fonts.googleapis.com/css2?family=Belanosima:wght@400;700&family=Mochiy+Pop+One&family=Montserrat:ital,wght@0,100;0,200;0,300;0,400;0,500;0,600;0,700;0,800;0,900;1,100;1,200;1,300;1,400;1,500;1,600;1,700;1,900&family=Poppins:ital,wght@0,100;0,200;0,300;0,400;0,500;0,600;0,700;0,800;0,900;1,100;1,200;1,300;1,400;1,500;1,600;1,700;1,800;1,900&family=Roboto:wght@300;400&display=swap"
	rel="stylesheet">
</head>
<body>

	

		<header>
		<div id="title">
			<h1>
				Pet <span>Adoção <ion-icon name="paw-outline"></ion-icon></span>
			</h1>
		</div>
		
		
		<ul>
			<a href="#" class="inscricao"><li>Bem-vindo, <b>${usuarioLogado.login}</b></li></a>
			<a href="entrada?acao=Logout" class="inscricao"><li>Sair</li></a>
			
		</ul>
		 
	</header>
	
	<main>
	
	<aside>
		<h2>
				<span>A cada lar encontrado,</span>
			</h2>
			<h2>um novo animalzinho <span>feliz</span>!</h2>
			
			<div class="btn-op">
			<button
						onclick="window.location.href='/adocao/entrada?acao=ListaPets'">VER PETS</button>
			<button class="btn-opcoes"
						onclick="window.location.href='/adocao/entrada?acao=NovoPetForm'">CADASTRAR</button>
			
				</div>
	</aside>
	
	<article>
			<img src="img/cat-dog-2.webp" alt="Dog Cat">
		</article>
	
	</main>	
	
	<script type="module"
		src="https://unpkg.com/ionicons@7.1.0/dist/ionicons/ionicons.esm.js"></script>
	<script nomodule
		src="https://unpkg.com/ionicons@7.1.0/dist/ionicons/ionicons.js"></script>
</body>
</html>