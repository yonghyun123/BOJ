package boj_기초;

import java.util.Scanner;

/*
 * 
 * 서로 다른 N개의 자연수의 합이 S라고 한다. S를 알 때, 자연수 N의 최대값은 얼마일까?

입력
첫째 줄에 자연수 S(1≤S≤4,294,967,295)가 주어진다.

출력
첫째 줄에 자연수 N의 최대값을 출력한다.

예제 입력 1 
200
예제 출력 1 
19
 */
public class BOJ_1789 {
	public static Scanner sc;
	public static long N;
	public static long result;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		sc = new Scanner(System.in);
		N = sc.nextLong();
		result = 1;
		
		while(result * (result+1) <= N*2){
			result++;
		}
		System.out.println(--result);
	}

}
