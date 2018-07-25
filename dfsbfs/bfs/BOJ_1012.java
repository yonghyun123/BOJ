package dfsbfs.bfs;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

// 유기농 배추 심기
/*
 * 배추벌레 갯수 구하기 배추벌레는 배추가 심어져있는 4방향으로 이동할 수 있음
 * 
 */
public class BOJ_1012 {
	
	public static Scanner sc = new Scanner(System.in);
	public static int R, C;
	public static int numOfCabbage;
	public static int[] dRow = {0,1,0,-1};
	public static int[] dCol = {1,0,-1,0};
	
	
	public static void main(String[] args) {
		int T = sc.nextInt();
		
		while(T-- > 0){
			int result = 0;
			
			R = sc.nextInt();
			C = sc.nextInt();
			numOfCabbage = sc.nextInt();
			
			int[][] board = new int[R][C];
			boolean[][] visited = new boolean[R][C];
			
			for(int i = 0; i < numOfCabbage; i++){
				int r = sc.nextInt();
				int c = sc.nextInt();
				
				board[r][c] = 1;
			}
			
			for(int i = 0; i < R; i++){
				for(int j = 0; j < C; j++){
					if(!visited[i][j] && board[i][j] == 1){
						int[] startPos = {i,j};
						result += bfs(board,visited,startPos);
					}
				}
			}
			
			System.out.println(result);
		}

	}
	
	public static int bfs(int[][] board, boolean[][] visited, int[] start){
		Queue<int[]> q = new LinkedList<>();
		q.add(start);
		visited[start[0]][start[1]] = true;
		
		while(!q.isEmpty()){
			int curR = q.peek()[0];
			int curC = q.peek()[1];
			q.poll();
			
			for(int i = 0; i < 4; i++){
				int nextR = curR + dRow[i];
				int nextC = curC + dCol[i];
				
				if(nextR < 0 || nextR >= R || nextC < 0 || nextC >= C) continue;
				if(!visited[nextR][nextC] && board[nextR][nextC] == 1){
					int[] temp = {nextR, nextC};
					q.add(temp);
					visited[nextR][nextC] = true;
				}
			}
		}
		
		return 1;
	}

}
