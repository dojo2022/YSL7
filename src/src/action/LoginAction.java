package action;

import java.io.UnsupportedEncodingException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import model.Users;
import service.LoginService;

public class LoginAction {
	HttpServletRequest request=null;

	public LoginAction(HttpServletRequest request) {
		this.request=request;
	}

	public String login() throws UnsupportedEncodingException  {
		request.setCharacterEncoding("UTF-8");

		//1.numberとpasswordをgetparameterで取得
		String number = request.getParameter("number");
		String password = request.getParameter("password");



		//入力値のチェック（空文字チェック）
		//空白を入力されたら空白はすべて取り除く処理id.strip()という決まったメソッド
		//空白で文字も入っていない、どちらか片方でもその状態だったらこの処理を返してねのif文
		if(number.strip().length()==0|| password.strip().length()==0) {
			//errMsg",に"※ID/PWの入力は必須ですを入れて返す処理
			request.setAttribute("errMsg", "※社員番号とパスワードの入力は必須です");
			return "/WEB-INF/jsp/login.jsp";
		}


		//2．LoginServiceをnewする。
		LoginService service = new LoginService();

		//3．LoginServiceの中のloginメソッドを引数numberとpasswordを渡して呼び出す。
		Users user = service.login(number, password);

		//4．戻り値がnullじゃなかったら、sessionスコープに戻り値の値を格納する。
		if (user == null) {
			//5. home.jspにフォワードするpassをサーブレットに返す。
			request.setAttribute("errMsg", "※社員番号とパスワードの入力は必須です");
			System.out.println("エラーに入ったよ");
			return "WEB-INF/jsp/login.jsp";
		}else {
			HttpSession session = request.getSession();
			session.setAttribute("user", user);
			//5. home.jspにフォワードするpassをサーブレットに返す。
			return "/WEB-INF/jsp/home.jsp";
		}


	}

}
