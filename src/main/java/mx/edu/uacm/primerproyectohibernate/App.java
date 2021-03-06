package mx.edu.uacm.primerproyectohibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

import mx.edu.uacm.primerproyectohibernate.dominio.Usuario;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
       //codigo legado
    	//SessionFactory sf = new Configuration().configure().buildSessionFactory();
    	
    	//creamos un registro estrandar del servicio a traves de un builder
    	StandardServiceRegistry sr = new StandardServiceRegistryBuilder().configure().build();
    	
    	//creamos el sesion factory
    	
    	SessionFactory sf = new MetadataSources(sr).buildMetadata().buildSessionFactory();
    	
    	//abrimos la sesion
    	Session session = sf.openSession();
    	
    	//crear nuestra entidad
    	Usuario usr = new Usuario();
    	usr.setId(1);
    	usr.setNombreUsuario("usuariox");
    	
    	Usuario usr2 = new Usuario();
    	usr2.setId(2);
    	usr2.setNombreUsuario("usuariox");
    	
    	
    	//crear una transaccion
    	//un lote de operaciones vs base de datos
    	session.getTransaction().begin();
    	
    	session.persist(usr);
    	session.persist(usr2);
    	
    	//cierre de la transaccion commit
    	session.getTransaction().commit();
    	
    	session.close();
    	sf.close();
    	
    	
    	
    }
}
