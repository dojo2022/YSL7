package service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;

import dao.BEvaluationsDAO;
import dao.BMessagesDAO;
import dao.BNotesDAO;
import model.BEvaluationsBeans;
import model.BMessagesBeans;
import model.BNotesBeans;

public class BTabService {




//selectNotesメソッドです（メモ系）
	public ArrayList<BNotesBeans> selectNotes(int empId){
		Connection con = null;
		ArrayList<BNotesBeans> notesList= new ArrayList<BNotesBeans>();
		try {
			Class.forName("org.h2.Driver");
			con = DriverManager.getConnection("jdbc:h2:file:C:/ysl7data/miemo", "sa", "");
			//BUserDAOをインスタンス化する、その際に引数に接続を司る上の値を渡してあげる
			BNotesDAO bnDao=new BNotesDAO(con);

			//BUserDAOのselectAllListメソッドを呼び出す（引数なし）
			notesList=bnDao.selectNotes(empId);
		}catch(ClassNotFoundException | SQLException e) {
			e.printStackTrace();
			return notesList;
		}
		// データベースを切断
		if (con != null) {
			try {
				con.close();
			}
			catch (SQLException e) {
				e.printStackTrace();
				//Exceptionが出ているのでnullで返す
				return null;
			}
		}
		return notesList;
	}

//	selectMessagesメソッドです（メッセージ系）
	public ArrayList<BMessagesBeans> selectMessages(int empId){
		Connection con = null;
		ArrayList<BMessagesBeans> messageList= new ArrayList<BMessagesBeans>();
		try {
			Class.forName("org.h2.Driver");
			con = DriverManager.getConnection("jdbc:h2:file:C:/ysl7data/miemo", "sa", "");
			//BUserDAOをインスタンス化する、その際に引数に接続を司る上の値を渡してあげる
			BMessagesDAO bmDao=new BMessagesDAO(con);

			//BUserDAOのselectAllListメソッドを呼び出す（引数なし）
			messageList=bmDao.selectMessages(empId);
		}catch(ClassNotFoundException | SQLException e) {
			e.printStackTrace();
			return messageList;
		}
		// データベースを切断
		if (con != null) {
			try {
				con.close();
			}
			catch (SQLException e) {
				e.printStackTrace();
				//Exceptionが出ているのでnullで返す
				return null;
			}
		}
		return messageList;
	}
//	selectMyEvaluationメソッドです（評価系）
	public ArrayList<BEvaluationsBeans> selectMyEvaluation(int empId){
		Connection con = null;
		ArrayList<BEvaluationsBeans> myEvaluationList= new ArrayList<BEvaluationsBeans>();
		try {
			Class.forName("org.h2.Driver");
			con = DriverManager.getConnection("jdbc:h2:file:C:/ysl7data/miemo", "sa", "");
			//BUserDAOをインスタンス化する、その際に引数に接続を司る上の値を渡してあげる
			BEvaluationsDAO beDao=new BEvaluationsDAO(con);

			//BUserDAOのselectAllListメソッドを呼び出す（引数なし）
			myEvaluationList=beDao.selectMyEvaluation(empId);
		}catch(ClassNotFoundException | SQLException e) {
			e.printStackTrace();
			return myEvaluationList;
		}
		// データベースを切断
		if (con != null) {
			try {
				con.close();
			}
			catch (SQLException e) {
				e.printStackTrace();
				//Exceptionが出ているのでnullで返す
				return null;
			}
		}
		return myEvaluationList;
	}
//	selectOtherEvaluationメソッドです（評価系）
	public ArrayList<BEvaluationsBeans> selectOtherEvaluation(int empId){
		Connection con = null;
		ArrayList<BEvaluationsBeans> otherEvaluationList= new ArrayList<BEvaluationsBeans>();
		try {
			Class.forName("org.h2.Driver");
			con = DriverManager.getConnection("jdbc:h2:file:C:/ysl7data/miemo", "sa", "");
			//BUserDAOをインスタンス化する、その際に引数に接続を司る上の値を渡してあげる
			BEvaluationsDAO beDao=new BEvaluationsDAO(con);

			//BUserDAOのselectAllListメソッドを呼び出す（引数なし）
			otherEvaluationList=beDao.selectOtherEvaluation(empId);
		}catch(ClassNotFoundException | SQLException e) {
			e.printStackTrace();
			return otherEvaluationList;
		}
		// データベースを切断
		if (con != null) {
			try {
				con.close();
			}
			catch (SQLException e) {
				e.printStackTrace();
				//Exceptionが出ているのでnullで返す
				return null;
			}
		}
		return otherEvaluationList;
	}
}

