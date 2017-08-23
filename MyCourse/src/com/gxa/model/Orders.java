package com.gxa.model;


public class Orders {
	private String order_id;
	private String order_time;
	private String admin_id;
	private String user_id;
	private String course_id;
	private String order_status;
	public Orders() {
		super();
	}
	public Orders(String order_id, String order_time, String admin_id,
			String user_id, String course_id, String order_status) {
		super();
		this.order_id = order_id;
		this.order_time = order_time;
		this.admin_id = admin_id;
		this.user_id = user_id;
		this.course_id = course_id;
		this.order_status = order_status;
	}
	public String getOrder_id() {
		return order_id;
	}
	public void setOrder_id(String order_id) {
		this.order_id = order_id;
	}
	public String getOrder_time() {
		return order_time;
	}
	public void setOrder_time(String order_time) {
		this.order_time = order_time;
	}
	public String getAdmin_id() {
		return admin_id;
	}
	public void setAdmin_id(String admin_id) {
		this.admin_id = admin_id;
	}
	public String getUser_id() {
		return user_id;
	}
	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}
	public String getCourse_id() {
		return course_id;
	}
	public void setCourse_id(String course_id) {
		this.course_id = course_id;
	}
	public String getOrder_status() {
		return order_status;
	}
	public void setOrder_status(String order_status) {
		this.order_status = order_status;
	}
	@Override
	public String toString() {
		return "Orders [order_id=" + order_id + ", order_time=" + order_time
				+ ", admin_id=" + admin_id + ", user_id=" + user_id
				+ ", course_id=" + course_id + ", order_status=" + order_status
				+ "]";
	}



	
}
