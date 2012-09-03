package br.com.schoolmanager.controller;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.model.DataModel;
import javax.faces.model.ListDataModel;

import br.com.schoolmanager.dao.SerieDAO;
import br.com.schoolmanager.model.Serie;

@ManagedBean
@SessionScoped
public class SerieController {
		
	private Serie serie;
	
	@SuppressWarnings("rawtypes")
	private DataModel listaSeries;
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public DataModel getListarSeries() {
        List<Serie> lista = new SerieDAO().list();
        listaSeries = new ListDataModel(lista);
        return listaSeries;
    }

    public Serie getSerie() {
        return serie;
    }

    public void setSerie(Serie serie) {
        this.serie = serie;
    }

    public String prepararAdicionarSerie(){
        serie = new Serie();
        return "adicionarSerie";
    }

    public String prepararAlterarSerie(){
        serie = (Serie)(listaSeries.getRowData());
        return "alterarSerie";
    }

    public String excluirSerie(){

        Serie serieTemp = (Serie)(listaSeries.getRowData());
        SerieDAO dao = new SerieDAO();
        dao.remove(serieTemp);
        return "indexSerie";

    }

    public String adicionarSerie(){

    	SerieDAO dao = new SerieDAO();
        dao.save(serie);
        return "indexSerie";
        
    }

    public String alterarSerie(){

        SerieDAO dao = new SerieDAO();
        dao.update(serie);
        return "indexSerie";

    }
}
