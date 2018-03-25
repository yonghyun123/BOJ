package boj_기초;

import java.util.Scanner;

/*
 * 
 * 문제
M과 N이 주어질 때 M이상 N이하의 자연수 중 완전제곱수인 것을 모두 골라 그 합을 구하고 그 중 최소값을 찾는 프로그램을 작성하시오. 예를 들어 M=60, N=100인 경우 60이상 100이하의 자연수 중 완전제곱수는 64,  81,  100 이렇게 총 3개가 있으므로 그 합은 245가 되고 이 중 최소값은 64가 된다.

입력
첫째 줄에 M이, 둘째 줄에 N이 주어진다. M과 N은 10000이하의 자연수이며 M은 N보다 같거나 작다.

출력
M이상 N이하의 자연수 중 완전제곱수인 것을 모두 찾아 첫째 줄에 그 합을, 둘째 줄에 그 중 최소값을 출력한다. 단, M이상 N이하의 자연수 중 완전제곱수가 없을 경우는 첫째 줄에 -1을 출력한다.

예제 입력
60
100
예제 출력 
245
64
 */

public class BOJ_1977 {
	public static Scanner sc;
	public static int N1,N2;
	public static int total,min;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		sc = new Scanner(System.in);
		N1 = sc.nextInt();
		N2 = sc.nextInt();
		
		double sqrtN1 = Math.ceil(Math.sqrt(N1)); //올림
		double sqrtN2 = Math.floor(Math.sqrt(N2)); //버림
		if(sqrtN1 > sqrtN2){
			System.out.println(-1);
		} else{
			for(double i = sqrtN1; i <= sqrtN2; i++){
				total += i*i;
			}
			System.out.println(total);
			System.out.println((int)(sqrtN1 * sqrtN1));
		}

	}
}
