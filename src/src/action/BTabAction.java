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


	//selectMessages(メッセージです)
		//サービスのselectMessagesメソッドを実行する（引数empId）
		ArrayList<BMessagesBeans> messageList = tabService.selectMessages(empId);

	//selectEvaluation(評価です)
		//サービスのselectMessagesメソッドを実行する（引数empId）
		ArrayList<BEvaluationsBeans> evaluationList=tabService.selectEvaluation(empId);
		//戻ってきた値がnullだったら(ここにこれまで全部のArrayListを入れる)
		if(notesList.size() == 0&& messageList.size() == 0&&evaluationList.size() == 0) {
			request.setAttribute("errMsg", "正常に表示されませんでした。");
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
