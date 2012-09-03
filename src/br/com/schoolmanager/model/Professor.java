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
@Table(name = "professor")
public class Professor {

	@Id
	@GeneratedValue
	private long id;

	@Column(name = "nome")
	private String nome;

	@Column(name = "materia")
	private String materia;

	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(name = "serie_professor", joinColumns = @JoinColumn(name = "id_professor", referencedColumnName = "id"), inverseJoinColumns = @JoinColumn(name = "id_serie", referencedColumnName = "id"))
	private List<Serie> series;

	@ManyToOne
	@JoinColumn(name = "instituicao_id")
	private Instituicao instituicao;
	
	// Getters and Setters

	public String getMateria() {
		return materia;
	}

	public void setMateria(String materia) {
		this.materia = materia;
	}

	public List<Serie> getSeries() {
		return series;
	}

	public void setSeries(List<Serie> series) {
		this.series = series;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
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
