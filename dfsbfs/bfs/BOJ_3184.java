package dfsbfs.bfs;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

//양
/*
 * 입력
 * 
 *-----------v는 늑대 o는 양 (수가 많으면 잡아먹힘) ex) 양2 늑1 양 win 양 1 늑 1 늑 win
 * 6 6              출력 
 * ...#..		 0 2
 * .##v#.
 * #v.#.#
 * #.o#.#
 * .###.#
 * ...###
 * 
 */
public class BOJ_3184 {
	
	public static Scanner sc = new Scanner(System.in);
	public static int R, C;
	public static int[] dRow = {0,1,0,-1};
	public static int[] dCol = {1,0,-1,0};
	
	
	public static void main(String[] args) {
		R = sc.nextInt();
		C = sc.nextInt();
		
		char[][] board = new char[R][C];
		boolean[][] visited = new boolean[R][C];
		int sheepResult = 0;
		int wolfResult = 0;
		
		for(int i = 0; i < R; i++){
			String inputStr = sc.next();
			for(int j = 0; j < inputStr.length(); j++){
				board[i][j] = inputStr.charAt(j);
			}
		}
		
		for(int i = 0; i < R; i++){
			for(int j = 0; j < C; j++){
				if(visited[i][j]) continue;
				if(board[i][j] == 'o' || board[i][j] == 'v'){
					int[] startPos = {i,j};
					int[] temp = bfs(board, visited, board[i][j], startPos);
					
					if(temp[0] == 0){
						sheepResult += temp[1];
					} else if(temp[0] == 1){
						wolfResult += temp[1];
					}
				}
			}
		}
		
		System.out.print(sheepResult + " "+ wolfResult);
	}
	
	public static int[] bfs(char[][] board, boolean[][] visited, char animal, int[] startPos){
		Queue<int[]> q = new LinkedList<>();
		int wolf = 0;
		int sheep = 0;
		visited[startPos[0]][startPos[1]] = true;
		
		if(animal == 'v'){
			wolf += 1;
		} else if(animal == 'o'){
			sheep += 1;
		}
		
		q.add(startPos);
		while(!q.isEmpty()){
			int curR = q.peek()[0];
			int curC = q.peek()[1];
			q.poll();
			
			for(int i = 0; i < 4; i++){
				int nextR = curR + dRow[i];
				int nextC = curC + dCol[i];
				
				int[] nextPos = {nextR, nextC};
				if(nextR < 0 || nextR >= R || nextC < 0 || nextC >= C) continue;
				if(visited[nextR][nextC]) continue;
				if(board[nextR][nextC] == '.' || board[nextR][nextC] == 'v' || board[nextR][nextC] == 'o'){
					if(board[nextR][nextC] == 'v'){
						wolf += 1;
					}
					else if(board[nextR][nextC] == 'o'){
						sheep += 1;
					}
					visited[nextR][nextC] = true;
					q.add(nextPos);
				}
			}
		}
		
		// 0 양, 1 wolf
		if(wolf < sheep){
			int[] sheepTemp = {0, sheep};
			return sheepTemp;
		}
		else {
			int[] wolfTemp = {1, wolf};
			return wolfTemp;
		}
	}

}
