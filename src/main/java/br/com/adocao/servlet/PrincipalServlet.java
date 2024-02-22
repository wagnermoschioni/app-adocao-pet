package br.com.adocao.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import br.com.adocao.action.Acao;

@WebServlet("/entrada")
public class PrincipalServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String paramAcao = request.getParameter("acao");
		
		HttpSession sessao = request.getSession();

		boolean isAcaoProtegida = !(paramAcao.equals("LoginForm") || paramAcao.equals("Login"));
		
		if (isAcaoProtegida && (sessao.getAttribute("usuarioLogado") == null)) {
			response.sendRedirect("entrada?acao=LoginForm");
			return;
		}
		
	

		
		String nomeAcaoExecutar = "";
		String classeAcao = "br.com.adocao.action." + paramAcao;

		try {
			Class classe = Class.forName(classeAcao); // carregar a classe com o nome
			Acao obj = (Acao) classe.newInstance();
			nomeAcaoExecutar = obj.executa(request, response);
		} catch (ClassNotFoundException | InstantiationException | IllegalAccessException e) {
			throw new ServletException();
		}

		String endereco = nomeAcaoExecutar.split(":")[1];

		if (nomeAcaoExecutar.split(":")[0].equals("forward")) {
			RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/jsp/" + endereco);
			dispatcher.forward(request, response);

		} else {
			response.sendRedirect(endereco);

		}

	}

}
