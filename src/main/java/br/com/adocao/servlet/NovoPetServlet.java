package br.com.adocao.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/novoPet")
public class NovoPetServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String nomePet = request.getParameter("nome");
		
		PrintWriter writer = response.getWriter();

		writer.println("<html>");
		writer.println("<body>");
		writer.println("Cadastro do pet " + nomePet + " efetuado com sucesso");
		writer.println("</body>");
		writer.println("</html>");
	}

}
