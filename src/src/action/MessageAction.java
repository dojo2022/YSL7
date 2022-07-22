package action;

import java.io.UnsupportedEncodingException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import model.Users;
import service.MessageService;

public class MessageAction {
	HttpServletRequest request=null;

	//serviceの戻り値を呼んでくる
	public MessageAction(HttpServletRequest request) {
		this.request=request;
	}

	public String sendMessage() throws UnsupportedEncodingException {
		request.setCharacterEncoding("UTF-8");


		HttpSession session = request.getSession();
		Users user = (Users)session.getAttribute("user");
		int userId = user.getUserId();

		String message = request.getParameter("message");

		MessageService service = new MessageService();

		boolean result = service.sendMessage(userId, message);

		if(result==false) {
			request.setAttribute("errMsg", "メッセージを送信することができませんでした");
			return "/WEB-INF/jsp/message.jsp";
		}else {
			request.setAttribute("errMsg", "メッセージを送信しました");
			return "/WEB-INF/jsp/home.jsp";
		}

	}

}
