package model;

import java.io.Serializable;

public class Guest implements Serializable{
	private int guestId;
	private String name;
	private String kana;
	private String pass;

	private String birthday;
	private String tel;
	private String mail;
	private String address;
	/**
	 * 顧客情報一覧時使用
	 * @param id
	 * @param name
	 * @param kana
	 */
	public Guest(int id, String name, String kana) {
		this.guestId = id;
		this.name = name;
		this.kana = kana;
	}
	/**
	 * 顧客情報登録時使用
	 * @param guestId
	 * @param name
	 * @param kana
	 * @param pass
	 * @param birthday
	 * @param tel
	 * @param address
	 * @param mail
	 */
	public Guest(int guestId, String name, String kana, String pass, String birthday, String tel, String mail, String address) {
		super();
		this.guestId = guestId;
		this.name = name;
		this.kana = kana;
		this.pass = pass;
		this.birthday = birthday;
		this.tel = tel;
		this.address = address;
		this.mail = mail;
	}

	/**
	 * id抜き
	 * @param name
	 * @param kana
	 * @param pass
	 * @param birthday
	 * @param tel
	 * @param address
	 * @param mail
	 */
	public Guest(String name, String kana, String pass, String birthday, String tel, String address,
			String mail) {
		super();
		this.name = name;
		this.kana = kana;
		this.pass = pass;
		this.birthday = birthday;
		this.tel = tel;
		this.address = address;
		this.mail = mail;
	}

	/**
	 * 顧客情報詳細表示時使用
	 * @param guestId
	 * @param name
	 * @param kana
	 * @param birthday
	 * @param tel
	 * @param address
	 * @param mail
	 */
	public Guest(int guestId, String name, String kana, String birthday, String tel, String mail, String address) {

		this.guestId = guestId;
		this.name = name;
		this.kana = kana;
		this.birthday = birthday;
		this.tel = tel;
		this.address = address;
		this.mail = mail;
	}
	public int getGuestId() {
		return guestId;
	}
	public String getName() {
		return name;
	}
	public String getKana() {
		return kana;
	}
	public String getBirthday() {
		return birthday;
	}
	public String getTel() {
		return tel;
	}
	public String getAddress() {
		return address;
	}
	public String getMail() {
		return mail;
	}
	public String getPass() {
		return pass;
	}

}
