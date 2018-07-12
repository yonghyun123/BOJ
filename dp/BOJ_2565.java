package dp;
import java.util.Scanner;

// 전기줄 문제 LIS 최장 길이 수열 응용
public class BOJ_2565 {
	public static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		int N = sc.nextInt();
		int[] inputArr = new int[501];
		int[] dp = new int[501];
		
		for(int i = 0; i < N; i++){
			int first = sc.nextInt();
			int second = sc.nextInt();
			inputArr[first] = second;
		}
		

		//main logic
		dp[0] = 0;
		int max = 0;
		for(int i = 1; i <= 500; i++){
			if(inputArr[i] == 0) continue;
			dp[i] = 1;
			for(int j = 0; j < i; j++){
				if(inputArr[i] > inputArr[j]  && (dp[j]+1 > dp[i])){
					dp[i] = dp[j]+1;
				}
			}
			max = Math.max(dp[i], max);
		}

		System.out.println(N-max);	
		

	}

}
