package service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import dao.UsersDao;
import model.Users;

public class LoginService {

	public Users login(String number,String password) {
		Connection con = null;
		Users user = null;

		try {
			Class.forName ("org.h2.Driver");
			con = DriverManager.getConnection ("jdbc:h2:file:C:/ysl7data/miemo", "sa", "");
			// UsersDaoをインスタンス化
			UsersDao ud = new UsersDao(con);

			//1.引数で渡されたnumberとpwをDaoに渡して、loginメソッドを呼び出す。
			user  = ud.login(number, password);

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
			return null;

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
			return null;
		}
		// データベースを切断
		if (con != null) {
			try {
				con.close();
			}
			catch (SQLException e) {
				e.printStackTrace();
				//Exceptionが出ているのでuserをnullで返す
				return null;
			}
		}

			return user;
		}

}
