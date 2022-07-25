package action;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import model.BGraphCalc;
import model.BStampsBeans;
import model.Users;
import service.GraphFeelingService;

public class GraphFeelingAction {
	HttpServletRequest request=null;

	public GraphFeelingAction(HttpServletRequest request) {
		this.request=request;
	}

	public String showGraph() throws UnsupportedEncodingException{
		request.setCharacterEncoding("UTF-8");
		HttpSession session = request.getSession();
		Users user = (Users)session.getAttribute("user");
		int userId = user.getUserId();

		GraphFeelingService service = new GraphFeelingService();
		ArrayList<Object> stampGraph = service.showGraph(userId);

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

		return "WEB-INF/jsp/graph_feeling.jsp";
	}




}
