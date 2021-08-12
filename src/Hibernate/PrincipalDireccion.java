package Hibernate;

import Hibernate.modelos.Despacho;
import Hibernate.modelos.Direccion;
import Hibernate.modelos.Profesor;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class PrincipalDireccion {

    public static void main(String[] args) {

//         Preaparo la sexión de ORM que intermedia entre JAVA y la BD
        SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
//  Creo la sesión que me conecta a la base de datos
        Session session = sessionFactory.openSession();

/*
// INSERCION DE DIRECCION RELACION 1:1 unidirecccional
        Direccion direccion = new Direccion(11,"Plaza Castilla", 22,"valencia", "Valencia la Nueva");
        Profesor profesor = new Profesor(11,"Luca", "Martinez", "García");
        profesor.setDireccion(direccion);

        session.beginTransaction();
        session.save(profesor);
        session.getTransaction().commit();
        session.close();
*/

      // INSERCION DE DESPACHO RELACION ONE TO ONE BIDIRECCIONAL

        Despacho despacho = new Despacho(22,2,3);
        Profesor profesor1 = new Profesor(22,"ana","salina","mariscal");
        profesor1.setDespacho(despacho);
        despacho.setProfesor(profesor1);

        Despacho despacho2 = new Despacho(13,202,3);
        Profesor profesor2 = new Profesor(13,"Peter","Ugarte","mariscal");
        profesor2.setDespacho(despacho2);
        despacho2.setProfesor(profesor2);

        session.beginTransaction();
        // como es dirireccional, me da igual guardar el profesor o guardar el despacho
        session.saveOrUpdate(profesor1);
        session.saveOrUpdate(despacho2);

        session.getTransaction().commit();
        session.close();

    }
}
