package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class MessagesDao {
	Connection con=null;

	public MessagesDao(Connection con) {
		this.con=con;
	}
	//登録するだけの処理でtrycatchとかエラー返すのはServiceでは？
	public boolean sendMessage(int userId, String message) throws ClassNotFoundException, SQLException {
		boolean result = false;

		// JDBCドライバを読み込む
		Class.forName("org.h2.Driver");

		// SQL文を準備する
		String sql = "INSERT INTO Messages (from_u_id, message) VALUES (?, '?')";
		PreparedStatement pStmt = con.prepareStatement(sql);

		// SQL文を完成させる
		pStmt.setString(1,"userId");
		pStmt.setString(2,"message");

		// SQL文を実行し、更新件数を取得する
		int num = pStmt.executeUpdate();

		if(num==1) {
			result= true;
		}
		// 結果を返す
				return result;
	}



}
