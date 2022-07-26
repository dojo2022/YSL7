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
		System.out.println("getにはいったよ");
		request.setCharacterEncoding("UTF-8");
		//★ページIDの取得
				String pageId = request.getParameter("page_id");
				//★ボタンの名前の取得
				String button = request.getParameter("bt_name");
				//次に飛ぶところのURLをNULLで宣言して、処理によって値を格納する
				String url = null;
				System.out.println(pageId);
				System.out.println(button);


//		//  //フロントから管理画面を押された時
/*				if(pageId.equals("FH01") && button.equals("hr")) {
//					//★アクションをインスタンス化
					BListAction lAction = new BListAction(request);
//					//★アクションのsearchメソッドを呼び出す
				url =lAction.selectAllList();
				}
*/
		////一覧から個人ページを表示するとき
				if(pageId.equals("BL01") && button.equals("to_profile")) {
					//★アクションをインスタンス化
					BTabAction tAction = new BTabAction(request);
					//★アクションのsearchメソッドを呼び出す
					url = tAction.showMainPage();
				}

//		//個人ページの先月・次月ボタンを押したとき
//				else if(pageId.equals("BP01") && button.equals("last_month") || button.equals("next_month")) {
//					//★アクションをインスタンス化
//					BTabAction tAction = new BTabAction(request);
//					//★アクションのsearchメソッドを呼び出す
//					url = tAction.showMainPage();
//				}


		//個人ページから一覧にもどる
				else if(pageId.equals("BP01") && button.equals("back_list")) {
					HttpSession session = request.getSession();
					session.removeAttribute("empId");
					BListAction listAction=new BListAction(request);
					url = listAction.selectAllList();
				}

		//メモの新規作成画面
				else if(pageId.equals("BP01") && button.equals("to_regist_note")) {
					url = "/WEB-INF/backjsp/bRegistNote.jsp";
				}

		// 新規社員登録画面に移動する
				else if(pageId.equals("BL01") && button.equals("to_regist_user")) {
					BUserAction uAction = new BUserAction(request);
					url = uAction.getSecId();
				}


		//新規社員登録画面から一覧に戻るのは
				else if(pageId.equals("BL01") && button.equals("戻る")) {
					//★アクションをインスタンス化
					BListAction lAction= new BListAction(request);
					//タブアクションのメソッドを実行
					url = lAction.selectAllList();;
					}
		//新規メモ作成画面から個人ページに戻るのもヒストリーバック

		//個人情報編集画面から個人ページに戻る

		//社員用画面に戻る
				else if(pageId.equals("BL01") && button.equals("to_front")) {
					url = "WEB-INF/jsp/home.jsp";
					}




		//JSPさんへ処理を依頼する
		RequestDispatcher dispatcher = request.getRequestDispatcher(url);
		dispatcher.forward(request, response);


	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		request.setCharacterEncoding("UTF-8");
		//★ページIDの取得
		String pageId = request.getParameter("page_id");
		//★ボタンの名前の取得
		String button = request.getParameter("bt_name");

		System.out.println("pageId:"+pageId+"だよ");
		System.out.println("button:"+button+"だよ");
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
			url = uAction.uDelete();
		}


		//個人ページから個人情報編集画面
		if(pageId.equals("BP01") && button.equals("編集")) {
			url = "/WEB-INF/backjsp/bUUpdate.jsp";
		}


		//個人情報変更ボタン
		if(pageId.equals("BR02") && button.equals("保存")) {
			//★アクションをインスタンス化
			BUserAction uAction = new BUserAction(request);
			//★アクションのsearchメソッドを呼び出す
			url = uAction.uUpdate();
		}

		//メモの保存ボタン
		if(pageId.equals("BN01") && button.equals("保存")) {
			//★アクションをインスタンス化
			BNotesAction nAction = new BNotesAction(request);
			BTabAction tAction = new BTabAction(request);
			//★アクションのメソッドから成功したかどうかを受け取る
			String sAns =nAction.nRegist();
			//TacActionのshowMainPageを呼び出す（引数どしよ）
			if(sAns=="1") {
				url = tAction.showMainPage();
			}
			else {
				//エラーメッセージ格納してjspに戻す
				request.setAttribute("errMsg", "登録できませんでした。");
				url= "/WEB-INF/backjsp/bRegistNote.jsp";
			}
		}

		//メモの削除ボタン
		if(pageId.equals("BP01") && button.equals("削除")) {
			//★アクションをインスタンス化
			BNotesAction nAction = new BNotesAction(request);
			BTabAction tAction = new BTabAction(request);
			//★アクションのメソッドから成功したかどうかを受け取る
			int ans = nAction.nDelete();
			if(ans==1) {
				url = tAction.showMainPage();
			}else {
				//エラーメッセージ格納してjspに戻す
				request.setAttribute("errMsg", "登録できませんでした。");
				url= "/WEB-INF/backjsp/bRegistNote.jsp";
			}
		}

		//JSPさんへ処理を依頼する
		System.out.println("url:"+url+"だよ");
		RequestDispatcher dispatcher = request.getRequestDispatcher(url);
		dispatcher.forward(request, response);



	}

}
