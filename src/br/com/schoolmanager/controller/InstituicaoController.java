package br.com.schoolmanager.controller;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.model.DataModel;
import javax.faces.model.ListDataModel;

import br.com.schoolmanager.dao.InstituicaoDAO;
import br.com.schoolmanager.model.Instituicao;

@ManagedBean
@SessionScoped
public class InstituicaoController {

	private Instituicao instituicao;

	@SuppressWarnings("rawtypes")
	private DataModel listaInstituicoes;

	@SuppressWarnings({ "rawtypes", "unchecked" })
	public DataModel getListarInstituicoes() {
		List<Instituicao> lista = new InstituicaoDAO().list();
		listaInstituicoes = new ListDataModel(lista);
		return listaInstituicoes;
	}

	public Instituicao getInstituicao() {
		return instituicao;
	}

	public void setInstituicao(Instituicao instituicao) {
		this.instituicao = instituicao;
	}

	public String prepararAdicionarInstituicao() {
		instituicao = new Instituicao();
		return "adicionarInstituicao";
	}

	public String prepararAlterarInstituicao() {
		instituicao = (Instituicao) (listaInstituicoes.getRowData());
		return "alterarInstituicao";
	}

	public String excluirInstituicao() {

		Instituicao instituicaoTemp = (Instituicao) (listaInstituicoes
				.getRowData());
		InstituicaoDAO dao = new InstituicaoDAO();
		dao.remove(instituicaoTemp);
		return "indexInstituicao";

	}

	public String adicionarInstituicao() {

		InstituicaoDAO dao = new InstituicaoDAO();
		dao.save(instituicao);
		return "indexInstituicao";

	}

	public String alterarInstituicao() {

		InstituicaoDAO dao = new InstituicaoDAO();
		dao.update(instituicao);
		return "indexInstituicao";

	}
}
