package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class BUPUSDAO {
	Connection con=null;

	public BUPUSDAO(Connection con) {
			this.con=con;
	}

	//insertPost1
	public void insertPost1(int empId, int intPost1)throws ClassNotFoundException, SQLException{

		System.out.println("empId" + empId);
		System.out.println("intPost1" + intPost1);
		// JDBCドライバを読み込む
		Class.forName("org.h2.Driver");

		// SQL文を準備する
		String sql = "INSERT INTO UP (u_id, post_id) VALUES (?, ?);";
		PreparedStatement pStmt = con.prepareStatement(sql);

		// SQL文を完成させる
		pStmt.setInt(1,empId);
		pStmt.setInt(2,intPost1);

		//実行！！
		pStmt.executeUpdate();

	}

	//insertPost2
	public void insertPost2(int empId, int intPost2)throws ClassNotFoundException, SQLException{

		// JDBCドライバを読み込む
		Class.forName("org.h2.Driver");

		// SQL文を準備する
		String sql = "INSERT INTO UP (u_id, post) VALUES (?, ?);";
		PreparedStatement pStmt = con.prepareStatement(sql);

		// SQL文を完成させる
		pStmt.setInt(1,empId);
		pStmt.setInt(2,intPost2);

		//実行！！
		pStmt.executeUpdate();

	}

	//insertPost3
	public void insertPost3(int empId, int intPost3)throws ClassNotFoundException, SQLException{

		// JDBCドライバを読み込む
		Class.forName("org.h2.Driver");

		// SQL文を準備する
		String sql = "INSERT INTO UP (u_id, post) VALUES (?, ?);";
		PreparedStatement pStmt = con.prepareStatement(sql);

		// SQL文を完成させる
		pStmt.setInt(1,empId);
		pStmt.setInt(2,intPost3);

		//実行！！
		pStmt.executeUpdate();

	}

	//insertSection
	public int insertSection(int empId, int intSecId)throws ClassNotFoundException, SQLException{
		int result = 0;

		// JDBCドライバを読み込む
		Class.forName("org.h2.Driver");

		// SQL文を準備する
		String sql = "INSERT INTO US (u_id, sec_id) VALUES (?, ?);";
		PreparedStatement pStmt = con.prepareStatement(sql);

		// SQL文を完成させる
		pStmt.setInt(1,empId);
		pStmt.setInt(2,intSecId);

		result = pStmt.executeUpdate();
		System.out.println("insertSection = " + result);

		return result;
	}


	//updatePoet1
	public int updatePost1(int empId, int intPost1)throws ClassNotFoundException, SQLException{
		int result = 0;
		System.out.println(empId);
		System.out.println(intPost1);
		// JDBCドライバを読み込む
		Class.forName("org.h2.Driver");

		// SQL文を準備する
		String sql = "UPDATE UP SET post_id = ? WHERE u_id = ?;";
		PreparedStatement pStmt = con.prepareStatement(sql);

		// SQL文を完成させる
		pStmt.setInt(1,intPost1);
		pStmt.setInt(2,empId);

		//実行！！
		result = pStmt.executeUpdate();

		return result;

	}

	//updatePoet2
	public int updatePost2(int empId,int intPost2)throws ClassNotFoundException, SQLException{
		int result = 0;
		System.out.println(empId);
		System.out.println(intPost2);
		// JDBCドライバを読み込む
		Class.forName("org.h2.Driver");

		// SQL文を準備する
		String sql = "UPDATE UP SET post_id = ? WHERE u_id = ?;";
		PreparedStatement pStmt = con.prepareStatement(sql);

		// SQL文を完成させる
		pStmt.setInt(1,intPost2);
		pStmt.setInt(2,empId);

		//実行！！
		result = pStmt.executeUpdate();

		return result;
	}

	//updatePoet3
	public int updatePost3(int empId,int intPost3)throws ClassNotFoundException, SQLException{
		int result = 0;
		System.out.println(empId);
		System.out.println(intPost3);
		// JDBCドライバを読み込む
		Class.forName("org.h2.Driver");

		// SQL文を準備する
		String sql = "UPDATE UP SET post_id = ? WHERE u_id = ?;";
		PreparedStatement pStmt = con.prepareStatement(sql);

		// SQL文を完成させる
		pStmt.setInt(1,intPost3);
		pStmt.setInt(2,empId);

		//実行！！
		result = pStmt.executeUpdate();

		return result;


	}

	//insertSection
	public int updateSection(int empId, int intSecId)throws ClassNotFoundException, SQLException{
		int result = 0;

		// JDBCドライバを読み込む
		Class.forName("org.h2.Driver");

		// SQL文を準備する
		String sql = "UPDATE UP SET sec_id = ? WHERE u_id = ?;";
		PreparedStatement pStmt = con.prepareStatement(sql);

		// SQL文を完成させる
		pStmt.setInt(1,empId);
		pStmt.setInt(2,intSecId);

		result = pStmt.executeUpdate();
		System.out.println("insertSection = " + result);

		return result;
	}



}
