package br.com.adocao.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import br.com.adocao.model.Pet;
import br.com.adocao.model.Usuario;

public class UsuarioDAO {
	
	private Connection con = null;
	
	public List<Usuario> listarUsuarios() {

		Conexao conexao = new Conexao();
		con = conexao.getConexao();
		List<Usuario> usuarios = new ArrayList<Usuario>();
		String sql = "SELECT * FROM tb_usuario ORDER BY id";

		try (PreparedStatement pstmt = con.prepareStatement(sql); ResultSet rs = pstmt.executeQuery()) {

			while (rs.next()) {
				Usuario user = new Usuario();
				user.setId(rs.getInt("id"));
				user.setLogin(rs.getString("login"));
				user.setSenha(rs.getString("senha"));

				usuarios.add(user);

			}
		} catch (SQLException e) {
			e.printStackTrace();

		}
		return usuarios;

	}
	
	public Usuario existeUsuario(String login, String senha) {
		List<Usuario> listaUsuarios = this.listarUsuarios();

		for (Usuario usuario : listaUsuarios) {
			if (usuario.isValido(login, senha)) {
				return usuario;
			}
		}
		return null;
	}
	
}
