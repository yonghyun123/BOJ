package sw_expert.String.Palin2;

import java.util.Scanner;

public class Palin2 {
	
	public static Scanner sc;
	public static int T = 0;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		sc = new Scanner(System.in);
		
		while(T++ < 10){
			int tmpT = sc.nextInt();
			char [][]board = new char[100][100];
			boolean resultFlag = false;
			int result = 0;
			
			for(int i = 0; i < 100; i++){
				String lineInput = sc.next();
				for(int j = 0; j < 100; j++){
					board[i][j] = lineInput.charAt(j);
				}
			}
			
			
			for(int i = 0; i < 100; i++){
				for(int j = 0; j <= i; j++){
					for(int row = 0; row < 100; row++){
						String vPalin = "";
						String hPalin = "";
						for(int k = j; k < 100-i+j; k++){
							vPalin += board[row][k];
							hPalin += board[k][row];
						}
						StringBuffer strBuffer1 = new StringBuffer();
						StringBuffer strBuffer2 = new StringBuffer();

						strBuffer1.append(vPalin);
						strBuffer2.append(hPalin);

						String revVpalin = strBuffer1.reverse().toString();
						String revHpalin = strBuffer2.reverse().toString();

						if(vPalin.equals(revVpalin)){
							resultFlag = true;
							result = 100 - i;
							break;
						}

						if(hPalin.equals(revHpalin)){
							resultFlag = true;
							result = 100 - i;
							break;
						}
					}
					if(resultFlag) break;

				}
				if(resultFlag) break;

			}
		
			
			System.out.println("#"+tmpT+" "+result);


		}
	}

}
