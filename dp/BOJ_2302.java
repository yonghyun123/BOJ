package dp;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.logging.Logger;

public class BOJ_2302 {
	public static Scanner sc = new Scanner(System.in);
	public static int[] dp;

	public static void main(String[] args) {
		int N = sc.nextInt();
		int fixN = sc.nextInt();
		int sum = 1;
		dp = new int[N+1];
		int max = getFiboPattern(N);
		
		int temp = 0;
		for(int i = 0; i < fixN; i++){
			int royalSeat = sc.nextInt();
			sum *= dp[royalSeat-1-temp];
			temp = royalSeat;	
		}
		
		System.out.println(sum*dp[N-temp]);
		
	}
	
	public static int getFiboPattern(int n){
		if(n == 0) return dp[n] = 1;
		if(n == 1) return dp[n] = 1;
		if(dp[n] == 0 && n >= 2) {
			dp[n] = getFiboPattern(n-1) +  getFiboPattern(n-2);
		}
		return dp[n];
	}

}
