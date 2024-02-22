package br.com.adocao.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.adocao.dao.PetDAO;


@WebServlet("/removePet")
public class RemovePetServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String idParam = request.getParameter("id");		
		Integer id = Integer.parseInt(idParam);		

		new PetDAO().removerPet(id);
		response.sendRedirect("listaPets");
	}

}
