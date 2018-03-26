package boj_기초;

import java.util.Scanner;

/*
 * 
 * 한수는 2차원 배열 (항상 2^N * 2^N 크기이다)을 Z모양으로 탐색하려고 한다. 
 * 예를 들어, 2*2배열을 왼쪽 위칸, 오른쪽 위칸, 왼쪽 아래칸, 오른쪽 아래칸 순서대로 방문하면 Z모양이다.
만약, 2차원 배열의 크기가 2^N * 2^N라서 왼쪽 위에 있는 칸이 하나가 아니라면, 배열을 4등분 한 후에 (크기가 같은 2^(N-1)로) 재귀적으로 순서대로 방문한다.
다음 예는 2^2 * 2^2 크기의 배열을 방문한 순서이다.
N이 주어졌을 때, (r, c)를 몇 번째로 방문하는지 출력하는 프로그램을 작성하시오.

다음 그림은 N=3일 때의 예이다.
입력
첫째 줄에 N r c가 주어진다. N은 15보다 작거나 같은 자연수이고, r과 c는 0보다 크거나 같고, 2^N-1보다 작거나 같은 정수이다

출력
첫째 줄에 문제의 정답을 출력한다.

예제 입력 
2 3 1
예제 출력 
11
예제 입력  
3 7 7
예제 출력
63
 */
public class BOJ_1074 {
	public static Scanner sc;
	public static int N,R,C;
	public static int result;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		sc = new Scanner(System.in);
		N = sc.nextInt();
		R = sc.nextInt();
		C = sc.nextInt();
		
		recursion((int)Math.pow(2, N), 0, 0);
	}
	
	public static void recursion(int N, int r, int c){
		// N =2 일때부터 숫자 count
//		System.out.println("N="+N+",r="+r+",c="+c);
//		System.out.println(result);
		if(N == 2){
			if(r == R && c == C){
				System.out.println(result);
			}
			result++;
			
			if(r == R && c+1 == C){
				System.out.println(result);
			}
			result++;
			
			if(r+1 == R && c == C){
				System.out.println(result);
			}
			result++;
			
			if(r+1 == R && c+1 == C){
				System.out.println(result);
			}
			result++;
			return;
		}
		
		recursion(N/2, r, c);
		recursion(N/2, r, c+N/2);
		recursion(N/2, r+N/2, c);
		recursion(N/2, r+N/2, c+N/2);
	}

}
