package sw_expert.Array2.Sum;

import java.util.Scanner;

public class Sum {
	public static Scanner sc;
	public static int T = 0;
	public static int [][]board;
	public static int leftCross;
	public static int rightCross;
	public static int []result;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		sc = new Scanner(System.in);
		
		while(T++ < 10){
			//input data 
			//문제 잘못이해함
			int tmpT = sc.nextInt();
			board = new int[100][100];
			leftCross = 0;
			rightCross = 0;
			int idx = 0;
			int max = 0;
			
			for(int i = 0; i < board.length; i++){
				for(int j = 0; j < board[i].length; j++){
					board[i][j] = sc.nextInt();
				}
			}
			
			//algorithm logic
			for(int i = 0; i < 100; i++){
				int rowSum = 0;
				int colSum = 0;
				
				for(int j = 0; j < 100; j++){
					rowSum += board[i][j];
					colSum += board[j][i];
				}	
				
				if(rowSum > colSum ){
					if(max < rowSum) max = rowSum;
				} else {
					if(max < colSum) max = colSum;
				}
				leftCross += board[i][i];
				rightCross += board[i][99-i];
			}
			
			if(leftCross > rightCross){
				if(max < leftCross) max = leftCross;
			} else {
				if(max < rightCross) max = rightCross;
			}
			
			
			System.out.println("#"+tmpT+" "+max);
			
		}
	}

}
