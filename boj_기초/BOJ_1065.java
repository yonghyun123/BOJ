package boj_기초;

import java.util.Scanner;

/*
 * 
 * 어떤 양의 정수 X의 자리수가 등차수열을 이룬다면, 그 수를 한수라고 한다. 
 * 등차수열은 연속된 두 개의 수의 차이가 일정한 수열을 말한다. N이 주어졌을 때, 1보다 크거나 같고, 
 * N보다 작거나 같은 한수의 개수를 출력하는 프로그램을 작성하시오. 

입력
첫째 줄에 1,000보다 작거나 같은 자연수 N이 주어진다.

출력
첫째 줄에 1보다 크거나 같고, N보다 작거나 같은 한수의 개수를 출력한다.

예제 입력 
110
예제 출력 
99
 */
public class BOJ_1065 {
	
	public static Scanner sc;
	public static int N;
	public static int cnt;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		sc = new Scanner(System.in);
		N = sc.nextInt();
		cnt = 0;
		for(int i = 1; i <= N; i++){
			if(i < 100){
				cnt += 1;
			}else if(i < 1000){
				int tempI = i;
				int first = tempI % 10;		tempI /= 10;
				int tenth = tempI % 10;		tempI /= 10;
				int hundredth = tempI % 10;
				if((first - tenth) == (tenth - hundredth)){
					cnt += 1;
				}
			}
		}
		System.out.println(cnt);
	}
}
