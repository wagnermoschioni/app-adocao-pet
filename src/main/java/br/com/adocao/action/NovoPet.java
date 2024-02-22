package br.com.adocao.action;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.adocao.dao.PetDAO;
import br.com.adocao.model.Pet;

public class NovoPet {
	
	public String executa(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String nomePet = request.getParameter("nome");		
		String dataParam = request.getParameter("data");	
		String racaParam = request.getParameter("raca");
		
		Date dataNascimento = null;
		try {
			SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
			dataNascimento = sdf.parse(dataParam);
		} catch (ParseException e) {			
			throw new ServletException(e);
		}		
		
		Pet pet = new Pet();
		pet.setNome(nomePet);
	    pet.setDataNascimento(dataNascimento);
	    pet.setRaca(racaParam);
	    
		new PetDAO().gravarPet(pet);			

    	//response.sendRedirect("entrada?acao=ListaPets");
    	
    	return "redirect:entrada?acao=ListaPets";
		
		
	}

}
