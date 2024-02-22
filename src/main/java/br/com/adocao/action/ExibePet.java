package br.com.adocao.action;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.adocao.dao.PetDAO;
import br.com.adocao.model.Pet;

public class ExibePet implements Acao {
	
	public String executa(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String idParam = request.getParameter("id");		
		Integer id = Integer.parseInt(idParam);

		Pet pet = new PetDAO().buscarPet(id);
		
		request.setAttribute("pet", pet);
//		RequestDispatcher dispatcher = request.getRequestDispatcher("formEditaPet.jsp");
//		dispatcher.forward(request, response);
		return "forward:formEditaPet.jsp";
				
	}

}
