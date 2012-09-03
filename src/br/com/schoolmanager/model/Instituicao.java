package br.com.schoolmanager.model;

/**@
 * 
 * @author Anderson Gomes
 *
 */

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "instituicao")
public class Instituicao {

	@Id
	@GeneratedValue
	private long id;

	@Column(name = "nome")
	private String nome;

	/*@OneToMany(targetEntity=Serie.class, mappedBy="instituicao", cascade=CascadeType.ALL, fetch=FetchType.LAZY)
	private List<Serie> series;

	@OneToMany(targetEntity=Professor.class, mappedBy="instituicao", cascade=CascadeType.ALL, fetch=FetchType.LAZY)
	private List<Professor> professores;
	*/
	
	// Getters and Setters

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
	/*
	public List<Serie> getSeries() {
		return series;
	}

	public void setSeries(List<Serie> series) {
		this.series = series;
	}
	*/
	public long getId() {
		return id;
	}
	/*
	public List<Professor> getProfessores() {
		return professores;
	}

	public void setProfessores(List<Professor> professores) {
		this.professores = professores;
	}
	*/
}
