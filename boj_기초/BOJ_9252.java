package boj_기초;

import java.util.ArrayList;
import java.util.Scanner;

public class BOJ_9252 {
	public static Scanner sc = new Scanner(System.in);
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList<String> lisList = new ArrayList<>();
		
		String input = sc.next();
		String input2 = sc.next();
		
		int[] dp = new int[input.length()];
		dp[0] = 1;
		
		for(int i = 1; i < input.length(); i++){
			dp[i] = 1;
			String tempStr = "";
			
			for(int j = 0; j < i; j++){
				if(input.charAt(i) > input.charAt(j) && dp[j] + 1 > dp[i]){
					dp[i] = dp[j]+1;
					tempStr += input.charAt(j);
				}
			}
			lisList.add(tempStr);
		}
		
		for(String item : lisList){
			System.out.println(item);
		}
	}

}
