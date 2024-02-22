package br.com.adocao.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.adocao.action.AlteraPet;
import br.com.adocao.action.ExibePet;
import br.com.adocao.action.ListaPets;
import br.com.adocao.action.NovoPet;
import br.com.adocao.action.RemovePet;


@WebServlet("/entrada")
public class PrincipalServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String paramAcao = request.getParameter("acao");
		String nomeAcaoExecutar = "";
		
		if (paramAcao.equals("ListaPets")) {
			ListaPets acao = new ListaPets();
			nomeAcaoExecutar = acao.executa(request, response);
		}
		
		if (paramAcao.equals("RemovePet")) {			
			RemovePet acao = new RemovePet();
			nomeAcaoExecutar = acao.executa(request, response);
		}
		
		if (paramAcao.equals("AlteraPet")) {
			AlteraPet acao = new AlteraPet();
			nomeAcaoExecutar =  acao.executa(request, response);
		}
		if (paramAcao.equals("ExibePet")) {			
			ExibePet acao = new ExibePet();
			nomeAcaoExecutar = acao.executa(request, response);
		}
		
		if (paramAcao.equals("NovoPet")) {			
			NovoPet acao = new NovoPet();
			nomeAcaoExecutar = acao.executa(request, response);
		}	
			
		String endereco = 	nomeAcaoExecutar.split(":")[1];
		
		
		if (nomeAcaoExecutar.split(":")[0].equals("forward")) {
			RequestDispatcher dispatcher = request.getRequestDispatcher(endereco);
			dispatcher.forward(request, response);
				
		} else {
			response.sendRedirect(endereco);
			
		}
     	
		
		
	}

}
