package br.com.adocao.servlet;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.adocao.dao.PetDAO;
import br.com.adocao.model.Pet;

@WebServlet("/novoPet")
public class NovoPetServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String nomePet = request.getParameter("nome");		
		String dataParam = request.getParameter("data");	
		String racaParam = request.getParameter("raca");
		String isVacinadoParam = request.getParameter("vacinado");
		
		boolean isVacinado = Boolean.parseBoolean(isVacinadoParam);
		
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
	    pet.setVacinado(isVacinado);
	    
		new PetDAO().gravarPet(pet);			

		response.sendRedirect("listaPets");
			
	}

}
