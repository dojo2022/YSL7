package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import model.BStampsBeans;

public class BStampsDAO {
	Connection con = null;
	//コンストラクタ
	public BStampsDAO(Connection con) {
		this.con = con;
	}
	//emp_idに合致するユーザーの各スタンプが押された回数を数えるメソッド
	public BStampsBeans countAllStamps(int empId) throws ClassNotFoundException, SQLException{
		//戻り値を入れるBStampsBeans型の変数を用意する
		BStampsBeans sCount = new BStampsBeans();
		//JDBCドライバを読み込む
		Class.forName("org.h2.Driver");

		//SQL文を準備する
		String sql = "select stamp1, stamp2, stamp3,stamp4, stamp5 FROM STAMPS where u_id = ? and date>='2022-07-01' and date<'2022-08-01'";
		PreparedStatement pStmt = con.prepareStatement(sql);

		//SQL文の?部分を埋める
		pStmt.setInt(1, empId);

		//SQL文を実行し、結果を取得する
		ResultSet rs = pStmt.executeQuery();

		//取ってきたデータをbeansにしまう
		while(rs.next()) {
			if(rs.getInt("stamp1") == 1) {
				sCount.setCountS1(sCount.getCountS1()+1);
			}
			if(rs.getInt("stamp2") == 1) {
				sCount.setCountS2(sCount.getCountS2()+1);
			}
			if(rs.getInt("stamp3") == 1) {
				sCount.setCountS3(sCount.getCountS3()+1);
				}
			if(rs.getInt("stamp4") == 1) {
				sCount.setCountS4(sCount.getCountS4()+1);
			}
			if(rs.getInt("stamp5") == 1) {
				sCount.setCountS5(sCount.getCountS5()+1);
			}

		}

		//結果を返す
		return sCount;

	}
	//emp_idに合致するユーザーが押したスタンプ1(とても不満)のcategory_id,categoryを調べるメソッド
	public ArrayList<BStampsBeans> selectStamp1(int empId)throws ClassNotFoundException, SQLException{
		//戻り値を入れるArrayListを準備する
		ArrayList<BStampsBeans> stamp1 = new ArrayList<>();

		// JDBCドライバを読み込む
		Class.forName("org.h2.Driver");

		//SQL文を準備する
		String sql = "SELECT stamps.category_id, categories.category from stamps left join categories on stamps.category_id = categories.category_id where u_id = ? and stamp1 = 1 and date>='2022-07-02' and date<'2022-08-01'";
		PreparedStatement pStmt = con.prepareStatement(sql);

		//SQL文の?部分を埋める
		pStmt.setInt(1, empId);


		//SQL文を完成させる
		ResultSet rs = pStmt.executeQuery();

		while(rs.next()) {
			BStampsBeans s1 = new BStampsBeans();
			s1.setCategoryId(rs.getInt("category_id"));
			s1.setCategory(rs.getString("category"));
			stamp1.add(s1);
		}
		return stamp1;
	}
	//emp_idに合致するユーザーが押したスタンプ2(不満)のcategory_id,categoryを調べるメソッド
	public ArrayList<BStampsBeans> selectStamp2(int empId)throws ClassNotFoundException, SQLException{
		//戻り値を入れるArrayListを準備する
		ArrayList<BStampsBeans> stamp2 = new ArrayList<>();

		// JDBCドライバを読み込む
		Class.forName("org.h2.Driver");

		//SQL文を準備する
		String sql = "SELECT stamps.category_id, categories.category from stamps left join categories on stamps.category_id = categories.category_id where u_id = ? and stamp2 = 1 and date>='2022-07-02' and date<'2022-08-01'";
		PreparedStatement pStmt = con.prepareStatement(sql);

		//SQL文の?部分を埋める
		pStmt.setInt(1, empId);


		//SQL文を完成させる
		ResultSet rs = pStmt.executeQuery();

		while(rs.next()) {
			BStampsBeans s2 = new BStampsBeans();
			s2.setCategoryId(rs.getInt("category_id"));
			s2.setCategory(rs.getString("category"));
			stamp2.add(s2);
		}
		return stamp2;
	}
	//emp_idに合致するユーザーが押したスタンプ3(普通)のcategory_id,categoryを調べるメソッド
	public ArrayList<BStampsBeans> selectStamp3(int empId)throws ClassNotFoundException, SQLException{
		//戻り値を入れるArrayListを準備する
		ArrayList<BStampsBeans> stamp3 = new ArrayList<>();

		// JDBCドライバを読み込む
		Class.forName("org.h2.Driver");

		//SQL文を準備する
		String sql = "SELECT stamps.category_id, categories.category from stamps left join categories on stamps.category_id = categories.category_id where u_id = ? and stamp3 = 1 and date>='2022-07-02' and date<'2022-08-01'";
		PreparedStatement pStmt = con.prepareStatement(sql);

		//SQL文の?部分を埋める
		pStmt.setInt(1, empId);


		//SQL文を完成させる
		ResultSet rs = pStmt.executeQuery();

		while(rs.next()) {
			BStampsBeans s3 = new BStampsBeans();
			s3.setCategoryId(rs.getInt("category_id"));
			s3.setCategory(rs.getString("category"));
			stamp3.add(s3);
		}
		return stamp3;
	}
	//emp_idに合致するユーザーが押したスタンプ4(満足)のcategory_id,categoryを調べるメソッド
	public ArrayList<BStampsBeans> selectStamp4(int empId)throws ClassNotFoundException, SQLException{
		//戻り値を入れるArrayListを準備する
		ArrayList<BStampsBeans> stamp4 = new ArrayList<>();

		// JDBCドライバを読み込む
		Class.forName("org.h2.Driver");

		//SQL文を準備する
		String sql = "SELECT stamps.category_id, categories.category from stamps left join categories on stamps.category_id = categories.category_id where u_id = ? and stamp4 = 1 and date>='2022-07-02' and date<'2022-08-01'";
		PreparedStatement pStmt = con.prepareStatement(sql);

		//SQL文の?部分を埋める
		pStmt.setInt(1, empId);


		//SQL文を完成させる
		ResultSet rs = pStmt.executeQuery();

		while(rs.next()) {
			BStampsBeans s4 = new BStampsBeans();
			s4.setCategoryId(rs.getInt("category_id"));
			s4.setCategory(rs.getString("category"));
			stamp4.add(s4);
		}
		return stamp4;
	}
	//emp_idに合致するユーザーが押したスタンプ5(とても満足)のcategory_id,categoryを調べるメソッド
	public ArrayList<BStampsBeans> selectStamp5(int empId)throws ClassNotFoundException, SQLException{
		//戻り値を入れるArrayListを準備する
		ArrayList<BStampsBeans> stamp5 = new ArrayList<>();

		// JDBCドライバを読み込む
		Class.forName("org.h2.Driver");

		//SQL文を準備する
		String sql = "SELECT stamps.category_id, categories.category from stamps left join categories on stamps.category_id = categories.category_id where u_id = ? and stamp5 = 1 and date>='2022-07-02' and date<'2022-08-01'";
		PreparedStatement pStmt = con.prepareStatement(sql);

		//SQL文の?部分を埋める
		pStmt.setInt(1, empId);


		//SQL文を完成させる
		ResultSet rs = pStmt.executeQuery();

		while(rs.next()) {
			BStampsBeans s5 = new BStampsBeans();
			s5.setCategoryId(rs.getInt("category_id"));
			s5.setCategory(rs.getString("category"));
			stamp5.add(s5);
		}
		return stamp5;
	}

