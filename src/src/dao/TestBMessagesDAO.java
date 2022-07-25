package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;

import model.BMessagesBeans;

public class TestBMessagesDAO {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		int empId = 2;
		Class.forName("org.h2.Driver");
		Connection con = DriverManager.getConnection("jdbc:h2:file:C:/ysl7data/miemo", "sa", "");

		BMessagesDAO bmDao = new BMessagesDAO(con);
		ArrayList<BMessagesBeans> messageList = bmDao.selectMessages(empId);
		System.out.println("------------test1----------------");
		for(BMessagesBeans ms : messageList) {
			System.out.println(ms.getDate());
			System.out.println(ms.getContent());
		}

	}

}
