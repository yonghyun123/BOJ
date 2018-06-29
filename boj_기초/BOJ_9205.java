package boj_기초;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BOJ_9205 {
	
	public static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		int T = sc.nextInt();

		while(T-- >0){
			int numOfCu = sc.nextInt();
			ArrayList<int[]> position = new ArrayList<>();

			for(int i = 0; i < numOfCu+2; i++){
				int x = sc.nextInt();
				int y = sc.nextInt();
				int[] pos = {x,y};
				position.add(pos);
			}
			int[] start = position.get(0);
			System.out.print(bfs(start, position));
		}

	
	}
	
	public static String bfs(int[] start, ArrayList<int[]> position){
		Queue<int[]> q = new LinkedList<>();
		boolean resultFlag = false;
		boolean[] visited = new boolean[position.size()];
		
		visited[0] = true; 
		q.add(start);
		
		while(!q.isEmpty()){
			int curX = q.peek()[0];
			int curY = q.peek()[1];
			
			if(curX == position.get(position.size()-1)[0] && curY == position.get(position.size()-1)[1]){
				resultFlag = true;
				break;
			}
			
			q.poll();
			for(int i = 0; i < position.size(); i++){
				
				if(visited[i]) continue;
				int nextX = position.get(i)[0];
				int nextY = position.get(i)[1];
				
				if( Math.abs((nextX - curX)) + Math.abs((nextY - curY)) <= 1000){
					int[] nextPos = {nextX, nextY};
					q.add(nextPos);
					visited[i] = true;
				}	
			}
		}
		if(resultFlag){
			return "happy";
		} else {
			return "sad";
		}
		
	}
}
