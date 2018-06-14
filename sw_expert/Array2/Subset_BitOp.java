package sw_expert.Array2;

public class Subset_BitOp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = {1,2,3,4,5,6};
		int n = arr.length;
		
		for(int i = 0; i < 8; i++){
//			System.out.println("i="+i);
			for(int j = 0; j < n; j++){
//				System.out.println("i ="+i);
//				System.out.println("j ="+j);
//				System.out.println(i&1<<j);
				if((i & (1<<j)) != 0){
//					System.out.println("i:"+Integer.toBinaryString(i));
//					System.out.println("j:"+Integer.toBinaryString(j));
					System.out.print(arr[j]+" ");
				}
			}
			System.out.println();
		}
		System.out.println(1<<1);
		
	}

}
