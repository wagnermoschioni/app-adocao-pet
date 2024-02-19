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

@WebServlet("/alteraPet")
public class AlteraPetServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String id = request.getParameter("id");
		String nome = request.getParameter("nome");		
		String dataParam = request.getParameter("data");

		Integer idParam = Integer.parseInt(id);
		
		Date dataNascimento = null;
		try {
			SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
			dataNascimento = sdf.parse(dataParam);
		} catch (ParseException e) {
			throw new ServletException(e);
		}
		
		Banco banco = new Banco();
		Pet pet = banco.buscarPet(idParam);
		
		pet.setNome(nome);
		pet.setDataNascimento(dataNascimento);
		
		response.sendRedirect("listaPets");

	}

}
