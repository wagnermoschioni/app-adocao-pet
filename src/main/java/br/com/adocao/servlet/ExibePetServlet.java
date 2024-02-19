package br.com.adocao.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.adocao.model.Banco;
import br.com.adocao.model.Pet;


@WebServlet("/exibePet")
public class ExibePetServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String idParam = request.getParameter("id");
		
		Integer id = Integer.parseInt(idParam);
		
		Banco banco = new Banco();
		
		Pet pet = banco.buscarPet(id);
		
		request.setAttribute("pet", pet);
		RequestDispatcher dispatcher = request.getRequestDispatcher("formEditaPet.jsp");
		dispatcher.forward(request, response);
	}

}
