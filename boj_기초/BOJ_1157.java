package boj_기초;

import java.util.Scanner;

/*
 * 문제
알파벳 대소문자로 된 단어가 주어지면, 이 단어에서 가장 많이 사용된 알파벳이 무엇인지 알아내는 프로그램을 작성하시오. 단, 대문자와 소문자를 구분하지 않는다.

입력
첫째 줄에 알파벳 대소문자로 이루어진 단어가 주어진다. 주어지는 단어의 길이는 1,000,000을 넘지 않는다.

출력
첫째 줄에 이 단어에서 가장 많이 사용된 알파벳을 대문자로 출력한다. 단, 가장 많이 사용된 알파벳이 여러 개 존재하는 경우에는 ?를 출력한다.

예제 입력 
Mississipi
예제 출력 
?
예제 입력 2 
zZa
예제 출력 2 
Z
예제 입력 3 
z
예제 출력 3 
Z
예제 입력 4 
baaa
예제 출력 4 
A
 * 
 */
public class BOJ_1157 {
	public static Scanner sc;
	public static String input;
	public static String transInput;
	public static int []bucket;
	public static boolean flag; // ? 판별
	public static int max;
	public static char ans;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		sc = new Scanner(System.in);
		input = sc.next(); //문자열 입력
		bucket = new int[26]; // 알파벳 갯수 넣을 bucket;
		max = 0;
		
		transInput = input.toUpperCase();
		
		for(int i = 0; i < transInput.length(); i++){
			bucket[transInput.charAt(i) - 65] += 1;
			if(max < bucket[transInput.charAt(i) - 65]){
				ans = transInput.charAt(i);
				max = bucket[transInput.charAt(i) - 65];
			} else if (max == bucket[transInput.charAt(i) - 65]) {
				ans = '?';
			}
		}
		System.out.println(ans);
	}
}
