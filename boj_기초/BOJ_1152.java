package boj_기초;

import java.util.Scanner;
import java.util.StringTokenizer;

/*
 * 
 * 영어 대소문자와 띄어쓰기만으로 이루어진 문장이 주어진다. 이 문장에는 몇 개의 단어가 있을까? 이를 구하는 프로그램을 작성하시오.

입력
첫 줄에 영어 대소문자와 띄어쓰기로 이루어진 문장이 주어진다. 이 문장의 길이는 1,000,000을 넘지 않는다. 
단어는 띄어쓰기 한 개로 구분되며, 공백이 연속해서 나오는 경우는 없다.

출력
첫째 줄에 단어의 개수를 출력한다.

예제 입력 
The Curious Case of Benjamin Button
예제 출력 
6
 */

public class BOJ_1152 {
	public static Scanner sc;
	public static String str;
	public static StringTokenizer st;
	public static int result;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		sc = new Scanner(System.in);
		str = sc.nextLine();
		st = new StringTokenizer(str, " ");
		
		while(st.hasMoreTokens()){
//			System.out.println(st.nextToken());
			st.nextToken();
			result++;
		}
		System.out.println(result);
		
	
	}

}
