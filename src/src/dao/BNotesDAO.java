package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;




public class BNotesDAO {
	Connection con=null;

	public BNotesDAO(Connection con) {
		this.con=con;
	}
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
