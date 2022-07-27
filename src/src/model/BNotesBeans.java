package model;

import java.io.Serializable;
import java.sql.Date;

public class BNotesBeans implements Serializable  {
    private static final long serialVersionUID = 1L;
	//	メンバ変数
	private String name;
	private String title;
	private String content;
	private Date date;
	private int noteId;
	private int fromUId;
	private int aboutUId;


	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public int getNoteId() {
		return noteId;
	}

	public void setNoteId(int noteId) {
		this.noteId = noteId;
	}
	public int getFromUId() {
		return fromUId;
	}

	public void setFromUId(int fromUId) {
		this.fromUId = fromUId;
	}

	public int getAboutUId() {
		return aboutUId;
	}

	public void setAboutUId(int aboutUId) {
		this.aboutUId = aboutUId;
	}

}
