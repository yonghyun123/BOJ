package sw_expert.Array2.Ladder2;

import java.util.Scanner;

public class Ladder2 {
	public static Scanner sc;
	public static int[][] board;
	public static int T = 0;
	public static boolean [][]visited;
	
	public static int step = 0;
	public static boolean finalFlag = false;
	
	public static int []dX = {0, 0, 1}; //new row
	public static int []dY = {1, -1, 0}; //new column
	
	//이동좌표 오른쪽 -> 왼쪽 -> 아래
	
	public static void main(String[] args){
		sc = new Scanner(System.in);
		while(T++ < 10){
			int tmpT = sc.nextInt();
			int min = 99999;
			int result = 0;

			board = new int[100][100];
			visited = new boolean[100][100];
			
			//input data
			for(int i = 0; i < board.length; i++){
				for(int j = 0; j < board[i].length; j++){
					board[i][j] = sc.nextInt();
				}
			}
			
			//column by column compare
			for(int i = 0; i < board[0].length; i++){
				step = 0;
				finalFlag = false;
				if(!visited[0][i] && board[0][i] == 1){
					search(board, 0, i);
				}
//				System.out.println("i="+i+", step="+step);
				if(step != 0 && min >= step) {
					min = step;
					result = i;
				}
				
				visited = new boolean[100][100];
			}
			System.out.println("#"+tmpT+" "+result);
			
		}
	}
	
	public static void search(int [][]board, int curX, int curY){
		visited[curX][curY] = true;
		if(curX == 99){
			//총합이 들어감
			finalFlag = true;
			
			return;
		}
		//다음좌표 돌려가면서 구하기
		for(int i = 0; i < 3; i++){
			int nextX = curX + dX[i];
			int nextY = curY + dY[i];
			if(!isBoundary(nextX, nextY)) continue;
			if(!visited[nextX][nextY] && board[nextX][nextY] != 0){
				step += 1;
				search(board, nextX, nextY);
			}
			if(finalFlag){
				return;
			}
		}
	}
	
	public static boolean isBoundary(int nextX, int nextY){
		if(nextX < 0 || nextX > 99 || nextY < 0 || nextY > 99) return false;
		else return true;
	}
}
