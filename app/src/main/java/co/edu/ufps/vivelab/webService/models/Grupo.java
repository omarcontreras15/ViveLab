package co.edu.ufps.vivelab.webService.models;

import java.util.List;

public class Grupo {

    private int id;

    private String nombre;

    private List<EstudianteGrupo> estudianteGrupos;

    private Convocatoria convocatoria;

    private List<Novedad> novedads;

    private List<Sesion> sesions;

    public Grupo() {
    }

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return this.nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public List<EstudianteGrupo> getEstudianteGrupos() {
        return this.estudianteGrupos;
    }

    public void setEstudianteGrupos(List<EstudianteGrupo> estudianteGrupos) {
        this.estudianteGrupos = estudianteGrupos;
    }

    public Convocatoria getConvocatoria() {
        return this.convocatoria;
    }

    public void setConvocatoria(Convocatoria convocatoria) {
        this.convocatoria = convocatoria;
    }

    public List<Novedad> getNovedads() {
        return this.novedads;
    }

    public void setNovedads(List<Novedad> novedads) {
        this.novedads = novedads;
    }

    public List<Sesion> getSesions() {
        return this.sesions;
    }

    public void setSesions(List<Sesion> sesions) {
        this.sesions = sesions;
    }


}
