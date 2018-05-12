package midasit;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.StringTokenizer;

/*당신에게 회사의 신입사원 명단이 주어질 것 입니다. 모든 신입사원에게는 아래의 규칙에 따라 이메일 주소가 부여되어야 합니다.

각 신입사원의 이름(Full Name)은 영문이며, 두 부분 또는 세 부분으로 구성 됩니다. 
각 부분은 이름(First Name), 중간이름(Middle Name, 선택적), 성(Last name)이고, 공백으로 구분됩니다. 
단, 성(Last Name)에는 하이픈이 추가로 포함 될 수 있습니다.

회사 이름 또한 영문 이며, 각 이메일 주소는 LastFirst@Company.com 형식을 사용해야 합니다.

First는 이름의 머리 글자입니다.
Last는 성입니다.
Company는 회사 이름입니다.
만들어지는 주소는 소문자이어야 하며 하이픈이 없어야 합니다.

또한 둘 이상의 사람이 동일한 전자 메일 주소를 가질 경우 "@"기호 앞에 후속 정수 (두 번째 주소부터 2를 부여)를 추가하여 주소를 구분합니다.

예) "jd@company.com"인 사람이 세 명인 경우 "jd@company.com", "jd2@company.com" , "jd3@company.com" 주소를 각각 할당해야 합니다.

이메일 주소를 생성하는 프로그램을 작성 해 주시기 바랍니다.

입력

입력은 표준 입력(stdin)으로 주어집니다.
입력의 첫 번째 줄은 회사 이름이고, 회사 이름의 길이(N)은 3<=N<=100 입니다. 
두 번째 줄은 부호 “,“로 구분된 사원의 이름 목록입니다.
입력되는 목록에서 신입사원 수는 3에서 1000명까지 허용됩니다.

출력

출력은 표준 출력(stdout)으로 이루어집니다.
사원 이름 목록과 동일한 순서로 이메일 주소 목록을 출력하여야 합니다.
이메일 주소 사이의 구분자는 쉼표와 공백 한 개입니다.
(예 doej@exmp.com, parkp@ exmp.com)
 * MIDASIT
John Doe, Peter Parker, Mary Jane Watson-Parker, James Doe, John Elvis Doe, Jane Doe, Penny Parker

출력
doej@midasit.com, parkerp@midasit.com, watsonparkerm@midasit.com, doej2@midasit.com, doej3@midasit.com, doej4@midasit.com, parkerp2@midasit.com

<예2>
입력
MIDASIT
,   John   Doe  ,    Peter Parker,  Mary  Jane      Watson-Parker  ,  James   Doe,  John Elvis Doe,    Jane    Doe ,  Penny Parker  ,

출력
doej@midasit.com, parkerp@midasit.com, watsonparkerm@midasit.com, doej2@midasit.com, doej3@midasit.com, doej4@midasit.com, parkerp2@midasit.com
 * 
 */
public class AutoMailNaming {
	public static Scanner sc;
	public static BufferedReader br;
	public static StringTokenizer st;
	public static ArrayList<String> nameList;
	public static ArrayList<String> emailList;
	

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		sc = new Scanner(System.in);
		br = new BufferedReader(new InputStreamReader(System.in));
		nameList = new ArrayList<>();
		emailList = new ArrayList<>();
		
		String company = sc.next();
		String inputName = br.readLine();
		
		company = company.toLowerCase();
		st = new StringTokenizer(inputName, ",");
		System.out.println(inputName);
		while(st.hasMoreTokens()){
			nameList.add(st.nextToken().trim());
		}
		
		//make email
		Map<String, Integer> map = new HashMap<>();
		for(String name : nameList){
	
			name = name.replace("-", "");
			name = name.toLowerCase();
			char firstEng = name.charAt(0);
			st = new StringTokenizer(name, " ");
			String firstName = "";
			while(st.hasMoreTokens()){
				firstName = st.nextToken();
			}
			String dupName = firstName + firstEng;
			if(map.containsKey(dupName)){
				map.put(dupName, map.get(dupName)+1);
				emailList.add(dupName+map.get(dupName)+"@"+company+".com");
			} else {
				map.put(dupName, 1);
				emailList.add(dupName+"@"+company+".com");
			}	
		}
		
		//출력형태 맞추기
		for(int i = 0; i < emailList.size()-1; i++){
			System.out.println(emailList.get(i)+",");
		}
		System.out.println(emailList.get(emailList.size()-1));
			
	}

}
