package service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import dao.StampsDao;

public class EditFeelingService {

	public boolean editFeeling(int userId, int categoryId, int stamp1, int stamp2, int stamp3,
			int stamp4, int stamp5, String comment){
		Connection con = null;
		boolean result = false;


		try {
			Class.forName("org.h2.Driver");
			con = DriverManager.getConnection("jdbc:h2:file:C:/YSL7Data/miemo", "sa", "");
			//★DAOをインスタンス化する、その際に引数に接続を司る上の値を渡してあげる
			StampsDao dao = new StampsDao(con);

			//★daoのメソッドを呼び出す
			 result = dao.editFeeling(userId,categoryId,stamp1,stamp2,stamp3,stamp4,stamp5,comment);

		}catch(SQLException e) {
			e.printStackTrace();
			System.out.println(e.getMessage());
			//トランザクションがある場合はこちらに書く（無ければ丸ごと書かない）
			/*try {
				con.rollback();
			} catch (SQLException e1) {
				// TODO 自動生成された catch ブロック
				e1.printStackTrace();
			}*/
			//Exceptionが出ているのでuserをnullで返す
			return false;
		}catch(ClassNotFoundException e) {
			e.printStackTrace();
			//トランザクションがある場合はこちらに書く（無ければ丸ごと書かない）
			/*try {
				con.rollback();
			} catch (SQLException e1) {
				// TODO 自動生成された catch ブロック
				e1.printStackTrace();
			}*/
			//Exceptionが出ているのでuserをnullで返す
			return false;
		}
		// データベースを切断
		if (con != null) {
			try {
				con.close();
			}
			catch (SQLException e) {
				e.printStackTrace();
				//Exceptionが出ているのでuserをnullで返す
				return false;
			}
		}
		return result;
	}



}
