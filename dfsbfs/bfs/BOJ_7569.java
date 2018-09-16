package dfsbfs.bfs;

import java.util.Scanner;

public class BOJ_7569 {
	
	public static Scanner sc = new Scanner(System.in);
	public static int R, C, H;
	
	public static int[] dRow = {0, 1, 0,-1, 0, 0};
	public static int[] dCol = {1, 0,-1, 0, 0, 0};
	public static int[] dHei = {0, 0, 0, 0,-1, 1};

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		C = sc.nextInt();
		R = sc.nextInt();
		H = sc.nextInt();
		
		//H가 맨앞에 있는 것이 포인트
		int[][][] board = new int[H][R][C];
		
		for(int i = 0; i < H; i++){
			for(int j = 0; j < R; j++){
				for(int k = 0; k < C; k++){
					board[i][j][k] = sc.nextInt();
				}
			}
		}
		
		for(int i = 0; i < H; i++){
			for(int j = 0; j < R; j++){
				for(int k = 0; k < C; k++){
					System.out.print(board[i][j][k]);
				}
				System.out.println();
			}
			System.out.println();
		}
	}
}
