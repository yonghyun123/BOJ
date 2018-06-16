package boj_기초;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BOJ_2606 {
	public static Scanner sc;
	public static int nodeNum;
	public static int edgeNum;
	public static int [][]board;
	public static boolean[] visited;
	public static int result = 0;

	public static void main(String[] args) {
		
		sc = new Scanner(System.in);
		nodeNum = sc.nextInt();
		edgeNum = sc.nextInt();
		board = new int[nodeNum][nodeNum];
		visited = new boolean[nodeNum];
		
		
		for(int i = 0; i < edgeNum; i++){
			int row = sc.nextInt();
			int col = sc.nextInt();
			
			if(row == col) continue;
			board[row-1][col-1] = board[col-1][row-1] = 1;
		}
		
//		dfs(0, visited);
//		for(int i = 0; i < visited.length; i++){
//			if(visited[i]) result++;
//		}
		bfs(0);
		System.out.println(result - 1);
	}
	
	public static void dfs(int startNode, boolean[] visited){
		//no escape condition
		visited[startNode] = true;
		for(int i = 0; i < nodeNum; i++){
			if(!visited[i] && board[startNode][i] == 1){
				dfs(i,visited);
			}
		}
	}
	
	public static void bfs(int startNode){
		Queue<Integer> q = new LinkedList<>();
		boolean []visited = new boolean[nodeNum];
		
		visited[startNode] = true;
		q.add(startNode);
		
		while(!q.isEmpty()){
			int curNode = q.poll();
			for(int i = 0 ; i < nodeNum; i++){
				if(!visited[i] && board[curNode][i] == 1){
					q.add(i);
					visited[i] = true;
				}
			}
		}
		
		for(int i = 0; i < visited.length; i++){
			if(visited[i]) result++;
		}
	}

}
