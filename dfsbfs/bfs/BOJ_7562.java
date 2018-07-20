package dfsbfs.bfs;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BOJ_7562 {
	public static Scanner sc = new Scanner(System.in);
	public static int[] dRow = {-2, -1, 1, 2, 2, 1, -1, -2};
	public static int[] dCol = {1, 2, 2, 1, -1, -2, -2, -1};
	public static int N;
	public static int endRow;
	public static int endCol;
	
	public static int result = 0;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int T = sc.nextInt();
		while(T-- > 0){
			result = 0;
			N = sc.nextInt();
			int startRow = sc.nextInt();
			int startCol = sc.nextInt();
			endRow = sc.nextInt();
			endCol = sc.nextInt();
			
			int[] startPos = {startRow, startCol, 0};
			bfs(startPos);
			System.out.println(result);
			
		}

	}
	
	public static void bfs(int[] start){
		int[][] visited = new int[N][N];
		Queue<int[]> q = new LinkedList<>();
		q.add(start);
		
		while(!q.isEmpty()){
			int curRow = q.peek()[0];
			int curCol = q.peek()[1];
			int resultCnt = q.peek()[2];
			
			if(endRow == curRow && endCol == curCol){
				result = resultCnt;
				break;
			}
			
			q.poll();
			
			for(int i = 0; i < 8; i++){
				int nextRow = dRow[i] + curRow;
				int nextCol = dCol[i] + curCol;
				if(nextRow < 0 || nextCol < 0 || nextRow >= N || nextCol >= N) continue;
				if(visited[nextRow][nextCol] == 0){
					int[] temp = {nextRow, nextCol, resultCnt+1};
					q.add(temp);
					visited[nextRow][nextCol] = 1;
				}
			}
		}
		
	}

}
