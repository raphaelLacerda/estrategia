package service;

import java.io.Serializable;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.annotation.Resource;
import javax.ejb.EJBHome;
import javax.ejb.EJBMetaData;
import javax.ejb.EJBObject;
import javax.ejb.Handle;
import javax.ejb.HomeHandle;
import javax.ejb.LocalBean;
import javax.ejb.LocalHome;
import javax.ejb.PostActivate;
import javax.ejb.PrePassivate;
import javax.ejb.Remove;
import javax.ejb.RemoveException;
import javax.ejb.SessionContext;
import javax.ejb.Singleton;
import javax.ejb.Stateful;
import javax.ejb.StatefulTimeout;

import modelo.Curso;

//@Stateless
//@RequestScoped
@Stateful(passivationCapable = true)
//@StatefulTimeout(unit = TimeUnit.SECONDS, value = 30)
//@LocalBean
//@Singleton
public class CarrinhoService{
	

	private List<Curso> cursos = new ArrayList<Curso>();

	@PostActivate
	public void carregando() {
		System.out.println(this + "***********recuperando********" + cursos);
	}

	@PrePassivate
	public void serializando() {
		System.out.println(this + "*****************serializando " + cursos);
	}

	@PostConstruct
	public void inicializando() {
		System.out.println("criando novo carrinho service " + this);
	}

	@PreDestroy
	public void destruindo() {
		System.out.println("morrendo destruido!!!!!");
	}

	@Remove
	public void removendo() {
		System.out.println("removendo objeto");
	}

	public List<Curso> adicionar(Curso curso) {

		System.out.println("adicionando no carrinho" + this);
		cursos.add(curso);
		return cursos;
	}

	public List<Curso> listar() {

		System.out.println("listando cursos  " + this);
		return cursos;
	}

	

}
