package scheduler;

import java.util.List;

import javax.ejb.Schedule;
import javax.ejb.Stateless;
import javax.ejb.Timeout;
import javax.inject.Inject;

import dao.AlunoDAOJPAEJB;
import modelo.Aluno;

@Stateless
public class AlunosScheduler {


	@Inject
	private AlunoDAOJPAEJB dao;
	
//	https://docs.oracle.com/javaee/6/api/javax/ejb/ScheduleExpression.html
//	@Schedule(hour = "*", minute = "*", second = "*/30", persistent = false)
	public void notificarAlunos() {

		
		List<Aluno> aniversariantes = dao.listarAniversariantes();
		
		System.out.println("quantidade de alunos para serem notificados "+ aniversariantes.size());
		
		aniversariantes.forEach(a -> {
			
			System.out.println("Parabens "+ a);
		});
		
	}
	
	
	
}
