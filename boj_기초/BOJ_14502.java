package boj_기초;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BOJ_14502 {
	public static Scanner sc;
	// 우 하 좌 상
	public static int []dRow = {0, 1, 0, -1}; //delta 행 
	public static int []dCol = {1, 0, -1, 0}; //delta 열
	public static int result = 987654321; 
	public static boolean [][]visited;
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		int [][]board = {
				{1,0,1,0},
				{2,0,0,2},
				{0,1,0,0},
				{0,0,0,0}
		};
		dfs(board,0);
		System.out.println(result);
		
	}
	public static int spreadVirus(int [][]board){
		int tempCnt = 0;
		Queue<int[]> bfsQ = new LinkedList<>();
		visited = new boolean[4][4];
		int [][]tempBoard = new int[4][4];
		//copy board
		for(int i = 0; i < 4; i++){
			for(int j = 0; j < 4; j++){
				tempBoard[i][j] = board[i][j];
			}
		}
		
		for(int i = 0; i < 4; i++){
			for(int j = 0; j < 4; j++){
				if(tempBoard[i][j] == 2){
					int []temp = {i,j};
					visited[i][j] = true;
					bfsQ.add(temp);
				}
			}
		}
		
		while(!bfsQ.isEmpty()){
			
			int []curPos = bfsQ.poll();
			int curRow = curPos[0];
			int curCol = curPos[1];
			
			for(int i = 0; i < 4; i++){
				int nextRow = dRow[i] + curRow;
				int nextCol = dCol[i] + curCol;
				
				if(nextCol < 0 || nextCol > 3 || nextRow < 0 || nextRow > 3) continue; //boundary check
				if(tempBoard[nextRow][nextCol] == 0 && !visited[nextRow][nextCol]){
					int []nextPos = {nextRow, nextCol};
					tempBoard[nextRow][nextCol] = 2;
					bfsQ.add(nextPos);
					visited[nextRow][nextCol] = true;
				}
			}
		}
		
		for(int i = 0; i < 4; i ++){
			for(int j = 0; j < 4; j++){
				if(tempBoard[i][j] == 2) tempCnt += 1;
//				System.out.print(tempBoard[i][j]);
			}
//			System.out.println();
		}
//		System.out.println(tempCnt);
		return tempCnt;
		
		

	}
	
	public static void dfs(int [][]board, int cnt){
		
		if(cnt == 3){
			result = result < spreadVirus(board) ?  result : spreadVirus(board) ;
			return;
		}
		
		for(int i = 0; i < 4; i++){
			for(int j = 0; j < 4; j++){
				if(board[i][j] == 0){
					board[i][j] = 1;
					dfs(board, cnt+1);
					board[i][j] = 0;
				}
			}
		}
	}

}
