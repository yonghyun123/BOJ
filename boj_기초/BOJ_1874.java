package boj_기초;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Stack;

/*
 * 
 * 1부터 n까지의 수를 스택에 넣었다가 뽑아 늘어놓음으로써, 하나의 수열을 만들 수 있다. 이 때,
 *  스택에 push하는 순서는 반드시 오름차순을 지키도록 한다고 하자. 임의의 수열이 주어졌을 때 스택을 이용해 그 수열을 만들 수 있는지 없는지, 
 *  있다면 어떤 순서로 push와 pop 연산을 수행해야 하는지를 알아낼 수 있다. 이를 계산하는 프로그램을 작성하라.

입력
첫 줄에 n (1 ≤ n ≤ 100,000)이 주어진다. 둘째 줄부터 n개의 줄에는 수열을 이루는 1이상 n이하의 정수가 하나씩 순서대로 주어진다. 
물론 같은 정수가 두 번 나오는 일은 없다.

출력
입력된 수열을 만들기 위해 필요한 연산을 한 줄에 한 개씩 출력한다. push연산은 +로, pop 연산은 -로 표현하도록 한다. 불가능한 경우 NO를 출력한다.

예제 입력 
8
4
3
6
8
7
5
2
1
예제 출력 
+
+
+
+
-
-
+
+
-
+
+
-
-
-
-
-
 */
public class BOJ_1874 {
	public static Scanner sc;
	public static int T;
	public static Stack<Integer> st;
	public static Stack<Integer> tempSt;
	
	public static ArrayList<Character> resultOp; //결과값 저장
	
	public static int[] input;
	public static int idx;
	public static boolean flag;
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		sc = new Scanner(System.in);
		st = new Stack<>();
		tempSt = new Stack<>();
		resultOp = new ArrayList<>();
		
		idx = 1;
		flag = true;
		
		T = sc.nextInt();
		input= new int[T];
		
		//입력
		for(int i = 0; i < T; i++) {
			input[i] = sc.nextInt();
		}
		
		for(int i = T - 1; i >= 0; i--){
			tempSt.push(input[i]);
		}
		
		//stack 계산
		while(idx <= T){
			st.push(idx);
			resultOp.add('+');
			recursionPop(st, tempSt);
			idx += 1;
		}
		
		if(st.empty()) {
			for(Character ch : resultOp){
				System.out.println(ch);
			}
		} else {
			System.out.println("NO");
		}
	}
	
	public static void recursionPop(Stack<Integer> st, Stack<Integer> tempSt){
		if(!st.empty() && (int)st.peek() == (int)tempSt.peek()){
			st.pop();
			tempSt.pop();
			resultOp.add('-');
			recursionPop(st, tempSt);
		}
		else{
			return;
		}
	}
}
