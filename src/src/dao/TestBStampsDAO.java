package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;

import model.BStampsBeans;

public class TestBStampsDAO {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		int empId = 2;
		Class.forName("org.h2.Driver");
		Connection con = DriverManager.getConnection("jdbc:h2:file:C:/ysl7data/miemo", "sa", "");

		BStampsDAO bsDao = new BStampsDAO(con);
		BStampsBeans sCount = bsDao.countAllStamps(empId);
		System.out.println("------------test1----------------");
		System.out.println(sCount.getCountS1());
		System.out.println(sCount.getCountS2());
		System.out.println(sCount.getCountS3());
		System.out.println(sCount.getCountS4());
		System.out.println(sCount.getCountS5());

		System.out.println("------------test2----------------");

		ArrayList<BStampsBeans> stamp2 = bsDao.selectStamp2(empId);
		BStampsBeans s1 = stamp2.get(0);
		System.out.println(s1.getCategoryId());
		System.out.println(s1.getCategory());

		System.out.println("------------test3----------------");

		ArrayList<BStampsBeans> allStamps = bsDao.selectAllStamps(empId);
		for(BStampsBeans bs: allStamps) {
			System.out.println(bs.getDate());
			System.out.println(bs.getStamp1());
			System.out.println(bs.getStamp2());
			System.out.println(bs.getStamp3());
			System.out.println(bs.getStamp4());
			System.out.println(bs.getStamp5());
			System.out.println(bs.getCategory());
		}
	}

}
