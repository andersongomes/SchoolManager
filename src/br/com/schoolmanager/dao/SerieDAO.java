package br.com.schoolmanager.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import br.com.schoolmanager.model.Serie;
import br.com.schoolmanager.utils.HibernateUtil;

/**@
 * 
 * @author Anderson Gomes
 *
 */

public class SerieDAO {
	
	public void save(Serie serie) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction t = session.beginTransaction();
		session.save(serie);
		t.commit();
	}

	public Serie getSerie(long id) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		return (Serie) session.load(Serie.class, id);
	}

	public List<Serie> list() {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction t = session.beginTransaction();
		
		@SuppressWarnings("unchecked")
		List<Serie> lista = session.createQuery("from Serie").list();
		t.commit();
		return lista;
	}

	public void remove(Serie serie) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction t = session.beginTransaction();
		session.delete(serie);
		t.commit();
	}

	public void update(Serie serie) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction t = session.beginTransaction();
		session.update(serie);
		t.commit();
	}
}
