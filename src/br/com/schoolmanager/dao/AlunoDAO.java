package br.com.schoolmanager.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import br.com.schoolmanager.model.Aluno;
import br.com.schoolmanager.utils.HibernateUtil;

/**@
 * 
 * @author Anderson Gomes
 *
 */

public class AlunoDAO {
	
	public void save(Aluno aluno) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction t = session.beginTransaction();
		session.save(aluno);
		t.commit();
	}

	public Aluno getAluno(long id) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		return (Aluno) session.load(Aluno.class, id);
	}

	public List<Aluno> list() {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction t = session.beginTransaction();
		
		@SuppressWarnings("unchecked")
		List<Aluno> lista = session.createQuery("from Aluno").list();
		t.commit();
		return lista;
	}

	public void remove(Aluno aluno) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction t = session.beginTransaction();
		session.delete(aluno);
		t.commit();
	}

	public void update(Aluno aluno) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction t = session.beginTransaction();
		session.update(aluno);
		t.commit();
	}
	
}
