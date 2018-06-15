package boj_기초;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BOJ_13265 {
	
	public static Scanner sc;
	public static int T;
	public static final int RED = -1;
	public static final int BLUE = 1;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		sc = new Scanner(System.in);
		T = sc.nextInt();
		
		// 모든 테스트 케이스를 한번에
		while(T-- > 0){
			//each node and edge per test case;
			int node = sc.nextInt();
			int edge = sc.nextInt();
			int [][]board = new int[node][node];
			
			for(int j = 0; j < edge; j++){
				int row = sc.nextInt();
				int col = sc.nextInt();
				
				board[row-1][col-1] = board[col-1][row-1] = 1;
			}
			//print board
//			for(int i = 0; i < board.length; i++){
//				for(int j = 0; j < board[i].length; j++){
//					System.out.print(board[i][j]);
//				}
//				System.out.println();
//			}
			if(bfsQ(node, 0,  board, RED)){
				System.out.println("possible");
			} else {
				System.out.println("impossible");
			}
			
		}
	}
	
	public static boolean bfsQ(int node, int startNode, int[][] board, int color){
		//첫 노드 색깔 무조건 빨간색
		Queue<Integer> q = new LinkedList<>();
		boolean[] visited = new boolean[node];
		int[] promising = new int[node];
		int palette = color;

		promising[startNode] = palette;
		q.add(startNode);
		
		while(!q.isEmpty()){
			int curNode = q.poll();
			visited[curNode] = true;
			if(promising[curNode] == 0){
				promising[curNode] = RED;
				palette = BLUE;
			}
			if(promising[curNode] == RED){
				palette = BLUE;
			} else if(promising[curNode] == BLUE){
				palette = RED;
			}
			
			for(int i = 0; i < node; i++){
				// add element into queue
				// if linked two node is promising
				
				if(board[curNode][i] == 1 && promising[i] != 0){
					if(promising[i] != palette) return false;
				} else if(board[curNode][i] == 1){
					promising[i] = palette;
					q.add(i);
				}
	
			}
		}
		return true;
	}
}
