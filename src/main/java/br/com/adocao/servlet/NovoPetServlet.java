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

import br.com.adocao.model.Banco;
import br.com.adocao.model.Pet;

@WebServlet("/novoPet")
public class NovoPetServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String nomePet = request.getParameter("nome");		
		String dataParam = request.getParameter("data");		
		
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
		Banco banco = new Banco();
		
		banco.adiciona(pet);
		
//		request.setAttribute("nome", pet.getNome());
//		RequestDispatcher dispatcher = request.getRequestDispatcher("listaPets");
//		dispatcher.forward(request, response);
		response.sendRedirect("listaPets");
			
	}

}
