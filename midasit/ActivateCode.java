package midasit;

import java.util.Scanner;

/*활성화 코드 만들기(ActivateCode)

사용자로부터 입력된 시리얼 번호와 웹 인증 서버에서 받은 토큰을 조합하여 활성화 코드를 만들고자 합니다.
-------------110110110--------
다음 그림은 시리얼 번호이며, 첫 번째 입력된 정수의 2진수 변환 결과입니다. (ex. 438)
-------------xxx1101xx--------
빨간색으로 표시한 것은 토큰이며, 두 번째 입력된 정수의 2진수 변환 결과입니다. (ex. 13)


활성화 코드는 시리얼 번호에서 토큰을 삭제하는 방식으로 만들어집니다. 토큰은 시리얼 번호에서 0개 이상 나타날 수 있으며, 
삭제 순서에 따라서 남은 시리얼 번호가 달라집니다. 이 중에서 가장 작은 자릿수의 시리얼 번호가 활성화 코드입니다.

다음은 활성화 코드를 생성하는 예시입니다. 1)의 방법으로 생성하면 1자리의 활성화 코드가 생성되고 2)의 방법으로 하면 
5자리의 활성화 코드가 생성됩니다. 따라서 가장 작은 활성화 코드의 자릿수는 1이 됩니다.


활성화 코드의 자릿수를 출력하는 프로그램을 작성해 주시기 바랍니다.

입력

입력은 표준 입력(stdin)으로 주어집니다.
첫 번째 줄에는 N이 주어집니다. N은 시리얼 넘버입니다. (100 <= N <= 999999999999)
두 번째 줄에는 X가 주어집니다. X는 제거할 인증 토큰입니다. (8 <= X <= 128)

출력

출력은 표준 출력(stdout)으로 이루어집니다.
시리얼 넘버에서 인증 토큰을 모두 제거하고 난 후의 가장 작은 자릿수를 출력합니다.
 * 
 * 
 * 
 * 
입력
438
13

출력
1
 */

public class ActivateCode {
	public static Scanner sc;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		sc = new Scanner(System.in);
		
		int N1 = sc.nextInt();
		int N2 = sc.nextInt();
		
		System.out.println(Integer.toBinaryString(N1));
		System.out.println(Integer.toBinaryString(N2));
		
		String input = Integer.toBinaryString(N1);
		String pattern = Integer.toBinaryString(N2);
		
		while(input.contains(pattern)){
			input = input.replace(pattern, "");
		}
		System.out.println(input);
		
	}

}
