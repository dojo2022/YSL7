package service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;

import dao.BUPUSDAO;
import dao.BUserDAO;
import model.RoleBeans;

public class BUserService {



	public ArrayList<ArrayList<RoleBeans>> getRole(){
		Connection con = null;

		ArrayList<ArrayList<RoleBeans>> allRole = new ArrayList<>();
		try {
			Class.forName("org.h2.Driver");
			con = DriverManager.getConnection("jdbc:h2:file:C:/ysl7data/miemo", "sa", "");
			//BUserDAOを実体化する
			BUserDAO buDao = new BUserDAO(con);
			//BUserDAOのselectProfileメソッドを呼び出す
			allRole.add(buDao.getRole1());
			allRole.add(buDao.getRole2());
			allRole.add(buDao.getRole3());

		}catch(ClassNotFoundException | SQLException e) {
			e.printStackTrace();
			return allRole;
		}
		if(con != null) {
			try {
				con.close();
			}
			catch(SQLException e) {
				e.printStackTrace();
				return allRole;
			}
		}

		return allRole;

	}
	///intで引数として渡すものは、integer.paeseIntする！！

	//uRegist
	public int uRegist(String number, String name,String year, String gender, int intSecId, String post1, String post2, String post3) {
		Connection con = null;
		int num1 = 0;
		int num2 = 0;
		int num3 = 0;
		int empId = 0;
		int result = 0;

		try {
			Class.forName("org.h2.Driver");
			con = DriverManager.getConnection("jdbc:h2:file:C:/ysl7data/miemo", "sa", "");

			//自動的にinsertを実行してくれるのを切る
			con.setAutoCommit(false);
			//BNotesDAOをインスタンス化する、その際に引数に接続を司る上の値を渡してあげる
			BUserDAO buDao=new BUserDAO(con);
			BUPUSDAO bupusDao = new BUPUSDAO(con);

			//----Userに関するinsert-------------------
			//daoのdeleteUserメソッドを呼び出す（引数に上記でもらったempIdを渡す）
			int intgender = Integer.parseInt(gender);
			System.out.println(number);
			System.out.println(name);
			System.out.println(year);
			System.out.println(intgender);
			int ans = buDao.registUser(number,name,year,intgender);
			 //ansが0だった場合、insertできていない
			if(ans == 1) {
				empId = buDao.selectEmpId();
				System.out.println("empId" + empId);
				num1 = 1;
			}

			//----Postのinsert-------------------
			int intPost1 = Integer.parseInt(post1);
			int intPost2 = 0;
			int intPost3 = 0;
			if(!post2.equals("")) {
				intPost2 = Integer.parseInt(post2);
			}
			if(!post3.equals("")) {
				intPost3 = Integer.parseInt(post3);
	 		}
			//post3が空白じゃなかったら、registPost3
			//post2が空白じゃなかったら、registPost2
			//上記の二つ以外なら、registPost1
			if(post3.strip().length() != 0 ) {
				bupusDao.insertPost1(empId, intPost1);
				bupusDao.insertPost1(empId, intPost2);
				bupusDao.insertPost1(empId, intPost3);
				num2 =1;
			} else if(post2.strip().length() != 0 ) {
				bupusDao.insertPost1(empId, intPost1);
				bupusDao.insertPost2(empId, intPost2);
				num2 =1;
			} else {
				bupusDao.insertPost1(empId, intPost1);
				num2 =1;
			}

			//----Sectionのinsert-------------------
			num3 = bupusDao.insertSection(empId, intSecId);

			System.out.println("num1 = " + num1);
			System.out.println("num2 = " + num2);
			System.out.println("num3 = " + num3);

			int sum = num1 + num2 + num3;
			if(sum != 3) {
				throw new SQLException();
			} else {
				result = 1;
			}

			con.commit();


		}

		catch(ClassNotFoundException | SQLException e) {
			e.printStackTrace();
				try {
					con.rollback();
				} catch (SQLException e1) {
					// TODO 自動生成された catch ブロック
					e1.printStackTrace();
				}
			result = 0;
			return result;
		}
		// データベースを切断
				if (con != null) {
					try {
						con.close();
					}
					catch (SQLException e) {
						e.printStackTrace();
						//Exceptionが出ているのでansを0のまま返す
						result = 0;
						return result;
					}
				}
				return result;
			}



