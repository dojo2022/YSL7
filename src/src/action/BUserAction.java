package action;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

public class BUserAction {
	HttpServletRequest request=null;

	public BUserAction(HttpServletRequest request) {
		this.request=request;

	}



	//uRegist


	//uUpdate


	//uDelete


	//getSecId
	public String getSecId() {

		//配列を用意
		ArrayList<String> one = new ArrayList<String>();//事業部
		ArrayList<String> two = new ArrayList<String>();//部
		ArrayList<String> three = new ArrayList<String>();//金融・保険サービス１部
		ArrayList<String> three2 = new ArrayList<String>();//金融・保険サービス２部

		//最初のプルダウンメニューを入れちゃう
				one.add("SI事業部");
				one.add("ソリューション事業部");
				one.add("管理本部");
				one.add("企画部");

		//二番目のプルダウンメニューを入れちゃう
				two.add("金融・保険サービス1部");
				two.add("金融・保険サービス2部");
				two.add("社会公共サービス部");
				two.add("産業基盤サービス部");
				two.add("建設・公共サービス部");
				two.add("IT Co-Creation部");
				two.add("IT Engineering部");

		//三番目のプルダウンメニューを入れちゃう
				three.add("1課");
				three.add("2課");

				three2.add("1課");
				three2.add("2課");

		//全てをリクエストスコープへ入れる
				request.setAttribute("one", one);
				request.setAttribute("two", two);
				request.setAttribute("three", three);
				request.setAttribute("three2", three2);

		return "WebContent/WEB-INF/backjsp/uRegist.jsp";
	}


}
