package action;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

import service.BUserService;

public class BUserAction {
	HttpServletRequest request=null;

	public BUserAction(HttpServletRequest request) {
		this.request=request;

	}



	//uRegist
	public String uRegist() throws UnsupportedEncodingException{
			int ans = 0;

			request.setCharacterEncoding("UTF-8");
			String number = request.getParameter("number");
			String name = request.getParameter("name");
			String gender = request.getParameter("gender");
			String depId = request.getParameter("dep_id");
			String divId = request.getParameter("div_id");
			String secId = request.getParameter("sec_id");
			String post1 = request.getParameter("post1");
			String post2 = request.getParameter("post2");
			String post3 = request.getParameter("post3");
			String year = request.getParameter("year");

			System.out.println(divId);
			System.out.println(secId);

			if(number.strip().length()==0){
				//リクエストスコープにerrMsgという名前でエラーメッセージを保存
				request.setAttribute("numberErrMsg", "※社員番号を入力してください");
				return "/WEB-INF/backjsp/bURegist.jsp";

			}
			if(name.strip().length()==0){
				//リクエストスコープにerrMsgという名前でエラーメッセージを保存
				request.setAttribute("nameErrMsg", "※名前を入力してください");
				return "/WEB-INF/backjsp/bURegist.jsp";

			}
			if(gender.strip().length()==0){
				//リクエストスコープにerrMsgという名前でエラーメッセージを保存
				request.setAttribute("genderErrMsg", "※性別を入力してください");
				return "/WEB-INF/backjsp/bURegist.jsp";

			}
			if(divId.strip().length()==0){
				//リクエストスコープにerrMsgという名前でエラーメッセージを保存
				request.setAttribute("divIdErrMsg", "※部を入力してください");
				return "/WEB-INF/backjsp/bURegist.jsp";

			}
			if(secId.strip().length()==0){
				//リクエストスコープにerrMsgという名前でエラーメッセージを保存
				request.setAttribute("secIdErrMsg", "※課を入力してください");
				return "/WEB-INF/backjsp/bURegist.jsp";

			}
			if(post1.strip().length()==0){
				//リクエストスコープにerrMsgという名前でエラーメッセージを保存
				request.setAttribute("post1ErrMsg", "※役職１を入力してください");
				return "/WEB-INF/backjsp/bURegist.jsp";

			}
			if(year.strip().length()==0){
				//リクエストスコープにerrMsgという名前でエラーメッセージを保存
				request.setAttribute("yearErrMsg", "※入社年度を入力してください");
				return "/WEB-INF/backjsp/bURegist.jsp";

			}

//			if(number.strip().length()==0|| name.strip().length()==0 || gender.strip().length()==0
//					|| secId.strip().length()==0 || post1.strip().length()==0 || year.strip().length()==0) {
//				//リクエストスコープにerrMsgという名前でエラーメッセージを保存
//				request.setAttribute("errMsg", "※エラーメッセージを入れる");
//				return "/WEB-INF/jsp/login.jsp";
//			}

			int intSecId = 0;
			if (divId.strip().equals("金融・保険サービス1部") && secId.strip().equals("1課")) {
				intSecId = 1;
			}
			if (divId.strip().equals("金融・保険サービス1部") && secId.strip().equals("2課")) {
				intSecId = 2;
			}
			if (divId.strip().equals("金融・保険サービス2部") && secId.strip().equals("1課")) {
				intSecId = 3;
			}
			if (divId.strip().equals("金融・保険サービス2部") && secId.strip().equals("2課")) {
				intSecId = 4;
			}

			System.out.println("intSecId = " + intSecId);

			//これはあとで消すこと！
			//intSecId = 1;



			BUserService uService = new BUserService();
			ans = uService.uRegist(number, name, year, gender, intSecId, post1, post2, post3);

			//戻ってきた値がnullだったら
			if(ans == 0) {
				request.setAttribute("errMsg", "※登録できませんでした");
				return "/WEB-INF/backjsp/bURegist.jsp";
			//ちゃんと入っていたら
			}else {
				//戻ってきたuser型のデータをsessionに格納し、servletに次のＪＳＰのパスを送る
				request.setAttribute("errMsg", "※登録できました");
				return "/WEB-INF/backjsp/bURegist.jsp";
			}
	}


