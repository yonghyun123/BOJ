package dfsbfs;
//토마토

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BOJ_7576 {
	public static Scanner sc = new Scanner(System.in);
	public static int Row;
	public static int Col;
	public static int[] dRow = {0,1,0,-1};
	public static int[] dCol = {1,0,-1,0};

	public static void main(String[] args) {
		Col = sc.nextInt();
		Row = sc.nextInt();
	
		int[][] board = new int[Row][Col];
		ArrayList<int[]> startList = new ArrayList<>();
		
		for(int i = 0; i < Row; i++){
			for(int j = 0; j < Col; j++){
				board[i][j] = sc.nextInt();
				if(board[i][j] == 1){
					int[] temp = {i,j};
					startList.add(temp);
				}
			}
		}
		//우선적으로 토마토가 다 익었는지 체크
		if(isRipen(board)){
			System.out.println("0");
		} else {
			
			for(int[] item : startList){
				//bfs 시작
				int i = item[0];
				int j = item[1];
				int[] start = {i,j,0};
				bfs(board,start);
				
			}
			if(isRipen(board)){
				System.out.println(getMax(board));
			} else {
				System.out.println("-1");
			}
			
		}
	}
	public static int getMax(int[][] board){
		int max = 0;
		for(int i = 0; i < Row; i++){
			for(int j = 0; j < Col; j++){
				if(board[i][j] > max) max = board[i][j];
			}
		}
		return max;
	}
	
	public static void bfs(int[][] board, int[] start){
		
		Queue<int[]> q = new LinkedList<>();
		int[] startPos = start;
		q.add(startPos);
		
		while(!q.isEmpty()){
			int curRow = q.peek()[0];
			int curCol = q.peek()[1];
			int curCnt = q.peek()[2];
			q.poll();
			
			for(int i = 0; i < 4; i++){
				int nextRow = curRow + dRow[i];
				int nextCol = curCol + dCol[i];
				if(nextRow < 0 || nextRow >= Row || nextCol < 0 || nextCol >= Col) continue;
				if(board[nextRow][nextCol] == -1) continue;
				if(board[nextRow][nextCol] == 0){
					int[] nextPos = {nextRow, nextCol, curCnt+1};
					board[nextRow][nextCol] = curCnt+1;
					q.add(nextPos);
				} else {
					if(curCnt+1 < board[nextRow][nextCol]){
						int[] nextPos = {nextRow, nextCol, curCnt+1};
						board[nextRow][nextCol] = curCnt+1;
						q.add(nextPos);
					}
				}
			}
		}
		

	}
	public static boolean isRipen(int[][] board){
		for(int i = 0; i < Row; i++){
			for(int j = 0; j < Col; j++){
				if(board[i][j] == 0) return false;
			}
		}
		return true;
	}
}
