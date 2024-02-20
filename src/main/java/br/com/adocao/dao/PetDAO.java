package br.com.adocao.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.adocao.model.Pet;

public class PetDAO {
	
	private Connection con = null;
	
	public List<Pet> listarPets() {
		
		Conexao conexao = new Conexao();
		con = conexao.getConexao();
		List<Pet> pets = new ArrayList<Pet>();
		String sql = "SELECT * FROM tb_pet ORDER BY id";
		

		try (PreparedStatement pstmt = con.prepareStatement(sql); ResultSet rs = pstmt.executeQuery()) {

			while (rs.next()) {
				Pet pet = new Pet();
				pet.setId(rs.getInt("id"));
				pet.setNome(rs.getString("nome"));
				java.sql.Date dtNascimentoSql = rs.getDate("dt_nascimento");
				java.util.Date dtNascimento = new java.util.Date(dtNascimentoSql.getTime());
				pet.setDataNascimento(dtNascimento);

				pets.add(pet);

			}
		} catch (SQLException e) {
			e.printStackTrace();
			return pets;
		}
		return pets;
		
		
	}
}
