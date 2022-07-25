package dao;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import model.Users;

public class UsersDao {
	Connection con=null;

	public UsersDao (Connection con) {
		this.con = con;
	}

	//ログイン
	public Users login(String number, String password) throws ClassNotFoundException, SQLException {

		Users user = null;

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
				if(rs.next()) {
					 user = new Users();
					 user.setUserId(Integer.parseInt(rs.getString("u_id")));
				     user.setNumber(rs.getString("number"));
				     user.setName(rs.getString("name"));
				}




				// 結果を返す
				return user;
	}






	//ここからプロフィール表示
	public Users showProfile(int userId) throws ClassNotFoundException, SQLException {

		Users users = null;

		// JDBCドライバを読み込む
		Class.forName("org.h2.Driver");

		// SQL文を準備する
		String sql = "SELECT Users.name,Users.number,Departments.department, Divisions.division, Sections.section, Posts.post, Users.year, Users.password "
				+ "FROM US LEFT JOIN Users ON US.u_id = Users.u_id "
				+ "LEFT JOIN Sections ON US.sec_id = Sections.sec_id "
				+ "LEFT JOIN Divisions ON Sections.div_id = Divisions.div_id "
				+ "LEFT JOIN Departments ON Divisions.dep_id = Departments.dep_id "
				+ "LEFT JOIN UP ON US.u_id = UP.u_id "
				+ "LEFT JOIN Posts ON UP.post_id = Posts.post_id "
				+ "WHERE Users.u_id = ?";
		PreparedStatement pStmt = con.prepareStatement(sql);

		// SQL文を完成させる
		pStmt.setInt(1, userId);

		// SQL文を実行し、データを取得する
		ResultSet rs = pStmt.executeQuery();

		// 結果表をコレクションにコピーする
		if(rs.next()) {
			users = new Users();
			users.setName(rs.getString("name"));
			users.setNumber(rs.getString("number"));
			users.setDepartment(rs.getString("department"));
			users.setDivision(rs.getString("division"));
			users.setSection(rs.getString("section"));
			users.setPost(rs.getString("post"));
			users.setYear(rs.getString("year"));
			users.setPassword(rs.getString("password"));
		}



		// 結果を返す
		return users;

	}



	//ここからパスワード変更

	public boolean updatePw(int userId, String password) throws ClassNotFoundException, SQLException {
		boolean result = false;

		// JDBCドライバを読み込む
		Class.forName("org.h2.Driver");

		// SQL文を準備する
		String sql = " UPDATE Users set password = ? WHERE u_id =?";
		PreparedStatement pStmt = con.prepareStatement(sql);

		// SQL文を完成させる
		pStmt.setString(1, password);
		pStmt.setInt(2,userId);

		// SQL文を実行し、更新件数を取得する
		int num = pStmt.executeUpdate();

		if(num==1) {
			result= true;
		}
		// 結果を返す
		return result;
	}

	//評価の表示
	public ArrayList<Users> showEmp() throws ClassNotFoundException, SQLException {
		//return用の変数。
		ArrayList<Users> userList = new ArrayList<Users>();

		//ドライバの読み込み。
		Class.forName("org.h2.Driver");

		//SQL文コーナー。
		String sql = "SELECT Users.u_id, Users.name, Users.number, Departments.department, Divisions.division, Sections.section, Posts.post\r\n"
				+ " FROM US\r\n"
				+ " LEFT JOIN Users ON US.u_id = Users.u_id\r\n"
				+ " LEFT JOIN Sections ON US.sec_id = Sections.sec_id\r\n"
				+ " LEFT JOIN Divisions ON Sections.div_id = Divisions.div_id\r\n"
				+ " LEFT JOIN Departments ON Divisions.dep_id = Departments.dep_id\r\n"
				+ " LEFT JOIN UP ON US.u_id = UP.u_id\r\n"
				+ " LEFT JOIN Posts ON UP.post_id = Posts.post_id;	";
		PreparedStatement pStmt = con.prepareStatement(sql);

		//SQL文を実行し、結果を取得する。
		ResultSet rs = pStmt.executeQuery();

		//while回してrsに入れる。
		while(rs.next()) {
			Users users = new Users();
			users.setUserId(rs.getInt("u_id"));
			users.setName(rs.getString("name"));
			users.setNumber(rs.getString("number"));
			users.setDepartment(rs.getString("department"));
			users.setDivision(rs.getString("division"));
			users.setSection(rs.getString("section"));
			users.setPost(rs.getString("post"));
			userList.add(users);
		}
		return userList;
	}




}


