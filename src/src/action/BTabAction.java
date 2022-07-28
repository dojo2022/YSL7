package action;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import model.BEvaluationCalc;
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
		//ここがおかしくなるよみこまない
		request.setCharacterEncoding("UTF-8");
		int empId = Integer.parseInt(request.getParameter("empId"));
		//Serviceをインスタンス化（tabServiceという名前をつけたから、あわせてね）
		BTabService tabService = new BTabService();

		//プロフィール情報を取ってくる
		BProfileAllBeans profile = tabService.searchProfile(empId);

		//取ったempIdをsessionに保存しておく
		HttpSession session = request.getSession();
//		Enumeration en = session.getAttributeNames();
//
//		String eName;
//		while(en.hasMoreElements()){
//		  eName = (String)en.nextElement();
//		  session.removeAttribute(eName);
//		}
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

		//戻り値が０行のとき
		if(stamp1.size() == 0) {
			request.setAttribute("s1ErrMsg", "表示できるデータがありません。");
		}
		if(stamp2.size() == 0) {
			request.setAttribute("s2ErrMsg", "表示できるデータがありません。");
		}
		if(stamp3.size() == 0) {
			request.setAttribute("s3ErrMsg", "表示できるデータがありません。");
		}
		if(stamp4.size() == 0) {
			request.setAttribute("s4ErrMsg", "表示できるデータがありません。");
		}
		if(stamp5.size() == 0) {
			request.setAttribute("s5ErrMsg", "表示できるデータがありません。");
		}		System.out.println("スタンプだよ"+stamp2);


		//計算モデルを実体化する
		BGraphCalc bgc = new BGraphCalc();

		//スタンプ割合が入ったArrayList
		ArrayList<Double> stampPercent = bgc.stCalc(sCount);
		session.setAttribute("stampPercent", stampPercent);


		//stamp1~stamp5のカテゴリ割合が入ったArrayList
		ArrayList<Double> s1Percent = bgc.s1Calc(stamp1);
		ArrayList<Double> s2Percent = bgc.s1Calc(stamp2);

		ArrayList<Double> s3Percent = bgc.s1Calc(stamp3);
		ArrayList<Double> s4Percent = bgc.s1Calc(stamp4);
		ArrayList<Double> s5Percent = bgc.s1Calc(stamp5);

//		for(int i=0;i<s4Percent.size();i++) {
//			System.out.println("入ってる？" + i + "回目");
//			System.out.println(s4Percent.get(i));
//		}

		//戻り値が０行のとき
		if(s1Percent.size() == 0) {
			request.setAttribute("s1ErrMsg", "表示できるデータがありません。");
		}
		if(s2Percent.size() == 0) {
			request.setAttribute("s2ErrMsg", "表示できるデータがありません。");
		}
		if(s3Percent.size() == 0) {
			request.setAttribute("s3ErrMsg", "表示できるデータがありません。");
		}
		if(s4Percent.size() == 0) {
			request.setAttribute("s4ErrMsg", "表示できるデータがありません。");
		}
		if(s5Percent.size() == 0) {
			request.setAttribute("s5ErrMsg", "表示できるデータがありません。");
		}


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
		//念のためのセット
		session.setAttribute("stampGraph", stampGraph);

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
		System.out.println("AA"+notesList.size());
		for(BNotesBeans s : notesList) {
			System.out.println(s.getName()+"aaaaaaaaaaa");
			System.out.println(s.getTitle());
			System.out.println(s.getContent());
			System.out.println(s.getDate());
		}

		//検索結果をsessionに保存
		session.setAttribute("notesList", notesList);

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
				if(myEvaluationList.size()!=0) {
					session.setAttribute("myEvaluation", myEvaluationList.get(0));
				}
				ArrayList<BEvaluationsBeans> otherEvaluationList = tabService.selectOtherEvaluation(empId);

				BEvaluationCalc calc = new BEvaluationCalc();
				ArrayList<Double> avg= calc.evaCalc(otherEvaluationList);
				//検索結果をsessionに保存
				session.setAttribute("avg", avg);

				//自己評価と他己評価の両方がないとき
				if(myEvaluationList.size() == 0 && avg.size() == 0) {
					request.setAttribute("evErrMsg", "評価はまだされていないようです。");
				}
		//戻ってきた値がnullだったら(ここにこれまで全部のArrayListを入れる)
			return "/WEB-INF/backjsp/bMainPage.jsp";



 }
}
