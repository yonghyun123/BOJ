package sw_expert.Array2.Ladder1;

import java.util.Scanner;

public class Ladder1 {
	public static Scanner sc;
	public static int T = 0;
	public static int[] dY = {1, -1, 0}; //new column 계산
	public static int[] dX = {0, 0, 1}; //new row 계산
	public static boolean [][]visited;
	public static int finalDes;
	public static int result;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		sc = new Scanner(System.in);
		
		while(T++ < 10){
			int tmpT = sc.nextInt();
			int [][]board = new int[10][10];
			visited = new boolean[10][10];
			finalDes = 0;
			result = 0;
			
			for(int i = 0; i < 10; i++){
				for(int j = 0; j < 10; j++){
					board[i][j] = sc.nextInt();
				}
			}
			
			for(int i = 0; i < 10; i++){
				finalDes = 0;
				if(board[0][i] == 1 && !visited[0][i]){
					
					dfs(board, 0, i);
					System.out.println(finalDes);
					System.out.println("i"+i);
					if(finalDes == 2){
						result = i;
						System.out.println("여기들어와?"+i);
						break;
					}
				}

				visited = new boolean[10][10];
			}


			System.out.println("#"+1+" "+result);
			
		}
	}
	
	public static void dfs(int [][]board, int curRow, int curCol){
		if(finalDes != 0) return;
		visited[curRow][curCol] = true;
		System.out.println("row:"+curRow+", "+"col:"+curCol);
		if(curRow == 9){
			finalDes = board[curRow][curCol];
			System.out.println(finalDes);
			return;
		}
		for(int i = 0; i < 3; i++){
			int nextRow = dX[i] + curRow;
			int nextCol = dY[i] + curCol;
			if(finalDes != 0){
				return;
			}
			if(nextRow < 0 || nextRow > 9 || nextCol < 0 || nextCol > 9) continue;
			if(!visited[nextRow][nextCol] && board[nextRow][nextCol] != 0){
				dfs(board, nextRow, nextCol);
			}
			if(finalDes != 0){
				return;
			}
		}
		
	}

}
