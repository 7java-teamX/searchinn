package beans;

import java.io.Serializable;


public class Admin implements Serializable{
	private String id;
	private String pass;

	public Admin() {};
	public Admin(String id, String pass) {
		this.id = id;
		this.pass = pass;
	}
	public String getId() {
		return id;
	}
	public String getPass() {
		return pass;
	}
}
