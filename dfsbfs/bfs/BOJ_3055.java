package dfsbfs.bfs;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

// 탈출문제 
/*
 * 물이 차오르면서 고슴도치가 탈출을 할 수 있는지 확인
 * idea는 옛날에 고민했었던 bfs sync 맞추는 방법
 * 
 * ---------------- * water, D 탈출구, S 시작점, X 벽돌(물이 차오르지 않고 지나갈 수 없음)
 * ex)     ->  output
 * 3 3			3
 * D.*
 * ...
 * .S.
 * 
 */
public class BOJ_3055 {
	public static Scanner sc = new Scanner(System.in);
	public static int R;
	public static int C;
	
	public static int[] dRow = {0,1,0,-1};
	public static int[] dCol = {1,0,-1,0};
	
 	public static void main(String[] args) {
		 R = sc.nextInt();
		 C = sc.nextInt();
		 Queue<int[]> water = new LinkedList<>();
		 Queue<int[]> hedgehog = new LinkedList<>();
		 boolean[][] visited = new boolean[R][C];
		 int result = 0;
		 
		 char[][] board = new char[R][C];
		 for(int i = 0; i < R; i++){
			 String inputStr = sc.next();
			 for(int j = 0; j < inputStr.length(); j++){
				 int[] startPos = {i,j};
				 if(inputStr.charAt(j) == 'S') {
					 visited[i][j] = true;
					 hedgehog.add(startPos);
				 }
				 if(inputStr.charAt(j) == '*') water.add(startPos);
				 board[i][j] = inputStr.charAt(j);
			 }
		 }
		 //make board
//		 for(int i = 0; i < R; i++){
//			 for(int j = 0; j < C; j++){
//				 System.out.print(board[i][j]);
//			 }
//			 System.out.println();
//		 }
		 
		 //check startPos
//		 for(int[] item : water){
//			 System.out.println(item[0]+","+item[1]);
//		 }
		 
		 while(true){
			 result++;
			 if(hedgehog.size() == 0){
				 System.out.println("KAKTUS");
				 break;
			 }
			 waterBfs(water, board);
			 
			 if(hedgeBfs(hedgehog, board, visited)){
				 System.out.println(result);
				 break;
			 }
			 
		 }
	}
 	
 	public static boolean hedgeBfs(Queue<int[]> hedgehogQ, char[][] board, boolean[][] visited){
 		int len = hedgehogQ.size();
 		
 		for(int i = 0; i < len; i++){
 			int curR = hedgehogQ.peek()[0];
 			int curC = hedgehogQ.peek()[1];
// 			System.out.println("HEDGEHOG-->curR:"+curR+",curC:"+curC);
 			hedgehogQ.poll();
 			
 			for(int j = 0; j < 4; j++){
 				int nextR = curR + dRow[j];
 				int nextC = curC + dCol[j];
 				if(nextR < 0 || nextR >= R || nextC < 0 || nextC >= C) continue;
 				if(board[nextR][nextC] == 'D') return true;
 				if(!visited[nextR][nextC] && board[nextR][nextC] == '.'){
 					int[] nextPos = {nextR, nextC};
 					visited[nextR][nextC] = true;
 					hedgehogQ.add(nextPos);
 				}
 				
 			}
 		}
 		
 		return false;
 	}
 	
 	public static void waterBfs(Queue<int[]> waterQ, char[][] board){
 		int len = waterQ.size();
 		
 		for(int i = 0; i < len; i++){
 			int curR = waterQ.peek()[0];
 			int curC = waterQ.peek()[1];
// 			System.out.println("WATER-->curR:"+curR+",curC:"+curC);
 			waterQ.poll();
 			
 			for(int j = 0; j < 4; j++){
 				int nextR = curR + dRow[j];
 				int nextC = curC + dCol[j];
 				
 				if(nextR < 0 || nextR >= R || nextC < 0 || nextC >= C) continue;
 				if(board[nextR][nextC] == '.'){
 					int[] nextPos = {nextR, nextC};
 					board[nextR][nextC] = '*';
 					waterQ.add(nextPos);
 				}
 			}
 		}
 	}
}
