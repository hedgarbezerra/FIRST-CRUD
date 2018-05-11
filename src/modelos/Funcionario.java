package modelos;
import java.io.File;
import java.util.Date;

public class Funcionario {
	private String id;
	private String nome;
	private String data;
	private String prof;
	private String cpf;
	private String email;
	private double sal;
	private String tele;
	private byte[] foto;
	private File foto2;
	public byte[] getFoto() {
		return foto;
	}
	public void setFoto(byte[] foto) {
		this.foto = foto;
	}
	public File getFoto2() {
		return foto2;
	}
	public void setFoto2(File foto2) {
		this.foto2 = foto2;
	}
	
	public Funcionario() {
		
	}
	
	public String getData() {
		return data;
	}
	public void setData(String data) {
		this.data = data;
	}
	public String getTele() {
		return tele;
	}
	public void setTele(String tele) {
		this.tele = tele;
	}
	public void setId(String id) {
		this.id = id;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public void setProf(String prof) {
		this.prof = prof;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public void setSal(double sal) {
		this.sal = sal;
	}
	public String getTel() {
	return tele;	
		
	}
	public String getEmail() {
		return email;
		
	}
	public double getSal () {
		return sal;
		
	}

	public String getId() {
		return id;
	}
	
	public String getNome() {
		return nome;
	}


	public String getProf () {
		
		return prof;
	}

	public String getCpf() {
		return cpf;
	}

}
