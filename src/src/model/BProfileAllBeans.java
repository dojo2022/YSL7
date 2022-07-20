package model;

import java.io.Serializable;

public class BProfileAllBeans implements Serializable {
	private static final long serialVersionUID = 1L;

	private int empId;
	private String number;
	private String name;
	private int gender;
	private String year;
	private int retireFlag;
	private int secId;
	private String section;
	private String division;
	private String department;
	private int postId;
	private String post;

	public int getEmpId() {
		return empId;
	}
	public void setEmpId(int empId) {
		this.empId = empId;
	}
	public String getNumber() {
		return number;
	}
	public void setNumber(String number) {
		this.number = number;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getGender() {
		return gender;
	}
	public void setGender(int gender) {
		this.gender = gender;
	}
	public String getYear() {
		return year;
	}
	public void setYear(String year) {
		this.year = year;
	}
	public int getRetireFlag() {
		return retireFlag;
	}
	public void setRetireFlag(int retireFlag) {
		this.retireFlag = retireFlag;
	}
	public int getSecId() {
		return secId;
	}
	public void setSecId(int secId) {
		this.secId = secId;
	}
	public String getSection() {
		return section;
	}
	public void setSection(String section) {
		this.section = section;
	}
	public String getDivision() {
		return division;
	}
	public void setDivision(String division) {
		this.division = division;
	}
	public String getDepartment() {
		return department;
	}
	public void setDepartment(String department) {
		this.department = department;
	}
	public int getPostId() {
		return postId;
	}
	public void setPostId(int postId) {
		this.postId = postId;
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
