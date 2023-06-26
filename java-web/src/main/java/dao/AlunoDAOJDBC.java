package dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import factory.ConnectionFactory;
import modelo.Aluno;

public class AlunoDAOJDBC {

	private Connection conexao;

	public AlunoDAOJDBC(Connection conexao) {
		this.conexao = conexao;
	}

	public Aluno salvar(Aluno aluno) {

		try {
			PreparedStatement ps = conexao
					.prepareStatement("insert into aluno (nome, email, dataNascimento) values (?, ?, ?)");
			ps.setString(1, aluno.getNome());
			ps.setString(2, aluno.getEmail());
			ps.setDate(3, Date.valueOf(aluno.getDataNascimento()));
			ps.executeUpdate();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return aluno;
	}

	public List<Aluno> listar() {

		List<Aluno> alunos = new ArrayList<>();
		try {
			ResultSet rs = conexao.prepareStatement("select * from aluno").executeQuery();
			while (rs.next()) {

				alunos.add(new Aluno(rs.getInt("id"), rs.getString("nome"), rs.getString("email"),
						rs.getDate("dataNascimento").toLocalDate(), Collections.emptyList()));
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return alunos;

	}

	public static void main(String[] args) {

		Connection connection = new ConnectionFactory().getConexao();

		AlunoDAOJDBC alunoDAOJDBC = new AlunoDAOJDBC(connection);

		Aluno aluno = new Aluno();
		aluno.setNome("mathues");
		aluno.setDataNascimento(LocalDate.of(1985, 4, 28));
		aluno.setEmail("matheus@gmail.com");

		alunoDAOJDBC.salvar(aluno);

		List<Aluno> alunos = alunoDAOJDBC.listar();

		System.out.println(alunos);

	}

}
