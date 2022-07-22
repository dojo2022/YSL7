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

		System.out.println(empId);
		System.out.println(intPost1);
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

	//insertSection1
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

		return result;
	}


	//updatePoet1
	public int updatePost1(int empId, int intPost1){

	}

	//updatePoet2
	public int upPost2(int empId,int intPost2){

	}

	//updatePoet3
	public int updatetPost3(int empId, int intPost1, int intPost2, int intPost3){

	}


}
