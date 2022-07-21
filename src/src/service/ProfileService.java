package service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import dao.UsersDao;
import model.Users;


public class ProfileService {

	//プロフィール表示のサービス
	public Users showProfile(int userId) {
		Connection con = null;
		Users users = null;

		try {
			Class.forName("org.h2.Driver");
			con = DriverManager.getConnection("jdbc:h2:file:C:/YSL7Data/miemo", "sa", "");
			//★UserDAOをインスタンス化する、その際に引数に接続を司る上の値を渡してあげる
			UsersDao dao = new UsersDao(con);

			//★daoのメソッドを呼び出す
			 users = dao.showProfile(userId);

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
			return users;
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
			return users;
		}
		// データベースを切断
		if (con != null) {
			try {
				con.close();
			}
			catch (SQLException e) {
				e.printStackTrace();
				//Exceptionが出ているのでuserをnullで返す
				return users;
			}
		}
		return users;


	}




	//パスワード変更のサービス
	public  boolean updatePw(int userId, String password) {
		Connection con = null;
		boolean result = false;


		try {
			Class.forName("org.h2.Driver");
			con = DriverManager.getConnection("jdbc:h2:file:C:/YSL7Data/miemo", "sa", "");
			//★UserDAOをインスタンス化する、その際に引数に接続を司る上の値を渡してあげる
			UsersDao dao = new UsersDao(con);

			//★daoのメソッドを呼び出す
			 result = dao.updatePw(userId,password);

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
