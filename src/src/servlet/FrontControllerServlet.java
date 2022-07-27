package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import action.BListAction;
import action.EditFeelingAction;
import action.EvaluationAction;
import action.GraphFeelingAction;
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
		System.out.println("doGetはいったよ");
		// TODO Auto-generated method stub
		HttpSession session = request.getSession();

		request.setCharacterEncoding("UTF-8");
		String path=null;
		if(request.getParameter("page_id")!=null && request.getParameter("bt_name")!=null) {
			//セッションが切れていたらリダイレクト
			if (session.getAttribute("user") == null) {
				response.sendRedirect("/miemo/FrontControllerServlet");
				return;
			}


			//ページIDの取得
			String pageId =request.getParameter("page_id");
			//ボタンの名前の取得
			String button = request.getParameter("bt_name");

			//home.jspからprofile.jspへ
			if(pageId.equals("FH01") && button.equals("profile")) {
				ProfileAction action = new ProfileAction(request);
				path = action.showProfile();
			}

			//home.jspからmessage.jspへ
			if (pageId.equals("FH01") && button.equals("message")) {
				path = "WEB-INF/jsp/message.jsp";
			}

			//hpme.jspからregist_feeling.jsp
			if (pageId.equals("FH01") && button.equals("regist_feeling")) {
				path = "WEB-INF/jsp/regist_feeling.jsp";
			}

			//home.jspからhistory_feeling.jsp
			if (pageId.equals("FH01") && button.equals("history_feeling")) {
				HistoryFeelingAction action = new HistoryFeelingAction(request);
				path = action.showHistory();
			}

			//home.jspからgraph_feeling.jsp
			if (pageId.equals("FH01") && button.equals("graph_feeling")) {
				GraphFeelingAction action = new GraphFeelingAction(request);
				path = action.showGraph();
			}

			//home.jspからsearch_evaluation.jsp
			if ((pageId.equals("FH01") && button.equals("evaluation")) || (pageId.equals("FE02") && button.equals("evaluation"))) {
				SearchEvaluationAction action = new SearchEvaluationAction(request);
				path = action.showEmp();
			}

			//home.jspかlist.jsp(人事部画面へ)
			if (pageId.equals("FH01") && button.equals("hr")) {
				BListAction action = new BListAction(request);
				path = action.selectAllList();
			}

			//home.jspへ
			if (pageId.equals("FH01") && button.equals("home")) {
				path = "WEB-INF/jsp/home.jsp";
			}
		}else {
			//単にlogin画面に遷移させるだけのメソッド
			//セッションがあった場合はセッションを破棄する
			session.invalidate();
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

		//セッションが切れていたらログイン画面にフォワード
		HttpSession session = request.getSession();
//		if (session.getAttribute("user") == null) {
//			response.sendRedirect("/miemo/FrontControllerServlet");
//			return;
//		}

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

		//セッションが切れていたらリダイレクト


		//パスワード変更のdoPost
		if(pageId.equals("FP01") && button.equals("変更")) {
			if (session.getAttribute("user") == null) {
				response.sendRedirect("/miemo/FrontControllerServlet");
				return;
			}
			ProfileAction action = new ProfileAction(request);
			path = action.updatePw();
			if(path.equals("/WEB-INF/jsp/profile.jsp")) {
				path = action.showProfile();
			}
		}

		//メッセージ送信のdoPost
		if(pageId.equals("FM01") && button.equals("送信")) {
			if (session.getAttribute("user") == null) {
				response.sendRedirect("/miemo/FrontControllerServlet");
				return;
			}
			MessageAction action = new MessageAction(request);
			path = action.sendMessage();
		}

		//きもち記録のdoPost
		if(pageId.equals("FF01") && button.equals("登録")) {
			if (session.getAttribute("user") == null) {
				response.sendRedirect("/miemo/FrontControllerServlet");
				return;
			}
			RegistFeelingAction action = new RegistFeelingAction(request);
			path = action.registFeeling();
		}

		//きもち履歴からきもち編集へ
		if(pageId.equals("FF02") && button.equals("編集画面へ")) {
			if (session.getAttribute("user") == null) {
				response.sendRedirect("/miemo/FrontControllerServlet");
				return;
			}
			path = "/WEB-INF/jsp/edit_feeling.jsp";
		}

		//きもち編集のdoPost
		if(pageId.equals("FF03") && button.equals("更新")) {
			if (session.getAttribute("user") == null) {
				response.sendRedirect("/miemo/FrontControllerServlet");
				return;
			}
			EditFeelingAction action = new EditFeelingAction(request);
			path = action.editFeeling();
		}

		//評価相手検索画面から評価画面へ
		if(pageId.equals("FE01") && button.equals("評価する")) {
			if (session.getAttribute("user") == null) {
				response.sendRedirect("/miemo/FrontControllerServlet");
				return;
			}
			path = "WEB-INF/jsp/evaluation.jsp";
		}

		//評価のdoPost
		if(pageId.equals("FE02") && button.equals("登録")) {
			if (session.getAttribute("user") == null) {
				response.sendRedirect("/miemo/FrontControllerServlet");
				return;
			}
			EvaluationAction action = new EvaluationAction(request);
			path = action.registEval();

		}





		//JSPさんへ処理を依頼する
		RequestDispatcher dispatcher = request.getRequestDispatcher(path);
		dispatcher.forward(request, response);

	}

}
