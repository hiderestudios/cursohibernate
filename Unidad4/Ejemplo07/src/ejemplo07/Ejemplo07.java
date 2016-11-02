/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejemplo07;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

/**
 *
 * @author borja
 */
public class Ejemplo07 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        SessionFactory sessionFactory;

        Configuration configuration = new Configuration();
        configuration.configure();
        ServiceRegistry serviceRegistry = new ServiceRegistryBuilder().applySettings(configuration.getProperties()).buildServiceRegistry();
        sessionFactory = configuration.buildSessionFactory(serviceRegistry);

        
        Profesor profesor = new Profesor(415,(new Nombre("Elias","Rubio","Sanchez")),TipoFuncionario.Carrera);
        //--Session--
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        
        session.save(profesor);
        
        session.getTransaction().commit();
        session.close();
        
        
    
    }

}
