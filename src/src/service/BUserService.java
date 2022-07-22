package service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import dao.BUPUSDAO;
import dao.BUserDAO;

public class BUserService {


	///intで引数として渡すものは、integer.paeseIntする！！

	//uRegist
	public int uRegist(String number, String name,String year, String gender, String secId, String post1, String post2, String post3) {
		Connection con = null;
		int num1;
		int num2;
		int num3;
		int empId;
		int result=0;

		try {
			Class.forName("org.h2.Driver");
			con = DriverManager.getConnection("jdbc:h2:file:C:/ysl7data/miemo", "sa", "");
			//BNotesDAOをインスタンス化する、その際に引数に接続を司る上の値を渡してあげる
			BUserDAO buDao=new BUserDAO(con);
			BUPUSDAO bupusDao = new BUPUSDAO(con);

			//daoのdeleteUserメソッドを呼び出す（引数に上記でもらったempIdを渡す）
			int ans = buDao.registUser(String number, String name,String year, int gender);

			if(ans != 0) {
				empId = ans;
				num1 = 1;
			}

			//post3が空白じゃなかったら、registPost3
			//post2が空白じゃなかったら、registPost2
			//上記の二つ以外なら、registPost1
			if(post3.length != 0 ) {
				num2 = bupusDao.insertPost3();
			} else if(post2.length != 0 ) {
				num2 = bupusDao.insertPost2();
			} else {
				num2 = bupusDao.insertPost1();
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
						//Exceptionが出ているのでansを0のまま返す
						return ans;
					}
				}
				return ans;
			}

	//uDelete
	public int uDelete(int empId) {
		Connection con = null;
		int ans=0;
		try {
			Class.forName("org.h2.Driver");
			con = DriverManager.getConnection("jdbc:h2:file:C:/ysl7data/miemo", "sa", "");
			//BNotesDAOをインスタンス化する、その際に引数に接続を司る上の値を渡してあげる
			BUserDAO buDao=new BUserDAO(con);

			//daoのdeleteUserメソッドを呼び出す（引数に上記でもらったempIdを渡す）
			ans=buDao.deleteUser(empId);

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
						//Exceptionが出ているのでansを0のまま返す
						return ans;
					}
				}
				return ans;
			}
	}

