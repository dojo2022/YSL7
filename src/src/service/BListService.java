package service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;

import dao.BUserDAO;
import model.BProfileAllBeans;

public class BListService  {
	public ArrayList<BProfileAllBeans> selectAllList() {
		Connection con = null;
		ArrayList<BProfileAllBeans> listAll = new ArrayList<>();
		try {
			Class.forName("org.h2.Driver");
			con = DriverManager.getConnection("jdbc:h2:file:C:/ysl7data/miemo", "sa", "");
			//BUserDAOをインスタンス化する、その際に引数に接続を司る上の値を渡してあげる
			BUserDAO buDao=new BUserDAO(con);

			//BUserDAOのselectAllListメソッドを呼び出す（引数なし）
			listAll=buDao.selectAllList();
		}catch(ClassNotFoundException | SQLException e) {
			e.printStackTrace();
			return listAll;
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
		return listAll;
	}
}
