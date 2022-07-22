package service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;

import dao.BEvaluationsDAO;
import dao.BMessagesDAO;
import dao.BNotesDAO;
import dao.BStampsDAO;
import model.BEvaluationsBeans;
import model.BMessagesBeans;
import model.BNotesBeans;
import model.BStampsBeans;

public class BTabService {

//searchStampGraphメソッド（きもちグラフ）
	public ArrayList<Object>searchStampGraph (int empId){
		Connection con = null;
		ArrayList<Object> stampGraph = new ArrayList<>();
		try {
			Class.forName("org.h2.Driver");
			con = DriverManager.getConnection("jdbc:h2:file:C:/ysl7data/miemo", "sa", "");
			//BStampsDAOを実体化する
			BStampsDAO bsDao = new BStampsDAO(con);
			//BStampsDAOのcountAllStampsメソッドを呼び出す
			BStampsBeans sCount = bsDao.countAllStamps(empId);
			//BStampsDAOのselectStamp1~5メソッドを呼び出す
			ArrayList<BStampsBeans> stamp1 = bsDao.selectStamp1(empId);
			ArrayList<BStampsBeans> stamp2 = bsDao.selectStamp2(empId);
			ArrayList<BStampsBeans> stamp3 = bsDao.selectStamp3(empId);
			ArrayList<BStampsBeans> stamp4 = bsDao.selectStamp4(empId);
			ArrayList<BStampsBeans> stamp5 = bsDao.selectStamp5(empId);

			//sCount~stamp5までを一個のArrayListにまとめる
			stampGraph.add(sCount);
			stampGraph.add(stamp1);
			stampGraph.add(stamp2);
			stampGraph.add(stamp3);
			stampGraph.add(stamp4);
			stampGraph.add(stamp5);
		}catch(ClassNotFoundException | SQLException e) {
			e.printStackTrace();
			return stampGraph;
		}
		if(con != null) {
			try {
				con.close();
			}
			catch(SQLException e) {
				e.printStackTrace();
				return stampGraph;
			}
		}

		return stampGraph;
	}

//searchAllStampsメソッド（きもちスタンプタブ）
	public ArrayList<BStampsBeans> searchAllStamps(int empId){
		Connection con = null;
		ArrayList<BStampsBeans> allStamps = new ArrayList<>();
		try {
			Class.forName("org.h2.Driver");
			con = DriverManager.getConnection("jdbc:h2:file:C:/ysl7data/miemo", "sa", "");

			//BStampsDAOを実体化
			BStampsDAO bsDao = new BStampsDAO(con);
			//BStampsDAOのselectAllStampsメソッドを呼び出す
			allStamps = bsDao.selectAllStamps(empId);
		}
		catch(ClassNotFoundException | SQLException e) {
			e.printStackTrace();
			return allStamps;

		}
		if(con != null) {
			try {
				con.close();
			}catch(SQLException e) {
				e.printStackTrace();
				return allStamps;

			}
		}

		return allStamps;
	}

//selectNotesメソッドです（メモ系）
	public ArrayList<BNotesBeans> selectNotes(int empId){
		Connection con = null;
		ArrayList<BNotesBeans> notesList= new ArrayList<BNotesBeans>();
		try {
			Class.forName("org.h2.Driver");
			con = DriverManager.getConnection("jdbc:h2:file:C:/ysl7data/miemo", "sa", "");
			//BUserDAOをインスタンス化する、その際に引数に接続を司る上の値を渡してあげる
			BNotesDAO bnDao=new BNotesDAO(con);

			//noteDAOのselectNotesメソッドを呼び出す
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
				return notesList;
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

