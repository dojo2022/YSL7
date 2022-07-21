package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import model.BNotesBeans;



public class BNotesDAO {
	Connection con=null;

	public BNotesDAO(Connection con) {
		this.con=con;
	}

	//タブからメモに飛んだ時に全件検索するやつ
	public ArrayList<BNotesBeans> selectNotes(int empId) throws SQLException, ClassNotFoundException {

		//あらかじめreturn用の変数を用意しておく
		ArrayList<BNotesBeans> noteList = new ArrayList<BNotesBeans>();

		// JDBCドライバを読み込む
		Class.forName("org.h2.Driver");

		// SQL文を準備する
		String sql = "(SELECT Notes.date AS date, f.name AS from_name, Notes.title AS title, Notes.content AS content"
				+ " FROM Notes"
				+ " LEFT JOIN Users AS f ON f.id = Notes.from_u_id"
				+ " LEFT JOIN Users AS a ON a.id = Notes.about_u_id"
				+ " WHERE about_u_id = ? ORDER BY DATE DESC;)";
		PreparedStatement pStmt = con.prepareStatement(sql);

		// SQL文を完成させる
		pStmt.setInt(1,empId);


		// SQL文を実行し、結果表を取得する
		ResultSet rs = pStmt.executeQuery();

		// 結果表をコレクションにコピーする
		while (rs.next()) {
			BNotesBeans notes = new BNotesBeans();
			notes.setDate(rs.getDate("date"));
			notes.setName(rs.getString("from_name"));
			notes.setTitle(rs.getString("title"));
			notes.setContent(rs.getString("content"));
			noteList.add(notes);
		}


		// 結果を返す
		return noteList;

	}
	//新規メモ追加
	public int insertNotes(int uId, int empId, String title, String content) throws ClassNotFoundException, SQLException{

		//あらかじめreturn用の変数を用意しておく
		int ans=0;

		// JDBCドライバを読み込む
		Class.forName("org.h2.Driver");

		// SQL文を準備する
		String sql = "INSERT INTO Notes (from_u_id, about_u_id, title, content) VALUES (?, ?, ?, ?)";
		PreparedStatement pStmt = con.prepareStatement(sql);

		// SQL文を完成させる
		pStmt.setInt(1,uId);
		pStmt.setInt(2,empId);
		pStmt.setString(3,title);
		pStmt.setString(4,content);

		// SQL文を実行し、結果表を取得する
		ans = pStmt.executeUpdate();

		// 結果を返す
		return ans;
	}
	//メモ削除
	public int deleteNotes(int noteId) throws ClassNotFoundException, SQLException{

		//あらかじめreturn用の変数を用意しておく
		int ans=0;

		// JDBCドライバを読み込む
		Class.forName("org.h2.Driver");

		// SQL文を準備する
		String sql = "DELETE FROM Notes WHERE note_id=?";
		PreparedStatement pStmt = con.prepareStatement(sql);

		// SQL文を完成させる
		pStmt.setInt(1,noteId);

		// SQL文を実行し、結果表を取得する
		ans = pStmt.executeUpdate();

		// 結果を返す
		return ans;
	}
}
