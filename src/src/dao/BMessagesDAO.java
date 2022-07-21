package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import model.BMessagesBeans;

public class BMessagesDAO {
	Connection con=null;

	public BMessagesDAO(Connection con) {
		this.con=con;
	}

	public ArrayList<BMessagesBeans> selectMessages(int empId) throws SQLException, ClassNotFoundException {

		//あらかじめreturn用の変数を用意しておく
		ArrayList<BMessagesBeans> messageList = new ArrayList<>();

		// JDBCドライバを読み込む
		Class.forName("org.h2.Driver");

		// SQL文を準備する
		String sql = "SELECT date, content FROM Messages WHERE from_u_id=? AND ORDER BY date DESC";
		PreparedStatement pStmt = con.prepareStatement(sql);

		// SQL文を完成させる
		pStmt.setInt(1,empId);

		// SQL文を実行し、結果表を取得する
		ResultSet rs = pStmt.executeQuery();

		// 結果表をコレクションにコピーする
		while (rs.next()) {
			BMessagesBeans messages = new BMessagesBeans();
			 messages.setDate(rs.getDate("date"));
			 messages.setContent(rs.getString("content"));
			 messageList.add(messages);


		}
		return messageList;
	}
}
