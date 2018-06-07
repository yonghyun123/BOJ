package hanium;

/*
 * 
 * 앞에서부터 읽을 때와 뒤에서부터 읽을 때 똑같은 단어를 팰린드롬(palindrome)이라고 합니다. 예를들어서 racecar, 10201은 팰린드롬 입니다.

두 자연수 n, m이 매개변수로 주어질 때, n 이상 m 이하의 자연수 중 팰린드롬인 숫자의 개수를 return 하도록 solution 함수를 완성해 주세요.

제한사항
m은 500,000이하의 자연수이며, n은 m 이하의 자연수입니다.
 */

public class Ex01 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		

	}
	
	public static int solution(int n, int m){
		int answer = 0;
		
		for(int i = n; i <= m; i++){
			String palin = Integer.toString(i);
			String revPalin = new StringBuffer(palin).reverse().toString();
			
			if(palin.equals(revPalin)){
				answer += 1;
			}
			
		}
		
		return answer;
	}

}
