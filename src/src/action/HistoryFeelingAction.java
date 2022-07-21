package action;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import model.Stamps;
import model.Users;
import service.HistoryFeelingService;

public class HistoryFeelingAction {
	HttpServletRequest request=null;

	public HistoryFeelingAction(HttpServletRequest request) {
		this.request=request;
	}

	public String showHistory() throws UnsupportedEncodingException  {
		request.setCharacterEncoding("UTF-8");

		//1．sessionスコープからuserIdを取得する
		HttpSession session = request.getSession();//セッションにアクセスする用意をする
		Users u = (Users)session.getAttribute("users");//セッションからusers(userId, name, numberの入っているビーンズ)を取得
		int userId =u.getUserId();//usersの中からuserIdだけを取り出す

		//2．HistoryFeelingServiceをnewする
		HistoryFeelingService service = new HistoryFeelingService();

		//3．HistoryFeelingServiceのshowHistoryを引数にuserIdを渡して呼び出す
		ArrayList<Stamps> historyList = service.showHistory(userId);

		//4 ．返ってきたデータをリクエストスコープに格納する 記録したきもち・カテゴリー・メッセージを格納
		request.setAttribute("historyList",historyList );

		//5．パスを作成して、サーブレットに返す。（WEB-INF/jsp/history_feeling.jsp）
		if(historyList.size() == 0 ) {
			return "WEB-INF/jsp/home.jsp";
		} else {
			return "WEB-INF/jsp/history_feeling.jsp";
		}
	}
}
