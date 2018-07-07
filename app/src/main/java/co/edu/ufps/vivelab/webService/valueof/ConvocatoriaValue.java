package co.edu.ufps.vivelab.webService.valueof;

import co.edu.ufps.vivelab.webService.models.Curso;

public class ConvocatoriaValue {

    private Integer curso_id;

    private Integer instructor_id;

    private String lugar;

    private String fecha_inicio;

    private String foto;

    private Curso curso;

    public ConvocatoriaValue(Integer curso_id, Integer instructor_id, String lugar, String fecha_inicio, String foto) {
        super();
        this.curso_id = curso_id;
        this.instructor_id = instructor_id;
        this.lugar = lugar;
        this.fecha_inicio = fecha_inicio;
        this.foto = foto;
    }

    public ConvocatoriaValue() {
        super();
    }

    public Integer getCurso_id() {
        return curso_id;
    }

    public void setCurso_id(Integer curso_id) {
        this.curso_id = curso_id;
    }

    public Integer getInstructor_id() {
        return instructor_id;
    }

    public void setInstructor_id(Integer instructor_id) {
        this.instructor_id = instructor_id;
    }

    public String getLugar() {
        return lugar;
    }

    public void setLugar(String lugar) {
        this.lugar = lugar;
    }

    public String getFecha_inicio() {
        return fecha_inicio;
    }

    public void setFecha_inicio(String fecha_inicio) {
        this.fecha_inicio = fecha_inicio;
    }

    public String getFoto() {
        return foto;
    }

    public void setFoto(String foto) {
        this.foto = foto;
    }

    public Curso getCurso() {
        return curso;
    }

    public void setCurso(Curso curso) {
        this.curso = curso;
    }

    @Override
    public String toString() {
        return "ConvocatoriaValue{" +
                "curso_id=" + curso_id +
                ", instructor_id=" + instructor_id +
                ", lugar='" + lugar + '\'' +
                ", fecha_inicio='" + fecha_inicio + '\'' +
                ", foto='" + foto + '\'' +
                '}';
    }
}
