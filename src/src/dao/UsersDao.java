package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.Users;

public class UsersDao {
	Connection con=null;

	public UsersDao (Connection con) {
		this.con = con;
	}

	//
	public Users login(String number, String password) throws ClassNotFoundException, SQLException {

		Users user = new Users();

		// JDBCドライバを読み込む
				Class.forName("org.h2.Driver");

				// SQL文を準備する
				String sql = "SELECT u_id, name, number FROM Users WHERE number = ? AND password = ?";
				PreparedStatement pStmt = con.prepareStatement(sql);

				// SQL文を完成させる
				pStmt.setString(1, number);
				pStmt.setString(2, password);

				// SQL文を実行し、結果表を取得する
				ResultSet rs = pStmt.executeQuery();

				// 結果表をコレクションにコピーする
				 rs.next();
				 user.setUserId(Integer.parseInt(rs.getString("u_id")));
			     user.setNumber(rs.getString("number"));
			     user.setName(rs.getString("name"));




				// 結果を返す
				return user;
	}

}
