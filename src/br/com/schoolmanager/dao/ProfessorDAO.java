package br.com.schoolmanager.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import br.com.schoolmanager.model.Professor;
import br.com.schoolmanager.utils.HibernateUtil;

/**@
 * 
 * @author Anderson Gomes
 *
 */

public class ProfessorDAO {
	
	public void save(Professor professor) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction t = session.beginTransaction();
		session.save(professor);
		t.commit();
	}

	public Professor getProfessor(long id) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		return (Professor) session.load(Professor.class, id);
	}

	public List<Professor> list() {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction t = session.beginTransaction();
		
		@SuppressWarnings("unchecked")
		List<Professor> lista = session.createQuery("from Professor").list();
		t.commit();
		return lista;
	}

	public void remove(Professor professor) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction t = session.beginTransaction();
		session.delete(professor);
		t.commit();
	}

	public void update(Professor professor) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction t = session.beginTransaction();
		session.update(professor);
		t.commit();
	}
}
