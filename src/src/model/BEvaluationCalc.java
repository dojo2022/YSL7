package model;

import java.util.ArrayList;

public class BEvaluationCalc {

	public ArrayList<Double> evaCalc(ArrayList<BEvaluationsBeans> otherEvaluationList){

		//戻り値入れるArrayList作成
		ArrayList<Double> eAvgList = new ArrayList<Double>();

		//人数を求める
		int s = otherEvaluationList.size();

		//変数の宣言
		double e1 =0;
		double e2 =0;
		double e3 =0;
		double e4 =0;
		double e5 =0;

		//5つの評価を持ってくる
		for(BEvaluationsBeans b : otherEvaluationList ) {
			e1 += b.getEva1();
			e2 += b.getEva2();
			e3 += b.getEva3();
			e4 += b.getEva4();
			e5 += b.getEva5();
		}

		//それぞれの項目の複数人からの評価の平均を求める
		double e1Avg = e1 / s;
		eAvgList.add((Math.floor(e1Avg * 10)) / 10);
		double e2Avg = e2 / s;
		eAvgList.add((Math.floor(e2Avg * 10)) / 10);
		double e3Avg = e3 / s;
		eAvgList.add((Math.floor(e3Avg * 10)) / 10);
		double e4Avg = e4 / s;
		eAvgList.add((Math.floor(e4Avg * 10)) / 10);
		double e5Avg = e5 / s;
		eAvgList.add((Math.floor(e5Avg * 10)) / 10);

		/*		//複数人からの評価の平均を求める
				double eAvg = (e1 + e2 + e3 + e4 + e5) /  s;*/

		return eAvgList;
	}
}