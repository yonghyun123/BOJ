package boj_기초;
/*
 * 
 * 어떤 수 X가 1보다 큰 제곱수로 나누어 떨어지지 않을 때, 제곱ㄴㄴ수라고 한다. 제곱수는 정수의 제곱이다.
 *  min과 max가 주어지면, min과 max를 포함한 사이에 제곱ㄴㄴ수가 몇 개 있는지 출력한다.
입력
첫째 줄에 min과 max가 주어진다. min은 1보다 크거나 같고, 1,000,000,000,000보다 작거나 같은 자연수이고, 
max는 min보다 크거나 같고, min+1,000,000보다 작거나 같은 자연수이다.

출력
첫째 줄에 [min,max]구간에 제곱ㄴㄴ수가 몇 개인지 출력한다.

예제 입력 1 
1 10
예제 출력 1 
7
 */

import java.util.ArrayList;
import java.util.Scanner;

public class BOJ_1016 {
	public static Scanner sc;
	public static long N1;
	public static long N2;
	public static ArrayList<Integer> bucket;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		sc = new Scanner(System.in);
		N1 = sc.nextLong(); //min
		N2 = sc.nextLong(); //max
		bucket = new ArrayList<Integer>();
		
		for(int i = 1, k = 0; i*i <= N2; i++, k++){
			bucket.add(i*i);
		}
		for(int item : bucket){
			System.out.println(item);
		}

	}

}
