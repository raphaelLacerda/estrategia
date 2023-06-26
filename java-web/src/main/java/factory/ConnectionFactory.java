package factory;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {

	public Connection getConexao() {

		try {

			Class.forName("org.postgresql.Driver");
			// NÃO esquecer de criar a base
			return DriverManager.getConnection("jdbc:postgresql://localhost:5432/alunos", "postgres", "alunos");

		} catch (SQLException | ClassNotFoundException e) {
			e.printStackTrace();
			throw new IllegalStateException(e);
		}
	}

	public static void main(String[] args) {
		System.out.println(new ConnectionFactory().getConexao());
	}
}
