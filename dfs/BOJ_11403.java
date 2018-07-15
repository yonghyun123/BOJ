package dfs;

import java.util.Scanner;

public class BOJ_11403 {
	public static Scanner sc = new Scanner(System.in);
	
	public static void main(String[] args){
		int N = sc.nextInt();
		
		int[][] board = new int[N][N];
		int[] visited = new int[N];
		int[][] result = new int[N][N];
		
		for(int i = 0; i < N; i++){
			for(int j = 0; j < N; j++){
				board[i][j] = sc.nextInt();
			}
		}
		
		for(int i = 0; i < N; i++){
			visited = new int[N];
			dfs(board,i,visited);
			for(int j = 0; j < N; j++){
				result[i][j] = visited[j];
			}
		}
		for(int i = 0; i < N; i++){
			for(int j = 0; j < N; j++){
				System.out.print(result[i][j]+" ");
			}
			System.out.println();
		}
	}
	
	public static void dfs(int[][] board, int startNode, int[] visited){
		
		for(int i = 0; i < board.length; i++){
			if(board[startNode][i] == 1 && visited[i] != 1){
				visited[i] = 1;
				dfs(board,i,visited);
			}
		}
	}

}
