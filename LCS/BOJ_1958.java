package LCS;

import java.util.Scanner;

public class BOJ_1958 {
	public static Scanner sc = new Scanner(System.in);
	
	public static void main(String[] agrs){
		String input = sc.next();
		String input2 = sc.next();
		String input3 = sc.next();
		
		int[][][]dp = new int[input.length()+1][input2.length()+1][input3.length()+1];
		
		for(int i = 1; i <=input.length(); i++){
			for(int j = 1; j <= input2.length(); j++){
				for(int k = 1; k <= input3.length(); k++){
					if((input.charAt(i-1) == input2.charAt(j-1)) && (input2.charAt(j-1) == input3.charAt(k-1))){
						dp[i][j][k] = dp[i-1][j-1][k-1] + 1;
					} else{
						dp[i][j][k] = Math.max(Math.max(dp[i-1][j][k],dp[i][j-1][k]), dp[i][j][k-1]);
					}
				}
			}
		}
		System.out.println(dp[input.length()][input2.length()][input3.length()]);
		
	}

}
