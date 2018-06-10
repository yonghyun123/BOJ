package boj_기초;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BOJ_2638 {
	public static Scanner sc;
	public static int Row;
	public static int Col;
	public static int[][] board;
	public static boolean[][] visited;
	public static ArrayList<int[]> storePos;
	public static boolean cntFlag;
	//delta 우하좌상
	public static int[] dRow = {0,1,0,-1};
	public static int[] dCol = {1,0,-1,0};
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		sc = new Scanner(System.in);
		storePos = new ArrayList<>();
		
		Row = sc.nextInt();
		Col = sc.nextInt();
		
		board = new int[Row][Col];
		visited = new boolean[Row][Col];
		
		for(int i = 0; i < Row; i++){
			for(int j = 0; j < Col; j++){
				board[i][j] = sc.nextInt();
			}
		}
		
		bfs(0,0);
		
		for(int i = 0; i < Row; i++){
			for(int j = 0; j < Col; j++){
				System.out.print(board[i][j]);
			}
			System.out.println();
		}
		
		//main logic
		while(!isFillZero()){
			for(int i = 0; i < Row; i++){
				for(int j = 0; j < Col; j++){
					int checkCnt = 0;
					cntFlag = false;
					//2면 이상 공기인지 검사
					if(board[i][j] == 1){
						for(int k = 0; k < 4; k++){
							int nextR = dRow[k] + i;
							int nextC = dCol[k] + j;
							
							if(nextR < 0 || nextR >= Row || nextC < 0|| nextC >= Col) continue;
							if(board[nextR][nextC] == -1){
								checkCnt += 1;
								if(checkCnt >= 2){
									cntFlag = true;
									break;
								}
							}
						}
						if(cntFlag){
							int []promising = {i,j};
							storePos.add(promising);
						}

					}
				}
			}
			/* 전체 탐색 끝
			 * 1. 다시 bfs (0 -> -1)
			 * 2. 치즈녹이기 (1 -> -1)
			 * 
			 */
		
			
		}
			
		for(int[] item : storePos){
			System.out.println(item[0]+","+item[1]);
		}
		
		
	}
	public static boolean isFillZero(){
		for(int i = 0; i < Row; i++){
			for(int j = 0; j < Col; j++){
				if(board[i][j] != -1) return false;
			}
		}
		
		return true;
		
	}
	
	public static void bfs(int row, int col){
		Queue<int[]> bfsQ = new LinkedList<>();
		int []temp = {row,col};
		bfsQ.add(temp);
		//굳이 방문 안써도 될것같은데
//		visited[row][col] = true;
		
		while(!bfsQ.isEmpty()){
			int curR = bfsQ.peek()[0];
			int curC = bfsQ.peek()[1];
			
			bfsQ.poll(); 
			for(int i = 0; i < 4; i ++){
				int nextR = dRow[i] + curR;
				int nextC = dCol[i] + curC;
				if(nextR < 0 || nextR >= Row || nextC < 0 || nextC >= Col) continue;
				if(board[nextR][nextC] == 0){
					board[nextR][nextC] = -1;
					int []tempPosition = {nextR, nextC};
					bfsQ.add(tempPosition);
				}
			}
		}
	}

}
