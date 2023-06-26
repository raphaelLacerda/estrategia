package modelo;

import java.math.BigDecimal;

import org.junit.Assert;
import org.junit.Test;

public class AlunoTest {

	@Test
	public void deve_calcular_total_contratado() {

		Aluno aluno = new Aluno();
		aluno.contratarCurso(new Curso("a", BigDecimal.TEN));
		aluno.contratarCurso(new Curso("b", BigDecimal.ONE));
		aluno.contratarCurso(new Curso("c", BigDecimal.TEN));

		Assert.assertEquals(new BigDecimal("21"), aluno.totalContratado());
	}

}
