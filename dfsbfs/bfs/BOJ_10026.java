package dfsbfs.bfs;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BOJ_10026 {
	
	public static Scanner sc = new Scanner(System.in);
	public static int[] dRow = {0,1,0,-1};
	public static int[] dCol = {1,0,-1,-0};
	
	
	public static int N;
	public static int result = 0;
	
	
	public static void main(String[] args) {
		N = sc.nextInt();
		char[][] board = new char[N][N];
		char[][] copy = new char[N][N];
		boolean[][] visited = new boolean[N][N];
		
		for(int i = 0; i < N; i++){
			String inputStr = sc.next();
			
			for(int j = 0; j < inputStr.length(); j++){
				board[i][j] = inputStr.charAt(j);
				if(inputStr.charAt(j) == 'R'){
					copy[i][j] = 'G';
				} else {
					copy[i][j] = inputStr.charAt(j);
				}
			}
		}
		
		for(int i = 0; i < N; i++){
			for(int j = 0; j < N; j++){
				if(!visited[i][j]){
					int[] sPos = {i,j};
					bfs(board, visited, sPos, board[i][j]);
					
				}
			}
		}
		
		System.out.print(result+" ");
		visited = new boolean[N][N];
		result = 0;
		for(int i = 0; i < N; i++){
			for(int j = 0; j < N; j++){
				if(!visited[i][j]){
					int[] sPos = {i,j};
					bfs(copy, visited, sPos, copy[i][j]);
					
				}
			}
		}
		
		System.out.println(result);
		
	}
	
	public static void bfs(char[][] board, boolean[][] visited, int[] start, char color){
		result++;
		Queue<int[]> q = new LinkedList<>();
		q.add(start);
		visited[start[0]][start[1]] = true;
		
		while(!q.isEmpty()){
			int curRow = q.peek()[0];
			int curCol = q.peek()[1];
			q.poll();
			
			for(int i = 0; i < 4; i++){
				int nextRow = curRow + dRow[i];
				int nextCol = curCol + dCol[i];
				
				if(nextRow < 0 || nextRow >= N || nextCol < 0 || nextCol >= N) continue;
				if(!visited[nextRow][nextCol] && board[nextRow][nextCol] == color){
					int[] nextPos = {nextRow, nextCol};
					q.add(nextPos);
					visited[nextRow][nextCol] = true;
				}
			}
		}
	}
}
