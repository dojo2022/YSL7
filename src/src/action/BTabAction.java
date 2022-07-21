package action;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import model.BEvaluationsBeans;
import model.BMessagesBeans;
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
		ArrayList<BNotesBeans> notesList=tabService.selectNotes(empId);
		//戻ってきた値がnullだったら
		if(notesList.size() == 0) {
			request.setAttribute("errMsg", "リストが正常に表示されませんでした。。");
			return "/WEB-INF/backjsp/bMainPage.jsp";
		//ちゃんと入っていたら
		}else {
			//戻ってきたnotesList型のデータをsessionに格納し、servletに次のＪＳＰのパスを送る
			HttpSession session = request.getSession();
			session.setAttribute("notesList", notesList);
			return "/WEB-INF/backjsp/bMainPage.jsp";
			}

	//selectMessages(メッセージです)
		//サービスのselectMessagesメソッドを実行する（引数empId）
		ArrayList<BMessagesBeans> messageList=tabService.selectMessages(empId);
		//戻ってきた値がnullだったら
		if(messageList.size() == 0) {
			request.setAttribute("errMsg", "メッセージが正常に表示されませんでした。。");
			return "/WEB-INF/backjsp/bMainPage.jsp";
		//ちゃんと入っていたら
		}else {
			//戻ってきたmessageList型のデータをsessionに格納し、servletに次のＪＳＰのパスを送る
			HttpSession session = request.getSession();
			session.setAttribute("messageList", messageList);
			return "/WEB-INF/backjsp/bMainPage.jsp";
			}

	//selectEvaluations(評価です)
		//サービスのselectMessagesメソッドを実行する（引数empId）
		ArrayList<BEvaluationsBeans> evaluationList=tabService.selectEvaluation(empId);
		//戻ってきた値がnullだったら
		if(evaluationList.size() == 0) {
			request.setAttribute("errMsg", "メッセージが正常に表示されませんでした。。");
			return "/WEB-INF/backjsp/bMainPage.jsp";
		//ちゃんと入っていたら
		}else {
			//戻ってきたevaluationList型のデータをsessionに格納し、servletに次のＪＳＰのパスを送る
			HttpSession session = request.getSession();
			session.setAttribute("evaluationList", evaluationList);
			return "/WEB-INF/backjsp/bMainPage.jsp";
			}


 }
}
