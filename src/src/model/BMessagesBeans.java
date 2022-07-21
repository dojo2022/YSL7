package model;

import java.io.Serializable;
import java.sql.Date;

public class BMessagesBeans implements  Serializable {
	private static final long serialVersionUID = 1L;

	private Date date;
	private String content;

	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
}
