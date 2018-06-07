package hanium;

import java.util.Arrays;

/*
 * 
 * 조선소에서는 1시간 동안 남은 일 중 하나를 골라 작업량 1만큼 처리할 수 있습니다. 
 * 조선소에서 작업할 수 있는 N 시간과 각 일에 대한 작업량이 담긴 배열(works)이 있을 때 
 * 배상 비용을 최소화한 결과를 반환하는 함수를 만들어 주세요. 예를 들어, N=4일 때, 
 * 선박별로 남은 일의 작업량이 works = [4, 3, 3]이라면 배상 비용을 최소화하기 위해 
 * 일을 한 결과는 [2, 2, 2]가 되고 배상 비용은 22 + 22 + 22 = 12가 되어 12를 반환해 줍니다.

제한사항
일할 수 있는 시간 N : 1,000,000 이하의 자연수
배열 works의 크기 : 1,000 이하의 자연수
각 일에 대한 작업량 : 1,000 이하의 자연수
 */
public class Ex02 {
	
	public static void main(String[] args){
		int N = 2;
		int[] works = {3,3,3};
		System.out.println(solution(N,works));
		
	}
	public static int solution(int no, int[] works) {
		int answer = 0;
		int tempSum = 0;
		
		for(int i = 0; i < works.length; i++){
			tempSum += works[i];
		}
		
		if(no >= tempSum){
			return 0;
		} else{
			while(no > 0){
				Arrays.sort(works);
				works[works.length-1] -= 1;
				no -= 1;
			}
		}

		for(int i = 0; i < works.length; i++){
			answer += Math.pow(works[i],2);
		}
		return answer;
	}

}
