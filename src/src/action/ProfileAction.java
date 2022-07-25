package action;

import java.io.UnsupportedEncodingException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import model.Users;
import service.ProfileService;

public class ProfileAction {

	HttpServletRequest request=null;

	//serviceの戻り値を呼んでくる
	public ProfileAction(HttpServletRequest request) {
		this.request=request;
	}

	public String showProfile() throws UnsupportedEncodingException  {
		request.setCharacterEncoding("UTF-8");


		HttpSession session = request.getSession();
		Users user = (Users)session.getAttribute("user");
		int userId = user.getUserId();

		ProfileService service = new ProfileService();

		Users users = service.showProfile(userId);

		//戻ってきた値にデータが入っていなければ(nullであれば)
		if(users==null) {
			request.setAttribute("errMsg", "データを取得できませんでした");
			return "/WEB-INF/jsp/home.jsp";
		//ちゃんと入っていたら
		}else {
			//戻ってきたuser型のデータをsessionに格納し、servletに次のＪＳＰのパスを送る
			request.setAttribute("users", users);
			return "/WEB-INF/jsp/profile.jsp";
		}

	}



	//ここからパスワード変更のAction処理
	public String updatePw() throws UnsupportedEncodingException  {
		request.setCharacterEncoding("UTF-8");


		HttpSession session = request.getSession();
		Users user = (Users)session.getAttribute("user");
		int userId = user.getUserId();
		String password = request.getParameter("newpassbox");
		String password2 = request.getParameter("newpass2box");
		boolean result = false;


		//入力値のチェック（空文字チェック）
		//空白を入力されたら空白はすべて取り除く処理id.strip()という決まったメソッド
		//空白で文字も入っていない、どちらか片方でもその状態だったらこの処理を返してねのif文
		if(password.strip().length()==0|| password2.strip().length()==0) {
			//errMsg",に"※ID/PWの入力は必須ですを入れて返す処理
			request.setAttribute("errMsg", "※パスワードの入力は必須です");
			return "/WEB-INF/jsp/profile.jsp";
		}

	//新しいパスワード入力と新しいパスワード確認が一致しているかをかく
		if(password.equals(password2)) {

			ProfileService service = new ProfileService();

			result = service.updatePw(userId,password);

		}else {
			request.setAttribute("errMsg", "確認用とパスワードが異なります");
			return "/WEB-INF/jsp/home.jsp";
		}

		if(result==false) {
			request.setAttribute("errMsg", "パスワードの更新に失敗しました");
			return "/WEB-INF/jsp/profile.jsp";
		}else {
			//servletに次のＪＳＰのパスを送る
			request.setAttribute("errMsg", "パスワードを更新しました");
			return "/WEB-INF/jsp/home.jsp";
		}

	}


}
