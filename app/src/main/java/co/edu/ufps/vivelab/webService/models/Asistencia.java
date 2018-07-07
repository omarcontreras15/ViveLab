package co.edu.ufps.vivelab.webService.models;

public class Asistencia {

    private int id;

    private byte asistio;

    private EstudianteGrupo estudianteGrupo;

    private Sesion sesion;

    public Asistencia() {
    }

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public byte getAsistio() {
        return this.asistio;
    }

    public void setAsistio(byte asistio) {
        this.asistio = asistio;
    }

    public EstudianteGrupo getEstudianteGrupo() {
        return this.estudianteGrupo;
    }

    public void setEstudianteGrupo(EstudianteGrupo estudianteGrupo) {
        this.estudianteGrupo = estudianteGrupo;
    }

    public Sesion getSesion() {
        return this.sesion;
    }

    public void setSesion(Sesion sesion) {
        this.sesion = sesion;
    }

}
