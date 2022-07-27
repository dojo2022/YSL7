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
		Users user = (Users) session.getAttribute("user");
		int fromUserId = user.getUserId();

		//評価相手のUserIDの取得
		int toUserId;
		String sToUserId = request.getParameter("user_id");
		toUserId = Integer.parseInt(sToUserId);

//		if (sToUserId != null) {
//			toUserId = Integer.parseInt(sToUserId);
//		}else {
//			String sToUserId2 = request.getParameter("evaluate_name2");
//			toUserId = Integer.parseInt(sToUserId2);
//		}



		//評価の値を取得します
		int evaluation1 = 0;
		int evaluation2 = 0;
		int evaluation3 = 0;
		int evaluation4 = 0;
		int evaluation5 = 0;


		String sEvaluation1 = request.getParameter("evaluate1");
		String sEvaluation2 = request.getParameter("evaluate2");
		String sEvaluation3 = request.getParameter("evaluate3");
		String sEvaluation4 = request.getParameter("evaluate4");
		String sEvaluation5 = request.getParameter("evaluate5");

		if(sEvaluation1 != null && sEvaluation2 != null && sEvaluation3 != null && sEvaluation4 != null && sEvaluation5 != null) {
			evaluation1 = Integer.parseInt(sEvaluation1);
			evaluation2 = Integer.parseInt(sEvaluation2);
			evaluation3 = Integer.parseInt(sEvaluation3);
			evaluation4 = Integer.parseInt(sEvaluation4);
			evaluation5 = Integer.parseInt(sEvaluation5);


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
				request.setAttribute("errMsg", "評価を登録しました");
				return "/WEB-INF/jsp/home.jsp";
			}

		}else {
			request.setAttribute("errMsg", "※評価項目はすべて登録してください");
//			String name = (String)request.getAttribute("param.evaluate_name");
//			Users u = new Users();
//			u.setUserId(toUserId);
//			u.setName(name);
//			request.setAttribute("u", u );
			return "/WEB-INF/jsp/evaluation.jsp";
		}
	}
}
