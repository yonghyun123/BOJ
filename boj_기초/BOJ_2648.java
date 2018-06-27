package boj_기초;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BOJ_2648 {

	public static Scanner sc = new Scanner(System.in);
	public static int N;

	public static int[] dRow = { 0, 1, 0, -1 };
	public static int[] dCol = { 1, 0, -1, 0 };
	public static int rainH = 0;
	public static boolean[][] visited;

	public static void main(String[] args) {
		N = sc.nextInt();
		int[][] board = new int[N][N];
		int[][] copy = new int[N][N];
		visited = new boolean[N][N];
		
		int max = -9999999;

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				board[i][j] = sc.nextInt();
				copy[i][j] = board[i][j];
			}
		}

		// 완전 탐색하기전에 graph를 copy 해야함
		// copy한 그래프당 안전영역을 구해야함
		while (!isZero(copy)) {
			
			int safeZone = 0;
		
			for(int i = 0; i < N; i++){
				for(int j = 0; j < N; j++){
					if(!visited[i][j] && copy[i][j] > 0){
						int[] temp = {i,j};
						safeZone += bfs(temp, copy);
					}
				}
			}
			if(safeZone >= max) max = safeZone;
			
			rainH += 1;
			
			//init state
			visited = new boolean[N][N];
			copy = changedBoard(board, rainH);
		}
		System.out.println(max);

	}
	
	public static int[][] changedBoard(int[][] copy, int cnt){
		int[][] tmpBoard = new int[N][N];
		
		
		for(int i = 0; i < N; i++){
			for(int j = 0; j < N; j++){
				tmpBoard[i][j] = copy[i][j]-cnt;
			}
		}
		return tmpBoard;
	}

	public static boolean isZero(int[][] copy) {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (copy[i][j] > 0)
					return false;
			}
		}
		return true;
	}

	public static int bfs(int[] start, int[][] board) {
		Queue<int[]> q = new LinkedList<>();

		q.add(start);
		visited[start[0]][start[1]] = true;

		while (!q.isEmpty()) {
			int curRow = q.peek()[0];
			int curCol = q.peek()[1];
			q.poll();

			for (int i = 0; i < 4; i++) {
				int nextRow = curRow + dRow[i];
				int nextCol = curCol + dCol[i];

				if (nextRow < 0 || nextRow >= N || nextCol < 0 || nextCol >= N)
					continue;
				if (!visited[nextRow][nextCol] && board[nextRow][nextCol] > 0) {
					int[] tempItem = { nextRow, nextCol };
					q.add(tempItem);
					visited[nextRow][nextCol] = true;
				}
			}
		}
		
		return 1;
		
	}

}