	//uUpdate
	public String uUpdate() throws UnsupportedEncodingException{
		int ans = 0;

		request.setCharacterEncoding("UTF-8");
		String empId = request.getParameter("empId");
		String number = request.getParameter("number");
		String name = request.getParameter("name");
		String gender = request.getParameter("gender");
		String depId = request.getParameter("dep_id");
		String divId = request.getParameter("div_id");
		String secId = request.getParameter("sec_id");
		String post1 = request.getParameter("post1");
		String post2 = request.getParameter("post2");
		String post3 = request.getParameter("post3");
		String year = request.getParameter("year");
		System.out.println(empId);

//		if(number.strip().length()==0|| name.strip().length()==0 || gender.strip().length()==0
//				|| secId.strip().length()==0 || post1.strip().length()==0 || year.strip().length()==0) {
//			//リクエストスコープにerrMsgという名前でエラーメッセージを保存
//			request.setAttribute("errMsg", "※エラーメッセージを入れる");
//			return "/WEB-INF/jsp/login.jsp";
//		}

		int intSecId = 0;
		if (divId.strip().equals("金融・保険サービス1部") && secId.strip().equals("1課")) {
			intSecId = 1;
		}
		if (divId.strip().equals("金融・保険サービス1部") && secId.strip().equals("2課")) {
			intSecId = 2;
		}
		if (divId.strip().equals("金融・保険サービス2部") && secId.strip().equals("1課")) {
			intSecId = 3;
		}
		if (divId.strip().equals("金融・保険サービス2部") && secId.strip().equals("2課")) {
			intSecId = 4;
		}





		BUserService uService = new BUserService();
		ans = uService.uUpdate(empId, number, name, year, gender, intSecId, post1, post2, post3);

		//戻ってきた値がnullだったら
		if(ans == 0) {
			request.setAttribute("errMsg", "※登録できませんでした");
			return "/WEB-INF/backjsp/bURegist.jsp";
		//ちゃんと入っていたら
		}else {
			//戻ってきたuser型のデータをsessionに格納し、servletに次のＪＳＰのパスを送る
			request.setAttribute("errMsg", "※登録できました");
			return "/WEB-INF/backjsp/bURegist.jsp";
		}
}



	//uDelete
		public String uDelete() throws UnsupportedEncodingException  {
			request.setCharacterEncoding("UTF-8");
			int empId=Integer.parseInt(request.getParameter("empId"));
			int ans=0;

			//入力値に問題が無ければ指定のserviceを呼び出す
			BUserService BUserService = new BUserService();
			ans = BUserService.uDelete(empId);
			//戻ってきた値が0だったら
			if(ans == 0) {
				request.setAttribute("errMsg", "削除できませんでした");
				return "/WEB-INF/backjsp/bUUpdate.jsp";
			//ちゃんと入っていたら
			}else {
				//servletに次のＪＳＰのパスを送る
				return "/WEB-INF/backjsp/bList.jsp";
			}
		}




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
				two.add("部を選択");
				two.add("金融・保険サービス1部");
				two.add("金融・保険サービス2部");
				two.add("社会公共サービス部");
				two.add("産業基盤サービス部");
				two.add("建設・公共サービス部");
				two.add("IT Co-Creation部");
				two.add("IT Engineering部");
		//三番目のプルダウンメニューを入れちゃう
				three.add("課を選択");
				three.add("1課");
				three.add("2課");
				three2.add("課を選択");
				three2.add("1課");
				three2.add("2課");
		//全てをリクエストスコープへ入れる
				request.setAttribute("one", one);
				request.setAttribute("two", two);
				request.setAttribute("three", three);
				request.setAttribute("three2", three2);

		return "/WEB-INF/backjsp/bURegist.jsp";
	}


}
