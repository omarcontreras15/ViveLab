package co.edu.ufps.vivelab.webService.models;

import java.util.Date;

public class Novedad {

    private int id;

    private Date fecha;

    private String novedad;

    private Grupo grupo;

    public Novedad() {
    }

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getFecha() {
        return this.fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public String getNovedad() {
        return this.novedad;
    }

    public void setNovedad(String novedad) {
        this.novedad = novedad;
    }

    public Grupo getGrupo() {
        return this.grupo;
    }

    public void setGrupo(Grupo grupo) {
        this.grupo = grupo;
    }


}
