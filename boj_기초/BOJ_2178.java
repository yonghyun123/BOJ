package boj_기초;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BOJ_2178 {
	public static Scanner sc = new Scanner(System.in);
	public static int RN;
	public static int CN;
	public static int[][] board;
	
	public static int[] dRow = {0,1,0,-1};
	public static int[] dCol = {1,0,-1,0};

	public static void main(String[] args) {	
		RN = sc.nextInt();
		CN = sc.nextInt();
		
		board = new int[RN][CN];
		
		for(int i = 0; i < RN; i++){
			String tempStr = sc.next();
			for(int j = 0; j < tempStr.length(); j++){
				board[i][j] = Character.getNumericValue(tempStr.charAt(j));
			}
		}

		int []startPos = {0,0};
		System.out.println(bfs(startPos));
	}
	
	public static int bfs(int[] start){
		Queue<int[]> q = new LinkedList<>();
		boolean[][] visited = new boolean[RN][CN];
		int answer = 0;
		int depth = 1;
		int startRow = start[0];
		int startCol = start[1];
		
		int[] qItem = {startRow, startCol, depth};
		
		visited[start[0]][start[1]] = true;
		q.add(qItem);
		
		while(!q.isEmpty()){
			int curRow = q.peek()[0];
			int curCol = q.peek()[1];
			int curDepth = q.peek()[2];
			q.poll();
			
			if( (curRow == RN-1) && (curCol == CN-1) ) {
				answer = curDepth;
				break;
			}
			
			for(int i = 0; i < 4; i++){
				int nextRow = curRow + dRow[i];
				int nextCol = curCol + dCol[i];
				if(nextRow < 0 || nextRow >= RN || nextCol < 0 || nextCol >= CN) continue;
				if(visited[nextRow][nextCol]) continue;
				if(board[nextRow][nextCol] == 1){
					int[] addedQItem = {nextRow, nextCol, curDepth+1};
					q.add(addedQItem);
					visited[nextRow][nextCol] = true;
				}
			}
		}
		return answer;
		
	}

}
