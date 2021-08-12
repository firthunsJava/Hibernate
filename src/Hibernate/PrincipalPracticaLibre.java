package Hibernate;

import Hibernate.modelos.Profesor;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class PrincipalPracticaLibre {
    public static void main(String[] args) {
        //         Preaparo la sexión de ORM que intermedia entre JAVA y la BD
        SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
//  Creo la sesión que me conecta a la base de datos
        Session session = sessionFactory.openSession();





        session.beginTransaction();
        // como es dirireccional, me da igual guardar el profesor o guardar el despacho

        session.getTransaction().commit();
        session.close();

    }
}
