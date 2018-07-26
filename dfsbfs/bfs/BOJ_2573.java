package dfsbfs.bfs;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

// 빙산

/*
 * 5 7
 * 0 0 0 0 0 0 0   -> 근처 0의 갯수만큼 수가 낮아짐..
 * 0 2 4 5 3 0 0
 * 0 3 0 2 5 2 0
 * 0 7 6 2 4 0 0
 * 0 0 0 0 0 0 0
 * 
 */
public class BOJ_2573 {
	public static Scanner sc = new Scanner(System.in);
	public static int R,C;
	public static int[] dRow = {0,1,0,-1};
	public static int[] dCol = {1,0,-1,0};

	public static void main(String[] args) {
		R = sc.nextInt();
		C = sc.nextInt();
		int result = 0;
		boolean resultFlag = false;
		
		int[][] board = new int[R][C];
		boolean[][] visited = new boolean[R][C];
		for(int i = 0; i < R; i++){
			for(int j = 0; j < C; j++){
				board[i][j] = sc.nextInt();
			}
		}
		while(true){
			int cnt = 0;
//			
//			for(int i = 0; i < R; i++){
//				for(int j = 0; j < C; j++){
//					System.out.print(board[i][j]);
//				}
//				System.out.println();
//			}
//			System.out.println();
			visited = new boolean[R][C];
			for(int i = 0; i < R; i++){
				for(int j = 0; j < C; j++){
					if(!visited[i][j] && board[i][j] != 0){
						cnt += 1;
						if(cnt == 2){
							resultFlag = true;
							break;
						}
						int[] test = {i,j};
						bfsMelt(board, visited, test);
						
					}
				}
				if(resultFlag)break;
			}
			
			if(resultFlag){
				System.out.println(result);
				break;
			} else if(isAllMelted(board)){
				System.out.println(0);
				break;
			}
			result++;

		}

	}
	
	public static boolean isAllMelted(int[][] board){
		for(int i = 0; i < R; i++){
			for(int j = 0; j < C; j++){
				if(board[i][j] != 0){
					return false;
				}
			}
		}
		return true;
	}
	
	public static int checkMelt(int[][] board, int r, int c){
		int ret = 0;
		for(int i = 0; i < 4; i++){
			int nR = r + dRow[i];
			int nC = c + dCol[i];
			
			if(board[nR][nC] == 0){
				ret += 1;
			}
		}
		return ret;
	}
	
	public static void bfsMelt(int[][] board, boolean[][] visited, int[] start){
		Queue<int[]> q= new LinkedList<>();
		int[][] copy = new int[R][C];
		q.add(start);
		visited[start[0]][start[1]] = true;
		
		for(int i = 0; i < R; i ++){
			for(int j = 0; j < C; j++){
				copy[i][j] = board[i][j];
			}
		}
		
		int meltFirst = checkMelt(board, start[0], start[1]);
		if(board[start[0]][start[1]] - meltFirst < 0){
			board[start[0]][start[1]] = 0;
		} else {
			board[start[0]][start[1]] -= meltFirst;	
		}
		
		while(!q.isEmpty()){
			int curR = q.peek()[0];
			int curC = q.peek()[1];
			q.poll();
			
			for(int i = 0; i < 4; i++){
				int nextR = curR + dRow[i];
				int nextC = curC + dCol[i];
				
				if(nextR < 0 || nextR >= R || nextC < 0 || nextC >= C) continue;
				if(!visited[nextR][nextC] && copy[nextR][nextC] != 0){
					int melCnt = checkMelt(copy, nextR, nextC);
					if(board[nextR][nextC] - melCnt < 0){
						board[nextR][nextC] = 0;
					} else {
						board[nextR][nextC] -= melCnt;
					}
					int[] nextPos = {nextR, nextC};
					q.add(nextPos);
					visited[nextR][nextC] = true;
				}
			}
		}
		
	}

}
