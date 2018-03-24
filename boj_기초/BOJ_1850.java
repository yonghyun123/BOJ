package boj_기초;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.StringTokenizer;

/*
 * 
 * 모든 자리가 1로만 이루어져있는 두 자연수 A와 B가 주어진다. 이 때, A와 B의 최대 공약수를 구하는 프로그램을 작성하시오.

예를 들어, A가 111이고, B가 1111인 경우에 A와 B의 최대공약수는 1이고, A가 111이고, B가 111111인 경우에는 최대공약수가 111이다.

입력
첫째 줄에 두 자연수 A와 B를 이루는 1의 개수가 주어진다. 입력되는 수는 19자리를 넘지 않는 자연수이다.

출력
첫째 줄에 A와 B의 최대공약수를 출력한다. 정답은 천만 자리를 넘지 않는다.

예제 입력 
3 4
예제 출력 
1
예제 입력 
3 6
예제 출력  
111
 */
public class BOJ_1850 {
	public static Scanner sc;
	public static BufferedReader br;
	public static StringTokenizer st;
	public static int  N1, N2;
	public static long  result;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		br = new BufferedReader(new InputStreamReader(System.in));
		
		try {
			st = new StringTokenizer(br.readLine(), " ");
			while(st.hasMoreTokens()){
				N1 = Integer.parseUnsignedInt(st.nextToken());
				N2 = Integer.parseUnsignedInt(st.nextToken());
			}
			
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		
		for(int i = 1; i <= gcd(N1,N2); i++){
			System.out.print(1);
		}

	}
	
	public static int gcd(int N1, int N2){
		if(N2 == 0){
			return N1;
		} else {
			return gcd(N2, N1 % N2);
		}
	}
}
