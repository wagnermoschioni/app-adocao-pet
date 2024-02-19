package br.com.adocao.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet(urlPatterns = "/saudacao")
public class SaudacaoServlet extends HttpServlet{

	private static final long serialVersionUID = 1L;

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	
		PrintWriter writer = resp.getWriter();
		
		writer.println("<html>");
		writer.println("<body>");
		writer.println("Esse é o primeiro Servlet");
		writer.println("</body>");
		writer.println("</html>");
	}
}
