package servlet;

import java.io.IOException;
import java.io.StringWriter;
import java.nio.charset.Charset;
import java.time.LocalDate;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.enterprise.context.RequestScoped;
import javax.enterprise.event.Event;
import javax.inject.Inject;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.IOUtils;

import com.google.gson.Gson;

import dao.AlunoDAOJDBC;
import dao.AlunoDAOJPA;
import dao.AlunoDAOJPACDI;
import dao.AlunoDAOJPAEJB;
import factory.ConnectionFactory;
import factory.JpaFactory;
import modelo.Aluno;

@WebServlet("/cadastro/alunos")
public class AlunosCadastroServlet extends HttpServlet {

	private Map<Integer, Aluno> mapaDeAlunos = new HashMap<>();

	@Inject
	private AlunoDAOJPACDI alunoDAOJPA;

//	@Inject
//	private Event<Aluno> events;

//	@Inject
//	private AlunoDAOJPAEJB alunoDAOJPA;
//	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String nome = req.getParameter("nome");
		String email = req.getParameter("email");
		String data = req.getParameter("dataNascimento");

//		AlunoDAOJPA alunoDAOJPA = new AlunoDAOJPA();

//		salvarAlunosEmMemoria(resp, nome, email, data);

		Aluno alunoSalvo = alunoDAOJPA.salvar(new Aluno(nome, email, LocalDate.parse(data)));

		RequestDispatcher requestDispatcher = req.getRequestDispatcher("/lista.jsp");
		List<Aluno> alunos = alunoDAOJPA.listar();
		req.setAttribute("alunos", alunos);

		System.out.println("redirecionando aluno para listagem");
		requestDispatcher.forward(req, resp);
	}

	private void salvarAlunosEmMemoria(HttpServletResponse resp, String nome, String email, String data)
			throws IOException {
		int id = mapaDeAlunos.size() + 1;
		mapaDeAlunos.put(id, new Aluno(id, nome, email, LocalDate.parse(data)));
		resp.getWriter().println("aluno cadastrado com sucesso: " + mapaDeAlunos.get(id));
	}
}
