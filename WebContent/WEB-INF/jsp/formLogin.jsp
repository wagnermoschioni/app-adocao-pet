<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>LOG IN</title>
<link rel="stylesheet" href="css/login-estilo.css">
<link rel="preconnect" href="https://fonts.googleapis.com">
<link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.5.1/css/all.min.css" integrity="sha512-DTOQO9RWCH3ppGqcWaEA1BIZOC6xxalwEsw9c2QQeAIftl+Vegovlnee1c9QX4TctnWMn13TZye+giMm8e2LwA==" crossorigin="anonymous" referrerpolicy="no-referrer" />

<link
	href="https://fonts.googleapis.com/css2?family=Epilogue:ital,wght@0,100..900;1,100..900&family=Inter:wght@100..900&family=Lilita+One&family=Teko&display=swap"
	rel="stylesheet">
<link
	href="https://fonts.googleapis.com/css2?family=Belanosima:wght@400;700&family=Mochiy+Pop+One&family=Montserrat:ital,wght@0,100;0,200;0,300;0,400;0,500;0,600;0,700;0,800;0,900;1,100;1,200;1,300;1,400;1,500;1,600;1,700;1,900&family=Poppins:ital,wght@0,100;0,200;0,300;0,400;0,500;0,600;0,700;0,800;0,900;1,100;1,200;1,300;1,400;1,500;1,600;1,700;1,800;1,900&family=Roboto:wght@300;400&display=swap"
	rel="stylesheet">
</head>
<body>
 
	<main id="container">
        <form id="login-form">
            <div id="form-header">
                <h1>Faça seu login</h1>
               
            </div>
            <input type="hidden" name="acao" value="Login">
           <!--
            <div id="social-media">
                <a href="">
                    <i class="fa-solid fa-dog"></i>
                </a>               
                <a href="">
                    <i class="fa-solid fa-bone"></i>
                </a>
            </div>
-->
            <div id="inputs">
                <div class="input-box">
                    <label for="name">Login
                        <div class="input-field">
                            <i class="fa-solid fa-paw"></i>
                            <input type="text" id="login" name="login">
                        </div>
                    </label>
                </div>

                <div class="input-box">
                    <label for="name">Senha
                        <div class="input-field">
                            <i class="fa-solid fa-paw"></i>
                            <input type="password" id="senha" name="senha">
                        </div>
                    </label>
                </div>

               
            </div>

            <button type="submit" id="login-button">Login</button>


        </form>
    </main>   
		
</body>
</html>