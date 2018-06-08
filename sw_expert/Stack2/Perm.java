package sw_expert.Stack2;

public class Perm {
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = {1,2,3,4};
		perm(arr,0);
	}
	
	public static void swap(int[] arr, int i, int j){
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}
	
	public static void perm(int[] arr, int depth){
		if(arr.length == depth){
			for(int i = 0; i < arr.length; i++){
				System.out.print(arr[i]);
			}
			System.out.println();
		}
		for(int i = depth; i < 4; i++){
			swap(arr,i,depth);
			perm(arr, depth+1);
			swap(arr,i,depth);
		}
	}
	
}
