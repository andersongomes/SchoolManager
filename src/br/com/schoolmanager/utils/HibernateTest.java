package br.com.schoolmanager.utils;

import java.sql.SQLException;

import org.hibernate.Session;


/**@
 * 
 * @author Anderson Gomes
 *
 */

public class HibernateTest {

    public static void main(String[] args) throws SQLException {

        try {
        	Session session = HibernateUtil.getSessionFactory().openSession();
        	System.out.println("Conectou!");
        	session.close();
		} catch (Exception e) {
			System.out.println("Não conectou!");
		}
        /* Criar o banco 
        SchemaExport schema = new SchemaExport(new AnnotationConfiguration().configure());
    	schema.create(true, true);
        */
    	//Transaction t = session.beginTransaction();
        //session.save(user);
        //t.commit();
        //System.out.println("ID do Pessoa: " + user.getId());
        
        //user = (Usuario) session.load(Usuario.class, 1L);
        //System.out.println(user.getNome());

       

    }
}
