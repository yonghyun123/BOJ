package sw_expert.Array2;

//practice permutation
public class Permutation {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int []arr = {1,2,3,4};
		perm(arr, 0);
	}
	
	public static void perm(int []arr, int depth){
		if(depth == arr.length){
			for(int i = 0; i < arr.length; i++){
				System.out.print(arr[i]);
			}
			System.out.println();
		}
		for(int i = depth; i < arr.length; i++){
			swap(arr, i, depth);
			perm(arr, depth+1);
			swap(arr, i, depth);
		}
	}
	
	public static void swap(int []arr, int i, int j){
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}

}
