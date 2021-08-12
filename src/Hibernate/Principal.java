package Hibernate;

import Hibernate.modelos.Profesor;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Principal {

    public static void main(String[] args) {
// Preaparo la sexión de ORM que intermedia entre JAVA y la BD
        SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
//  Creo la sesión que me conecta a la base de datos
        Session session = sessionFactory.openSession();


// vamos a poder realizar las transcisiones
// creo un profesor para insertarlo en la base de datos

        Profesor profesor = new Profesor(1,"Juan", "Pérez", "García");

//        empiezo la transacción donde realizaré las operaciones CRUD
        // 1. accion de guardar los datos de un profesor
       /* session.beginTransaction();

        session.save(profesor ); // guardamos al profesor en la base de datos

        session.getTransaction().commit();*/
//        session.close();

        // 2. LEER
     /*   session.beginTransaction();
        Profesor profesor1 =  (Profesor)session.get(Profesor.class,1);
        System.out.println(profesor1.toString());
        session.close();*/

        // 3. ACTUALIZAR INFORMACIÓN DEL PROFESOR
//        session.beginTransaction();
//        session.update(new Profesor(1,"Paco","Martinez","SOria"));
//        session.getTransaction().commit();


       //4. Delete
//        session.beginTransaction();
//        session.delete(profesor);
//        session.getTransaction().commit();

// 5. GUARDAR Y ACTUALIZAR
        Profesor profe = new Profesor(1, "Ana", "Garcia", "Lopez");
        session.beginTransaction();
        session.saveOrUpdate(profe);
        session.getTransaction().commit();

        session.close();
    }
}
