package entities;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Client {

	private String name;
	private String email;
	private Date birthDate;
	private SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
	
	public Client() {
	}
	
	public Client(String name, String email, Date birthDate) {
		this.name = name;
		this.email = email;
		this.birthDate = birthDate;
	}
	public String getName() {
		return this.name;
	}
	
	public String getEmail() {
		return this.email;
	}
	
	public Date getBirthDate() {
		return this.birthDate;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public void setemail(String email) {
		this.email = email;
	}
	
	public void setDate(Date birthDate) {
		this.birthDate = birthDate;
	}
	
	public String toString() {
		return String.format("%s (%s) - %s", name, sdf.format(birthDate), email);
	}
	
}
