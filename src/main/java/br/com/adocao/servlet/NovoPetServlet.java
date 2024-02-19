package br.com.adocao.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.adocao.model.Banco;
import br.com.adocao.model.Pet;

@WebServlet("/novoPet")
public class NovoPetServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String nomePet = request.getParameter("nome");
		
		Pet pet = new Pet();
		pet.setNome(nomePet);
				
		Banco banco = new Banco();
		
		banco.adiciona(pet);
		
		/*
		PrintWriter writer = response.getWriter();

		writer.println("<html>");
		writer.println("<body>");
		writer.println("Cadastro do pet " + nomePet + " efetuado com sucesso");
		writer.println("</body>");
		writer.println("</html>");
		*/
		
		request.setAttribute("nome", pet.getNome());
		RequestDispatcher dispatcher = request.getRequestDispatcher("novoPetCadastrado.jsp");
		dispatcher.forward(request, response);
			
	}

}
