package action;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import model.BEvaluationsBeans;
import model.BGraphCalc;
import model.BMessagesBeans;
import model.BNotesBeans;
import model.BProfileAllBeans;
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
		//Serviceをインスタンス化（tabServiceという名前をつけたから、あわせてね）
		BTabService tabService = new BTabService();

		//プロフィール情報を取ってくる
		BProfileAllBeans profile = tabService.searchProfile(empId);

		//取ったempIdをsessionに保存しておく
		HttpSession session = request.getSession();
		session.setAttribute("profile", profile);
		session.setAttribute("empId", empId);

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

		//計算結果をsessionに保存する
		session.setAttribute("sCount", sCount);
		session.setAttribute("s1Percent", s1Percent);
		session.setAttribute("s2Percent", s2Percent);
		session.setAttribute("s3Percent", s3Percent);
		session.setAttribute("s4Percent", s4Percent);
		session.setAttribute("s5Percent", s5Percent);

		//検索結果が0件の場合の処理
		if(stampGraph.size() == 0) {
			request.setAttribute("sgErrMsg", "きもちの整理がついていないようです…。");
		}

		//searchAllStamps(きもちスタンプ)
		ArrayList<BStampsBeans> allStamps = tabService.searchAllStamps(empId);

		//検索結果をsessionに保存
		session.setAttribute("allStamps", allStamps);

		//検索結果が0件の場合の処理
		if(allStamps.size() == 0) {
			request.setAttribute("stErrMsg", "きもちの整理がついていないようです…。");
		}

		//selectNotes(メモです)
		//サービスのselectNotesメソッドを実行する（引数empId）
		ArrayList<BNotesBeans> notesList=tabService.selectNotes(empId);

		//検索結果をsessionに保存
		session.setAttribute("noteList", notesList);

		//検索結果が0件の場合の処理
		if(notesList.size() == 0) {
			request.setAttribute("ntErrMsg", "まだメモがありません。メモを登録してみましょう！");
		}

		//selectMessages(メッセージです)
		//サービスのselectMessagesメソッドを実行する（引数empId）
		ArrayList<BMessagesBeans> messageList = tabService.selectMessages(empId);

		//検索結果をsessionに保存
		session.setAttribute("messageList", messageList);

		//検索結果が0件の場合の処理
		if(messageList.size() == 0) {
			request.setAttribute("msErrMsg", "メッセージが届いていないようです。");
		}

		//selectEvaluation(評価です)
		//サービスのselectMessagesメソッドを実行する（引数empId）
		ArrayList<BEvaluationsBeans> myEvaluationList = tabService.selectMyEvaluation(empId);

		//検索結果をsessionに保存
		session.setAttribute("myEvaluation", myEvaluationList);

		ArrayList<BEvaluationsBeans> otherEvaluationList = tabService.selectOtherEvaluation(empId);
		//検索結果をsessionに保存
		session.setAttribute("otherEvaluationList", otherEvaluationList);

		//自己評価と他己評価の両方がないとき
		if(myEvaluationList.size() == 0 && otherEvaluationList.size() == 0) {
			request.setAttribute("evErrMsg", "評価はまだされていないようです。");
		}

		//戻ってきた値がnullだったら(ここにこれまで全部のArrayListを入れる)
			return "/WEB-INF/backjsp/bMainPage.jsp";



 }
}
