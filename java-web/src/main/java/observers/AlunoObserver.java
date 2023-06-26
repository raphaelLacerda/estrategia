package observers;

import java.nio.file.Files;

import javax.enterprise.event.ObservesAsync;

import modelo.Aluno;

public class AlunoObserver {

		
	
	public void enviarEmailQueAlunoFoiAlterado(@ObservesAsync Aluno aluno) {
		
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println("enviando email de cadastro do aluno"+ aluno);
	}
}
