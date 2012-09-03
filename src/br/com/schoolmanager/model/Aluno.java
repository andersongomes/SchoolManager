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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="aluno")
public class Aluno {

	@Id
	@GeneratedValue
	private long id;

	@Column(name = "nome")
	private String nome;

	@Column(name = "matricula")
	private int matricula;

	@Column(name = "sexo")
	private String sexo;

	@ManyToOne
	@JoinColumn(name = "serie_id")
	private Serie serie;
	
	// Getters and Setters

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public int getMatricula() {
		return matricula;
	}

	public void setMatricula(int matricula) {
		this.matricula = matricula;
	}

	public String getSexo() {
		return sexo;
	}

	public void setSexo(String sexo) {
		this.sexo = sexo;
	}

	public long getId() {
		return id;
	}

	public Serie getSerie() {
		return serie;
	}

	public void setSerie(Serie serie) {
		this.serie = serie;
	}
}
