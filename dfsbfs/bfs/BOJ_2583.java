package dfsbfs.bfs;
//영역구하기 bfs

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BOJ_2583 {
	
	public static Scanner sc = new Scanner(System.in);
	public static int R, C, K;
	public static int[] dRow = {0,1,0,-1};
	public static int[] dCol = {1,0,-1,0};
	public static int callCnt = 0;
	public static void main(String[] args) {
		R = sc.nextInt();
		C = sc.nextInt();
		K = sc.nextInt();
		
		int[][] board = new int[R][C];
		ArrayList<Integer> resultList = new ArrayList<>();
		
		for(int i = 0; i < K; i++){
			int startCol = sc.nextInt();
			int startRow = sc.nextInt();
			int endCol = sc.nextInt();
			int endRow = sc.nextInt();
			
			for(int j = startRow; j < endRow; j++){
				for(int k = startCol; k < endCol; k++){
					board[j][k] = 1;
				}
			}
		}
		
//		뒤집힌 board 그대로해도 상관없을듯..
		for(int i = 0; i < R; i++){
			for(int j = 0; j < C; j++){
				if(board[i][j] == 0){
					int[] startPos = {i,j};
					resultList.add(bfs(board, startPos));
				}
			}
		}
		System.out.println(callCnt);
		Collections.sort(resultList);
		for(int item : resultList){
			System.out.print(item+" ");
		}
		
		
	}
	public static int bfs(int[][] board, int[] start){
		callCnt++;
		boolean[][] visited = new boolean[R][C];
		Queue<int[]> q = new LinkedList<>();
		int resultArea = 1;
		
		q.add(start);
		visited[start[0]][start[1]] = true;
		
		while(!q.isEmpty()){
			int curRow = q.peek()[0];
			int curCol = q.peek()[1];
			q.poll();
			
			for(int i = 0; i < 4; i++){
				int nextRow = curRow + dRow[i];
				int nextCol = curCol + dCol[i];
				
				if(nextRow < 0 || nextRow >= R || nextCol < 0 || nextCol >= C) continue;
				if(!visited[nextRow][nextCol] && board[nextRow][nextCol] == 0){
					visited[nextRow][nextCol] = true;
					board[nextRow][nextCol] = 1;
					int[] nextPos = {nextRow, nextCol};
					q.add(nextPos);
					resultArea += 1;
				}
			}
			
		}
		return resultArea;
		
	}

}
