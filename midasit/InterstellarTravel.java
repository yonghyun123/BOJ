//package midasit;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.StringTokenizer;

/*인류의 마지막 여행 (InterstellarTravel)

환경 파괴로 인하여 지구에서 더 이상 생존할 수 없게 된 인류는, 새로이 정착할 수 있을 것으로 보이는 행성 “Z”를 발견하였습니다.

NASA는 행성 Z가 인류의 정착에 적합한지 탐사하기 위하여 탐사대를 보낼 예정입니다. 탐사대의 임무는 다음과 같습니다.

탐사대는 행성 A에서 출발하여 행성 Z에 도착해야 합니다.
탐사대는 이동 과정에서 추가로 정착 후보 행성 1곳을 방문하여 인류의 정착이 가능한지 리포트를 작성해야 합니다.
탐사대는 행성과 행성을 단방향으로 이어주는 웜홀을 통과하여 행성Z를 향해 출발할 계획입니다.

당신은, 이 과정에서 탐사대가 운항할 최적의 경로를 계산하기 위한 프로그램 개발을 의뢰 받았습니다.

행성 A에서 출발하여 후보 행성 1곳을 거친 후 목적행성 Z를 향해 갈 수 있는 최단 경로를 계산하는 프로그램을 작성해 주시기 바랍니다.
(행성과 행성간의 거리는 1로 동일하며, 후보 행성을 반드시 통과해야만 합니다.)

입력

입력은 표준 입력(stdin)으로 주어집니다.
첫 번째 줄에는 총 이동 가능한 경로(웜홀)의 개수 N이 주어집니다. 두 번째 줄부터 N개의 이동 가능한 경로가 주어집니다. 경로는 콤마로 구분된 두 개의 행성 명으로 나타내며, 행성 명은 알파벳 대문자 한 글자로 표현됩니다. 예를 들어 경로가 “A,B”라고 주어지면 행성 A에서 행성 B로 이동 가능하다는 의미입니다.

마지막 줄에는 정착 후보 행성 명이 주어집니다.

출발지는 A, 최종 종착지는 Z로 표현되며, 총 행성의 수는 3개 이상, 26개 이하입니다.

출력

출력은 표준 출력(stdout)으로 이루어집니다.
최단 경로의 거리를 출력합니다.
정착 후보 행성을 통과할 수 없거나 최종 목적지에 도달하기가 불가능하다면 -1을 출력합니다.
 * 
 * 
 */
public class InterstellarTravel {
	
	public static Scanner sc;
	public static StringTokenizer st;
	public static int[][] graph;
	public static boolean []visited;
	public static int resultFlag;
	public static int mustVertex;
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		sc = new Scanner(System.in);
		graph = new int[26][26];
		visited = new boolean[26];
		
		int N = sc.nextInt();

		for(int i = 0; i < N; i++){
			String input = sc.next();
			st = new StringTokenizer(input, ",");
			ArrayList<Integer> convertList = new ArrayList<>();
			while(st.hasMoreTokens()){
				 convertList.add(st.nextToken().charAt(0)-65);
			}
			//graph init
			graph[convertList.get(0)][convertList.get(1)] = graph[convertList.get(1)][convertList.get(0)] = 1;
		}
		String tmpMustVertex = sc.next();
		mustVertex = tmpMustVertex.charAt(0) - 65;
		

		visited[0] = true;
		Dfs(0,0);
		if(resultFlag != 0){
			System.out.println(resultFlag);
		} else {
			System.out.println(-1);
		}
		
	}
	
	public static void Dfs(int start, int depth){
		if(start == 25 && !visited[mustVertex]){
			return;
		}
		if(start == 25 && visited[mustVertex]){
			resultFlag = depth;
			return;
		}
		visited[start] = true;
		for(int i = 0; i < 26; i++){
			if(graph[start][i] == 1 && !visited[i]){
				visited[i] = true;
				Dfs(i, depth+1);
				visited[i] = false;
			}
		}
	}

}
