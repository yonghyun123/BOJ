package sw_expert.String.Palin;

import java.util.Scanner;

public class Palin {
	public static Scanner sc;
	public static int T = 0;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		sc = new Scanner(System.in);
		
		while(T++ < 10){
			int findlen = sc.nextInt();
			char [][]board = new char[8][8];
			int result = 0;
			
			//char형 board 입력하는 방법
			for(int i = 0; i < 8; i++){
				String input = sc.next();
				for(int j = 0; j < 8; j++){
					board[i][j] = input.charAt(j);
				}
			}
			
			
			//반복 횟수 (8 - findlen) + 1
			for(int i = 0; i < 8; i++){
				for(int j = 0; j < 8-findlen+1; j++){
					String Hpalin = "";
					String Vpalin = "";
					for(int k = j; k < findlen+j; k++){
						 Hpalin += board[i][k];
						 Vpalin += board[k][i];
					}
//					System.out.println(Hpalin);
//					System.out.println(Vpalin);
					StringBuffer stBuffer1 = new StringBuffer();
					StringBuffer stBuffer2 = new StringBuffer();

					
					stBuffer1.append(Hpalin);
					stBuffer2.append(Vpalin);
					String revHpalin = stBuffer1.reverse().toString();
					String revVpalin = stBuffer2.reverse().toString();
					
					
					if(Hpalin.equals(revHpalin)){
						result += 1;
					}
					if(Vpalin.equals(revVpalin)){
						result += 1;
					}
				}				
			}
			System.out.println("#"+T+" "+result);

			
		}
	}

}
