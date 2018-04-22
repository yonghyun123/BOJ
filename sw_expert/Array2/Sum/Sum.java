package sw_expert.Array2.Sum;

import java.util.Scanner;

public class Sum {
	public static Scanner sc;
	public static int T = 0;
	public static int [][]board;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		sc = new Scanner(System.in);
		
		while(T < 10){
			//input data 
			//문제 잘못이해함
			int tmpT = sc.nextInt();
			board = new int[101][101];
			for(int i = 0; i < 100; i++){
				for(int j = 0; j < 100; j++){
					board[i][j] = sc.nextInt();
				}
			}
			
			//algorithm logic
			for(int i = 0; i < 100; i++){
				int rowSum = 0;
				int colSum = 0;
				int crossSum = 0;
				
				for(int j = 0; j < 100; j++){
					rowSum += board[i][j];
					colSum += board[j][i];
				}
			}
			
		}
	}

}
