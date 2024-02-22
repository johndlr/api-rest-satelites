package com.auroracode.springboot.satelitesRestApi.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "satelite")
public class Satelite {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;
    @Column(name = "nombre")
    private String nombre;
    @Column(name = "diametro")
    private int diametro;
    @Column(name = "gravedad")
    private double gravedad;
    @Column(name = "temperatura")
    private double temperatura;
    @Column(name = "planeta")
    private String planeta;

    public Satelite() {
    }

    public Satelite(String nombre, int diametro, double gravedad, double temperatura, String planeta) {
        this.nombre = nombre;
        this.diametro = diametro;
        this.gravedad = gravedad;
        this.temperatura = temperatura;
        this.planeta = planeta;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getDiametro() {
        return diametro;
    }

    public void setDiametro(int diametro) {
        this.diametro = diametro;
    }

    public double getGravedad() {
        return gravedad;
    }

    public void setGravedad(double gravedad) {
        this.gravedad = gravedad;
    }

    public double getTemperatura() {
        return temperatura;
    }

    public void setTemperatura(double temperatura) {
        this.temperatura = temperatura;
    }

    public String getPlaneta() {
        return planeta;
    }

    public void setPlaneta(String planeta) {
        this.planeta = planeta;
    }

    @Override
    public String toString() {
        return "Satelite{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", diametro=" + diametro +
                ", gravedad=" + gravedad +
                ", temperatura=" + temperatura +
                ", planeta='" + planeta + '\'' +
                '}';
    }
}
