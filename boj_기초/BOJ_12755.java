package boj_기초;

import java.util.Scanner;

public class BOJ_12755 {
	public static Scanner sc;
	public static int idx = 1;
	public static int nCount = 1;
	public static char result;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		sc = new Scanner(System.in);
		int N = sc.nextInt();
		
		while(N > 0){
			String str = Integer.toString(idx);
			idx++;
			N -= str.length();
			if(N <= 0){
				System.out.println(str.charAt((str.length()-1) + N));
			}
		}

	}

}
