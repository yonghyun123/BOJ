package dfsbfs.bfs;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

//벽부수고 이동하기
/*
 * 6 4     벽을 하나까지 부셔가면서 최단거리 찾는 알고리즘
 * 0100
 * 1110
 * 1000
 * 0000
 * 0111
 * 0000
 * 
 */
public class BOJ_2206 {
	
	public static Scanner sc = new Scanner(System.in);
	public static int R,C;
	public static int[] dRow = {0,1,0,-1};
	public static int[] dCol = {1,0,-1,0};
	

	public static void main(String[] args) {
		 R = sc.nextInt();
		 C = sc.nextInt();
		 ArrayList<Integer> resultList = new ArrayList<>();
		 int[][] board = new int[R][C];
		 
		 for(int i = 0; i < R; i++){
			 String tempStr = sc.next();
			 for(int j = 0; j <tempStr.length(); j++){
				 board[i][j] = Character.getNumericValue(tempStr.charAt(j));
			 }
		 }
		 
		 for(int i = 0; i < R; i++){
			 for(int j = 0; j < C; j++){
				 
				 if(board[i][j] == 1){
					 board[i][j] = 0;
					 int[] startPos = {0,0,1};
					 resultList.add(bfs(board, startPos));
					 board[i][j] = 1;
				 }
			 }
		 }
		 
		 if(isPositive(resultList)){
			 Collections.sort(resultList);
			 System.out.println(resultList.get(resultList.size()-1));
		 } else{
			 System.out.println("-1");
		 }
		 
	}
	
	public static boolean isPositive(ArrayList<Integer> list){
		for(int item : list){
			if(item == -1){
				return true;
			}
		}
		return false;
	}
	
	public static int bfs(int[][] board, int[] start){
		Queue<int[]> q = new LinkedList<>();
		boolean[][] visited = new boolean[R][C];
		
		visited[start[0]][start[1]] = true;
		q.add(start);
		
		while(!q.isEmpty()){
			
			int curR = q.peek()[0];
			int curC = q.peek()[1];
			int curCnt = q.peek()[2];
			q.poll();
			
			if(curR == R-1 && curC == C-1){
				return curCnt;
			}
			
			for(int i = 0; i < 4; i++){
				int nextR = curR + dRow[i];
				int nextC = curC + dCol[i];
				
				if(nextR < 0 || nextR >= R || nextC < 0 || nextC >= C) continue;
				if(!visited[nextR][nextC] && board[nextR][nextC] == 0){
					int[] nextPos = {nextR, nextC, curCnt+1};
					visited[nextR][nextC] = true;
					q.add(nextPos);
				}
			}
		}
		
		return -1;
	}

}
