package br.com.schoolmanager.controller;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.model.DataModel;
import javax.faces.model.ListDataModel;

import br.com.schoolmanager.dao.AlunoDAO;
import br.com.schoolmanager.model.Aluno;

@ManagedBean
@SessionScoped
public class AlunoController {
	
	private Aluno aluno;
	
	@SuppressWarnings("rawtypes")
	private DataModel listaAlunos;
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public DataModel getListarAlunos() {
        List<Aluno> lista = new AlunoDAO().list();
        listaAlunos = new ListDataModel(lista);
        return listaAlunos;
    }

    public Aluno getAluno() {
        return aluno;
    }

    public void setAluno(Aluno aluno) {
        this.aluno = aluno;
    }

    public String prepararAdicionarAluno(){
        aluno = new Aluno();
        return "adicionarAluno";
    }

    public String prepararAlterarAluno(){
        aluno = (Aluno)(listaAlunos.getRowData());
        return "alterarAluno";
    }

    public String excluirAluno(){

        Aluno alunoTemp = (Aluno)(listaAlunos.getRowData());
        AlunoDAO dao = new AlunoDAO();
        dao.remove(alunoTemp);
        return "indexAluno";

    }

    public String adicionarAluno(){

    	AlunoDAO dao = new AlunoDAO();
        dao.save(aluno);
        return "indexAluno";
        
    }

    public String alterarAluno(){

        AlunoDAO dao = new AlunoDAO();
        dao.update(aluno);
        return "indexAluno";

    }
}
