<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>LOG IN</title>
<link rel="stylesheet" href="css/formulario-estilo.css">
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

	<section>

		<div class="form-box">
			<div class="form-value">
				<form action="/adocao/entrada">
					<h2>Login</h2>
					<input type="hidden" name="acao" value="Login"> 
					<div class="inputbox">
						<input type="text" name="login"><label for="login">Login</label>
					</div>
					
					<div class="inputbox">
						<input type="password" name="senha"><label for="senha">Senha</label>
					</div>

					
					<button type="submit">LOG IN</button>

				</form>
				<!-- 
				<button onclick="history.go(-1)">Cancelar</button>
					 -->
			</div>
		</div>
	</section>
	<script type="module"
		src="https://unpkg.com/ionicons@7.1.0/dist/ionicons/ionicons.esm.js"></script>
	<script nomodule
		src="https://unpkg.com/ionicons@7.1.0/dist/ionicons/ionicons.js"></script>
</body>
</html>