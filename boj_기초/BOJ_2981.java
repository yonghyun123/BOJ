package boj_기초;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;
import java.util.Stack;

/*
 * 
 * 트럭을 타고 이동하던 상근이는 경찰의 검문을 받게 되었다. 경찰은 상근이가 운반하던 화물을 하나하나 모두 확인할 것이기 때문에, 검문하는데 엄청나게 오랜 시간이 걸린다.

상근이는 시간을 떼우기 위해서 수학 게임을 하기로 했다.

먼저 근처에 보이는 숫자 N개를 종이에 적는다. 그 다음, 종이에 적은 수를 M으로 나누었을 때, 나머지가 모두 같게 되는 M을 모두 찾으려고 한다. M은 1보다 커야 한다.

N개의 수가 주어졌을 때, 가능한 M을 모두 찾는 프로그램을 작성하시오.

입력
첫째 줄에 종이에 적은 수의 개수 N이 주어진다. (2 ≤ N ≤  100)

다음 줄부터 N개 줄에는 종이에 적은 수가 하나씩 주어진다. 이 수는 모두 1보다 크거나 같고, 1,000,000,000보다 작거나 같은 자연수이다. 같은 수가 두 번 이상 주어지지 않는다.

항상 M이 하나 이상 존재하는 경우만 입력으로 주어진다.

출력
첫재 줄에 가능한 M을 공백으로 구분하여 모두 출력한다. 이 때, M은 증가하는 순서이어야 한다.

예제 입력 
3
6
34
38
예제 출력
2 4
 */

public class BOJ_2981 {
	public static Scanner sc;
	public static int T;
	public static ArrayList<Integer> input;
	public static int dividend;
	public static boolean flag = false;
	
	public static ArrayList<Integer> result;
	public static ArrayList<Integer> divider;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		sc = new Scanner(System.in);
		T = sc.nextInt();
		input = new ArrayList<>();
		result = new ArrayList<>();
		divider = new ArrayList<>();
		
		for(int i = 0; i < T; i++){
			int temp = sc.nextInt();
			input.add(temp);
		}
		
		Collections.sort(input);
		dividend = input.get(input.size()-1) - input.get(0);
		
		for(int i = 2; i <= dividend; i++){
			// 나누어떨어지면 약수
			if(dividend % i == 0){
				divider.add(i);
			}
		}
		
		for(Integer item : divider){
			flag = false;
			int reminder = input.get(0) % item;
			
			for(int i = 1; i < input.size(); i++){
				if(input.get(i) % item != reminder){
					flag = true;
					break;
				}
			}
			if(!flag){
				result.add(item);
			}
		}
		for(Integer result : result){
			System.out.print(result + " ");
		}
	}
}
