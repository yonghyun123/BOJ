package LCS;

public class exLCS {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String input = "ccccccabcd";
		String input2 = "abce";
		int ans = 0;
		//배열 크기는 각각 string 길이
		int [][]dp = new int[input.length()+1][input2.length()+1];
		
		for(int i = 1; i <= input.length(); i++){
			for(int j = 1; j <= input2.length(); j++){
				
				if(input.charAt(i-1) == input2.charAt(j-1)){
					dp[i][j] = dp[i-1][j-1] + 1;
					if(ans < dp[i][j]) ans = dp[i][j];
				}
			}
		}
		System.out.println(ans);

	}

}
