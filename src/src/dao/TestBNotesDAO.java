package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;

import model.BNotesBeans;

public class TestBNotesDAO {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		int empId = 2;
		Class.forName("org.h2.Driver");
		Connection con = DriverManager.getConnection("jdbc:h2:file:C:/ysl7data/miemo", "sa", "");

		BNotesDAO bnDao = new BNotesDAO(con);
		ArrayList<BNotesBeans> noteList = bnDao.selectNotes(empId);
		/*		int ans = bnDao.insertNotes(empId, 1, "テスト", "テスト");
				System.out.println(ans);
				int result = bnDao.insertNotes(1, empId, "テスト", "テスト");
				System.out.println(result);
		*/		for(BNotesBeans bn : noteList) {
			System.out.println(bn.getName());
			System.out.println(bn.getDate());
			System.out.println(bn.getTitle());
			System.out.println(bn.getContent());

		}



	}

}
