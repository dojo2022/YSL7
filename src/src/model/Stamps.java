package model;

import java.io.Serializable;
import java.sql.Date;

public class Stamps implements Serializable {
	private static final long serialVersionUID = 1L;
	private int userId;
	private int stampId;
	private int categoryId;
	private String name;
	private int stamp1;
	private int stamp2;
	private int stamp3;
	private int stamp4;
	private int stamp5;
	private String category;
	private String commnet;
	private int sumStamp1;
	private int sumStamp2;
	private int sumStamp3;
	private int sumStamp4;
	private int sumStamp5;
	private Date date;
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public int getStampId() {
		return stampId;
	}
	public void setStampId(int stampId) {
		this.stampId = stampId;
	}
	public int getCategoryId() {
		return categoryId;
	}
	public void setCategoryId(int categoryId) {
		this.categoryId = categoryId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getStamp1() {
		return stamp1;
	}
	public void setStamp1(int stamp1) {
		this.stamp1 = stamp1;
	}
	public int getStamp2() {
		return stamp2;
	}
	public void setStamp2(int stamp2) {
		this.stamp2 = stamp2;
	}
	public int getStamp3() {
		return stamp3;
	}
	public void setStamp3(int stamp3) {
		this.stamp3 = stamp3;
	}
	public int getStamp4() {
		return stamp4;
	}
	public void setStamp4(int stamp4) {
		this.stamp4 = stamp4;
	}
	public int getStamp5() {
		return stamp5;
	}
	public void setStamp5(int stamp5) {
		this.stamp5 = stamp5;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public String getCommnet() {
		return commnet;
	}
	public void setCommnet(String commnet) {
		this.commnet = commnet;
	}
	public int getSumStamp1() {
		return sumStamp1;
	}
	public void setSumStamp1(int sumStamp1) {
		this.sumStamp1 = sumStamp1;
	}
	public int getSumStamp2() {
		return sumStamp2;
	}
	public void setSumStamp2(int sumStamp2) {
		this.sumStamp2 = sumStamp2;
	}
	public int getSumStamp3() {
		return sumStamp3;
	}
	public void setSumStamp3(int sumStamp3) {
		this.sumStamp3 = sumStamp3;
	}
	public int getSumStamp4() {
		return sumStamp4;
	}
	public void setSumStamp4(int sumStamp4) {
		this.sumStamp4 = sumStamp4;
	}
	public int getSumStamp5() {
		return sumStamp5;
	}
	public void setSumStamp5(int sumStamp5) {
		this.sumStamp5 = sumStamp5;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}



}
