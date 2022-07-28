package model;

import java.util.ArrayList;

public class BGraphCalc {

	public ArrayList<Double> stCalc(BStampsBeans sCount){
		//戻り値を入れるためのArrayListを用意する
		ArrayList<Double> stampPercent = new ArrayList<>();

		//各スタンプの中身（押された回数）を取り出す
		double s1 = sCount.getCountS1();
		double s2 = sCount.getCountS2();
		double s3 = sCount.getCountS3();
		double s4 = sCount.getCountS4();
		double s5 = sCount.getCountS5();
		System.out.println("s1:"+ s1);
		System.out.println("s2:"+ s2);
		System.out.println("s3:"+ s3);
		System.out.println("s4:"+ s4);
		System.out.println("s5:"+ s5);
		//全スタンプの回数の合計を求める
		double sumStamps = (s1 + s2 + s3 + s4 + s5);
		System.out.println("スタンプ合計"+ sumStamps);

		//各スタンプのパーセントを求める
		double p1 = ((double)s1 / sumStamps) * 100;
		stampPercent.add(p1);
		double p2 = ((double)s2 / sumStamps) * 100;
		stampPercent.add(p2);
		double p3 = ((double)s3 / sumStamps) * 100;
		stampPercent.add(p3);
		double p4 = ((double)s4 / sumStamps) * 100;
		stampPercent.add(p4);
		double p5 = ((double)s5 / sumStamps) * 100;
		stampPercent.add(p5);

		return stampPercent;
	}

	//stamp1の各カテゴリの割合を求めるメソッド
	public ArrayList<Double> s1Calc(ArrayList<BStampsBeans> stamp1){
		ArrayList<Double> s1Percent = new ArrayList<>();
		//stamp1の行数で押された回数を調べる
		int s1Count = stamp1.size();
		if(s1Count!=0) {
		int[] s1Category = new int[11];
			//各カテゴリ何回スタンプが押されたを数え、配列に入れる
			for(int i=0; i<stamp1.size(); i++) {
				for(int j=1; j<11; j++) {
					if(stamp1.get(i).getCategoryId() == j) {
						s1Category[j] += 1;
					}
				}
			}
			//stamp1のカテゴリのパーセントを求める
			for(int k=1; k<11;k++) {
				double s1 = ((double)s1Category[k] / (double)s1Count) * 100;
				s1Percent.add(s1);

			}
			return s1Percent;
		}else {
			return s1Percent;
		}
	}

}
