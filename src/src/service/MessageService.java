package service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import dao.MessagesDao;

public class MessageService {

	public boolean sendMessage(int userId, String message) {
		Connection con = null;
		boolean result = false;


		try {
			Class.forName("org.h2.Driver");
			con = DriverManager.getConnection("jdbc:h2:file:C:/YSL7Data/miemo", "sa", "");
			//★UserDAOをインスタンス化する、その際に引数に接続を司る上の値を渡してあげる
			MessagesDao dao = new MessagesDao(con);

			//★daoのメソッドを呼び出す
			 result = dao.sendMessage(userId, message);

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
