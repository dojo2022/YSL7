package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import model.Stamps;

public class StampsDao {
	Connection con = null;

	public StampsDao(Connection con) {
		this.con = con;
	}

	public boolean registFeeling(int userId, int categoryId, int stamp1, int stamp2, int stamp3,
			int stamp4, int stamp5, String comment) throws ClassNotFoundException, SQLException {
		boolean result = false;

		// JDBCドライバを読み込む
		Class.forName("org.h2.Driver");

		// SQL文を準備する
		String sql = "INSERT INTO Stamps (u_id, category_id, stamp1, stamp2, stamp3, stamp4, stamp5, comment) "
				+ "VALUES (?, ?, ?, ?, ?, ?, ?, ?);";
		PreparedStatement pStmt = con.prepareStatement(sql);

		// SQL文を完成させる(ワイルドカード検索）
		pStmt.setInt(1, userId);
		pStmt.setInt(2, categoryId);
		pStmt.setInt(3, stamp1);
		pStmt.setInt(4, stamp2);
		pStmt.setInt(5, stamp3);
		pStmt.setInt(6, stamp4);
		pStmt.setInt(7, stamp5);
		pStmt.setString(8, comment);

		int ans = pStmt.executeUpdate();

		if(ans == 1) {
			result = true;
		}


		return result;
	}


	public ArrayList<Stamps> showHistory(int userId) throws ClassNotFoundException, SQLException  {

		//あらかじめreturn用の変数を用意しておく
		ArrayList<Stamps> historyList = new ArrayList<>();

		// JDBCドライバを読み込む
		Class.forName("org.h2.Driver");

		// SQL文を準備する
		String sql = "SELECT Stamps.stamp_id, Stamps.stamp1, Stamps.stamp2, Stamps.stamp3, Stamps.stamp4, Stamps.stamp5, Stamps.category_id, Categories.category, Stamps.date FROM Stamps"
				+ "LEFT JOIN Categories ON Stamps.category_id = Categories.category_id"
				+ "WHERE Stamps.u_id = ?;";
		PreparedStatement pStmt = con.prepareStatement(sql);

		// SQL文を完成させる(ワイルドカード検索）
		pStmt.setInt(1, userId);


		// SQL文を実行し、結果表を取得する
		ResultSet rs = pStmt.executeQuery();

		// 結果表をコレクションにコピーする
		while (rs.next()) {
			Stamps stamp = new Stamps();
			stamp.setStampId(Integer.parseInt(rs.getString("stamp_id")));
			stamp.setStamp1(Integer.parseInt(rs.getString("stamp1")));
			stamp.setStamp2(Integer.parseInt(rs.getString("stamp2")));
			stamp.setStamp3(Integer.parseInt(rs.getString("stamp3")));
			stamp.setStamp4(Integer.parseInt(rs.getString("stamp4")));
			stamp.setStamp5(Integer.parseInt(rs.getString("stamp5")));
			stamp.setCategoryId(Integer.parseInt(rs.getString("category_id")));
			stamp.setCategory(rs.getString("category"));
			stamp.setComment(rs.getString("comment"));
			historyList.add(stamp);
		}


		// 結果を返す
		return historyList;

	}


	public boolean editFeeling(int stampId, int categoryId, int stamp1, int stamp2, int stamp3,
			int stamp4, int stamp5, String comment) throws ClassNotFoundException, SQLException {
		boolean result = false;

		// JDBCドライバを読み込む
		Class.forName("org.h2.Driver");

		// SQL文を準備する
		String sql = "UPDATE Stamps set category_id = ?, stamp1=?, stamp2=?, stamp3=?, stamp4=?, stamp5=?, comment=? WHERE stamp_id = ?;";
		PreparedStatement pStmt = con.prepareStatement(sql);

		// SQL文を完成させる(ワイルドカード検索）
		pStmt.setInt(1, categoryId);
		pStmt.setInt(2, stamp1);
		pStmt.setInt(3, stamp2);
		pStmt.setInt(4, stamp3);
		pStmt.setInt(5, stamp4);
		pStmt.setInt(6, stamp5);
		pStmt.setString(7, comment);
		pStmt.setInt(8, stampId);

		int ans = pStmt.executeUpdate();

		if(ans == 1) {
			result = true;
		}


		return result;
	}

}
