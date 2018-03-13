package boj_기초;

import java.util.Scanner;

/*
 * 
 * 피보나치 수는 0과 1로 시작한다. 0번째 피보나치 수는 0이고, 1번째 피보나치 수는 1이다. 
 * 그 다음 2번째 부터는 바로 앞 두 피보나치 수의 합이 된다.

이를 식으로 써보면 Fn = Fn-1 + Fn-2 (n>=2)가 된다.

n=17일때 까지 피보나치 수를 써보면 다음과 같다.

0, 1, 1, 2, 3, 5, 8, 13, 21, 34, 55, 89, 144, 233, 377, 610, 987, 1597

n이 주어졌을 때, n번째 피보나치 수를 구하는 프로그램을 작성하시오.

입력
첫째 줄에 n이 주어진다. n은 1,000,000,000,000,000,000보다 작거나 같은 자연수이다.

출력
첫째 줄에 n번째 피보나치 수를 1,000,000으로 나눈 나머지를 출력한다.

예제 입력 
1000
예제 출력 
228875
 */
public class BOJ_2749 {
	private static final int MOD = 1000000;
	private static final int P = MOD/10*15; //피사노 주기.
	public static Scanner sc;
	public static int N;
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		sc = new Scanner(System.in);
		
		N = sc.nextInt();
		
		System.out.println(fibo(N));
	}
	
	public static long fibo(int N){
		long prev = 0;
		long current = 1;
		long next = 0;
		
		if(N == 0) return 0 % MOD;
		if(N == 1) return 1 % MOD;
		
		//N = 3이면 2번회전 return 1
		for(int i = 2; i < P; i++){
			next = prev + current;
			next %= MOD;
			prev = current ;
			current = next;
			System.out.println(next);
		}
		return next % P;
	}
}
