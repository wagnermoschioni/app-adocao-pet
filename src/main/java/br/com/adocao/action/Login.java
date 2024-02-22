package br.com.adocao.action;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import br.com.adocao.dao.UsuarioDAO;
import br.com.adocao.model.Usuario;

public class Login implements Acao {

	@Override
	public String executa(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String login = request.getParameter("login");
		String senha = request.getParameter("senha");
		
			
		Usuario usuario = new UsuarioDAO().existeUsuario(login, senha);
		
		if (usuario != null) {
			System.out.println("Login efetuado com sucesso");
			HttpSession sessao = request.getSession();			
			sessao.setAttribute("usuarioLogado", usuario);
		} else {
			return "redirect:entrada?acao=LoginForm";
		}
		
		return "redirect:entrada?acao=ListaPets";
	}

}
