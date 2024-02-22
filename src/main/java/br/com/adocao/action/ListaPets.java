package br.com.adocao.action;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import br.com.adocao.dao.PetDAO;
import br.com.adocao.model.Pet;

public class ListaPets implements Acao {
	
	public String executa(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		long antes = System.currentTimeMillis();		
		
		List<Pet> lista = new PetDAO().listarPets();
		
		request.setAttribute("pets", lista);
		
		long depois = System.currentTimeMillis();
		
		System.out.println("TEMPO: " + (depois - antes));
		
//		RequestDispatcher dispatcher = request.getRequestDispatcher("listaPets.jsp");
//		dispatcher.forward(request, response);
	
		return "forward:listaPets.jsp";
		
	}

}
