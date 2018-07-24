package dfsbfs.bfs;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/* 벽부수고 이동하기 2 
 * 
 * 6 4 1   ->벽을 부술 수 있는 갯수가 주어짐 0,0 -> M,N 도착
 * 0100
 * 1110
 * 1000
 * 0000
 * 0111
 * 0000
 */
public class BOJ_14442 {
	public static Scanner sc = new Scanner(System.in);
	public static int R,C,B;
	public static int[] dRow = {0,1,0,-1};
	public static int[] dCol = {1,0,-1,0};
	
	public static void main(String[] args) {
		 R = sc.nextInt();
		 C = sc.nextInt();
		 B = sc.nextInt();
		 
		 int result = 0;
		 int[][] board = new int[R][C];
		 
		 for(int i = 0; i < R; i++){
			 String tempStr = sc.next();
			 for(int j = 0; j <tempStr.length(); j++){
				 board[i][j] = Character.getNumericValue(tempStr.charAt(j));
			 }
		 }
		 
		  System.out.println(bfs(board));
	}
	
	public static int bfs(int[][] board){
		Queue<Child> q = new LinkedList<>();
		//0 일때 벽을 안부심, 1일때 벽을 부심
		
		boolean[][][] visited = new boolean[R][C][B+1];
		visited[0][0][0] = true;
		
		q.add(new Child(0,0,1,0));
		
		while(!q.isEmpty()){
			
			int curR = q.peek().curR;
			int curC = q.peek().curC;
			int curBlock = q.peek().curBlock;
			int curCnt = q.peek().curCnt;
			q.poll();
			
			if(curR == R-1 && curC == C-1){
				return curCnt;
			}
			
			for(int i = 0; i < 4; i++){
				int nextR = curR + dRow[i];
				int nextC = curC + dCol[i];
				
				if(nextR < 0 || nextR >= R || nextC < 0 || nextC >= C) continue;
				//다음 벽이 없으면서 이동한적 없고, 벽을 부순적 없을때,
				if(board[nextR][nextC] == 0 && !visited[nextR][nextC][0] && curBlock == 0){
					visited[nextR][nextC][0] = true;
					q.add(new Child(nextR, nextC, curCnt+1, 0));
				}
				for(int j = 1; j <= B; j++){
					// 다음이 벽이면서 부신벽을 지나간 적 없고, 벽을 부순적 없을때, --> 벽을 부심
					if(board[nextR][nextC] == 1 && !visited[nextR][nextC][j] && curBlock < B){
						visited[nextR][nextC][j] = true;
						q.add(new Child(nextR, nextC, curCnt+1, curBlock+1));
					}
					
					if(board[nextR][nextC] == 0 && !visited[nextR][nextC][j] && curBlock == B){
						visited[nextR][nextC][j] = true;
						q.add(new Child(nextR, nextC, curCnt+1, B));
					}
				}


				
				
			}
		}	
		return -1;
	}

}

