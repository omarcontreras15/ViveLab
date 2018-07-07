package co.edu.ufps.vivelab.webService.valueof;

public class EstudianteConvocatoriaValue {
	
	private Integer id;
	
	private String disponibilidad;
	
	private Integer convocatoria_id;
	
	private Integer estudiante_id;
	
	private String en_grupo;
	
	public EstudianteConvocatoriaValue() {
	}

	public EstudianteConvocatoriaValue(Integer id, String disponibilidad, Integer convocatoria_id,
			Integer estudiante_id, String en_grupo) {
		this.id = id;
		this.disponibilidad = disponibilidad;
		this.convocatoria_id = convocatoria_id;
		this.estudiante_id = estudiante_id;
		this.en_grupo = en_grupo;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getDisponibilidad() {
		return disponibilidad;
	}

	public void setDisponibilidad(String disponibilidad) {
		this.disponibilidad = disponibilidad;
	}

	public Integer getConvocatoria_id() {
		return convocatoria_id;
	}

	public void setConvocatoria_id(Integer convocatoria_id) {
		this.convocatoria_id = convocatoria_id;
	}

	public Integer getEstudiante_id() {
		return estudiante_id;
	}

	public void setEstudiante_id(Integer estudiante_id) {
		this.estudiante_id = estudiante_id;
	}

	public String getEn_grupo() {
		return en_grupo;
	}

	public void setEn_grupo(String en_grupo) {
		this.en_grupo = en_grupo;
	}
	

}
