package service;

import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;

import com.sun.jdi.connect.spi.Connection;

import dao.UsersDao;
import model.Users;

public class SearchEvaluationService {


	public ArrayList<Users> showEmp(){
		Connection con = null;
		ArrayList<Users> userList = null;

		try {
			//DBのDriverにパスを渡すよ
			Class.forName("org.h2.Driver");
			con = DriverManager.getConnection("jdbc:h2:file:C:/YSL7Data/miemo","sa","");
			UsersDao udao = new UsersDao(con);
			//daoのメソッド呼び出すよ。※まだエラーだよ。
			userList = udao.showEmp();

		}catch(SQLException e){
			e.printStackTrace();
			System.out.println(e.getMessage());
			//Exceptionが出ているのでuserをnullで返すよ。
			return null;

		}catch(ClassNotFoundException e) {
			e.printStackTrace();
			return null;
		}

		//DBを切断するよ
		if(con !=null) {
			try {
				con.close();
			}catch(SQLException e) {
				e.printStackTrace();
				return null;
			}
		}

		return userList;
	}
}
