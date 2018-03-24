package boj_기초;

import java.util.Scanner;

/*
 * 
 * 
 * 두 자연수 A와 B에 대해서, A의 배수이면서 B의 배수인 자연수를 A와 B의 공배수라고 한다. 
 * 이런 공배수 중에서 가장 작은 수를 최소공배수라고 한다. 예를 들어, 6과 15의 공배수는 30, 60, 90등이 있으며, 최소 공배수는 30이다.

두 자연수 A와 B가 주어졌을 때, A와 B의 최소공배수를 구하는 프로그램을 작성하시오.

입력
첫째 줄에 테스트 케이스의 개수 T(1 ≤ T ≤ 1,000)가 주어진다. 둘째 줄부터 T개의 줄에 걸쳐서 A와 B가 주어진다. (1 ≤ A, B ≤ 45,000)

출력
첫째 줄부터 T개의 줄에 A와 B의 최소공배수를 입력받은 순서대로 한 줄에 하나씩 출력한다.

예제 입력 
3
1 45000
6 10
13 17
예제 출력 
45000
30
221
 */
public class BOJ_1934 {
	public static Scanner sc;
	public static int T;
	public static int N1,N2;
	public static int buffer;
	public static boolean flag;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		sc = new Scanner(System.in);
		T = sc.nextInt();

		for(int i = 0; i < T; i++){
			N1 = sc.nextInt();
			N2 = sc.nextInt();
			buffer = 1;
			
			for(int j = 1; j <= Math.min(N1, N2); j++){
//				if(N1 == N2){
//					flag = true;
//					break;
//				}
				if(N1 % j == 0 && N2 % j == 0){
					N1 /= j;
					N2 /= j;
					buffer *= j;
					j = 1;
				}
			}
			
//			if(flag){
//				System.out.println(N1);
//			} else {
//				System.out.println(N1 * N2 * buffer);
//			}
			System.out.println(N1);
			System.out.println(N2);
			System.out.println(buffer);
		}
	}

}
