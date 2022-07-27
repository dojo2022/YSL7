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
			con = DriverManager.getConnection("jdbc:h2:file:C:/ysl7data/miemo", "sa", "");
			//BNotesDAOをインスタンス化する、その際に引数に接続を司る上の値を渡してあげる
			BNotesDAO udao=new BNotesDAO(con);

			//daoのinsertNotesメソッドを呼び出す（引数に上記でもらったuId,empId,title,contentを渡す）
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
			con = DriverManager.getConnection("jdbc:h2:file:C:/ysl7data/miemo", "sa", "");
			//BNotesDAOをインスタンス化する、その際に引数に接続を司る上の値を渡してあげる
			BNotesDAO ndao=new BNotesDAO(con);

			//daoのdeleteメソッドを呼び出す（引数に上記でもらったnoteIdを渡す）
			ans=ndao.deleteNotes(noteId);

			if(ans == 0) {
				throw new SQLException("削除できませんでした");
			}



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

