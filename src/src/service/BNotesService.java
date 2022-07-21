package service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import dao.BNotesDAO;



public class BNotesService  {


	public int nRegist(int uId, int empId, String title, String content) {
		Connection con = null;
		int ans=0;
		try {
			Class.forName("org.h2.Driver");
			con = DriverManager.getConnection("jdbc:h2:file:C:/ysl7data/ysl7data", "sa", "");
			//★UserDAOをインスタンス化する、その際に引数に接続を司る上の値を渡してあげる
			BNotesDAO udao=new BNotesDAO(con);

			//★daoのsearchメソッドを呼び出す（引数に上記でもらったnameを渡す）
			ans=udao.insertNotes(uId,empId, title, content);

		}
		catch(ClassNotFoundException | SQLException e) {
			e.printStackTrace();
			return ans;
		}
		// データベースを切断
				if (con != null) {
					try {
						con.close();
					}
					catch (SQLException e) {
						e.printStackTrace();
						//Exceptionが出ているのでuserをnullで返す
						return ans;
					}
				}
				return ans;
			}
	public int nDelete(int noteId) {
		Connection con = null;
		int ans=0;
		try {
			Class.forName("org.h2.Driver");
			con = DriverManager.getConnection("jdbc:h2:file:C:/ysl7data/ysl7data", "sa", "");
			//★UserDAOをインスタンス化する、その際に引数に接続を司る上の値を渡してあげる
			BNotesDAO ndao=new BNotesDAO(con);

			//★daoのsearchメソッドを呼び出す（引数に上記でもらったnameを渡す）
			ans=ndao.deleteNotes(noteId);

		}
		catch(ClassNotFoundException | SQLException e) {
			e.printStackTrace();
			return ans;
		}
		// データベースを切断
				if (con != null) {
					try {
						con.close();
					}
					catch (SQLException e) {
						e.printStackTrace();
						//Exceptionが出ているのでuserをnullで返す
						return ans;
					}
				}
				return ans;
			}
	}

