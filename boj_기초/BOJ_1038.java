package boj_기초;

import java.util.ArrayList;
import java.util.Scanner;

/*
 * 
 * 음이 아닌 정수 X의 자릿수가 가장 큰 자릿수부터 작은 자릿수까지 감소한다면, 
 * 그 수를 감소하는 수라고 한다. 예를 들어, 321과 950은 감소하는 수지만, 
 * 322와 958은 아니다. N번째 감소하는 수를 출력하는 프로그램을 작성하시오. 0은 0번째 감소하는 수이고, 1은 1번째 감소하는 수이다. 만약 N번째 감소하는 수가 없다면 -1을 출력한다.

입력
첫째 줄에 N이 주어진다. N은 1,000,000보다 작거나 같은 자연수 또는 0이다.

출력
첫째 줄에 N번째 감소하는 수를 출력한다.

예제 입력 
18
예제 출력 
42
 */
public class BOJ_1038 {
	public static Scanner sc;

	public static int N;
	public static int cnt;
	public static int result;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		sc = new Scanner(System.in);
		N = sc.nextInt();
		
	
		for(int i = 1; i < 10; i++){
			int digit = 0;
			dfs(i,i,digit);
			if(cnt == N){
//				System.out.println("ddd");
				break;
			}
		}
		System.out.println(result);
	}
	
	public static void dfs(int curNum, int postNum, int digit){
		System.out.println(curNum);
		if(digit == 0){
			cnt++;
			if(cnt == N){
			
				result = curNum;
				return;
			}
		} else {
			for(int i = 0; i < postNum; i++){
				dfs(curNum * 10 + i, i, digit-1);
				if(cnt == N) return;
			}
		}
	}
	
}
