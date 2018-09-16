package boj_기초;

import java.util.Scanner;

public class BOJ_5532 {
	public static Scanner sc;
	public static int vacation;
	public static int totalMath;
	public static int totalKorean;
	public static int maxMath;
	public static int maxKorean;
	
	public static void main(String[] args) {
		sc = new Scanner(System.in);
		vacation = sc.nextInt();
		totalMath = sc.nextInt();
		totalKorean = sc.nextInt();
		maxMath = sc.nextInt();
		maxKorean = sc.nextInt();
		
		int dayCnt = 0;
		for(int i = 0; i < vacation; i++){
			if(totalMath <= 0 && totalKorean <= 0){
				//break 분기
				dayCnt = i;
				break;
			}
			totalMath -= maxMath;
			totalKorean -= maxKorean;
		}
		System.out.println(vacation - dayCnt);
	}
}
