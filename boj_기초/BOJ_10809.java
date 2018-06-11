package boj_기초;

import java.util.Scanner;

public class BOJ_10809 {
	public static Scanner sc;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		sc = new Scanner(System.in);
		String str = sc.next();
		int []alpha = new int[26];
		for(int i = 0; i < 26; i++){
			alpha[i] = -1;
		}
		
		for(int i = 0; i < str.length(); i++){
			int val = str.charAt(i) - 97;
			if(alpha[val] != -1) continue;
			alpha[val] = i;
		}
		
		for(int i = 0; i < 26; i++){
			System.out.print(alpha[i] + " ");
		}
	}

}
