package dfsbfs.bfs;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

//소수 경로
public class BOJ_1963 {
	
	public static Scanner sc = new Scanner(System.in);
	
	public static int start;
	public static int end;

	public static void main(String[] args) {
		int T = sc.nextInt();
	
		while(T-- > 0){
			int result = 0;
			start = sc.nextInt();
			end = sc.nextInt();
			int[] startPos = {start, 0};
			if((result = bfs(startPos)) == -1){
				System.out.println("Impossible");
			} else{
				System.out.println(result);
			}
			
		}
	}
	
	public static boolean isPrime(int num){
		if(num == 2) return true;
		if(num == 3) return true;
		if(num % 2 == 0) return false;
		for(int i = 3; i <= (int)Math.sqrt(num); i++){
			if(num % i == 0) return false;
		}
		return true;
	}
	
	public static int bfs(int[] startPos){
		Queue<int[]> q = new LinkedList<>();
		boolean[] visited = new boolean[10000];
		int[] temp = new int[4];
		
		q.add(startPos);
		visited[q.peek()[0]] = true;
		
		while(!q.isEmpty()){
			int curNum = q.peek()[0]; 
			int curCnt = q.peek()[1]; 
			q.poll();
			
			if(curNum == end){
				return curCnt;
			}
			
			for(int i = 0; i < 4; i++){
				int j = (i==0) ? 1 : 0;
				for(; j<10; j++){
					temp[0] = curNum / 1000;
					temp[1] = (curNum % 1000) / 100;
					temp[2] = ((curNum % 1000) % 100) / 10;
					temp[3] = ((curNum % 1000) % 100) % 10;
					
					temp[i] = j;
					
					int nextNum = 1000 * temp[0] + 100 * temp[1] + 10 * temp[2] + temp[3];
					if(!visited[nextNum] && isPrime(nextNum)){
						int[] next = {nextNum, curCnt+1};
//						System.out.println(nextNum);
						q.add(next);
						visited[nextNum] = true;
					}
				
				}
			}
		}

		return -1;
	}

}
