<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Novo Pet - Formulário</title>

<link rel="stylesheet" href="css/formulario-estilo.css">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.5.1/css/all.min.css" integrity="sha512-DTOQO9RWCH3ppGqcWaEA1BIZOC6xxalwEsw9c2QQeAIftl+Vegovlnee1c9QX4TctnWMn13TZye+giMm8e2LwA==" crossorigin="anonymous" referrerpolicy="no-referrer" />
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

	<main id="container">
        <form id="login-form">
            <div id="form-header">
                <h1>Cadastro</h1>
                <i class="fa-solid fa-cat"></i>
            </div>
          	<input type="hidden" name="acao" value="NovoPet">
            <div id="inputs">
                <div class="input-box">
                    <label for="name">Nome
                        <div class="input-field">
                            <i class="fa-solid fa-paw"></i>
                            <input type="text" id="name" name="nome">
                        </div>
                    </label>
                </div>

                <div class="input-box">
                    <label for="name">Raça
                        <div class="input-field">
                            <i class="fa-solid fa-paw"></i>
                            <input type="text" id="raca" name="raca">
                        </div>
                    </label>
                </div>

                <div class="input-box">
                    <label for="name">Data Nascimento
                        <div class="input-field">
                            <i class="fa-solid fa-calendar"></i>
                            <input type="text" id="dataNasc" name="data">
                        </div>
                    </label>
                </div>
                
            </div>
            <button type="submit" id="gravar-button">Gravar</button>
        </form>
    </main>   
    
    <script>
        // Obtém o elemento de entrada de texto
        var input = document.getElementById('dataNasc');
        
        // Adiciona um listener para o evento 'input'
        input.addEventListener('input', function() {
            // Obtém o valor atual do input
            var value = input.value;
        
            // Remove todos os caracteres não numéricos
            value = value.replace(/\D/g, '');
        
            // Formata a data (dd/mm/yyyy)
            if (value.length > 2) {
                value = value.substring(0, 2) + '/' + value.substring(2);
            }
            if (value.length > 5) {
                value = value.substring(0, 5) + '/' + value.substring(5, 9);
            }
        
            // Atualiza o valor do input
            input.value = value;
        });
        </script>
</body>
</html>