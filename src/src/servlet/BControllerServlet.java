package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import action.BNotesAction;
import action.BTabAction;
import action.BUserAction;

/**
 * Servlet implementation class BControllerServlet
 */
@WebServlet("/BControllerServlet")
public class BControllerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		//★ページIDの取得
				String pageId = request.getParameter("page_id");
				//★ボタンの名前の取得
				String button = request.getParameter("bt_name");
				//次に飛ぶところのURLをNULLで宣言して、処理によって値を格納する
				String url = null;


//		//  //フロントから管理画面を押された時
//				if(pageId.equals("FH01") && button.equals("hr")) {
//					//★アクションをインスタンス化
//					BListAction lAction = new BListAction()(request);
//					//★アクションのsearchメソッドを呼び出す
//					url =lAction.selectAllList();
//				}

		////一覧から個人ページを表示するとき
				if(pageId.equals("BL01") && button.equals("to_profile")) {
					//★アクションをインスタンス化
					BTabAction tAction = new BTabAction(request);
					//★アクションのsearchメソッドを呼び出す
					url = tAction.showMainPage();
				}

		//個人ページから一覧にもどる
				if(pageId.equals("BP01") && button.equals("back_list")) {
					url = "WebContent/WEB-INF/backjsp/listjsp";
				}

		//メモの新規作成画面
				if(pageId.equals("BN01") && button.equals("to_regist_note")) {
					url = "WebContent/WEB-INF/backjsp/registNote.jsp";
				}

		// 新規社員登録画面に移動する
				if(pageId.equals("BL01") && button.equals("to_regist_user")) {
					url = "WebContent/WEB-INF/backjsp/uRegist.jsp";
				}


		//新規社員登録画面から一覧に戻るのはヒストリーバック
		//新規メモ作成画面から個人ページに戻るのもヒストリーバック

		//社員用画面に戻る
				if(pageId.equals("BL01") && button.equals("to_front")) {
					url = "WEB-INF/jsp/home.jsp";
					}




		//JSPさんへ処理を依頼する
		RequestDispatcher dispatcher = request.getRequestDispatcher(url);
		dispatcher.forward(request, response);


	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		//★ページIDの取得
		String pageId = request.getParameter("page_id");
		//★ボタンの名前の取得
		String button = request.getParameter("bt_name");
		//次に飛ぶところのURLをNULLで宣言して、処理によって値を格納する
		String url = null;


		//新規社員登録の登録ボタン
		if(pageId.equals("BR01") && button.equals("登録")) {
			//★アクションをインスタンス化
			BUserAction uAction = new BUserAction(request);
			//★アクションのsearchメソッドを呼び出す
			url = uAction.uRegist();
		}

		//退職ボタン
		if(pageId.equals("BR02") && button.equals("退職")) {
			//★アクションをインスタンス化
			BUserAction uAction = new BUserAction(request);
			//★アクションのsearchメソッドを呼び出す
			url = Action.udelete();
		}


		//個人ページから個人情報編集画面
		if(pageId.equals("BP01") && button.equals("編集")) {
			url = "WebContent/WEB-INF/backjsp/uRegist.jsp";
		}


		//個人情報変更ボタン
		if(pageId.equals("BR02") && button.equals("保存")) {
			//★アクションをインスタンス化
			BUserAction uAction = new BUserAction(request);
			//★アクションのsearchメソッドを呼び出す
			url = Action.uUpdate();
		}

		//メモの保存ボタン
		if(pageId.equals("BN01") && button.equals("保存")) {
			//★アクションをインスタンス化
			BNotesAction bAction = new BNoteTAction(request);
			//★アクションのsearchメソッドを呼び出す
			url = bAction.nRegist();
		}

		//メモの削除ボタン
		if(pageId.equals("BP01") && button.equals("削除")) {
			//★アクションをインスタンス化
			BNotesAction nAction = new BNotesAction(request);
			//★アクションのsearchメソッドを呼び出す
			url = nAction.nDelete();
		}

		//JSPさんへ処理を依頼する
		RequestDispatcher dispatcher = request.getRequestDispatcher(url);
		dispatcher.forward(request, response);



	}

}
