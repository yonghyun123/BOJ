package LCS;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class BOJ_9252 {
	public static Scanner sc = new Scanner(System.in);
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String input = sc.next();
		String input2 = sc.next();
		StringBuilder sb = new StringBuilder();
		int[][] dp = new int[input.length()+1][input2.length()+1];
		String[][] position = new String[input.length()+1][input2.length()+1];
		
		for(int i = 0; i <= input.length(); i++){
			Arrays.fill(position[i], " "); 
		}
		
		for(int i = 1; i <= input.length(); i++){
			for(int j = 1; j <=input.length(); j++){
				if(input.charAt(i-1) == input2.charAt(j-1)){
					
					position[i][j] = "Correct";
					dp[i][j] = dp[i-1][j-1] + 1;
				} else {
					dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
					if(dp[i][j] == dp[i-1][j]){
						position[i][j] = "top";
					} else {
						position[i][j] = "left";
					}
				}
			}
		}
		
		int a = input.length();
		int b = input2.length();
		
		while(position[a][b] != " " && a >=0  && b >= 0){
			if(position[a][b].equals("Correct")){
				sb.append(input.charAt(a-1));
				a--;
				b--;
			} else if(position[a][b].equals("top")){
				a--;
			} else if(position[a][b].equals("left")){
				b--;
			}
		}
		System.out.println(dp[input.length()][input2.length()]);
		
		
		System.out.println(sb.reverse().toString());
	}

}
