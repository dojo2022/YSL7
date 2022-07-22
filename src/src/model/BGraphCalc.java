package model;

import java.util.ArrayList;

public class BGraphCalc {

	public ArrayList<Integer> stCalc(BStampsBeans sCount){
		//戻り値を入れるためのArrayListを用意する
		ArrayList<Integer> stampPercent = new ArrayList<>();

		//各スタンプの中身（押された回数）を取り出す
		int s1 = sCount.getCountS1();
		int s2 = sCount.getCountS2();
		int s3 = sCount.getCountS3();
		int s4 = sCount.getCountS3();
		int s5 = sCount.getCountS5();

		//全スタンプの回数の合計を求める
		int sumStamps = (s1 + s2 + s3 + s4 + s5);

		//各スタンプのパーセントを求める
		int p1 = (s1 / sumStamps) * 100;
		stampPercent.add(p1);
		int p2 = (s2 / sumStamps) * 100;
		stampPercent.add(p2);
		int p3 = (s3 / sumStamps) * 100;
		stampPercent.add(p3);
		int p4 = (s4 / sumStamps) * 100;
		stampPercent.add(p4);
		int p5 = (s5 / sumStamps) * 100;
		stampPercent.add(p5);

		return stampPercent;
	}

	//stamp1の各カテゴリの割合を求めるメソッド
	public ArrayList<Integer> s1Calc(ArrayList<BStampsBeans> stamp1){
		ArrayList<Integer> s1Percent = new ArrayList<>();
		//stamp1の行数で押された回数を調べる
		int s1Count = stamp1.size();
		int[] s1Category = new int[10];
			//各カテゴリ何回スタンプが押されたを数え、配列に入れる
			for(int i=0; i<10; i++) {
				for(int j=0; j<10; j++) {
					if(stamp1.get(i).getCategoryId() == j) {
						s1Category[i] += 1;
					}
				}
			}
			//stamp1のカテゴリのパーセントを求める
			for(int k=0; k<10;k++) {
				int s1 = (s1Category[k] / s1Count) * 100;
				s1Percent.add(s1);

			}
			return s1Percent;
	}
	//stamp2の各カテゴリの割合を求めるメソッド
	public ArrayList<Integer> s2Calc(ArrayList<BStampsBeans> stamp2){
		ArrayList<Integer> s2Percent = new ArrayList<>();
		//stamp2の行数で押された回数を調べる
		int s2Count = stamp2.size();
		int[] s2Category = new int[10];
			//各カテゴリ何回スタンプが押されたを数え、配列に入れる
			for(int i=0; i<10; i++) {
				for(int j=0; j<10; j++) {
					if(stamp2.get(i).getCategoryId() == j) {
						s2Category[i] += 1;
					}
				}
			}
			//stamp2のカテゴリのパーセントを求める
			for(int k=0; k<10;k++) {
				int s2 = (s2Category[k] / s2Count) * 100;
				s2Percent.add(s2);

			}
			return s2Percent;

	}
	//stamp3の各カテゴリの割合を求めるメソッド
	public ArrayList<Integer> s3Calc(ArrayList<BStampsBeans> stamp3){
		ArrayList<Integer> s3Percent = new ArrayList<>();
		//stamp3の行数で押された回数を調べる
		int s3Count = stamp3.size();
		int[] s3Category = new int[10];
			//各カテゴリ何回スタンプが押されたを数え、配列に入れる
			for(int i=0; i<10; i++) {
				for(int j=0; j<10; j++) {
					if(stamp3.get(i).getCategoryId() == j) {
						s3Category[i] += 1;
					}
				}
			}
			//stamp3のカテゴリのパーセントを求める
			for(int k=0; k<10;k++) {
				int s3 = (s3Category[k] / s3Count) * 100;
				s3Percent.add(s3);

			}
			return s3Percent;

	}
	public ArrayList<Integer> s4Calc(ArrayList<BStampsBeans> stamp4){
		ArrayList<Integer> s4Percent = new ArrayList<>();
		//stamp4の行数で押された回数を調べる
		int s4Count = stamp4.size();
		int[] s4Category = new int[10];
			//各カテゴリ何回スタンプが押されたを数え、配列に入れる
			for(int i=0; i<10; i++) {
				for(int j=0; j<10; j++) {
					if(stamp4.get(i).getCategoryId() == j) {
						s4Category[i] += 1;
					}
				}
			}
			//stamp4のカテゴリのパーセントを求める
			for(int k=0; k<10;k++) {
				int s4 = (s4Category[k] / s4Count) * 100;
				s4Percent.add(s4);

			}
			return s4Percent;

	}
	public ArrayList<Integer> s5Calc(ArrayList<BStampsBeans> stamp5){
		ArrayList<Integer> s5Percent = new ArrayList<>();
		//stamp5の行数で押された回数を調べる
		int s5Count = stamp5.size();
		int[] s5Category = new int[10];
			//各カテゴリ何回スタンプが押されたを数え、配列に入れる
			for(int i=0; i<10; i++) {
				for(int j=0; j<10; j++) {
					if(stamp5.get(i).getCategoryId() == j) {
						s5Category[i] += 1;
					}
				}
			}
			//stamp5のカテゴリのパーセントを求める
			for(int k=0; k<10;k++) {
				int s4 = (s5Category[k] / s5Count) * 100;
				s5Percent.add(s4);

			}
			return s5Percent;

	}


}
