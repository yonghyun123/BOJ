package boj_기초;

import java.util.Scanner;

public class BOJ_11720 {
	
	public static Scanner sc;
	public static int N;
	public static int result = 0;

	public static void main(String[] args) {
		sc = new Scanner(System.in);
		N = sc.nextInt();
		String str = sc.next();
		
		for(int i = 0; i < str.length(); i++){
			result += Character.getNumericValue(str.charAt(i));
		}
		System.out.println(result);
	}

}
