package boj_기초;

import java.util.Arrays;
import java.util.Scanner;

public class BOJ_2437 {
	public static Scanner sc = new Scanner(System.in);
	
	public static void main(String[] args) {
		int N = sc.nextInt();
		int []input = new int[N];
		int result = 0;
		
		for(int i = 0; i < N; i++){
			input[i] = sc.nextInt();
		}
		Arrays.sort(input);
		
		for(int i = 0; i < N; i++){
			if(result+1 < input[i]) break;
			else {
				result+=input[i];
			}
		}
		System.out.println(result+1);
	}
}
