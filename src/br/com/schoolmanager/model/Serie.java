package br.com.schoolmanager.model;

/**@
 * 
 * @author Anderson Gomes
 *
 */

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "serie")
public class Serie {

	@Id
	@GeneratedValue
	private long id;

	@Column(name = "nome")
	private String nome;

	/*@OneToMany(targetEntity=Aluno.class, mappedBy="serie", cascade=CascadeType.ALL, fetch=FetchType.LAZY)
	private List<Aluno> alunos;
	*/
	
	@ManyToOne
	@JoinColumn(name = "instituicao_id")
	private Instituicao instituicao;

	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(name = "serie_professor", joinColumns = @JoinColumn(name = "id_serie", referencedColumnName = "id"), inverseJoinColumns = @JoinColumn(name = "id_professor", referencedColumnName = "id"))
	private List<Professor> professores;
	
	// Getters and Setters
	
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	/*
	public List<Aluno> getAlunos() {
		return alunos;
	}

	public void setAlunos(List<Aluno> alunos) {
		this.alunos = alunos;
	}
	*/

	public List<Professor> getProfessores() {
		return professores;
	}

	public void setProfessores(List<Professor> professores) {
		this.professores = professores;
	}

	public long getId() {
		return id;
	}

	public Instituicao getInstituicao() {
		return instituicao;
	}

	public void setInstituicao(Instituicao instituicao) {
		this.instituicao = instituicao;
	}

}
