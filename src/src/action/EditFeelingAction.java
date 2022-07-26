package action;

import java.io.UnsupportedEncodingException;

import javax.servlet.http.HttpServletRequest;

import service.EditFeelingService;

public class EditFeelingAction {

	HttpServletRequest request=null;

	//serviceの戻り値を呼んでくる
	public EditFeelingAction(HttpServletRequest request) {
		this.request=request;
	}

	public String editFeeling() throws UnsupportedEncodingException {
		request.setCharacterEncoding("UTF-8");

		//String name = request.getParameter("name");
		//Integer.parseInt("1")
		int stampId = Integer.parseInt(request.getParameter("stamp_id"));

		int stamp1 = 0;
		int stamp2 = 0;
		int stamp3 = 0;
		int stamp4 = 0;
		int stamp5 = 0;

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
		int categoryId = Integer.parseInt(request.getParameter("category_id"));
		String comment = request.getParameter("comment");

		EditFeelingService service = new EditFeelingService();

		boolean result = service.editFeeling(stampId, categoryId, stamp1, stamp2, stamp3, stamp4, stamp5, comment);


		//戻ってきた値にデータが入っていなければ(nullであれば)
		if(result==false) {
			request.setAttribute("errMsg", "※検索したデータはありませんでした");
			return "/WEB-INF/jsp/history_feeling.jsp";
		//ちゃんと入っていたら
		}else {
			//servletに次のＪＳＰのパスを送る
			request.setAttribute("errMsg", "※きもちを更新しました");
			return "/WEB-INF/jsp/home.jsp";
		}
	}
}
