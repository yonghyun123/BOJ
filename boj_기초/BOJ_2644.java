package boj_기초;
import java.util.Scanner;

public class BOJ_2644 {
	public static Scanner sc = new Scanner(System.in);
	public static int numOfNode;
	public static int endNode;
	public static int result = -1;
	public static boolean resultFlag = false;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		numOfNode = sc.nextInt();
		int startNode = sc.nextInt();
		int[][] board = new int[numOfNode][numOfNode];
		boolean[] visited = new boolean[numOfNode];
		endNode = sc.nextInt();
		
		int numOfEdge = sc.nextInt();
		
		for(int i = 0; i < numOfEdge; i++){
			int row = sc.nextInt();
			int col = sc.nextInt();
			
			board[row-1][col-1] = board[col-1][row-1] = 1;
		}
		dfs(startNode-1, visited, board, 0);
		System.out.println(result);
	}
	
	public static void dfs(int start, boolean[] visited, int[][] board, int depth){
		
		if(start == endNode-1){
			result = depth;
			return;
		}
		visited[start] = true;
		
		for(int i = 0; i < numOfNode; i++){
			if(!visited[i] && board[start][i] == 1){
				dfs(i, visited, board, depth+1);
			}
		}
	}

}
