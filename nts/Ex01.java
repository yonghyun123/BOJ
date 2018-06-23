package nts;

public class Ex01 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] test = {3,2,1,2};
		int[] temp = solution(test);
	}

	public static int[] solution(int[] grade) {
		int[] answer = new int[grade.length];
		for (int i = 0; i < grade.length; i++) {
			int level = 1;
			for (int j = 0; j < grade.length; j++) {
				if (i == j)
					continue;
				// i가 기준
				if (grade[i] < grade[j])
					level += 1;
			}
			answer[i] = level;
		}

		return answer;

	}

}
