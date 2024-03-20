package br.com.adocao.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.adocao.model.Abrigo;

public class AbrigoDAO {
	
	private Connection con = null;

	public List<Abrigo> listarAbrigos() {
		
		Conexao conexao = new Conexao();
		con = conexao.getConexao();
		
		List<Abrigo> abrigos = new ArrayList<Abrigo>();
		String sql = "SELECT * FROM tb_abrigo ORDER BY id";
		
		try (PreparedStatement pstmt = con.prepareStatement(sql); ResultSet rs = pstmt.executeQuery()) {

			while (rs.next()) {
				Abrigo abrigo = new Abrigo();
				abrigo.setId(rs.getInt("id"));
				abrigo.setNomeFantasia(rs.getString("nome_fantasia"));
				abrigo.setNumInscricao(rs.getString("cnpj"));
				abrigo.setEndereco(rs.getString("endereco"));
				abrigo.setTelefone(rs.getString("telefone"));
				
				abrigos.add(abrigo);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			return abrigos;
		}
		return abrigos;
	}
	
	
}
