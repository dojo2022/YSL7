package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class EvaluationsDao {
	Connection con = null;

	public EvaluationsDao(Connection con) {
		this.con = con;
	}

	//引数の中身をDBと繋げるためのメソッド
	public boolean registEval(int toUserId, int fromUserId,
			int evaluation1, int evaluation2, int evaluation3,
			int evaluation4, int evaluation5)throws ClassNotFoundException, SQLException{

		//return用の変数
		boolean result = false;

		//ドライバの読み込み
		Class.forName("org.h2.Driver");

		//SQLの準備
		String sql = "INSERT INTO Evaluations (from_u_id, to_u_id, evaluation1, evaluation2, "
				+ "evaluation3, evaluation4, evaluation5) VALUES (?, ?, ?, ?, ?, ?, ?)";

		PreparedStatement pStmt = con.prepareStatement(sql);

		//SQL文を完成させる
		pStmt.setInt(1,toUserId);
		pStmt.setInt(2, toUserId);
		pStmt.setInt(3, evaluation1);
		pStmt.setInt(4, evaluation2);
		pStmt.setInt(5, evaluation3);
		pStmt.setInt(6, evaluation4);
		pStmt.setInt(7, evaluation5);

		//結果を取得
		int ans = pStmt.executeUpdate();

		if(ans != 0) {
			result = true;
		}
		return result;
	}
}
