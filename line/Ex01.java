package line;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 교통카드
10점
  문제의 입력값은 각 언어의 표준입력(stdin) 함수를, 출력값은 표준출력(stdout) 함수를 사용해주세요.
청소년 교통카드
최초 잔액이 20,000원인 청소년 교통카드가 있다.

이 카드는 사용할 때마다 운임만큼 차감되는데, 운임은 이동한 거리에 따라 결정된다.

기본운임

40km까지 : 720원
추가 운임

41km부터 : 8km마다 80원 추가
(예: 48km까지 800원, 56km까지 880원)
각각의 이동 거리를 입력하면 카드의 최종 잔액을 출력하는 프로그램을 작성하시오.

유의사항
최소 이동거리는 4km이며 최대 이동거리는 178km이다. 이를 벗어나면 현재 잔액을 출력하고 프로그램을 종료한다.
더 이상 차감할 수 없으면 이동할 수 없으므로 현재 잔액을 출력하고 프로그램을 종료한다.
입력형식
각 이동거리가 띄어쓰기로 구분되어 입력된다. 예를 들어 8km를 이동한 후 다시 30km를 이동했다면 8 30이다.
출력 형식
카드에 남은 잔액을 출력한다.

입/출력 예시
⋇ 입출력 형식을 잘 지켜주세요.
␣ : 공백
↵ : 줄바꿈
−⇥ : 탭
보기 입력 1
11 128 15 111 59 31 70 102 50 172 88 56 40 41 12
출력 1
4160
 * @author yonghyun
 *
 */
public class Ex01 {
	public static int startMoney = 20000;
	
	public static void main(String[] args) throws IOException {
		
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      	StringTokenizer st = new StringTokenizer(br.readLine());
      	int size = st.countTokens();
      	int arr[] = new int[size];
      	for(int i=0; i<size; i++) {
    	  arr[i] = Integer.parseInt(st.nextToken());
      	}
      	
      	for (int i = 0; i < arr.length; i++) {
			if(arr[i] < 4 || arr[i] > 178) break;
			
			if(arr[i] <= 40) startMoney -= 720;
			else {
				startMoney -= 720;
				int restCnt = (arr[i] - 41)/8 + 1;
				startMoney -= restCnt*80;
				
			}
		}
      	System.out.println(startMoney);
	}
}
