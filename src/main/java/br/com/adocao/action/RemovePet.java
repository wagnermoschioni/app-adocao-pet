package br.com.adocao.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.adocao.dao.PetDAO;

public class RemovePet {
	
	public String executa(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String idParam = request.getParameter("id");		
		Integer id = Integer.parseInt(idParam);		

		new PetDAO().removerPet(id);
		//response.sendRedirect("entrada?acao=ListaPets");
		
		return "redirect:entrada?acao=ListaPets";
		
		
	}

}
