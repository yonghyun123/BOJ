package nts;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class Ex02 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(solution("3+[{(5+1)-1}+3]"));
	}
	
	public static boolean solution(String input){
		//stack 내에서 우선순위가 가장 높은것이 [{( 순서
		Stack<Character> st = new Stack<>();
		Map<Character, Integer> priority = new HashMap<>();
		priority.put('[', 0);
		priority.put('{', 1);
		priority.put('(', 2);
		
		Map<Character, Character> paren = new HashMap<>();
		paren.put(']', '[');
		paren.put('}', '{');
		paren.put(')', '(');
		
		for(int i = 0; i < input.length(); i++){
			//여는괄호라면
			if(input.charAt(i) == '[' || input.charAt(i) == '{' || input.charAt(i) == '('){
				if(st.isEmpty()) {
					st.push(input.charAt(i));
				}
				else {
					//스택 내에서 우선순위가 뒤바뀐경우
					if(priority.get(st.peek()) >= priority.get(input.charAt(i))) return false;
					else {
						st.push(input.charAt(i));
					}
				}
			} 
			//닫는괄호라면
			else if(input.charAt(i) == ']' || input.charAt(i) == '}' || input.charAt(i) == ')'){ 
				if(st.isEmpty()) return false;
				else{
					if(st.peek() != paren.get(input.charAt(i))) {
						return false;	
					} else {
						st.pop();
					}
				}
			}
		}
		
		return true;
	}

}
