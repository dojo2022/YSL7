package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import model.BProfileAllBeans;
import model.RoleBeans;

public class BUserDAO {
	Connection con=null;

	public BUserDAO(Connection con) {
		this.con=con;
	}

	//事業部のデータを取得する
	public ArrayList<RoleBeans> getRole1() throws SQLException, ClassNotFoundException {
		// JDBCドライバを読み込む
		Class.forName("org.h2.Driver");

		ArrayList<RoleBeans> role = new ArrayList<RoleBeans>();
		// SQL文を準備する
		String sql = "SELECT * FROM DEPARTMENTS";
		PreparedStatement pStmt = con.prepareStatement(sql);
		ResultSet rs = pStmt.executeQuery();

		while (rs.next()) {
			RoleBeans r = new RoleBeans();
			r.setDepId(rs.getInt("dep_id"));
			r.setDepartment(rs.getString("department"));
			role.add(r);
		}

		return role;
	}

	//事業部と部をJOINした情報を取得
	public ArrayList<RoleBeans> getRole2() throws SQLException, ClassNotFoundException {
		// JDBCドライバを読み込む
		Class.forName("org.h2.Driver");

		ArrayList<RoleBeans> role = new ArrayList<RoleBeans>();
		// SQL文を準備する
		String sql = "SELECT DEPARTMENTS.DEP_ID, DEPARTMENTS.DEPARTMENT, DIVISIONS.DIV_ID ,DIVISIONS.DIVISION FROM DEPARTMENTS LEFT JOIN DIVISIONS ON DEPARTMENTS.DEP_ID = DIVISIONS.DEP_ID";

		PreparedStatement pStmt = con.prepareStatement(sql);
		ResultSet rs = pStmt.executeQuery();

		while (rs.next()) {
			RoleBeans r = new RoleBeans();
			r.setDepId(rs.getInt("dep_id"));
			r.setDivId(rs.getInt("div_id"));
			r.setDivision(rs.getString("division"));
			role.add(r);
		}

		return role;
	}

	//部と課をJOINした情報を取得
	public ArrayList<RoleBeans> getRole3() throws SQLException, ClassNotFoundException {
		// JDBCドライバを読み込む
		Class.forName("org.h2.Driver");

		ArrayList<RoleBeans> role = new ArrayList<RoleBeans>();
		// SQL文を準備する
		String sql = "SELECT DIVISIONS.DIV_ID ,SECTIONS.SEC_ID , SECTIONS.SECTION FROM DIVISIONS LEFT JOIN SECTIONS ON DIVISIONS.DIV_ID = SECTIONS.DIV_ID ";

		PreparedStatement pStmt = con.prepareStatement(sql);
		ResultSet rs = pStmt.executeQuery();

		while (rs.next()) {
			RoleBeans r = new RoleBeans();

			r.setDivId(rs.getInt("div_id"));
			r.setSecId(rs.getInt("sec_id"));
			r.setSection(rs.getString("section"));
			role.add(r);
		}

		return role;
	}

	//registUser
	public int registUser(String number, String name,String year, int intgender) throws ClassNotFoundException, SQLException{
		int result = 0;
//		int autoIncrementKey = 0;

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
		System.out.println("result" + result);


		//もしinsertできていたら、一番大きいu_idを取ってくる
//		if(result == 1) {
//			ResultSet res = pStmt.getGeneratedKeys();
//			if(res.next()){
//	             autoIncrementKey = res.getInt(1);
//	             System.out.println("res" + res);
//	         }
//			result = autoIncrementKey;
//		}

		return result;
	}

	//selectEmpId
	public int selectEmpId() throws ClassNotFoundException, SQLException {
		int empId = 0;

		// JDBCドライバを読み込む
		Class.forName("org.h2.Driver");

		// SQL文を準備する
		String sql = "SELECT MAX(u_id) FROM Users;";
		PreparedStatement pStmt = con.prepareStatement(sql);
		ResultSet rs = pStmt.executeQuery();

		while (rs.next()) {
			empId = rs.getInt("MAX(u_id)");
		}

		return empId;
	}

	//updateUser
	public int updateUser(int intempId, String number, String name,String year, int intgender) throws ClassNotFoundException, SQLException{
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
		pStmt.setInt(5,intempId);

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
		String sql = "UPDATE Users SET retireflag=1 WHERE u_id=?";
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
		String sql = "SELECT users.u_id, USERS.NUMBER AS NUMBER,USERS.NAME AS NAME,DEPARTMENTS.DEPARTMENT AS DEP,DIVISIONS.DIVISION AS DIV,SECTIONS.SECTION AS SEC,POSTS.POST AS POST,USERS.YEAR AS YEAR FROM US LEFT JOIN USERS ON US.U_ID = USERS.U_ID LEFT JOIN SECTIONS ON US.SEC_ID = SECTIONS.SEC_ID LEFT JOIN DIVISIONS ON SECTIONS.DIV_ID = DIVISIONS.DIV_ID LEFT JOIN DEPARTMENTS ON DIVISIONS.DEP_ID = DEPARTMENTS.DEP_ID LEFT JOIN UP ON US.U_ID = UP.U_ID LEFT JOIN POSTS ON UP.POST_ID = POSTS.POST_ID WHERE retireflag=0; ";




		// SQL文を実行し、結果表を取得する
		PreparedStatement pStmt = con.prepareStatement(sql);
		ResultSet rs = pStmt.executeQuery();

		// 結果表をコレクションにコピーする
		while (rs.next()) {
			BProfileAllBeans profiles = new BProfileAllBeans();
			profiles.setEmpId(rs.getInt("u_id"));
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
			profile.setEmpId(rs.getInt("u_id"));
			profile.setName(rs.getString("name"));
			profile.setNumber(rs.getString("number"));
			profile.setGender(rs.getInt("gender"));
			profile.setYear(rs.getString("year"));
			profile.setDepartment(rs.getString("department"));
			profile.setSection(rs.getString("section"));
			profile.setPost(rs.getString("post"));
		}

		return profile;
	}
}
