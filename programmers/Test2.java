package programmers;

public class Test2 {
	
	public static void main(String[] args){
		String s = "abcdc";
		System.out.println(solution(s));
		
	}
	public static int solution(String s){
		int answer = 0;
		boolean resultflag = true;
		for(int i = 0; i < s.length(); i++){
			for(int j = 0; j <= i; j++){
				String checkStr = "";
				String revCheStr = "";
				for(int k = j; k < s.length()-i+j; k++){
					checkStr += s.charAt(k);
				}
				StringBuffer sb = new StringBuffer();
				sb.append(checkStr);
				revCheStr = sb.reverse().toString();
				
				if(checkStr.equals(revCheStr)){
					return checkStr.length();
				}
			}
		}
		return 1;
	}

}
