package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import model.BEvaluationsBeans;

public class BEvaluationsDAO {
	Connection con=null;

	public BEvaluationsDAO(Connection con) {
		this.con=con;
	}
	//自己評価
	public ArrayList<BEvaluationsBeans> selectMyEvaluation(int empId) throws ClassNotFoundException, SQLException {

		//自己評価をreturnするArrayList
		ArrayList<BEvaluationsBeans> myEvaluationList = new ArrayList<>();

		// JDBCドライバを読み込む
		Class.forName("org.h2.Driver");

		//SQL文用意
		String sql = "SELECT * FROM Evaluations WHERE from_u_id=? AND to_u_id=?";
		PreparedStatement pStmt = con.prepareStatement(sql);

		//SQL完成させる
		pStmt.setInt(1,empId);
		pStmt.setInt(2,empId);

		// SQL文を実行し、結果表を取得する
		ResultSet rs = pStmt.executeQuery();

		//結果をArrayListに入れる
		while (rs.next()) {
			BEvaluationsBeans evaluation = new BEvaluationsBeans();
			evaluation.setEmpId(empId);
			evaluation.setEva1(rs.getInt("evaluation1"));
			evaluation.setEva2(rs.getInt("evaluation2"));
			evaluation.setEva3(rs.getInt("evaluation3"));
			evaluation.setEva4(rs.getInt("evaluation4"));
			evaluation.setEva5(rs.getInt("evaluation5"));
			myEvaluationList.add(evaluation);
		}
		return myEvaluationList;
	}

	//他者評価
	public ArrayList<BEvaluationsBeans> selectOtherEvaluation(int empId) throws ClassNotFoundException, SQLException {

		//他者評価をreturnするArrayList
		ArrayList<BEvaluationsBeans> otherEvaluationList = new ArrayList<>();

		// JDBCドライバを読み込む
		Class.forName("org.h2.Driver");

		//SQL文用意
		String sql = "SELECT * FROM Evaluations WHERE from_u_id<>? AND to_u_id=?";
		PreparedStatement pStmt = con.prepareStatement(sql);

		//SQL完成させる
		pStmt.setInt(1,empId);
		pStmt.setInt(2,empId);

		// SQL文を実行し、結果表を取得する
		ResultSet rs = pStmt.executeQuery();

		//結果をArrayListに入れる
		while (rs.next()) {
			BEvaluationsBeans evaluations = new BEvaluationsBeans();
			evaluations.setEmpId(empId);
			evaluations.setEva1(rs.getInt("evaluation1"));
			evaluations.setEva2(rs.getInt("evaluation2"));
			evaluations.setEva3(rs.getInt("evaluation3"));
			evaluations.setEva4(rs.getInt("evaluation4"));
			evaluations.setEva5(rs.getInt("evaluation5"));
			otherEvaluationList.add(evaluations);
		}
		return otherEvaluationList;
	}
}
