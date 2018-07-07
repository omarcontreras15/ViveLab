package co.edu.ufps.vivelab.webService.models;

import java.util.List;

public class EstudianteGrupo {

    private int id;

    private List<Asistencia> asistencias;

    private Estudiante estudiante;

    private Grupo grupo;

    public EstudianteGrupo() {
    }

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public List<Asistencia> getAsistencias() {
        return this.asistencias;
    }

    public void setAsistencias(List<Asistencia> asistencias) {
        this.asistencias = asistencias;
    }

    public Estudiante getEstudiante() {
        return this.estudiante;
    }

    public void setEstudiante(Estudiante estudiante) {
        this.estudiante = estudiante;
    }

    public Grupo getGrupo() {
        return this.grupo;
    }

    public void setGrupo(Grupo grupo) {
        this.grupo = grupo;
    }

}
