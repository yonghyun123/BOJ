package programmers;


import java.util.Arrays;


/*
 * 프로그래머스
 * 완주하지 못한 선수 코딩테스트 연
 * 
 *존나 쉬운건데 감이 없다.............
 */
public class NotArrived {
	
	public static String solution(String[] participant, String[] completion){
		

		Arrays.sort(participant);
		Arrays.sort(completion);
		
		int i = 0;
		for( i = 0; i < completion.length; i++){
			if(!(participant[i].equals(completion[i]))){
				return participant[i];
			}
		}
		return participant[i];
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[] part = {"mislav","stanko","mislav","ana"}; 
		String[] comp = {"stanko","ana","mislav"};          
		
		
		System.out.println(solution(part,comp));

	}
	

}
