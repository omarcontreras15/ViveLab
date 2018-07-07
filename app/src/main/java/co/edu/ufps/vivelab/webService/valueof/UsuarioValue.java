package co.edu.ufps.vivelab.webService.valueof;

public class UsuarioValue {

	private int id;

	private String avatar;

	private String email;

	private String password;

	private String username;
		
	private String rol;

	private Integer tipoUsuario;

	public UsuarioValue(String email, String password, String username) {
		this.email = email;
		this.password = password;
		this.username = username;
	}

	public UsuarioValue(int id, String avatar, String email, String password, String username, String rol) {
		this.id = id;
		this.avatar = avatar;
		this.email = email;
		this.password = password;
		this.username = username;
		this.rol = rol;
	}
	
	public UsuarioValue() {
		
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getAvatar() {
		return avatar;
	}

	public void setAvatar(String avatar) {
		this.avatar = avatar;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
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

	public String getRol() {
		return rol;
	}

	public void setRol(String rol) {
		this.rol = rol;
	}

	public Integer getTipoUsuario() {
		return tipoUsuario;
	}

	public void setTipoUsuario(Integer tipoUsuario) {
		this.tipoUsuario = tipoUsuario;
	}

	@Override
	public String toString() {
		return "UsuarioValue [id=" + id + ", avatar=" + avatar + ", email=" + email + ", password=" + password
				+ ", username=" + username + ", rol=" + rol + ", tipoUsuario=" + tipoUsuario + "]";
	}
	
	
	
}
