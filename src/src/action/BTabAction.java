package action;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import model.BNotesBeans;
import service.BTabService;

public class BTabAction {
	HttpServletRequest request=null;
	public BTabAction(HttpServletRequest request) {
		this.request=request;
	}
	public String showMainPage() throws UnsupportedEncodingException{
		//empIdを取ってくる
		request.setCharacterEncoding("UTF-8");
		int empId = Integer.parseInt(request.getParameter("empId"));
		//Serviceをインスタンス化（tabServiceという名前をつけたから、あわせてね）
		BTabService tabService = new BTabService();

		//selectNotes(メモです)
		//サービスのselectNotesメソッドを実行する（引数empId）
		ArrayList<BNotesBeans> notesList=tabService.selectNotes();
		//戻ってきた値がnullだったら
		if(notesList.size() == 0) {
			request.setAttribute("errMsg", "リストが正常に表示されませんでした。。");
			return "/WEB-INF/backjsp/bMainPage.jsp";
		//ちゃんと入っていたら
		}else {
			//戻ってきたuser型のデータをsessionに格納し、servletに次のＪＳＰのパスを送る
			HttpSession session = request.getSession();
			session.setAttribute("notesList", notesList);
			return "/WEB-INF/backjsp/bMainPage.jsp";
			}
 }
}
