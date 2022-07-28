package model;

public class RoleBeans {
	//メンバ変数
	private int depId;
	private int divId;
	private int secId;

	private String department;
	private String division;
	private String section;


	//以下セッターゲッター
	public int getDepId() {
		return depId;
	}
	public void setDepId(int depId) {
		this.depId = depId;
	}
	public int getDivId() {
		return divId;
	}
	public void setDivId(int divId) {
		this.divId = divId;
	}
	public int getSecId() {
		return secId;
	}
	public void setSecId(int secId) {
		this.secId = secId;
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


}
