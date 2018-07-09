package boj_기초;

import java.util.Arrays;
import java.util.Scanner;

public class BOJ_1965 {
	
	public static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		int N = sc.nextInt();
		int[] arr = new int[N];
		int[] dp = new int[N];
		
		for(int i = 0; i < N; i++){
			arr[i] = sc.nextInt();
		}
		
		dp[0] = 1;
		
		for(int i = 1; i < N; i++){
			dp[i] = 1;
			
			for(int j = 0; j < i; j++){
				if(arr[i] > arr[j] && dp[j]+1 > dp[i]){
					dp[i] = dp[j]+1;
				}
			}
		}
		Arrays.sort(dp);
		System.out.println(dp[N-1]);

	}

}
