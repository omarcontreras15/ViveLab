package co.edu.ufps.vivelab.webService.valueof;

public class EstudianteValue {

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

    private Integer tipo_documento;

    private String password;

    private String username;

    public EstudianteValue(int id, String apellido1, String apellido2, String avatar, String direccion,
                           String documento, String email, String fechaNac, String nombre, String telefono,
                           Integer tipo_documento, String password, String username) {
        this.id = id;
        this.apellido1 = apellido1;
        this.apellido2 = apellido2;
        this.avatar = avatar;
        this.direccion = direccion;
        this.documento = documento;
        this.email = email;
        this.fechaNac = fechaNac;
        this.nombre = nombre;
        this.telefono = telefono;
        this.tipo_documento = tipo_documento;
        this.password = password;
        this.username = username;
    }

    public EstudianteValue() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getApellido1() {
        return apellido1;
    }

    public void setApellido1(String apellido1) {
        this.apellido1 = apellido1;
    }

    public String getApellido2() {
        return apellido2;
    }

    public void setApellido2(String apellido2) {
        this.apellido2 = apellido2;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getDocumento() {
        return documento;
    }

    public void setDocumento(String documento) {
        this.documento = documento;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFechaNac() {
        return fechaNac;
    }

    public void setFechaNac(String fechaNac) {
        this.fechaNac = fechaNac;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public Integer getTipo_documento() {
        return tipo_documento;
    }

    public void setTipo_documento(Integer tipo_documento) {
        this.tipo_documento = tipo_documento;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

}
