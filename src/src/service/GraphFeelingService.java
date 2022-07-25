package service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;

import dao.BStampsDAO;
import model.BStampsBeans;

public class GraphFeelingService {
	public ArrayList<Object> showGraph (int userId){
		Connection con = null;
		ArrayList<Object> stampGraph = new ArrayList<>();
		try {
			Class.forName("org.h2.Driver");
			con = DriverManager.getConnection("jdbc:h2:file:C:/ysl7data/miemo", "sa", "");
			//BStampsDAOを実体化する
			BStampsDAO bsDao = new BStampsDAO(con);
			//BStampsDAOのcountAllStampsメソッドを呼び出す
			BStampsBeans sCount = bsDao.countAllStamps(userId);
			//BStampsDAOのselectStamp1~5メソッドを呼び出す
			ArrayList<BStampsBeans> stamp1 = bsDao.selectStamp1(userId);
			ArrayList<BStampsBeans> stamp2 = bsDao.selectStamp2(userId);
			ArrayList<BStampsBeans> stamp3 = bsDao.selectStamp3(userId);
			ArrayList<BStampsBeans> stamp4 = bsDao.selectStamp4(userId);
			ArrayList<BStampsBeans> stamp5 = bsDao.selectStamp5(userId);

			//sCount~stamp5までを一個のArrayListにまとめる
			stampGraph.add(sCount);
			stampGraph.add(stamp1);
			stampGraph.add(stamp2);
			stampGraph.add(stamp3);
			stampGraph.add(stamp4);
			stampGraph.add(stamp5);
		}catch(ClassNotFoundException | SQLException e) {
			e.printStackTrace();
			return stampGraph;
		}
		if(con != null) {
			try {
				con.close();
			}
			catch(SQLException e) {
				e.printStackTrace();
				return stampGraph;
			}
		}

		return stampGraph;
	}

}
