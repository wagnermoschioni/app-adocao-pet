package br.com.adocao.action;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.adocao.dao.AbrigoDAO;


public class Abrigo implements Acao {
	
	public String executa(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		List<br.com.adocao.model.Abrigo> lista = new AbrigoDAO().listarAbrigos();
		request.setAttribute("abrigos", lista);
    	return "forward:abrigos.jsp";
		
		
	}

}
