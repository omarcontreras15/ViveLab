package co.edu.ufps.vivelab.webService.models;

public class EstudianteConvocatoria {

    private int id;

    private String disponibilidad;

    private String en_grupo;

    private Convocatoria convocatoria;

    private Estudiante estudiante;

    public EstudianteConvocatoria() {
    }

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDisponibilidad() {
        return this.disponibilidad;
    }

    public void setDisponibilidad(String disponibilidad) {
        this.disponibilidad = disponibilidad;
    }

    public Convocatoria getConvocatoria() {
        return this.convocatoria;
    }

    public void setConvocatoria(Convocatoria convocatoria) {
        this.convocatoria = convocatoria;
    }

    public Estudiante getEstudiante() {
        return this.estudiante;
    }

    public void setEstudiante(Estudiante estudiante) {
        this.estudiante = estudiante;
    }

    public String getEn_grupo() {
        return en_grupo;
    }

    public void setEn_grupo(String en_grupo) {
        this.en_grupo = en_grupo;
    }

}
