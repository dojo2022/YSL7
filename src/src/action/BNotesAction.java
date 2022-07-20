package action;

import java.io.UnsupportedEncodingException;

import javax.servlet.http.HttpServletRequest;

import service.BNotesService;


public class BNotesAction {
	HttpServletRequest request=null;

	public BNotesAction(HttpServletRequest request) {
		this.request=request;
	}
	// このthrowsは「もし例外起きてもここではなにもしないよ」という宣言（try-catchかこれがないとエラー）
		public String nRegist() throws UnsupportedEncodingException  {
			request.setCharacterEncoding("UTF-8");

			int uId = Integer.parseInt(request.getParameter("uId"));
			int empId = Integer.parseInt(request.getParameter("empId"));
			String title=request.getParameter("title");
			String content=request.getParameter("content");

			//入力値のチェック（空文字チェック）
			if(title.strip().length()==0||content.strip().length()==0) {
				request.setAttribute("errMsg", "必須項目を記入してください。");
				return "/WEB-INF/jsp/login.jsp";
			}
			//入力値に問題が無ければ指定のserviceを呼び出す
			BNotesService service = new BNotesService();
//			BProfileAllBeans listprof = service.nRegist(uId, empId,title,content);

			int ans = 0;
			//戻ってきた値がnullだったら
			if(ans == 0) {
				request.setAttribute("errMsg", "登録できませんでした。");
				return "/WEB-INF/backjsp/bRegistNote.jsp";
			//ちゃんと入っていたら
			}else {
				//戻ってきたuser型のデータをsessionに格納し、servletに次のＪＳＰのパスを送る
				return "/WEB-INF/backjsp/bMainPage.jsp";
				}
		}
			public String nDelete() throws UnsupportedEncodingException  {
				request.setCharacterEncoding("UTF-8");

				int noteId = Integer.parseInt(request.getParameter("uId"));

				//入力値に問題が無ければ指定のserviceを呼び出す
				BNotesService service = new BNotesService();
//				BProfileAllBeans listprof = service.nDelete(noteId);

				int ans = 0;
				//戻ってきた値がnullだったら
				if(ans == 0) {
					request.setAttribute("errMsg", "登録できませんでした");
					return "/WEB-INF/backjsp/bRegistNote.jsp";
				//ちゃんと入っていたら
				}else {
					//戻ってきたuser型のデータをsessionに格納し、servletに次のＪＳＰのパスを送る
					return "/WEB-INF/backjsp/bMainPage.jsp";
				}
		}


}
