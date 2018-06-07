package hanium;

/*이때, 우리는 기지국을 최소로 설치하면서 모든 아파트에 전파를 전달하려고 합니다. 
 * 위의 예시에선 최소 3개의 아파트 옥상에 기지국을 설치해야 모든 아파트에 전파를 전달할 수 있습니다.

아파트의 개수 N, 현재 기지국이 설치된 아파트의 번호가 담긴 1차원 배열 stations, 
전파의 도달 거리 W가 매개변수로 주어질 때, 모든 아파트에 전파를 전달하기 위해 증설해야 할 기지국 개수의 최솟값을 리턴하는 solution 함수를 완성해주세요

제한사항
N: 200,000,000 이하의 자연수
stations의 크기: 10,000 이하의 자연수
stations는 오름차순으로 정렬되어 있고, 배열에 담긴 수는 N보다 같거나 작은 자연수입니다.
W: 10,000 이하의 자연수

입출력 예
N	stations	W	answer
11	[4, 11]		1	3
16	[9]			2	3

 * 
 * 
 */

public class Ex03 {
	public static int[] board;
	public static boolean[] visited;
	public static int result = 1000000000;
	public static int W;
	public static int N;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int []temp = {9,3};
		System.out.println(solution(16,temp,2));
		System.out.println(result);
	}
	
	public static int solution(int n, int[] stations, int w){
		int answer = 0;
		board = new int[n];
		visited = new boolean[n];
		W = w;
		N = n;
		
		int[] tempStation = new int[stations.length];
		
		// 초기화 끝
		for(int i = 0; i < stations.length; i++){
			spread(visited,w, stations[i]-1);
		}

		for(int i = 0; i < visited.length; i++){
			if(!visited[i]){
				dfs(1, i, visited);
			}
		}
		return answer;
	}
	
	public static boolean isTrue(boolean[] visited){
		for(int i = 0; i < visited.length; i++){
			if(!visited[i]) return false;
		}
		return true;
	}
	
	public static void dfs(int depth, int pos, boolean[] visited){
		
		boolean []copy = new boolean[N];
		for(int i = 0; i < visited.length; i++){
			copy[i] = visited[i];
		}
		spread(copy, W, pos);

		if(isTrue(copy) && depth < result){
			result = depth;
			return;
		} else if(isTrue(copy)){
			return;
		}

		for(int i = 0; i < copy.length; i++){
			if(!copy[i]){
				dfs(depth+1, i, copy);
			}
		}
	}
	public static void spread(boolean[] visited, int w, int pos){
		
		for(int i = pos-w; i <= pos+w; i++){
			if(i < 0) continue;
			if(i > visited.length-1) continue;
			visited[i] = true;
		}
	}

}
