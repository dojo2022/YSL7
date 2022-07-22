package model;

import java.util.ArrayList;

public class BEvaluationCalc {

	public double evaCalc(ArrayList<BEvaluationsBeans> otherEvaluationList){
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



		//複数人からの評価の平均を求める
		double eAvg = (e1 + e2 + e3 + e4 + e5) /  s;

		return eAvg;
	}
}