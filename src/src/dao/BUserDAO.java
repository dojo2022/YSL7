package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import model.BProfileAllBeans;

public class BUserDAO {
	Connection con=null;

	public BUserDAO(Connection con) {
		this.con=con;
	}

	//registUser
	public int registUser(String number, String name,String year, int intgender) throws ClassNotFoundException, SQLException{
		int result = 0;
		int autoIncrementKey = 0;

		// JDBCドライバを読み込む
		Class.forName("org.h2.Driver");

		// SQL文を準備する
		String sql = "INSERT INTO Users (number, name, year, gender) VALUES (?, ?, ?, ?);";
		PreparedStatement pStmt = con.prepareStatement(sql);

		// SQL文を完成させる
		pStmt.setString(1,number);
		pStmt.setString(2,name);
		pStmt.setString(3,year);
		pStmt.setInt(4,intgender);

		// SQL文を実行し、結果表を取得する
		result = pStmt.executeUpdate();

		//もしinsertできていたら、一番大きいu_idを取ってくる
		if(result == 1) {
			ResultSet res = pStmt.getGeneratedKeys();
			if(res.next()){
	             autoIncrementKey = res.getInt(1);
	         }
			result = autoIncrementKey;
		}

		return result;
	}

	//updateUser
	public int updateUser(int empId, String number, String name,String year, int intgender) throws ClassNotFoundException, SQLException{
		int result = 0;

		// JDBCドライバを読み込む
		Class.forName("org.h2.Driver");

		// SQL文を準備する
		String sql = "UPDATE Users SET number = ?, name = ?, year = ?, gender = ? where u_id = ?;";
		PreparedStatement pStmt = con.prepareStatement(sql);

		// SQL文を完成させる
		pStmt.setString(1,number);
		pStmt.setString(2,name);
		pStmt.setString(3,year);
		pStmt.setInt(4,intgender);
		pStmt.setInt(5,empId);

		// SQL文を実行し、結果表を取得する
		result = pStmt.executeUpdate();

		return result;
	}



	//deleteUser
	public int deleteUser(int empId) throws ClassNotFoundException, SQLException{

		//あらかじめreturn用の変数を用意しておく
		int ans=0;

		// JDBCドライバを読み込む
		Class.forName("org.h2.Driver");

		// SQL文を準備する
		String sql = "UPDATE Users SET flag=0 WHERE u_id=?";
		PreparedStatement pStmt = con.prepareStatement(sql);

		// SQL文を完成させる
		pStmt.setInt(1,empId);

		// SQL文を実行し、結果表を取得する
		ans = pStmt.executeUpdate();

		// 結果を返す
		return ans;
	}


	//selectAllList
	public ArrayList<BProfileAllBeans> selectAllList() throws SQLException, ClassNotFoundException {

		//あらかじめreturn用の変数を用意しておく
		ArrayList<BProfileAllBeans> listAll = new ArrayList<BProfileAllBeans>();

		// JDBCドライバを読み込む
		Class.forName("org.h2.Driver");

		// SQL文を準備する
		String sql = "SELECT Users.number AS number,Users.name AS name,Departments.department AS dep,Divisions.division AS div,Sections.section AS sec,Posts.post AS post,Users.year AS year"
				+ "FROM US LEFT JOIN Users ON US.u_id = Users.u_id "
				+ "LEFT JOIN Sections ON US.sec_id = Sections.sec_id "
				+ "LEFT JOIN Divisions ON Sections.div_id = Divisions.div_id "
				+ "LEFT JOIN Departments ON Divisions.dep_id = Departments.dep_id "
				+ "LEFT JOIN UP ON US.u_id = UP.u_id "
				+ "LEFT JOIN Posts ON UP.Post_id = Posts.id;";




		// SQL文を実行し、結果表を取得する
		PreparedStatement pStmt = con.prepareStatement(sql);
		ResultSet rs = pStmt.executeQuery();

		// 結果表をコレクションにコピーする
		while (rs.next()) {
			BProfileAllBeans profiles = new BProfileAllBeans();
			profiles.setNumber(rs.getString("number"));
			profiles.setName(rs.getString("name"));
			profiles.setDepartment(rs.getString("dep"));
			profiles.setDivision(rs.getString("div"));
			profiles.setSection(rs.getString("sec"));
			profiles.setPost(rs.getString("post"));
			profiles.setYear(rs.getString("year"));
			listAll.add(profiles);
		}


		// 結果を返す
		return listAll;

	}

	public BProfileAllBeans selectProfile(int empId) throws  SQLException, ClassNotFoundException {
		//戻り値を入れるためのBeans
		BProfileAllBeans profile = new BProfileAllBeans();

		// JDBCドライバを読み込む
		Class.forName("org.h2.Driver");

		//SQL文を準備する
		String sql = "SELECT US.u_id,Users.name, Users.number, Users.gender, Users.year, Departments.department, Divisions.division, Sections.section, Posts.post FROM US LEFT JOIN Users ON US.u_id = Users.u_id LEFT JOIN Sections ON US.sec_id = Sections.sec_id LEFT JOIN Divisions ON Sections.div_id = Divisions.div_id LEFT JOIN Departments ON Divisions.dep_id = Departments.dep_id  LEFT JOIN UP ON US.u_id = UP.u_id  LEFT JOIN Posts ON UP.post_id = Posts.post_id where us.u_id = ?";
		PreparedStatement pStmt = con.prepareStatement(sql);

		pStmt.setInt(1, empId);

		// SQL文を実行し、結果表を取得する
		ResultSet rs = pStmt.executeQuery();

		while(rs.next()) {
			profile.setEmpId(rs.getInt("US.u_id"));
			profile.setName(rs.getString("Users.name"));
			profile.setNumber(rs.getString("Users.number"));
			profile.setGender(rs.getInt("Users.gender"));
			profile.setYear(rs.getString("Users.year"));
			profile.setDepartment(rs.getString("Departments.department"));
			profile.setSection(rs.getString("Sections.section"));
			profile.setPost(rs.getString("Posts.post"));
		}

		return profile;
	}
}
