package 구현;

import java.util.Scanner;

public class BOJ_1598 {
	public static Scanner sc = new Scanner(System.in);
	public static void main(String[] args) {
		double start = sc.nextInt();
		double end = sc.nextInt();
		
		int topBottom = Math.abs(getRemainder(start)-getRemainder(end));
		int left = (int)Math.ceil(start/4);
		int right = (int)Math.ceil(end/4);
		
		int leftRight = Math.abs(right-left);
//		System.out.println(topBottom);
//		System.out.println(leftRight);;
		System.out.println(topBottom+leftRight);
	
		
	}
	
	public static int getRemainder(double input){
		switch((int)input % 4){
		case 1: return 0; //첫번째칸
		case 2: return 1; //2번째칸
		case 3: return 2; //3번째칸
		case 0: return 3; //4번째칸
		default: return -1; //실패
		}
	}
}
