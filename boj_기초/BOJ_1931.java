package boj_기초;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

public class BOJ_1931 {
	public static Scanner sc;
	public static int N;
	public static int result = 1;
	public static ArrayList<int[]> meeting;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		sc = new Scanner(System.in);
		meeting = new ArrayList<>();
		N = sc.nextInt();

		for (int i = 0; i < N; i++) {
			int start = sc.nextInt();
			int end = sc.nextInt();
			int[] tempTime = { start, end };
			meeting.add(tempTime);
		}

		// meeting end time sorting
		Collections.sort(meeting, new Comparator<int[]>() {

			@Override
			public int compare(int[] val1, int[] val2) {
				// TODO Auto-generated method stub
				if(val1[1] == val2[1]) return val1[0] - val2[0];
				else return val1[1] - val2[1];
			}
		});

//		for (int[] item : meeting) {
//			System.out.print(item[0] + ",");
//			System.out.println(item[1]);
//		}
		int end = meeting.get(0)[1];
		if(meeting.size() == 1){
			result = 1;
		} else {
			for (int j = 1; j < meeting.size(); j++) {
				// 다음 회의 지정
				if (meeting.get(j)[0] >= end) {
					result += 1;
					end = meeting.get(j)[1];
				}
			}
		}
		System.out.println(result);

	}
}
