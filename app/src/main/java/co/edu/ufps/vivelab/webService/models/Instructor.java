package co.edu.ufps.vivelab.webService.models;

import java.util.List;

public class Instructor {

    private int id;

    private String apellido1;

    private String apellido2;

    private String avatar;

    private String documento;

    private String email;

    private String nombres;

    private String telefono;

    private List<Convocatoria> convocatorias;

    private TipoDocumento tipoDocumento;

    public Instructor() {
    }

    public Instructor(String apellido1, String apellido2, String avatar, String documento, String email, String nombres,
                      String telefono) {
        super();
        this.apellido1 = apellido1;
        this.apellido2 = apellido2;
        this.avatar = avatar;
        this.documento = documento;
        this.email = email;
        this.nombres = nombres;
        this.telefono = telefono;
    }

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getApellido1() {
        return this.apellido1;
    }

    public void setApellido1(String apellido1) {
        this.apellido1 = apellido1;
    }

    public String getApellido2() {
        return this.apellido2;
    }

    public void setApellido2(String apellido2) {
        this.apellido2 = apellido2;
    }

    public String getAvatar() {
        return this.avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public String getDocumento() {
        return this.documento;
    }

    public void setDocumento(String documento) {
        this.documento = documento;
    }

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNombres() {
        return this.nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getTelefono() {
        return this.telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public List<Convocatoria> getConvocatorias() {
        return this.convocatorias;
    }

    public void setConvocatorias(List<Convocatoria> convocatorias) {
        this.convocatorias = convocatorias;
    }

    public TipoDocumento getTipoDocumento() {
        return this.tipoDocumento;
    }

    public void setTipoDocumento(TipoDocumento tipoDocumento) {
        this.tipoDocumento = tipoDocumento;
    }


}
