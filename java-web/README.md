# Servlet
* Criar Servlet Olá Mundo
* sobrescrever método service
* Criar aluno (id, nome, email, cursos)
* Criar Curso (id, nome, preco)
* Cadastrar aluno
    * POST localhost:8080/java-web/alunos
    * Recuperar JSON da requisição
        * InputStream to StringWriter
    * JSOn to Aluno
    * salvar aluno no Map setando o ID a partir do size
    * retornar JSON com content/type

* Buscar todos alunos
* Buscar um aluno específico
* GET localhost:8080/java-web/alunos?id=1



# JSP

* Criar cadastro.jsp
* fazer cadastro chegar na servlet
* fazer request dispatcher para lista.jsp
* motivar saber quanto tempo durou - Filter
* falar de request, session

# JDBC

* estabelecer conexao
* Padrão Factory
* salvar aluno no banco de dados
	* prepared statement x statement
		Interpretar (parse) a consulta SQL;
		Compilar a consulta SQL;
		Planejar e otimizar o caminho de busca dos dados;
		Executar a consulta otimizada, buscando e retornando os dados.
* criar o padrao DAO
* listar alunos
* autocommit transacional - ACID
		

# JPA

* entidades
* conexao base
* persistence xml
* schemma generation
* salvando aluno basico
* CRUD
* jpql
	* listando alunos com nota maior do que 5
* Beans Validation
	* ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
* incrementando com novos relacionamentos
	* @OneToOne, @OneToMany, @ManyToMany, @ManyToOne
* explicando o mappedby
* Internal connection pool limite < 50
* colocando o hikari





# CDI

* explicar chico xavier
* injetando
* escopos
* só mostrar a dependencia ambigua
	* qualifiers
* toda vez q um aluno for adicionado, deve enviar um email
* Decorator
	* adicionar historico de aluno
	* nao esquecer de habilitar no beans.xml
* Interceptor
	* criar classe
	* criar anotacao
	* habilitar beans
	* anotar @Transactional no bean


# EJB

> https://download.oracle.com/otn-pub/jcp/ejb-3_2-fr-spec/ejb-3_2-core-fr-spec.pdf?AuthParam=1575320472_775d8565689fa57bca213e1c76a7a6f9

* habilitar o persistence.xml avancado
* colocar todo mundo com scope provided
* criar o timeservice para notificar aniversariantes
* explicar o persistent
* Carrinho
	* @Stateless
		* com e sem pool
	* @RequestScoped
	* @SessionScoped
	* @Stateful
		* depois fazer combinação com session e stateful
	* @Singleton

	> fazer diferenca entre stateful e session abrindo em aba privativa
	
* como matar um @Stateful? 
	* @StatefulTimeout
	* @Remove
	
* @Transactional
* @TransacionalManagment


docker run --rm -p 5432:5432 -e POSTGRES_PASSWORD=1 postgres