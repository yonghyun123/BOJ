package boj_기초;

import java.util.Scanner;

public class BOJ_1748 {
	public static Scanner sc;
	public static int N;
	public static void main(String[] args) {
		sc = new Scanner(System.in);
		N = sc.nextInt();
		int result = 0;
		
		for(int i = 1; i <= N; i++){
			String tempStr = Integer.toString(i);
			result += tempStr.length();
		}
		
		System.out.println(result);

	}

}
