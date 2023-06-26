package servlet;

import java.io.IOException;
import java.io.StringWriter;
import java.nio.charset.Charset;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.IOUtils;

import com.google.gson.Gson;

import dao.AlunoDAOJDBC;
import factory.ConnectionFactory;
import modelo.Aluno;

@WebServlet("/alunos")
public class AlunosServlet extends HttpServlet {

	private Map<Integer, Aluno> mapaDeAlunos = new HashMap<>();

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String id = req.getParameter("id");
		String jsp = req.getParameter("jsp");

		if (jsp != null && !jsp.isEmpty()) {
			req.setAttribute("alunos", buscarAlunos());
			RequestDispatcher requestDispatcher = req.getRequestDispatcher("/alunos.jsp");
			requestDispatcher.forward(req, resp);
			return;
		}

		if (id != null && !id.isEmpty()) {
			retornarJson(resp, mapaDeAlunos.get(Integer.parseInt(id)));
		} else {
			retornarJson(resp, buscarAlunos());
		}
	}

	private Collection<Aluno> buscarAlunos() {
		return mapaDeAlunos.values();
		
//		return new AlunoDAOJDBC(new ConnectionFactory().getConexao()).listar();
//		return new AlunoDAOJPA(JpaFactory.getEntityManager()).listar();
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String bodyAsString = recuperarJsonDaRequisicao(req);

		Aluno aluno = new Gson().fromJson(bodyAsString, Aluno.class);

//		salvarAlunoNaBaseDeDados(aluno);
		salvarAlunoEmMemoria(aluno);

		resp.setStatus(201);
		retornarJson(resp, aluno);
	}

	private void salvarAlunoNaBaseDeDados(Aluno aluno) {

		AlunoDAOJDBC alunoDAO = new AlunoDAOJDBC(new ConnectionFactory().getConexao());
		alunoDAO.salvar(aluno);

//		AlunoDAOJPA alunoDAOJPA = new AlunoDAOJPA(JpaFactory.getEntityManager());
//		alunoDAOJPA.salvar(aluno);

	}

	private void salvarAlunoEmMemoria(Aluno aluno) {
		int idAlunos = mapaDeAlunos.size() + 1;
		aluno.setId(idAlunos);
		mapaDeAlunos.put(aluno.getId(), aluno);
		System.out.println("total de alunos!" + mapaDeAlunos.size());
	}

	private String recuperarJsonDaRequisicao(HttpServletRequest req) throws IOException {
		StringWriter writer = new StringWriter();
		IOUtils.copy(req.getInputStream(), writer, Charset.defaultCharset());
		String bodyAsString = writer.toString();
		
		System.out.println(bodyAsString);
		return bodyAsString;
	}

	private void retornarJson(HttpServletResponse resp, Object retorno) throws IOException {
		resp.setContentType("application/json");
		resp.setHeader("Access-Control-Allow-Origin", "*");
		resp.getWriter().print(new Gson().toJson(retorno));
	}
}
