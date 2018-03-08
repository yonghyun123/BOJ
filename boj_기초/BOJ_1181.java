package boj_기초;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Scanner;
import java.util.stream.Collectors;

/*
 * 알파벳 소문자로 이루어진 N개의 단어가 들어오면 아래와 같은 조건에 따라 정렬하는 프로그램을 작성하시오.

길이가 짧은 것부터
길이가 같으면 사전 순으로
입력
첫째 줄에 단어의 개수 N이 주어진다. (1≤N≤20,000) 둘째 줄부터 N개의 줄에 걸쳐 알파벳 소문자로 이루어진 단어가 한 줄에 하나씩 주어진다.
주어지는 문자열의 길이는 50을 넘지 않는다.
 

출력
조건에 따라 정렬하여 단어들을 출력한다. 단, 같은 단어가 여러 번 입력된 경우에는 한 번씩만 출력한다.
 

예제 입력 
13
but
i
wont
hesitate
no
more
no
more
it
cannot
wait
im
yours
예제 출력 

i
im
it
no
but
more
wait
wont
yours
cannot
hesitate
 */
public class BOJ_1181 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		HashSet<String> str = new HashSet<>();
		int T = sc.nextInt();
		
		//입력
		//next와 nextLine 구별잘해야해 이것때문에 오래걸렸어
		
		for(int i = 0; i < T; i++){
			String temp = sc.next();
			str.add(temp);
		}
	
		ArrayList<String> resultList = new ArrayList<>(str);
		
		for(int i = 0; i < resultList.size(); i++){
			for(int j = 0; j < resultList.size()-i-1; j++){
				if(resultList.get(j).length() > resultList.get(j+1).length()){
					Collections.swap(resultList, j, j+1);
				}
				else if(resultList.get(j).length() == resultList.get(j+1).length()){
					if(resultList.get(j).compareTo(resultList.get(j+1)) > 0){
						Collections.swap(resultList, j, j+1);
					}
				}
			}
		}
		
		//2줄짜리코드 
		String []strArr = new String[str.size()];
		str.toArray(strArr); // HashSet을 StringArrary로 복
		Arrays.sort(strArr); // 사전순 정렬
		
	    Arrays.sort(strArr, new Comparator<String>() {

			@Override
			public int compare(String o1, String o2) {
				// TODO Auto-generated method stub
				return Integer.compare(o1.length(), o2.length());
			}
	    	
		});

		//출력
		for(String result : strArr){
			System.out.println(result);
		}
	}
}
