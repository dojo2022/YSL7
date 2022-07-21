package action;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import model.BProfileAllBeans;
import service.BListService;

public class BListAction {
	HttpServletRequest request=null;

	public BListAction(HttpServletRequest request) {
		this.request=request;
	}
	// このthrowsは「もし例外起きてもここではなにもしないよ」という宣言（try-catchかこれがないとエラー）
			public String selectAllList() throws UnsupportedEncodingException  {
				request.setCharacterEncoding("UTF-8");

				//入力値に問題が無ければ指定のserviceを呼び出す
				BListService listService = new BListService();
				//サービスのselectAllListメソッドを実行する（引数なし）
				ArrayList<BProfileAllBeans> listAll=listService.selectAllList();
				//戻ってきた値がnullだったら
				if(listAll.size() == 0) {
					request.setAttribute("errMsg", "リストが正常に表示されませんでした。。");
					return "/WEB-INF/backjsp/bMainPage.jsp";
				//ちゃんと入っていたら
				}else {
					//戻ってきたuser型のデータをsessionに格納し、servletに次のＪＳＰのパスを送る
					HttpSession session = request.getSession();
					session.setAttribute("listAll", listAll);
					return "/WEB-INF/backjsp/bMainPage.jsp";
					}
			}

}
