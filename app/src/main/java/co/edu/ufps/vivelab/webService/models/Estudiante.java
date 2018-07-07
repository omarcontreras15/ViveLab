package co.edu.ufps.vivelab.webService.models;

import java.util.List;

public class Estudiante {

    private int id;

    private String apellido1;

    private String apellido2;

    private String avatar;

    private String direccion;

    private String documento;

    private String email;

    private String fechaNac;

    private String nombre;

    private String telefono;

    private TipoDocumento tipoDocumento;

    private List<EstudianteConvocatoria> estudianteConvocatorias;

    private List<EstudianteGrupo> estudianteGrupos;

    public Estudiante() {
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

    public String getDireccion() {
        return this.direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
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

    public String getFechaNac() {
        return this.fechaNac;
    }

    public void setFechaNac(String fechaNac) {
        this.fechaNac = fechaNac;
    }

    public String getNombre() {
        return this.nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTelefono() {
        return this.telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public TipoDocumento getTipoDocumento() {
        return this.tipoDocumento;
    }

    public void setTipoDocumento(TipoDocumento tipoDocumento) {
        this.tipoDocumento = tipoDocumento;
    }

    public List<EstudianteConvocatoria> getEstudianteConvocatorias() {
        return this.estudianteConvocatorias;
    }

    public void setEstudianteConvocatorias(List<EstudianteConvocatoria> estudianteConvocatorias) {
        this.estudianteConvocatorias = estudianteConvocatorias;
    }

    public List<EstudianteGrupo> getEstudianteGrupos() {
        return this.estudianteGrupos;
    }

    public void setEstudianteGrupos(List<EstudianteGrupo> estudianteGrupos) {
        this.estudianteGrupos = estudianteGrupos;
    }

}
