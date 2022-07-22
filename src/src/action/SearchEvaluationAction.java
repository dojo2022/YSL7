package action;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import model.Users;
import service.SearchEvaluationService;

public class SearchEvaluationAction {
	HttpServletRequest request = null;


	//コンストラクタ
	public SearchEvaluationAction(HttpServletRequest request){ //コンストラクタ
		this.request = request;
	}

	//表示するメソッド
	public String showEmp()throws UnsupportedEncodingException {
		request.setCharacterEncoding("UTF-8");//日本語だよ


		//何も入力されていなかったら全件検索にするので入力チェックは行わず、
		//serviceをインスタンス化するよ。
		SearchEvaluationService service= new SearchEvaluationService();

		//ServiceのSearchメソッドを実行するよ。
		//service作ってないから現状だとエラー出るよ。
		ArrayList<Users> userList = service.showEmp();

		//userListの中身がnullだったらsearch_evaluation.jspに戻るよ。
		if(userList.size() ==0) {
			request.setAttribute("errMsg", "検索したデータはありません");
			return "/WEB-INF/jsp/search_evaluation.jsp";
		//ちゃんと入っていたらservletにsearch_evaluation.jspのパスを送るよ。
		}else{
			HttpSession session = request.getSession();
			request.setAttribute("list", userList);
			return "/WEB-INF/jsp/search_evaluation.jsp";
		}

	}
}
