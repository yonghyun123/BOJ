package boj_기초;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

/*
 * 
 * 왕비를 피해 일곱 난쟁이들과 함께 평화롭게 생활하고 있던 백설공주에게 위기가 찾아왔다. 일과를 마치고 돌아온 난쟁이가 일곱 명이 아닌 아홉 명이었던 것이다.

아홉 명의 난쟁이는 모두 자신이 "백설 공주와 일곱 난쟁이"의 주인공이라고 주장했다. 뛰어난 수학적 직관력을 가지고 있던 백설공주는, 
다행스럽게도 일곱 난쟁이의 키의 합이 100이 됨을 기억해 냈다.

아홉 난쟁이의 키가 주어졌을 때, 백설공주를 도와 일곱 난쟁이를 찾는 프로그램을 작성하시오.

입력
아홉 개의 줄에 걸쳐 일곱 난쟁이의 키가 주어진다. 주어지는 키는 100을 넘지 않는 자연수이며, 
아홉 난쟁이의 키는 모두 다르며, 가능한 정답이 여러가지인 경우에는 아무거나 출력한다.

출력
일곱 난쟁이의 키를 오름차순으로 출력한다.

예제 입력 
20
7
23
19
10
15
25
8
13
예제 출력 
7
8
10
13
19
20
23
 */
public class BOJ_2309 {
	public static Scanner sc;
	public static int[] input;
	public static ArrayList<Integer> result;
	public static boolean flag;
	
	public static int total;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		sc = new Scanner(System.in);
		input = new int[9];
		result = new ArrayList<>();
		total = 0;
		
		for(int i = 0; i < 9; i++){
			int temp = sc.nextInt();
			input[i] = temp;
			result.add(temp);
			total += temp;
		}
		//total => 9명 난쟁이 키의 총합
		//특정 2명의 난쟁이 키를 빼면서 100을 만들면 성공
		
		for(int i = 0; i < (int)(input.length - 1); i++){
			for(int j = i + 1; j < input.length; j++){
				if( ( total - (input[i] + input[j]) )== 100){
					result.remove((Integer)input[i]);
					result.remove((Integer)input[j]);
					flag = true;

					break;
				}
			}
			if(flag) break;
		}
		Collections.sort(result);
		for(int item : result){
			System.out.println(item);
		}	
	}
}
