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
		double s4 = sCount.getCountS3();
		double s5 = sCount.getCountS5();

		//全スタンプの回数の合計を求める
		double sumStamps = (s1 + s2 + s3 + s4 + s5);

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
		System.out.println(s1Count+"かうんとだよ");
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
	//stamp2の各カテゴリの割合を求めるメソッド
	public ArrayList<Double> s2Calc(ArrayList<BStampsBeans> stamp2){
		ArrayList<Double> s2Percent = new ArrayList<>();
		//stamp2の行数で押された回数を調べる
		int s2Count = stamp2.size();
		System.out.println(s2Count+"かうんとだよ");
		if(s2Count!=0) {
			int[] s2Category = new int[11];
				//各カテゴリ何回スタンプが押されたを数え、配列に入れる
				for(int i=0; i<10; i++) {
					for(int j=1; j<11; j++) {
						if(stamp2.get(i).getCategoryId() == j) {
							s2Category[i] += 1;
						}
					}
				}
				//stamp2のカテゴリのパーセントを求める
				for(int k=1; k<11;k++) {
					double s2 = (s2Category[k] / s2Count) * 100;
					s2Percent.add(s2);

				}
				return s2Percent;
		}else {
			return s2Percent;
		}

	}
	//stamp3の各カテゴリの割合を求めるメソッド
	public ArrayList<Double> s3Calc(ArrayList<BStampsBeans> stamp3){
		ArrayList<Double> s3Percent = new ArrayList<>();
		//stamp3の行数で押された回数を調べる
		int s3Count = stamp3.size();
		if(s3Count!=0) {
			int[] s3Category = new int[11];
				//各カテゴリ何回スタンプが押されたを数え、配列に入れる
				for(int i=0; i<10; i++) {
					for(int j=1; j<11; j++) {
						if(stamp3.get(i).getCategoryId() == j) {
							s3Category[i] += 1;
						}
					}
				}
				//stamp3のカテゴリのパーセントを求める
				for(int k=1; k<11;k++) {
					double s3 = (s3Category[k] / s3Count) * 100;
					s3Percent.add(s3);

				}
				return s3Percent;
		}else {
			return s3Percent;
		}
	}
	public ArrayList<Double> s4Calc(ArrayList<BStampsBeans> stamp4){
		ArrayList<Double> s4Percent = new ArrayList<>();
		//stamp4の行数で押された回数を調べる
		int s4Count = stamp4.size();
		if(s4Count!=0) {
			int[] s4Category = new int[11];
				//各カテゴリ何回スタンプが押されたを数え、配列に入れる
				for(int i=0; i<10; i++) {
					for(int j=1; j<11; j++) {
						if(stamp4.get(i).getCategoryId() == j) {
							s4Category[i] += 1;
						}
					}
				}
				//stamp4のカテゴリのパーセントを求める
				for(int k=1; k<11;k++) {
					double s4 = (s4Category[k] / s4Count) * 100;
					s4Percent.add(s4);

				}
				return s4Percent;
		}else {
			return s4Percent;
		}

	}
	public ArrayList<Double> s5Calc(ArrayList<BStampsBeans> stamp5){
		ArrayList<Double> s5Percent = new ArrayList<>();
		//stamp5の行数で押された回数を調べる
		int s5Count = stamp5.size();
		if(s5Count!=0) {
			int[] s5Category = new int[11];
				//各カテゴリ何回スタンプが押されたを数え、配列に入れる
				for(int i=0; i<10; i++) {
					for(int j=1; j<11; j++) {
						if(stamp5.get(i).getCategoryId() == j) {
							s5Category[i] += 1;
						}
					}
				}
				//stamp5のカテゴリのパーセントを求める
				for(int k=1; k<11;k++) {
					double s4 = (s5Category[k] / s5Count) * 100;
					s5Percent.add(s4);

				}
				return s5Percent;
		}else {
			return s5Percent;
		}

	}


}
