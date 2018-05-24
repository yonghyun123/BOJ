package sw_expert.Stack.FindPath;

import java.util.Scanner;

public class FindPath {
	
	public static int T = 0;
	public static Scanner sc;
	public static int resultFlag;
	public static boolean []visited;
	public static int [][]graph;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		sc = new Scanner(System.in);
		
		while(T++ < 10){
			graph = new int[100][100];
			visited = new boolean[100];
			resultFlag = 0;
			
			int tmpT = sc.nextInt();
			int len = sc.nextInt();
			
			for(int i = 0; i < len; i++){
				int tmpRow = sc.nextInt();
				int tmpCol = sc.nextInt();
				
				graph[tmpRow][tmpCol] = graph[tmpCol][tmpRow] = 1;
			}
			//draw graph
			
//			for(int i = 0; i < 100; i++){
//				for(int j = 0; j < 100; j++){
//					System.out.print(graph[i][j]);
//				}
//				System.out.println();
//			}
			dfs(0);
			
			System.out.println("#"+tmpT+" "+resultFlag);
			
			
		}
	}
	
	public static void dfs(int node){
		visited[node] = true;;
		if(node == 99){
			resultFlag = 1;
			return;
		}
		for(int i = node; i < 100; i++){
			if(!visited[i] && graph[node][i] == 1){
				dfs(i);
			}
		}
		visited[node] = false;
		
	}

}
