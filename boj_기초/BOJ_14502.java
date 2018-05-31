package boj_기초;

import java.util.Scanner;

public class BOJ_14502 {
	public static Scanner sc;
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int [][]board = {
				{0,0,0,0},
				{0,0,0,0},
				{0,0,0,0},
				{0,0,0,0}
		};
		dfs(board,0,0);
		
	}
	public static void dfs(int [][]board, int cnt, int stack){
		
		if(cnt == 3){
			//dfs check code
			for(int i = 0; i < board.length; i++){
				for(int j = 0; j < board[i].length; j++){
					System.out.print(board[i][j]);
				}
				System.out.println();
			}
			System.out.println();
			return;
		}
		
		for(int i = 0; i < 4; i++){
			for(int j = 0; j < 4; j++){
				if(board[i][j] == 0){
					board[i][j] = 1;
					System.out.println(stack+"번째 스택입니다");
					dfs(board, cnt+1, stack+1);
					board[i][j] = 0;
				}
			}
		}
	}

}
