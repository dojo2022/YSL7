package service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;

import dao.StampsDao;
import model.Stamps;

public class HistoryFeelingService {


	public ArrayList<Stamps> showHistory (int userId) {
		Connection con = null;
		ArrayList<Stamps> showHistory = null;

		try {
			Class.forName("org.h2.Driver");
			con = DriverManager.getConnection("jdbc:h2:file:C:/ysl7data/miemo", "sa", "");

			//2．StampsDaoをnewして、showHistoryメソッドを呼び出し、DBからデータを取得する。
			StampsDao sd = new StampsDao(con);

			showHistory = sd.showHistory(userId);
		}
		catch(SQLException e) {
			e.printStackTrace();
			System.out.println(e.getMessage());
			//トランザクションがある場合はこちらに書く（無ければ丸ごと書かない）
			/*try {
				con.rollback();
			} catch (SQLException e1) {
				// TODO 自動生成された catch ブロック
				e1.printStackTrace();
			}*/
			//Exceptionが出ているのでuserをnullで返す
			return null;
		}catch(ClassNotFoundException e) {
			e.printStackTrace();
			//トランザクションがある場合はこちらに書く（無ければ丸ごと書かない）
			/*try {
				con.rollback();
			} catch (SQLException e1) {
				// TODO 自動生成された catch ブロック
				e1.printStackTrace();
			}*/
			//Exceptionが出ているのでuserをnullで返す
			return null;
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
		return showHistory;
	}







}
