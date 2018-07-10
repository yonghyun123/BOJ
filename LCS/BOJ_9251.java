package LCS;

import java.util.Scanner;

public class BOJ_9251 {
	public static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		String input = sc.next();
		String input2 = sc.next();
		
		int[][] dp = new int[input.length()+1][input2.length()+1];
		
		
		for(int i = 1; i <= input.length(); i++){
			for(int j = 1; j <= input2.length(); j++){
				if(input.charAt(i-1) == input2.charAt(j-1)){
//					System.out.println("i="+i+", j="+j);
					dp[i][j] = dp[i-1][j-1] + 1;
				} else {
					dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
				}
			}
		}
		
		for(int i = 1; i <= input.length(); i++){
			for(int j = 1; j <= input2.length(); j++){
				System.out.print(dp[i][j]);
			}
			System.out.println();
		}
		
		
		System.out.println(dp[input.length()][input2.length()]);

	}

}
