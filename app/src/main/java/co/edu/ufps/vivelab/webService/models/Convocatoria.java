package co.edu.ufps.vivelab.webService.models;

import java.util.Date;
import java.util.List;

public class Convocatoria {

    private int id;

    private Date fechaInicio;

    private String foto;

    private String lugar;

    private Curso curso;

    private Instructor instructor;

    private List<EstudianteConvocatoria> estudianteConvocatorias;

    private List<Grupo> grupos;

    public Convocatoria() {
    }

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getFechaInicio() {
        return this.fechaInicio;
    }

    public void setFechaInicio(Date fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public String getFoto() {
        return this.foto;
    }

    public void setFoto(String foto) {
        this.foto = foto;
    }

    public String getLugar() {
        return this.lugar;
    }

    public void setLugar(String lugar) {
        this.lugar = lugar;
    }

    public Curso getCurso() {
        return this.curso;
    }

    public void setCurso(Curso curso) {
        this.curso = curso;
    }

    public Instructor getInstructor() {
        return this.instructor;
    }

    public void setInstructor(Instructor instructor) {
        this.instructor = instructor;
    }

    public List<EstudianteConvocatoria> getEstudianteConvocatorias() {
        return this.estudianteConvocatorias;
    }

    public void setEstudianteConvocatorias(List<EstudianteConvocatoria> estudianteConvocatorias) {
        this.estudianteConvocatorias = estudianteConvocatorias;
    }

    public List<Grupo> getGrupos() {
        return this.grupos;
    }

    public void setGrupos(List<Grupo> grupos) {
        this.grupos = grupos;
    }


}
