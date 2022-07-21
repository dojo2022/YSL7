package service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;

import dao.BNotesDAO;
import model.BNotesBeans;

public class BTabService {




	//selectNotesメソッドです（メモ系）
	public ArrayList<BNotesBeans> selectNotes(int empId){
		Connection con = null;
		ArrayList<BNotesBeans> notesList= new ArrayList<>();
		try {
			Class.forName("org.h2.Driver");
			con = DriverManager.getConnection("jdbc:h2:file:C:/ysl7data/miemo", "sa", "");
			//BUserDAOをインスタンス化する、その際に引数に接続を司る上の値を渡してあげる
			BNotesDAO bnDao=new BNotesDAO(con);

			//BUserDAOのselectAllListメソッドを呼び出す（引数なし）
			notesList=bnDao.selectNotes(empId);
		}catch(ClassNotFoundException | SQLException e) {
			e.printStackTrace();
			return notesList;
		}
		// データベースを切断
		if (con != null) {
			try {
				con.close();
			}
			catch (SQLException e) {
				e.printStackTrace();
				//Exceptionが出ているのでnullで返す
				return null;
			}
		}
		return notesList;
	}

}

