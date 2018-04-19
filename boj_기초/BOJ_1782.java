package boj_기초;

import java.util.Scanner;

/*
 * 
 * 디지털 화면에서 숫자(디지털 숫자)는 코레스코 콘도에 돌아다니는 엘리베이터에 나온 숫자처럼 쓴다.
 *  (항승이처럼 엘리베이터가 무서워서 못타는 사람은 어쩔수 없다. 항승이가 엘리베이터에 타는 날은 그날 잠자리가 축축할지도 모른다.)

어떤 디지털 숫자를 거울에 비춰봤을 때 그 숫자가 원래 숫자와 같으면 그 숫자를 거울 숫자라고 부른다.
 0과 1과 8은 서로 대칭이고, 2와 5는 서로 거울에 비췄을 때 반대 숫자를 보여준다. 다른 숫자는 대칭으로 보여지지 않는다.

예를 들어, 0, 101, 1521은 거울 숫자이다. 하지만, 1221이나 1010은 거울 숫자가 아니다.



두 수 A와 B가 들어오면, A와 B 사이에 있는 거울 숫자의 개수를 출력하는 프로그램을 작성하시오. A와 B도 포함한다.

입력
첫째 줄에 두 수 A와 B가 공백을 사이에 두고 주어진다. 0<=A, B<=10^18

출력
첫째 줄에 거울 숫자의 개수를 출력한다.

예제 입력 1 
0 100
예제 출력 1 
7
 */

public class BOJ_1782 {
	
	public static Scanner sc;
	public static long N1,N2;
	public static int cnt;
	public static boolean flag;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		long st1 = System.currentTimeMillis();
		
		sc = new Scanner(System.in);
		N1 = sc.nextLong();
		N2 = sc.nextLong();
		cnt = 0;
		flag = true;
		String temp1 = Long.toString(N1);
		String temp2 = Long.toString(N2);
		
		int digit1 = temp1.length() ; //n1의 자리수
		int digit2 = temp2.length(); //n2의 자리수
		
		int right = (int) Math.pow(10, (int)(Math.log(N2))); //right
		int left = (int) Math.pow(10, (int)(Math.log(N1))); //left
		
		for(long i = N1; i <= N2; i++){
			String str1 = Long.toString(i);
			
			
			flag = true;
			if(isCorrect(str1.length(), str1));
			for(int j = 0; j < (int)(str1.length()+1)/2; j++){

				if(str1.charAt(j) == '2' && str1.charAt(str1.length()-1-j) == '5'){
					continue;
				}
				else if(str1.charAt(j) == '5' && str1.charAt(str1.length()-1-j) == '2'){
					continue;
				}
				else if(str1.charAt(j) == '0' || str1.charAt(j) == '1' || str1.charAt(j) == '8'){
					if(str1.charAt(j) != str1.charAt(str1.length()-j-1)){
						flag = false; break;
					}
				}
				else { 
					flag = false; break;
				}
			}
			if(flag){
				System.out.println(i);
				cnt += 1;
			}
		}
		System.out.println(cnt);
		long st2 = System.currentTimeMillis();
		System.out.println(st2-st1);
		
	}
	
	public static boolean isCorrect(int digit, String str){
		// 다시 풀어야해
		if(digit == 0){
			return true;
		}
		if(str.substring(0,0) != "1"){
			return false;
		} else if(str.substring(0,0) != "2"){
			return false;
		} else if(str.substring(0,0) != "0"){
			return false;
		} else if(str.substring(0,0) != "8"){
			return false;
		} else if(str.substring(0,0) != "5"){
			return false;
		} else {
			isCorrect(digit - 1, str.substring(1,str.length()));
			return true;
		}
		
	}

}
