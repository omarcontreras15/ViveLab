package co.edu.ufps.vivelab.webService.models;

import java.io.Serializable;
import java.util.List;

public class Curso implements Serializable {

    private int id;

    private String descripcion;

    private String foto;

    private String nombre;

    private List<Convocatoria> convocatorias;

    public Curso(int id, String descripcion, String foto, String nombre, List<Convocatoria> convocatorias) {
        super();
        this.id = id;
        this.descripcion = descripcion;
        this.foto = foto;
        this.nombre = nombre;
        this.convocatorias = convocatorias;
    }

    public Curso() {
    }

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescripcion() {
        return this.descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getFoto() {
        return this.foto;
    }

    public void setFoto(String foto) {
        this.foto = foto;
    }

    public String getNombre() {
        return this.nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public List<Convocatoria> getConvocatorias() {
        return this.convocatorias;
    }

    public void setConvocatorias(List<Convocatoria> convocatorias) {
        this.convocatorias = convocatorias;
    }


}
