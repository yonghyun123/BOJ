package dfsbfs.dfs;

import java.util.Scanner;

// 연결요소의 개수
public class BOJ_11724 {
	public static Scanner sc = new Scanner(System.in);
	public static int numOfNode;
	public static int numOfEdge;
	
	public static void main(String[] args) {
		numOfNode = sc.nextInt();
		numOfEdge = sc.nextInt();
		int[][] board = new int[numOfNode][numOfNode];
		int[] visited = new int[numOfNode];
		int result = 0;
		
		for(int i = 0; i < numOfEdge; i++){
			int first = sc.nextInt();
			int second = sc.nextInt();
			
			board[first-1][second-1] = board[second-1][first-1] = 1;
		}
		
		for(int i = 0; i < numOfNode; i++){
			if(visited[i] == 0){
				//dfs시작
				result += 1;
				dfs(board, visited, i);
			}
		}
		System.out.println(result);
	}
	
	public static void dfs(int[][] board, int[] visited, int start){
		visited[start] = 1;
		
		for(int i = 0; i < numOfNode; i++){
			if(visited[i] == 0 && board[start][i] == 1){
				dfs(board,visited,i);
			}
		}
	}

}
