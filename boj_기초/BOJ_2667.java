package boj_기초;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BOJ_2667 {
	
	private static Scanner sc;
	private static int aptNumber = 0;
	private static int N;
	
	//우하좌상
	private static int[] dRow = {0,1,0,-1};
	private static int[] dCol = {1,0,-1,0};
	public static void main(String[] args) {
		sc = new Scanner(System.in);
		N = sc.nextInt();
		int [][]board = new int[N][N];
		boolean [][]visited = new boolean[N][N];
		ArrayList<Integer> resultList = new ArrayList<>();
		
		for(int i = 0; i < N; i++){
			String boardLine = sc.next();
			for(int j = 0;  j < N; j++){
				board[i][j] = Character.getNumericValue(boardLine.charAt(j));
			}
		}
		
		for(int i = 0; i < N; i++){
			for(int j = 0; j < N; j++){
				if(!visited[i][j] && board[i][j] != 0){
					resultList.add(bfs(i,j,visited, board));
				}
			}
		}
		
		Collections.sort(resultList);
		System.out.println(aptNumber);
		for(int item : resultList){
			System.out.println(item);
		}
	}
	
	private static int bfs(int row, int col, boolean[][] visited, int[][] board){
		aptNumber++;
		int answer = 1;
		
		Queue<int[]> bfsQ = new LinkedList<>();
		int[] start = {row, col};
		bfsQ.add(start);
		visited[row][col] = true;
		board[row][col] = aptNumber;
		
		while(!bfsQ.isEmpty()){
			
			int curRow = bfsQ.peek()[0];
			int curCol = bfsQ.peek()[1];
			bfsQ.poll();
			
			for(int i = 0; i < 4; i++){
				int nextRow = dRow[i] + curRow;
				int nextCol = dCol[i] + curCol;
				//boundary check
				
				if(nextRow < 0 || nextRow >= N || nextCol < 0 || nextCol >=N) continue;
				if(!visited[nextRow][nextCol] && board[nextRow][nextCol] != 0){
					visited[nextRow][nextCol] = true;
					board[nextRow][nextCol] = aptNumber;
					answer += 1;
					int[] nextPos = {nextRow, nextCol};
					bfsQ.add(nextPos);
				}
			}
		}
		return answer;
	}

}
