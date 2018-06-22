package programmers;

public class Test2 {
	
	public static void main(String[] args){
		String s = "abcdcba";
		System.out.println(solution(s));
		
	}
	public static int solution(String s){
		int answer = 0;
		boolean resultflag = true;
		
		for(int i = 0; i < s.length(); i++){
			
			for(int j = 0; j <= i; j++){
				if(s.charAt(j) != s.charAt(s.length()-i+j-1)) continue;
				String checkStr = "";
				String revCheStr = "";
				for(int k = j; k < s.length()-i+j; k++){
					checkStr += s.charAt(k);
				}
				
				for(int k = 0; k < checkStr.length()/2; k++){
					if(checkStr.charAt(k) != checkStr.charAt(checkStr.length()-k-1)) break;
					if(k == (checkStr.length()/2 - 1) ) return checkStr.length();
				}
				
//				StringBuffer sb = new StringBuffer();
//				sb.append(checkStr);
//				revCheStr = sb.reverse().toString();
				
//				if(checkStr.equals(revCheStr)){
//					return checkStr.length();
//				}
			}
		}
		return 1;
	}

}
