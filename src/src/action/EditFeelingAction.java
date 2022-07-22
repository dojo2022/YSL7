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
		int stamp1 = Integer.parseInt(request.getParameter("stamp1"));
		int stamp2 = Integer.parseInt(request.getParameter("stamp2"));
		int stamp3 = Integer.parseInt(request.getParameter("stamp3"));
		int stamp4 = Integer.parseInt(request.getParameter("stamp4"));
		int stamp5 = Integer.parseInt(request.getParameter("stamp5"));
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
			return "/WEB-INF/jsp/home.jsp";
		}
	}
}
