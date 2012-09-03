package br.com.schoolmanager.controller;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.model.DataModel;
import javax.faces.model.ListDataModel;

import br.com.schoolmanager.dao.ProfessorDAO;
import br.com.schoolmanager.model.Professor;

@ManagedBean
@SessionScoped
public class ProfessorController {
	
	private Professor professor;
	
	@SuppressWarnings("rawtypes")
	private DataModel listaProfessores;
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public DataModel getListarProfessores() {
        List<Professor> lista = new ProfessorDAO().list();
        listaProfessores = new ListDataModel(lista);
        return listaProfessores;
    }

    public Professor getProfessor() {
        return professor;
    }

    public void setProfessor(Professor professor) {
        this.professor = professor;
    }

    public String prepararAdicionarProfessor(){
        professor = new Professor();
        return "adicionarProfessor";
    }

    public String prepararAlterarProfessor(){
        professor = (Professor)(listaProfessores.getRowData());
        return "alterarProfessor";
    }

    public String excluirProfessor(){

        Professor professorTemp = (Professor)(listaProfessores.getRowData());
        ProfessorDAO dao = new ProfessorDAO();
        dao.remove(professorTemp);
        return "indexProfessor";

    }

    public String adicionarProfessor(){

    	ProfessorDAO dao = new ProfessorDAO();
        dao.save(professor);
        return "indexProfessor";
        
    }

    public String alterarProfessor(){

        ProfessorDAO dao = new ProfessorDAO();
        dao.update(professor);
        return "indexProfessor";

    }
}
