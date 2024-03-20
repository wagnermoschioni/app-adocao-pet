package br.com.adocao.action;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.adocao.dao.PetDAO;

public class AlteraPet implements Acao {
	
	public String executa(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String id = request.getParameter("id");
		String nome = request.getParameter("nome");	
		String raca = request.getParameter("raca");
		String dataParam = request.getParameter("data");

		Integer idParam = Integer.parseInt(id);
		
		Date dataNascimento = null;
		try {
			SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
			dataNascimento = sdf.parse(dataParam);
		} catch (ParseException e) {
			throw new ServletException(e);
			
		}		

		PetDAO dao = new PetDAO();		
		dao.atualizarPet(idParam, nome, raca, dataNascimento);		
		
		//response.sendRedirect("entrada?acao=ListaPets");
		
		return "redirect:entrada?acao=ListaPets";
		
		
	}

}
