package com.gxa.model;

public class Course {
	private String course_id;
	private String course_name;
	private String course_price;
	private String course_type;
	private String course_img;
	private String course_video;
	private String course_desc;
	private String course_time;
	private String course_status;
	public Course() {
	}
	public Course(String course_id, String course_name, String course_price,
			String course_type, String course_img, String course_video,
			String course_desc, String course_time, String course_status) {
		this.course_id = course_id;
		this.course_name = course_name;
		this.course_price = course_price;
		this.course_type = course_type;
		this.course_img = course_img;
		this.course_video = course_video;
		this.course_desc = course_desc;
		this.course_time = course_time;
		this.course_status = course_status;
	}
	public Course(String course_name, String course_price, String course_type,
			String course_img, String course_video, String course_desc,
			String course_time, String course_status) {
		super();
		this.course_name = course_name;
		this.course_price = course_price;
		this.course_type = course_type;
		this.course_img = course_img;
		this.course_video = course_video;
		this.course_desc = course_desc;
		this.course_time = course_time;
		this.course_status = course_status;
	}
	public String getCourse_id() {
		return course_id;
	}
	public void setCourse_id(String course_id) {
		this.course_id = course_id;
	}
	public String getCourse_name() {
		return course_name;
	}
	public void setCourse_name(String course_name) {
		this.course_name = course_name;
	}
	public String getCourse_price() {
		return course_price;
	}
	public void setCourse_price(String course_price) {
		this.course_price = course_price;
	}
	public String getCourse_type() {
		return course_type;
	}
	public void setCourse_type(String course_type) {
		this.course_type = course_type;
	}
	public String getCourse_img() {
		return course_img;
	}
	public void setCourse_img(String course_img) {
		this.course_img = course_img;
	}
	public String getCourse_video() {
		return course_video;
	}
	public void setCourse_video(String course_video) {
		this.course_video = course_video;
	}
	public String getCourse_desc() {
		return course_desc;
	}
	public void setCourse_desc(String course_desc) {
		this.course_desc = course_desc;
	}
	public String getCourse_time() {
		return course_time;
	}
	public void setCourse_time(String course_time) {
		this.course_time = course_time;
	}
	public String getCourse_status() {
		return course_status;
	}
	public void setCourse_status(String course_status) {
		this.course_status = course_status;
	}
	@Override
	public String toString() {
		return "Course [course_id=" + course_id + ", course_name="
				+ course_name + ", course_price=" + course_price
				+ ", course_type=" + course_type + ", course_img=" + course_img
				+ ", course_video=" + course_video + ", course_desc="
				+ course_desc + ", course_time=" + course_time
				+ ", course_status=" + course_status + "]";
	}

	
	

}
