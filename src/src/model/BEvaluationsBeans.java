package model;

import java.io.Serializable;

public class BEvaluationsBeans implements  Serializable {
    private static final long serialVersionUID = 1L;

    private int empId;
    //評価
    private int eva1;
    private int eva2;
    private int eva3;
    private int eva4;
    private int eva5;
    private String date;
    private String comment;

	public int getEmpId() {
		return empId;
	}
	public void setEmpId(int empId) {
		this.empId = empId;
	}
	public int getEva1() {
		return eva1;
	}
	public void setEva1(int eva1) {
		this.eva1 = eva1;
	}
	public int getEva2() {
		return eva2;
	}
	public void setEva2(int eva2) {
		this.eva2 = eva2;
	}
	public int getEva3() {
		return eva3;
	}
	public void setEva3(int eva3) {
		this.eva3 = eva3;
	}
	public int getEva4() {
		return eva4;
	}
	public void setEva4(int eva4) {
		this.eva4 = eva4;
	}
	public int getEva5() {
		return eva5;
	}
	public void setEva5(int eva5) {
		this.eva5 = eva5;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getComment() {
		return comment;
	}
	public void setComment(String comment) {
		this.comment = comment;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}