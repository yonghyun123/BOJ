package nts;

import java.util.HashMap;
import java.util.Map;

public class Ex03 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(solution("zothf", "otz","hh"));
	}

	public static String solution(String rule, String A, String B){
		String answer = "";
		Map<Character, Integer> operMap = new HashMap<>();
		Map<Integer, Character> intMap = new HashMap<>();
		
		for(int i = 0; i < rule.length(); i++){
			operMap.put(rule.charAt(i), i);
			intMap.put(i, rule.charAt(i));
		}
		int carry = 0;
		//A가 더 클때

			for(int i = A.length() - 1; i > 0; i--){
				
				if(carry ==1){
					if( (operMap.get(A.charAt(i)) - 1) >= operMap.get(B.charAt(i))){
						int temp = (operMap.get(A.charAt(i)) -1) - operMap.get(B.charAt(i));
						answer += intMap.get(temp);
						carry = 0;
					} else {
						carry = 1;
						int temp = (A.length() - operMap.get(B.charAt(i))) + operMap.get(A.charAt(i));
						answer += intMap.get(temp);
					}
				}
				else {
					//빼는 쪽이 더클때
					if(operMap.get(A.charAt(i)) >= operMap.get(B.charAt(i))){
						int temp = operMap.get(A.charAt(i)) - operMap.get(B.charAt(i));
						answer += intMap.get(temp);
					} else {
						carry = 1;
						int temp = A.length() - operMap.get(B.charAt(i));
						answer += intMap.get(temp);
					}
				}
				

			}
	return answer;
	}
}
