package dfsbfs;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BOJ_1697 {
	
	public static Scanner sc = new Scanner(System.in);
	public static int end;
	public static int result = 0;
	
	public static int[] dDistance = {1, -1, 0};

	public static void main(String[] args) {
		int start = sc.nextInt();
		end = sc.nextInt(); 
		
		int[] startPos = {start, 0};
		bfs(startPos);
		System.out.println(result);
		
	}
	
	public static void bfs(int[] position){
		boolean[] visited = new boolean[100001];
		Queue<int[]> q = new LinkedList<>();
		
		q.add(position);
		
		while(!q.isEmpty()){
			int curPos = q.peek()[0];
			int curCnt = q.peek()[1];
			q.poll();
			
			if(curPos == end){
				result = curCnt;
				break;
			}
			for(int i = 0; i < 3; i++){
				int nextPos = 0;
				if(dDistance[i] == 0){
					 nextPos = curPos*2;
				} else{
					 nextPos = curPos+dDistance[i];
				}
				if(nextPos < 0 || nextPos > 100000) continue;
				if(!visited[nextPos]){
					visited[nextPos] = true;
					int[] tempPos = {nextPos, curCnt+1};
					q.add(tempPos);
				}
				
			}
			
		}
	}

}
