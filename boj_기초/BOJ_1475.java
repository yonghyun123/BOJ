package boj_기초;

import java.util.Scanner;
import java.util.Stack;

/*
 * 
 * 다솜이는 은진이의 옆집에 새로 이사왔다. 다솜이는 자기 방 번호를 예쁜 플라스틱 숫자로 문에 붙이려고 한다.
 * 다솜이의 옆집에서는 플라스틱 숫자를 한 세트로 판다. 한 세트에는 0번부터 9번까지 숫자가 하나씩 들어있다. 
 * 다솜이의 방 번호가 주어졌을 때, 필요한 세트의 개수의 최소값을 출력하시오. (6은 9를 뒤집어서 이용할 수 있고, 9는 6을 뒤집어서 이용할 수 있다.)
입력
첫째 줄에 다솜이의 방 번호 N이 주어진다. N은 1,000,000보다 작거나 같은 자연수 또는 0이다.

출력
첫째 줄에 필요한 세트의 개수를 출력한다.

예제 입력 
9999

예제 출력 
2
 */

public class BOJ_1475 {
	public static Scanner sc;
	public static int N;
	public static Stack<Integer> st;
	public static int []input;
	public static int []bucket;
	public static int digit;
	
	public static int sixNine;
	public static int max;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		sc = new Scanner(System.in);
		N = sc.nextInt();
		st = new Stack<>();
		digit = 1;
		
		
		while(N >= 10){
			int temp = N % 10;
			st.push(temp);
			N /= 10;
			digit += 1;
		}
		st.push(N);
		
		input = new int[digit];
		bucket = new int[10];
		
		digit = 0;
		while(!st.isEmpty()){
			input[digit++] = st.pop();
		}
		
		for(int i = 0; i < input.length; i++){
			bucket[input[i]] += 1;
		}
		sixNine = bucket[6]+bucket[9];
		for(int i = 0; i < bucket.length; i++){
			if(i == 6 || i == 9) continue;
			if(max < bucket[i]) max = bucket[i];
		}
		
		if(sixNine > max) { 
			System.out.println((sixNine+1) / 2);
		} else {
			System.out.println(max);
		}
		
	}

}
