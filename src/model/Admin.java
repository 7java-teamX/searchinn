package model;

import java.io.Serializable;

/**
 * @author 3BC1_12
 *
 */
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
