package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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


		//page_id.equals("FH01") && button.equals("hr")  //フロントから管理画面を押された時

		//page_id.equals("BL01") && button.equals("to_profile")//一覧から個人ページを表示するとき

		//page_id.equals("BP01") && button.equals("back_list")個人ページから一覧にもどる

		//page_id.equals("BN01") && button.equals("to_regist_note")メモの新規作成

		//page_id.equals("BN01") && button.equals("back_memo")メモ新規画面から個人ページに戻る

		//page_id.equals("BL01") && button.equals("to_regist_user") 新規社員登録画面に移動する

		//page_id.equals("BR01") && button.equals("back")新規社員登録画面から一覧に戻る

		//個人情報編集画面から個人ページに戻る

		//page_id.equals("BL01") && button.equals("to_front")社員用画面に戻る


	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		//新規社員登録の登録ボタン

		//退職ボタン

		//個人情報変更ボタン

		//メモの保存ボタン

		//メモの削除ボタン



	}

}
