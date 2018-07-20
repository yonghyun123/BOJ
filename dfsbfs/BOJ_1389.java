package dfsbfs;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BOJ_1389 {
	public static Scanner sc = new Scanner(System.in);
	public static int N = 101;

	public static void main(String[] args) {
		int userNum = sc.nextInt();
		int friendNum = sc.nextInt();
		int[][] board = new int[N][N];
		int[] minRelations = new int[N];
		int result = 0;
		
		for(int i = 0; i < friendNum; i++){
			int start = sc.nextInt();
			int end = sc.nextInt();
			
			board[start][end] = board[end][start] = 1;
		}
		
		for(int i = 1; i < N; i++){
			int total = 0;
			for(int j = 1; j < N; j++){
			//bfs
				if(i == j) continue;
//				if(board[i][j] == 1){
					int[] startPos = {i, 0};
//					System.out.println("i="+i+"j="+j+",return:"+bfs(board,startPos,j));
					total += bfs(board, startPos, j);
//				}
			}
			minRelations[i] = total;		
		}
		int min = 99999;
		for(int i = 1; i < N; i++){
			
			if(minRelations[i] != 0 && minRelations[i] < min){
				min = minRelations[i];
				result = i;
			}
		}
		System.out.println(result);
		
	}
	public static int bfs(int[][] board, int[] start, int end){
		Queue<int[]> q = new LinkedList<>();
		boolean visited[] = new boolean[N];
		int result = 0;
		
		visited[start[0]] = true;
		q.add(start);
		
		while(!q.isEmpty()){
			int curNode = q.peek()[0];
			int curCnt = q.peek()[1];
			q.poll();
			if(curNode == end){
				result = curCnt;
				break;
			}
			
			for(int i = 1; i < N; i++){
				if(!visited[i] && board[curNode][i] == 1){
					int[] nextPos = {i, curCnt+1};
					q.add(nextPos);
					visited[i] = true;
				}
			}
		}
		return result;
	}

}
