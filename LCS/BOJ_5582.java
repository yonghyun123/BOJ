package LCS;

import java.util.Scanner;

public class BOJ_5582 {
	public static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String inputStr = sc.next();
		String inputStr2 = sc.next();
		int result = 0;
		
		int[][] dp = new int[inputStr.length()+1][inputStr2.length()+1];
		
		for(int i = 1; i <= inputStr.length(); i++){
			for(int j = 1; j <= inputStr2.length(); j++){
				if(inputStr.charAt(i-1) == inputStr2.charAt(j-1)){
					dp[i][j] = dp[i-1][j-1]+1;
					
					if(result < dp[i][j]) result = dp[i][j];
				}
			}
		}
		System.out.println(result);
		

	}

}