	//uUpdate
	public int uUpdate(String empId, String number, String name,String year, String gender, int intSecId, String post1, String post2, String post3) {
		Connection con = null;
		int num1 = 0;
		int num2 = 0;
		int num3 = 0;
		int result = 0;

		try {
			Class.forName("org.h2.Driver");
			con = DriverManager.getConnection("jdbc:h2:file:C:/ysl7data/miemo", "sa", "");

			//自動的にinsertを実行してくれるのを切る
			con.setAutoCommit(false);
			//BNotesDAOをインスタンス化する、その際に引数に接続を司る上の値を渡してあげる
			BUserDAO buDao=new BUserDAO(con);
			BUPUSDAO bupusDao = new BUPUSDAO(con);

			//----Userに関するinsert-------------------
			//daoのdeleteUserメソッドを呼び出す（引数に上記でもらったempIdを渡す）
			int intgender = Integer.parseInt(gender);
			int intEmpId = Integer.parseInt(empId);
			System.out.println(number);
			System.out.println(name);
			System.out.println(year);
			System.out.println(intgender);
			int ans = buDao.updateUser(intEmpId, number,name,year,intgender);
			 //ansが0だった場合、Updateできていない
			if(ans == 1) {
				num1 = 1;
			}

			//----Postのinsert-------------------
			int intPost1 = Integer.parseInt(post1);
			int intPost2 = 0;
			int intPost3 = 0;
			if(!post2.equals("")) {
				intPost2 = Integer.parseInt(post2);
			}
			if(!post3.equals("")) {
				intPost3 = Integer.parseInt(post3);
	 		}
			//post3が空白じゃなかったら、registPost3
			//post2が空白じゃなかったら、registPost2
			//上記の二つ以外なら、registPost1
			if(post3.strip().length() != 0 ) {
				int ans1 = bupusDao.updatePost1(intEmpId, intPost1);
				int ans2 = bupusDao.updatePost2(intEmpId, intPost2);
				int ans3 = bupusDao.updatePost3(intEmpId, intPost3);
				int sum = ans1 + ans2 + ans3;
				if(sum == 3) {
					num2 =1;
				}else {
					num2 =0;
				}
			} else if(post2.strip().length() != 0 ) {
				int ans1 = bupusDao.updatePost1(intEmpId, intPost1);
				int ans2 = bupusDao.updatePost2(intEmpId, intPost2);
				int sum = ans1 + ans2;
				if(sum == 2) {
				 num2 =1;
				} else {
					num2 =0;
				}
			} else {
				int ans1 = bupusDao.updatePost1(intEmpId, intPost1);
				if(ans1 == 1) {
					num2 =1;
				} else {
					num2 = 0;
				}
			}

			//----Sectionのinsert-------------------
			num3 = bupusDao.insertSection(intEmpId, intSecId);

			System.out.println("num1" + num1);
			System.out.println("num2" + num2);
			System.out.println("num3" + num3);
			int sum = num1 + num2 + num3;
			if(sum != 3) {
				throw new SQLException();
			} else {
				result = 1;
			}

			con.commit();
		}

		catch(ClassNotFoundException | SQLException e) {
			e.printStackTrace();
				try {
					con.rollback();
				} catch (SQLException e1) {
					// TODO 自動生成された catch ブロック
					e1.printStackTrace();
				}
			result = 0;
			return result;
		}
		// データベースを切断
				if (con != null) {
					try {
						con.close();
					}
					catch (SQLException e) {
						e.printStackTrace();
						//Exceptionが出ているのでansを0のまま返す
						result = 0;
						return result;
					}
				}
				return result;
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

