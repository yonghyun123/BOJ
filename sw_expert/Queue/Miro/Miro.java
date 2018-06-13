package sw_expert.Queue.Miro;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Miro {
	
	public static Scanner sc;
	public static int T = 0;
	//우하좌상
	public static int[] dRow = {0,1,0,-1};
	public static int[] dCol = {1,0,-1,0};

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		sc = new Scanner(System.in);
		while(T++ < 10){
			int tmpT = sc.nextInt();
			int[][] board = new int[16][16];
			for(int i = 0; i < 16; i++){
				String str = sc.next();
				for(int j = 0; j < str.length(); j++){
					board[i][j] = Character.getNumericValue(str.charAt(j));
				}
				
			}
			System.out.print("#"+T+" ");
			System.out.println(findBfs(board,1,1));
		}
	}
	
	public static int findBfs(int[][] board, int row, int col){
		Queue<int[]> bfsQ = new LinkedList<>();
		boolean [][]visited = new boolean[16][16];
		
//		init bfs
		int []temp = {row,col};
		bfsQ.add(temp);
		visited[row][col] = true;
		
		while(!bfsQ.isEmpty()){
			int curR = bfsQ.peek()[0];
			int curC = bfsQ.peek()[1];
			bfsQ.poll();
			
			for(int i = 0; i < 4; i++){
				int nextRow = curR + dRow[i];
				int nextCol = curC + dCol[i];
				
				if(nextRow < 0 || nextRow > 15 || nextCol < 0 || nextCol > 15) continue;
				if(visited[nextRow][nextCol]) continue;
				if(board[nextRow][nextCol] == 0 || board[nextRow][nextCol] == 3){
					if(board[nextRow][nextCol] == 3){
						return 1;
					}
					int[] tempPos = {nextRow, nextCol};
					visited[nextRow][nextCol] = true;
					bfsQ.add(tempPos);
				}
				
			}
			
		}
		return 0;
	}

}
