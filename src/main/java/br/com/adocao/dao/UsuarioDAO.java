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
	
	public Pet buscarPet(Integer id) {
		Conexao conexao = new Conexao();
		con = conexao.getConexao();
		String sql = "SELECT * FROM tb_pet WHERE id = ?";
		Pet pet = null;
		
		try (PreparedStatement pstmt = con.prepareStatement(sql)) {
			pstmt.setLong(1, id);

			try (ResultSet rs = pstmt.executeQuery()) {
				if (rs.next()) {
					String nome = rs.getString("nome");	
					String raca = rs.getString("raca");
					java.sql.Date dtNascimentoSql = rs.getDate("dt_nascimento");
					java.util.Date dtNascimento = new java.util.Date(dtNascimentoSql.getTime());

					pet = new Pet();
					pet.setId(id);
					pet.setNome(nome);
					pet.setRaca(raca);
					pet.setDataNascimento(dtNascimento);
				}
			}

		} catch (SQLException e) {
			e.printStackTrace();
			return pet;
		}
		return pet;
	}
	
	
	public void gravarPet(Pet pet) {
		Conexao conexao = new Conexao();
		con = conexao.getConexao();
		
		String sql = "INSERT INTO tb_pet (nome, raca, dt_nascimento) values (?, ?, ?)";
			
		try (PreparedStatement pstmt = con.prepareStatement(sql)) {
			pstmt.setString(1, pet.getNome());
			pstmt.setString(2, pet.getRaca());
			java.sql.Date dataParam = new java.sql.Date(pet.getDataNascimento().getTime());
			pstmt.setDate(3, dataParam);
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();

		}
		
	}
	
	
	public void removerPet(Integer id) {
		Conexao conexao = new Conexao();
		con = conexao.getConexao();
		
		String sql = "DELETE FROM tb_pet WHERE id = ?";
		
		try (PreparedStatement pstmt = con.prepareStatement(sql)) {
			pstmt.setInt(1, id);
			pstmt.executeUpdate();
		}  catch (SQLException e) {
			e.printStackTrace();
		}
		
		
	}
	
	public void atualizarPet(Integer id, String nome, String raca, Date dataNascimento) {
		Conexao conexao = new Conexao();
		con = conexao.getConexao();		
		String sql = "UPDATE tb_pet SET nome = ?, raca = ?, dt_nascimento = ? WHERE id = ?";
		
		try (PreparedStatement pstmt = con.prepareStatement(sql)) {
			pstmt.setString(1, nome);
			pstmt.setString(2, raca);
			java.sql.Date dataNascSql = new java.sql.Date(dataNascimento.getTime());
			pstmt.setDate(3, dataNascSql);
			pstmt.setLong(4, id);

			pstmt.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();

		}
	}
}
