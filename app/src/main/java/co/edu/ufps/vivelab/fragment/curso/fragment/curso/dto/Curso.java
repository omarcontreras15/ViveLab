package co.edu.ufps.vivelab.fragment.curso.fragment.curso.dto;

import java.io.Serializable;

public class Curso implements Serializable {

    private String nombre_curso,fecha_ini, fecha_fin, lugar, url_img, descripcion, horario;
    private int cupos_disponibles;


    public Curso() {
    }

    public Curso(String nombre_curso, String fecha_ini, String fecha_fin, String lugar, String url_img, String descripcion, String horario, int cupos_disponibles) {
        this.nombre_curso = nombre_curso;
        this.fecha_ini = fecha_ini;
        this.fecha_fin = fecha_fin;
        this.lugar = lugar;
        this.url_img = url_img;
        this.descripcion = descripcion;
        this.horario = horario;
        this.cupos_disponibles = cupos_disponibles;
    }

    public String getNombre_curso() {
        return nombre_curso;
    }

    public void setNombre_curso(String nombre_curso) {
        this.nombre_curso = nombre_curso;
    }

    public String getFecha_ini() {
        return fecha_ini;
    }

    public void setFecha_ini(String fecha_ini) {
        this.fecha_ini = fecha_ini;
    }

    public String getFecha_fin() {
        return fecha_fin;
    }

    public void setFecha_fin(String fecha_fin) {
        this.fecha_fin = fecha_fin;
    }

    public String getLugar() {
        return lugar;
    }

    public void setLugar(String lugar) {
        this.lugar = lugar;
    }

    public String getUrl_img() {
        return url_img;
    }

    public void setUrl_img(String url_img) {
        this.url_img = url_img;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getHorario() {
        return horario;
    }

    public void setHorario(String horario) {
        this.horario = horario;
    }

    public int getCupos_disponibles() {
        return cupos_disponibles;
    }

    public void setCupos_disponibles(int cupos_disponibles) {
        this.cupos_disponibles = cupos_disponibles;
    }
}
