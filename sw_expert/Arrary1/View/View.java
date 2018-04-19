package sw_expert.Arrary1.View;

import java.util.Scanner;

public class View {
	public static int T = 0;
	public static int N;
	public static int[] input;
	public static Scanner sc;
	public static int result;
	public static int maxLeft;
	public static int maxRight;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		sc = new Scanner(System.in);
		
		while(T++ < 10){
			result = 0;
			maxRight = 0;
			maxLeft = 0;
			N = sc.nextInt();
			input = new int[N];
			//입력
			for(int i = 0; i < N; i++){
				input[i] = sc.nextInt();
			}
			
			for(int i = 2; i < N; i++){
				// left check and rigth check
				if( (input[i] - input[i-1] > 0) && (input[i] - input[i-2] > 0) && (input[i] - input[i+1] > 0) && (input[i] - input[i+2] > 0) ){
					//left 세대수
					if(input[i-1] > input[i-2]){
						maxLeft = input[i] - input[i-1];
					} else {
						maxLeft = input[i] - input[i-2];
					}
					
					//right 세대수
					if(input[i+1] > input[i+2]){
						maxRight = input[i] - input[i+1];
					} else {
						maxRight = input[i] - input[i+2];
					}
					
					if(maxRight > maxLeft){
						result += maxLeft;
					} else {
						result += maxRight;
					}
					
				}
			}
			
			System.out.println("#"+T+" "+result);
			
		}
	}

}
