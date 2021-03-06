package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import action.EditFeelingAction;
import action.EvaluationAction;
import action.HistoryFeelingAction;
import action.LoginAction;
import action.MessageAction;
import action.ProfileAction;
import action.RegistFeelingAction;
import action.SearchEvaluationAction;

/**
 * Servlet implementation class FrontControllerServlet
 */
@WebServlet("/FrontControllerServlet")
public class FrontControllerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");
		String path=null;
		if(request.getParameter("page_id")!=null && request.getParameter("bt_name")!=null) {
			//ページIDの取得
			String pageId =request.getParameter("page_id");
			//ボタンの名前の取得
			String button = request.getParameter("bt_name");
			if(pageId.equals("FH01") && button.equals("profile")) {//home.jspからprofile.jspへ
				ProfileAction action = new ProfileAction(request);
				path = action.showProfile();
			}
			if (pageId.equals("FH01") && button.equals("message")) {//home.jspからmessage.jspへ
				path = "WEB-INF/jsp/message.jsp";
			}
			if (pageId.equals("FH01") && button.equals("regist_feeling")) {//hpme.jspからregist_feeling.jsp
				path = "WEB-INF/jsp/regist_feeling.jsp";
			}
			if (pageId.equals("FH01") && button.equals("history_feeling")) {//home.jspからhistory_feeling.jsp
				HistoryFeelingAction action = new HistoryFeelingAction(request);
				path = action.showHistory();
			}
//			if (pageId.equals("FH01") && button.equals("graph_feeling")) {//home.jspからgraph_feeling.jsp
//				GraphFeelingAction action = new GraphFeelingAction(request);
//				path = action.showGraph();
//			}
			if ((pageId.equals("FH01") && button.equals("evaluation")) || (pageId.equals("FE02") && button.equals("evaluation"))) {//home.jspからsearch_evaluation.jsp
				SearchEvaluationAction action = new SearchEvaluationAction(request);
				path = action.showEmp();
			}
//			if (pageId.equals("FH01") && button.equals("hr")) {//home.jspかlist.jsp(人事部画面へ)
//				BListAction action = new BListAction(request);
//				path = action.selectAllList();
//			}
		}else {
			//単にlogin画面に遷移させるだけのメソッド
			path="/WEB-INF/jsp/login.jsp";
		}


		RequestDispatcher dispatcher = request.getRequestDispatcher(path);
		dispatcher.forward(request, response);

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");
		String pageId = request.getParameter("page_id");
		String button = request.getParameter("bt_name");
		//次に飛ぶところのURLをNULLで宣言して、処理によって値を格納する
		String path = null;

		//ログイン画面からホーム画面へ
		if(pageId.equals("FL01") && button.equals("ログイン")) {
			LoginAction action = new LoginAction(request);
			path = action.login();
		}
		//パスワード変更のdoPost
		if(pageId.equals("FP01") && button.equals("変更")) {
			ProfileAction action = new ProfileAction(request);
			path = action.updatePw();
		}
		//メッセージ送信のdoPost
		if(pageId.equals("FM01") && button.equals("送信")) {
			MessageAction action = new MessageAction(request);
			path = action.sendMessage();
		}
		//きもち記録のdoPost
		if(pageId.equals("FF01") && button.equals("登録")) {
			RegistFeelingAction action = new RegistFeelingAction(request);
			path = action.registFeeling();
		}
		//きもち履歴からきもち編集へ
		if(pageId.equals("FF02") && button.equals("編集画面へ")) {
			path = "/WEB-INF/jsp/edit_feeling.jsp";
		}
		//きもち編集のdoPost
		if(pageId.equals("FF03") && button.equals("更新")) {
			EditFeelingAction action = new EditFeelingAction(request);
			path = action.editFeeling();
		}
		//評価相手検索画面から評価画面へ
		if(pageId.equals("FE01") && button.equals("評価する")) {
			path = "WEB-INF/jsp/evaluation.jsp";
		}
		//評価のdoPost
		if(pageId.equals("FE02") && button.equals("登録")) {
			EvaluationAction action = new EvaluationAction(request);
			path = action.registEval();
		}




		//JSPさんへ処理を依頼する
		RequestDispatcher dispatcher = request.getRequestDispatcher(path);
		dispatcher.forward(request, response);

	}

}
