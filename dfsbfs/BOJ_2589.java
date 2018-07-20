package dfsbfs;
// 보물섬
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BOJ_2589 {
	
	public static Scanner sc = new Scanner(System.in);
	public static int R, C;
	public static int[] dRow = {0,1,0,-1};
	public static int[] dCol = {1,0,-1,0};
	public static void main(String[] args) {
		R = sc.nextInt();
		C = sc.nextInt();
		
		int totalCnt = 0;
		char[][] board = new char[R][C];
		
		for(int i = 0; i < R; i++){
			String inputRow = sc.next();
			for(int j = 0; j < inputRow.length(); j++){
				board[i][j] = inputRow.charAt(j);
			}
		}
		for(int i = 0; i < R; i++){
			for(int j = 0; j < C; j++){
				int[] startPos = {i,j,0};
				if(board[i][j] == 'L'){
					totalCnt = Math.max(totalCnt, bfs(board, startPos));	
				}
			}
		}
		
		System.out.println(totalCnt);
	
	}
	
	public static int bfs(char[][] board, int[]start){
		Queue<int[]> q = new LinkedList<>();
		boolean[][] visited = new boolean[R][C];
		q.add(start);
		int result = 0;
		
		while(!q.isEmpty()){
			int curRow = q.peek()[0];
			int curCol = q.peek()[1];
			int curCnt = q.peek()[2];
			q.poll();
			result = Math.max(curCnt, result);
			for(int i = 0; i < 4; i++){
				int nextRow = curRow + dRow[i];
				int nextCol = curCol + dCol[i];
				if(nextRow < 0 || nextRow >= R || nextCol < 0 || nextCol >= C) continue;
				if(!visited[nextRow][nextCol] && board[nextRow][nextCol] == 'L'){
					int[] nextPos = {nextRow, nextCol, curCnt+1};
					visited[nextRow][nextCol] = true;
					q.add(nextPos);
				}
			}
		}
		return result;
	}

}
