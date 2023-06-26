package servlet;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.List;
import java.util.Random;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import modelo.Curso;
import service.CarrinhoService;

@WebServlet("/carrinho")
public class CarrinhoServlet extends HttpServlet {

//	@Inject
//	private CarrinhoService carrinhoService;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

//		String nome = req.getParameter("nome");
//		if (nome != null) {
//			Curso curso = new Curso(nome, new BigDecimal(new Random().nextInt(500)));
//			carrinhoService.adicionar(curso);
//		}
//		List<Curso> cursos = carrinhoService.listar();
//
//		System.out.println("Total de cursos " + cursos.size());
//
//		if (cursos.size() > 3) {
//
//			carrinhoService.removendo();
//		}
//
//		resp.getWriter().print(cursos);
	}
}
