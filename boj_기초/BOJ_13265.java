package boj_기초;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BOJ_13265 {
	
	public static Scanner sc;
	public static int T;
	public static final int RED = 1;
	public static final int BLUE = 2;

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
				if(row == col) continue;
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
	
		promising[startNode] = color;
		visited[startNode] = true;
		q.add(startNode);
		
		while(!q.isEmpty()){
			int curNode = q.poll();
			for(int i = 0; i < node; i++){
				// add element into queue
				// if linked two node is promising
				if(board[curNode][i] == 1 &&  (promising[i] != promising[curNode]) ){
					if(!visited[i]){
						if(promising[curNode] == RED) promising[i] = BLUE;
						else if(promising[curNode] == BLUE) promising[i] = RED;
						visited[i] = true;
						q.add(i);
					}
				} else if(board[curNode][i] == 1 &&  (promising[i] == promising[curNode])) {
					return false;
				}

			}
			
		}
		return true;
	}
}
