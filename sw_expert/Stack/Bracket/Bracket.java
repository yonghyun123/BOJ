package sw_expert.Stack.Bracket;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Stack;

public class Bracket {
	public static int T = 0;
	public static Scanner sc;
	public static Map<Character, Character> bracket;
	public static Stack<Character> stack;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		sc = new Scanner(System.in);
		bracket = new HashMap<>();
		
		
		bracket.put('}', '{');
		bracket.put(')', '(');
		bracket.put('>', '<');
		bracket.put(']', '[');
		
		while(T++ < 10){
			int resultFlag = 1;
			int inputLen = sc.nextInt();
			String input = sc.next();
			stack = new Stack<>();
			
			for(int i = 0; i < input.length(); i++){
				if(input.charAt(i) == '(' || input.charAt(i) == '<' || input.charAt(i) == '{' || input.charAt(i) == '[') {
					stack.push(input.charAt(i));
				} else { // 닫는괄호 혹은 괄호가 아닐시
					if(stack.isEmpty()){
						// 0
						resultFlag = 0;
						
					} else {
						char temp = input.charAt(i);
						if(stack.peek() == bracket.get(temp)){
							stack.pop();
						}
						else {
							// 0
//							System.out.println("2번");
							resultFlag = 0;
						}
					}
				}
			}
			if(!stack.isEmpty()){
//				System.out.println("3번");
				resultFlag = 0;
			}
			System.out.println("#" + T + " " + resultFlag);
		}
	}

}
