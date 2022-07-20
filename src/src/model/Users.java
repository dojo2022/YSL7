package model;

import java.io.Serializable;

public class Users implements Serializable{
	private static final long serialVersionUID = 1L;
	private int userId;
	private String name;
	private String number;
	private String password;
	private int gender;
	private int retireFlag;
	private String department;
	private String division;
	private String section;
	private String post;


	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getNumber() {
		return number;
	}
	public void setNumber(String number) {
		this.number = number;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public int getGender() {
		return gender;
	}
	public void setGender(int gender) {
		this.gender = gender;
	}
	public int getRetireFlag() {
		return retireFlag;
	}
	public void setRetireFlag(int retireFlag) {
		this.retireFlag = retireFlag;
	}
	public String getDepartment() {
		return department;
	}
	public void setDepartment(String department) {
		this.department = department;
	}
	public String getDivision() {
		return division;
	}
	public void setDivision(String division) {
		this.division = division;
	}
	public String getSection() {
		return section;
	}
	public void setSection(String section) {
		this.section = section;
	}
	public String getPost() {
		return post;
	}
	public void setPost(String post) {
		this.post = post;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}
