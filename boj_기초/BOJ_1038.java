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
	public static int [][]dpGraph; 
	
	public static int N;
	public static int result;
	public static int bound;
	public static int sum;
	
	
	public static int C; // 앞자리 수 column
	public static int R; // 자리수 row
	public static boolean flag;  // exit for loop

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		sc = new Scanner(System.in);
		N = sc.nextInt();
		
		dpGraph = new int[10][10];
		
		bound = N;
		result = 0;
		sum = 0;
		
		//dp 표만들기
		//첫번째 행
		for(int i = 0; i < 10; i ++){
			dpGraph[0][i] = 1;
		}
		
		//(1,1) (2,2) (3,3) ...
		for(int i = 1; i < 10; i++){
			dpGraph[i][i] = 1;
		}
		
		//full graph
		for(int i = 1; i < 10; i++){
			for(int j = i + 1; j < 10; j++){
				int sum = 0;
				for(int k = i - 1; k < j; k++){
					sum += dpGraph[i-1][k];
				}
				dpGraph[i][j] = sum;
			}
		}
		// print graph
		/*
		for(int i = 0; i < 10; i++){
			for(int j = 0; j < 10; j++){
				System.out.print(dpGraph[i][j]+ " ");
			}
			System.out.println();
		}
		*/
		
		//calculate boundary
		for(int i = 0; i < 10; i++){
			for(int j = i; j < 10; j++){
				if(bound >= dpGraph[i][j]) { 
					bound -= dpGraph[i][j];
				}else{
					C = j;
					R = i;
					flag = true;
					break;
				}
			}
			if(flag){
				break;
			}
		}
		dfs(C, R+1, C, C*10);
		System.out.println(sum);
	}
	
	public static void dfs(int C, int R, int prevNum, int curNum){
		if(result == bound){
			sum = curNum;
			System.out.println(sum);
			return;
		}
		
		if(R == 1){
			result += 1;
			return;
		}

		for(int i = 0; i < C; i++){

			if(i < prevNum){
				System.out.println("ddd");
				dfs(C, R - 1, i, (curNum+(i * (int)Math.pow(10, R-2))));
			}
			
			if(result == bound){
				break;
			}
		}
	}
}
