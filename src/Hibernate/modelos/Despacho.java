package Hibernate.modelos;

import javax.persistence.*;
import java.io.Serializable;



@Entity
@Table(name="Despacho")
public class Despacho implements Serializable {

    @Id
    @Column(name = "id")
    private int id;
    @Column(name = "num_despacho")
    private int num_despacho;
    @Column(name = "piso")
    private int piso;

    @OneToOne(cascade = CascadeType.ALL)
    @PrimaryKeyJoinColumn // con esta instruccion decimos que las tablas unidas por sus id
    private Profesor profesor;

    public Despacho(int id, int num_despacho, int piso) {
        this.id = id;
        this.num_despacho = num_despacho;
        this.piso = piso;
    }

    public Despacho() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getNum_despacho() {
        return num_despacho;
    }

    public void setNum_despacho(int num_despacho) {
        this.num_despacho = num_despacho;
    }

    public int getPiso() {
        return piso;
    }

    public void setPiso(int piso) {
        this.piso = piso;
    }

    public Profesor getProfesor() {
        return profesor;
    }

    public void setProfesor(Profesor profesor) {
        this.profesor = profesor;
    }

    @Override
    public String toString() {
        return "Despacho{" +
                "id=" + id +
                ", num_despacho=" + num_despacho +
                ", piso=" + piso +
                '}';
    }
}
