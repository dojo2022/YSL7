package action;

import java.io.UnsupportedEncodingException;

import javax.servlet.http.HttpServletRequest;

import service.RegistFeelingService;

public class RegistFeelingAction {
	HttpServletRequest request=null;

	public RegistFeelingAction(HttpServletRequest request) {
		this.request = request;
	}

	public String registFeeling() throws UnsupportedEncodingException{
		request.setCharacterEncoding("UTF-8");

		int userId = Integer.parseInt(request.getParameter("stamp_id"));
		int stamp1 = Integer.parseInt(request.getParameter("stamp1"));
		int stamp2 = Integer.parseInt(request.getParameter("stamp2"));
		int stamp3 = Integer.parseInt(request.getParameter("stamp3"));
		int stamp4 = Integer.parseInt(request.getParameter("stamp4"));
		int stamp5 = Integer.parseInt(request.getParameter("stamp5"));
		int categoryId = Integer.parseInt(request.getParameter("category_id"));
		String comment = request.getParameter("comment");

		RegistFeelingService service = new RegistFeelingService();
		boolean result = service.registFeeling(userId, categoryId, stamp1, stamp2, stamp3, stamp4, stamp5, comment);

		if(result == false) {
			request.setAttribute("errMsg", "※登録失敗");
			return "WEB-INF/jsp/regist_feeling.jsp";
		}else {
			request.setAttribute("errMsg", "※きもちを登録しました");
			return "WEB-INF/jsp/home.jsp";
		}
	}
}
