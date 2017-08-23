package com.gxa.model;

public class Admin {
	private int admi_id;
	private String admin_name;
	private String admin_password;

	
	public int getadmi_id() {
		return admi_id;
	}
	public void setadmi_id(int admi_id) {
		this.admi_id = admi_id;
	}
	public String getadmin_name() {
		return admin_name;
	}
	public void setadmin_name(String admin_name) {
		this.admin_name = admin_name;
	}
	public String getadmin_password() {
		return admin_password;
	}
	public void setadmin_password(String admin_password) {
		this.admin_password = admin_password;
	}
	public Admin() {
	}
	public Admin(String admin_name, String admin_password) {
		this.admin_name = admin_name;
		this.admin_password = admin_password;
	}

	public Admin(int admi_id, String admin_name, String admin_password) {
		this.admi_id = admi_id;
		this.admin_name = admin_name;
		this.admin_password = admin_password;
	}
	@Override
	public String toString() {
		return "Admin [admi_id=" + admi_id + ", admin_name=" + admin_name
				+ ", admin_password=" + admin_password + "]";
	}
	

}
