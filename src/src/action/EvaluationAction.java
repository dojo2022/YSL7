package action;

import java.io.UnsupportedEncodingException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import model.Users;
import service.EvaluationService;

public class EvaluationAction {
	HttpServletRequest request = null;

	//コンストラクタ
	public EvaluationAction(HttpServletRequest request) {
		this.request = request;
	}

	//評価のメソッド
	public String registEval() throws UnsupportedEncodingException {
		request.setCharacterEncoding("UTF-8");//日本語だよ。
		HttpSession session = request.getSession();
		int toUserId = Integer.parseInt(request.getParameter("evaluate_name"));
		Users user = (Users) session.getAttribute("user");
		int fromUserId = user.getUserId();
		int evaluation1 = Integer.parseInt(request.getParameter("evaluate1"));
		int evaluation2 = Integer.parseInt(request.getParameter("evaluate2"));
		int evaluation3 = Integer.parseInt(request.getParameter("evaluate3"));
		int evaluation4 = Integer.parseInt(request.getParameter("evaluate4"));
		int evaluation5 = Integer.parseInt(request.getParameter("evaluate5"));

		//EvaluationServiceをインスタンス化するよ。
		EvaluationService service = new EvaluationService();

		//EvaluationServiceのメソッドを実行するよ。
		boolean ans = service.registEval(toUserId, fromUserId, evaluation1,
				evaluation2, evaluation3, evaluation4, evaluation5);

		//ansがfalseだったらevaluation.jspに戻るよ。
		if (ans = false) {
			request.setAttribute("errMsg", "失敗");
			return "/WEB-INF/jsp/evaluation.jsp";
			//ちゃんと入っていたらservletにhome.jspのパスを送るよ
		} else {
			session = request.getSession();
			session.setAttribute("result", ans);
			return "/WEB-INF/jsp/home.jsp";
		}
	}
}
