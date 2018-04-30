package sw_expert.String;

import java.util.HashMap;
import java.util.Map;

//pattern 알고리즘
public class BoyerMoore {

	public static void main(String[] args) {
		// TODO Auto-generated method stub		
		String input = "aaabcecd";
		String pattern = "ecd";
		boolean resultFlag = false;
		int inputIdx = pattern.length() - 1;
		int patternIdx = pattern.length() - 1;
		Map<String, Integer> skip = new HashMap<>();
		skip.put("d", 0);
		skip.put("c", 1);
		skip.put("e", 2);
		
		while(inputIdx < input.length()){
			patternIdx = pattern.length() - 1;
			System.out.println("inputIdx = "+inputIdx);
			if(isSame(inputIdx, patternIdx, input, pattern)){
				resultFlag = true;
				break;
			} else {
				if(skip.get(input.charAt(inputIdx)) != null){
					inputIdx += skip.get(input.charAt(inputIdx));
				} else {
					inputIdx += pattern.length();
				}
			}
		}
		if(resultFlag){
			System.out.println("Find!");
		} else {
			System.out.println("Not find!");
		}
		
		
	}
	
	public static boolean isSame(int inputIdx, int patternIdx, String input, String pattern){
		if(patternIdx == -1){
			return true;
		}
		if(input.charAt(inputIdx) != pattern.charAt(patternIdx)){
			return false;
		} else {
			return isSame(inputIdx-1, patternIdx - 1, input, pattern);
		}
	}

}
