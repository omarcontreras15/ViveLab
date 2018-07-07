package co.edu.ufps.vivelab.webService.models;

import java.util.List;

public class TipoDocumento {

    private int id;

    private String tipo;

    private List<Usuario> usuarios;

    public TipoDocumento() {
    }

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTipo() {
        return this.tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public List<Usuario> getUsuarios() {
        return this.usuarios;
    }

    public void setUsuarios(List<Usuario> usuarios) {
        this.usuarios = usuarios;
    }

}
