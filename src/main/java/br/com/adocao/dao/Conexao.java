package br.com.adocao.dao;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Properties;

public class Conexao {

	public Connection getConexao() {
		Connection result = null;

		try {
			Properties prop = new Properties();
			InputStream input = getClass().getClassLoader().getResourceAsStream("application.properties");

			if (input == null) {
				System.out.println("Nenhum arquivo 'database.properties' foi encontrado.");
				return null;
			}

			prop.load(input);

			String url = prop.getProperty("database.url");
			String user = prop.getProperty("database.user");
			String password = prop.getProperty("database.password");

			Class.forName("org.postgresql.Driver");
			result = DriverManager.getConnection(url, user, password);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}
}
