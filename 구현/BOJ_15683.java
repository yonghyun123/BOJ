package 구현;

import java.util.Scanner;

/*
 * 백준 15683 감시 
 * 완전탐색
 * 이건 꼭 풀어야해
 */
public class BOJ_15683 {
	public static Scanner sc = new Scanner(System.in);
	public static int row, col;
	
	public static void main(String[] args) {
		row = sc.nextInt();
		col = sc.nextInt();
		
		int[][] board = new int[row][col];
		for(int i = 0; i < row; i++){
			for(int j = 0; j < col; j++){
				board[i][j] = sc.nextInt();
			}
		}
		
		
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[i].length; j++) {
				System.out.print(board[i][j] + " ");
			}
			System.out.println();
		}
	}
	
	public static void spreadView(int[][] board, int[][] visited){
		
	}
	
	public static void dfs(int[][] board, int[][] visited){
		
	}

}
