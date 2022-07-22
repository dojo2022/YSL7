package action;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import model.BEvaluationsBeans;
import model.BGraphCalc;
import model.BMessagesBeans;
import model.BNotesBeans;
import model.BStampsBeans;
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
		//取ったempIdをsessionに保存しておく
		HttpSession session = request.getSession();
		session.setAttribute("empId", empId);

		//Serviceをインスタンス化（tabServiceという名前をつけたから、あわせてね）
		BTabService tabService = new BTabService();

	//searchStampGraph(きもちグラフ)
		ArrayList<Object> stampGraph = tabService.searchStampGraph(empId);
	//stampGraphから中身を取り出す
		BStampsBeans sCount = (BStampsBeans)stampGraph.get(0);
		ArrayList<BStampsBeans> stamp1 = (ArrayList<BStampsBeans>) stampGraph.get(1);
		ArrayList<BStampsBeans> stamp2 = (ArrayList<BStampsBeans>) stampGraph.get(2);
		ArrayList<BStampsBeans> stamp3 = (ArrayList<BStampsBeans>) stampGraph.get(3);
		ArrayList<BStampsBeans> stamp4 = (ArrayList<BStampsBeans>) stampGraph.get(4);
		ArrayList<BStampsBeans> stamp5 = (ArrayList<BStampsBeans>) stampGraph.get(5);

	//計算モデルを実体化する
		BGraphCalc bgc = new BGraphCalc();
	//スタンプ割合が入ったArrayList
		ArrayList<Integer> stampPercent = bgc.stCalc(sCount);
	//stamp1~stamp5のカテゴリ割合が入ったArrayList
		ArrayList<Integer> s1Percent = bgc.s1Calc(stamp1);
		ArrayList<Integer> s2Percent = bgc.s2Calc(stamp2);
		ArrayList<Integer> s3Percent = bgc.s3Calc(stamp3);
		ArrayList<Integer> s4Percent = bgc.s4Calc(stamp4);
		ArrayList<Integer> s5Percent = bgc.s5Calc(stamp5);


	//searchAllStamps(きもちスタンプ)
		ArrayList<BStampsBeans> allStamps = tabService.searchAllstamps(empId);

	//selectNotes(メモです)
		//サービスのselectNotesメソッドを実行する（引数empId）
		ArrayList<BNotesBeans> notesList=tabService.selectNotes(empId);


	//selectMessages(メッセージです)
		//サービスのselectMessagesメソッドを実行する（引数empId）
		ArrayList<BMessagesBeans> messageList = tabService.selectMessages(empId);

	//selectEvaluation(評価です)
		//サービスのselectMessagesメソッドを実行する（引数empId）
		ArrayList<BEvaluationsBeans> myEvaluationList=tabService.selectMyEvaluation(empId);
		ArrayList<BEvaluationsBeans> otherEvaluationList=tabService.selectOtherEvaluation(empId);
		//戻ってきた値がnullだったら(ここにこれまで全部のArrayListを入れる)
		if(notesList.size() == 0&& messageList.size() == 0 && myEvaluationList.size() == 0 && otherEvaluationList.size() == 0) {
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