	//empIdに合致するユーザーのきもちスタンプタブを表示するためのデータを取得するメソッド
	public ArrayList<BStampsBeans> selectAllStamps(int empId)throws ClassNotFoundException, SQLException{
		//戻り値を入れるArrayListを用意する
		ArrayList<BStampsBeans> allStamps = new ArrayList<>();

		//JDBCドライバを読み込む
		Class.forName("org.h2.Driver");

		//SQL文を準備する
		String sql = "SELECT date,stamp1,stamp2,stamp3,stamp4,stamp5,comment,categories.category from stamps left join categories on stamps.category_id = categories.category_id where u_id = ? and date>='2022-07-01' and date<'2022-08-01';";
		PreparedStatement pStmt = con.prepareStatement(sql);

		//SQL文の?部分を埋める
		pStmt.setInt(1, empId);

		//SQL文を実行し、結果表を取得する
		ResultSet rs = pStmt.executeQuery();

		//結果表をコレクションにコピーする
		while(rs.next()) {
			BStampsBeans sAll = new BStampsBeans();
			sAll.setDate(rs.getString("date"));
			sAll.setStamp1(rs.getInt("stamp1"));
			sAll.setStamp2(rs.getInt("stamp2"));
			sAll.setStamp3(rs.getInt("stamp3"));
			sAll.setStamp4(rs.getInt("stamp4"));
			sAll.setStamp5(rs.getInt("stamp5"));
			sAll.setComment(rs.getString("comment"));
			sAll.setCategory(rs.getString("category"));


			allStamps.add(sAll);
		}


		return allStamps;
	}
}
