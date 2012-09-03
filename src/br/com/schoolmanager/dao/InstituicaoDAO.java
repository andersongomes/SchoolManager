package br.com.schoolmanager.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import br.com.schoolmanager.model.Aluno;
import br.com.schoolmanager.model.Instituicao;
import br.com.schoolmanager.utils.HibernateUtil;

/**@
 * 
 * @author Anderson Gomes
 *
 */

public class InstituicaoDAO {
	
	public void save(Instituicao instituicao) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction t = session.beginTransaction();
		session.save(instituicao);
		t.commit();
	}

	public Aluno getAluno(long id) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		return (Aluno) session.load(Aluno.class, id);
	}

	public List<Instituicao> list() {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction t = session.beginTransaction();
		
		@SuppressWarnings("unchecked")
		List<Instituicao> lista = session.createQuery("from Instituicao").list();
		t.commit();
		return lista;
	}

	public void remove(Instituicao instituicao) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction t = session.beginTransaction();
		session.delete(instituicao);
		t.commit();
	}

	public void update(Instituicao instituicao) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction t = session.beginTransaction();
		session.update(instituicao);
		t.commit();
	}
}
