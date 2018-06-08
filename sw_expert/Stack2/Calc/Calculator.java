package sw_expert.Stack2.Calc;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Stack;

public class Calculator {
	
	public static Scanner sc;
	public static int T = 0;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		sc = new Scanner(System.in);
		

		Map<Character, Integer> priority = new HashMap<>();
		priority.put('(', 0);
		priority.put('+', 1);
		priority.put('-', 1);
		priority.put('*', 2);
		priority.put('/', 2);
		
		while(T++ < 10){
			int N = sc.nextInt();
			Stack<Character> st = new Stack<>();
			int result = 0;
			String input = sc.next();
			String postStr = "";
			for(int i = 0; i < input.length(); i++){
				
				if(input.charAt(i) == '('){
					st.push(input.charAt(i));
				} else if(input.charAt(i) == '*' || input.charAt(i) == '/' || input.charAt(i) == '+' || input.charAt(i) == '-' ){
					if(st.isEmpty() || priority.get(st.peek()) < priority.get(input.charAt(i))){
						st.push(input.charAt(i));
					}
					// 스택안에 있는 연산자가 우선순위가 더 클때
					else {
						postStr += st.peek();
						st.pop();
						st.push(input.charAt(i));
					}
				
				} else if(input.charAt(i) == ')'){
					while(st.peek() != '('){
						postStr += st.peek();
						st.pop();
					}
					st.pop();
				} else{
					postStr += input.charAt(i);
				}
			}
			
			//stack에서 빠져나오지 못한 연산자 처리
			while(!st.isEmpty()){
				postStr += st.peek();
				st.pop();
			}
			result = postCalc(postStr);  
			System.out.println("#"+T+" "+result);
			
		}
	}
	public static int postCalc(String postStr){
		int answer = 0;
		Stack<Integer> st = new Stack<>();
		
		for(int i = 0; i < postStr.length(); i++){
			if(postStr.charAt(i) == '*' || postStr.charAt(i) == '/' || postStr.charAt(i) == '+' || postStr.charAt(i) == '-' ){
				int op1 = st.pop();
				int op2 = st.pop();
				
				switch(postStr.charAt(i)){
					case '*': st.push(op2 * op1); break;
					case '/': st.push(op2 / op1); break;
					case '+': st.push(op2 + op1); break;
					case '-': st.push(op2 - op1); break;
					default: break;
				}
			} else {
				st.push(Character.getNumericValue(postStr.charAt(i)));
			}
		}
		
		return st.peek();
	}

}
