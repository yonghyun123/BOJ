package sw_expert.Stack;

public class FiboMem {
	public static int []M;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		M = new int[20];
		System.out.println(fibo(7));
	}
	
	public static int fibo(int n){
		
		if(n == 0){
			return 0;
		}
		if(n == 1){
			return 1;
		}
		if(M[n] == 0 && n >= 2){
			M[n] = fibo(n-1) + fibo(n-2);
		}
		return M[n];

		
		
	}

}
