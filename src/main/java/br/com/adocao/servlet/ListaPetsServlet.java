package br.com.adocao.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.adocao.model.Banco;
import br.com.adocao.model.Pet;

@WebServlet("/listaPets")
public class ListaPetsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		Banco banco = new Banco();

		List<Pet> lista = banco.getLista();

		PrintWriter writer = response.getWriter();

		writer.println("<html>");
		writer.println("<body>");
		writer.println("<ul>");

		for (Pet pet : lista) {
			writer.println("<li>" + pet.getNome() + "</li>");
		}
		
		writer.println("</ul>");
		writer.println("</body>");
		writer.println("</html>");

	}

}
