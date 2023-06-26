package modelo;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;

@Entity
public class Aluno {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@NotNull
	@NotEmpty
	private String nome;

	@Email
	private String email;

	@Past
	private LocalDate dataNascimento;

	private LocalDateTime updated;

	@ManyToMany
	private List<Curso> cursos = new ArrayList<>();

	@OneToOne
	private Endereco endereco;

	public Aluno() {

	}

	public Aluno(@NotNull String nome, @Email String email, @Past LocalDate dataNascimento) {
		super();
		this.nome = nome;
		this.email = email;
		this.dataNascimento = dataNascimento;
	}

	public Aluno(Integer id, @NotNull String nome, @Email String email, @Past LocalDate dataNascimento) {
		super();
		this.id = id;
		this.nome = nome;
		this.email = email;
		this.dataNascimento = dataNascimento;
	}

	public Aluno(Integer id, String nome, String email, LocalDate dataNascimento, List<Curso> cursos) {
		super();
		this.id = id;
		this.nome = nome;
		this.email = email;
		this.dataNascimento = dataNascimento;
		this.cursos = cursos;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public List<Curso> getCursos() {
		return cursos;
	}

	public void setCursos(List<Curso> cursos) {
		this.cursos = cursos;
	}

	public LocalDate getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(LocalDate dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	public LocalDateTime getUpdated() {
		return updated;
	}

	public Endereco getEndereco() {
		return endereco;
	}

	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}

	@Override
	public String toString() {
		return "Aluno [id=" + id + ", nome=" + nome + ", email=" + email + ", dataNascimento=" + dataNascimento
				+ ", updated=" + updated + ", endereco=" + endereco + "]";
	}

	@PrePersist
	@PreUpdate
	public void atualizacao() {
		this.updated = LocalDateTime.now();
	}

	public BigDecimal totalContratado() {
		return this.cursos.stream().map(Curso::getPreco).reduce(BigDecimal.ZERO, BigDecimal::add);
	}

	public void contratarCurso(Curso curso) {

		this.cursos.add(curso);
	}
}
