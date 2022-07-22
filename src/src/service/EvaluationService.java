package service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import dao.EvaluationsDao;

public class EvaluationService {

	public boolean registEval(int toUserId, int fromUserId,
			int evaluation1, int evaluation2, int evaluation3, int evaluation4, int evaluation5) {
		Connection con = null;
		boolean result = false;

		try {
			Class.forName("org.h2.Driver");
			con = DriverManager.getConnection("jdbc:h2:file:C:/YSL7Data/miemo", "sa", "");
			//EvaluationDaoをインスタンス化する。Daoがいないからエラー？
			EvaluationsDao eDao = new EvaluationsDao(con);

			//Daoのメソッドを呼び出す
			//Dao作ってないから現時点ではエラーだよ。
			result = eDao.registEval(toUserId, fromUserId, evaluation1,
					evaluation2, evaluation3, evaluation4, evaluation5);
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println(e.getMessage());
			//booleanだからfalseで返す？
			return false;
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			return false;
		}

		//DBの切断
		if (con != null) {
			try {
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
				return false;
			}
		}
		return true;
	}
}
