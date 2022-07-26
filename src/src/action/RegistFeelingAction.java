package action;

import java.io.UnsupportedEncodingException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import model.Users;
import service.RegistFeelingService;

public class RegistFeelingAction {
	HttpServletRequest request=null;

	public RegistFeelingAction(HttpServletRequest request) {
		this.request = request;
	}

	public String registFeeling() throws UnsupportedEncodingException{
		request.setCharacterEncoding("UTF-8");

		HttpSession session = request.getSession();
		Users user = (Users)session.getAttribute("user");
		int userId = user.getUserId();

		int stamp1 = 0;
		int stamp2 = 0;
		int stamp3 = 0;
		int stamp4 = 0;
		int stamp5 = 0;
		int categoryId = 0;

		String sStamp1 = request.getParameter("stamp1");
		if (sStamp1 != null) {
			stamp1 = Integer.parseInt(sStamp1);
		}
		String sStamp2 = request.getParameter("stamp2");
		if (sStamp2 != null) {
			stamp2 = Integer.parseInt(sStamp2);
		}
		String sStamp3 = request.getParameter("stamp3");
		if (sStamp3 != null) {
			stamp3 = Integer.parseInt(sStamp3);
		}
		String sStamp4 = request.getParameter("stamp4");
		if (sStamp4 != null) {
			stamp4 = Integer.parseInt(sStamp4);
		}
		String sStamp5 = request.getParameter("stamp5");
		if (sStamp5 != null) {
			stamp5 = Integer.parseInt(sStamp5);
		}
		String sCategoryId = request.getParameter("category_id");
		if(sCategoryId != null) {
			categoryId = Integer.parseInt(sCategoryId);
		}
		String comment = request.getParameter("comment");

		boolean result = false;

		if((sStamp1 != null || sStamp2 != null || sStamp3 != null || sStamp4 != null || sStamp5 != null) && sCategoryId != null) {
			RegistFeelingService service = new RegistFeelingService();
			result = service.registFeeling(userId, categoryId, stamp1, stamp2, stamp3, stamp4, stamp5, comment);
		}


		if(result == false) {
			request.setAttribute("errMsg", "※登録失敗");
			return "WEB-INF/jsp/regist_feeling.jsp";
		}else {
			request.setAttribute("errMsg", "※きもちを登録しました");
			return "WEB-INF/jsp/home.jsp";
		}
	}
}
