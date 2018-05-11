package modelos;

public class Chefe {
	private String id;
	private String nome;
	private String usuario;
	private String senha;
	private String email;

	public Chefe(String id, String nome, String usuario, String senha, String email) {
		this.id = id;
		this.nome = nome;
		this.usuario = usuario;
		this.senha = senha;
		this.email = email;
	}
	public Chefe() {}
	
	public void setId(String id) {
		this.id = id;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getId() {
		return id;
	}
	public String getNome() {
		return nome;
	}
	public String getUsuario() {
		return usuario;
	}
	public String getSenha() {
		return senha;
	}
	public String getEmail() {
		return email;
	}
	

}
