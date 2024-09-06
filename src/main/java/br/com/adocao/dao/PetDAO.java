package br.com.adocao.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import br.com.adocao.model.Pet;

public class PetDAO {
	
	public final static String SQL_SELECT = "select * from tb_pet order by id";
	public final static String SQL_SELECT_ID = "SELECT * FROM tb_pet WHERE id = ?";
	public final static String SQL_UPDATE = "UPDATE tb_pet SET nome = ?, raca = ?, dt_nascimento = ? WHERE id = ?";
	public final static String SQL_DELETE_ID = "DELETE FROM tb_pet WHERE id = ?";
	public final static String SQL_INSERT = "INSERT INTO tb_pet (nome, raca, dt_nascimento) values (?, ?, ?)";
	
	private Connection con = null;
	
	public List<Pet> listarPets() {
		
		Conexao conexao = new Conexao();
		con = conexao.getConexao();
		List<Pet> pets = new ArrayList<Pet>();
		
		

		try (PreparedStatement pstmt = con.prepareStatement(SQL_SELECT); ResultSet rs = pstmt.executeQuery()) {

			while (rs.next()) {
				Pet pet = new Pet();
				pet.setId(rs.getInt("id"));
				pet.setNome(rs.getString("nome"));
				pet.setRaca(rs.getString("raca"));
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
	
	public Pet buscarPet(Integer id) {
		Conexao conexao = new Conexao();
		con = conexao.getConexao();
		Pet pet = null;
		
		try (PreparedStatement pstmt = con.prepareStatement(SQL_SELECT_ID)) {
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
					
		try (PreparedStatement pstmt = con.prepareStatement(SQL_INSERT)) {
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
				
		try (PreparedStatement pstmt = con.prepareStatement(SQL_DELETE_ID)) {
			pstmt.setInt(1, id);
			pstmt.executeUpdate();
		}  catch (SQLException e) {
			e.printStackTrace();
		}
		
		
	}
	
	public void atualizarPet(Integer id, String nome, String raca, Date dataNascimento) {
		Conexao conexao = new Conexao();
		con = conexao.getConexao();		
				
		try (PreparedStatement pstmt = con.prepareStatement(SQL_UPDATE)) {
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
