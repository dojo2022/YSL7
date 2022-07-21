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

		//2．LoginServiceをnewする。
		LoginService service = new LoginService();

		//3．LoginServiceの中のloginメソッドを引数numberとpasswordを渡して呼び出す。
		Users user = service.login(number, password);

		//4．戻り値がnullじゃなかったら、sessionスコープに戻り値の値を格納する。
		if (user == null) {
			//5. home.jspにフォワードするpassをサーブレットに返す。
			return "WEB-INF/jsp/login.jsp";
		}else {
			HttpSession session = request.getSession();
			session.setAttribute("Users", user);
			//5. home.jspにフォワードするpassをサーブレットに返す。
			return "/WEB-INF/jsp/home.jsp";
		}


	}

}
