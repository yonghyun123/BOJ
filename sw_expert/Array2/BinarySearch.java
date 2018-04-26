package sw_expert.Array2;

public class BinarySearch {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int []arr = { 1, 2, 3, 4, 5 };
		System.out.println(binarySearch(arr, 0, arr.length-1, 4));
	}
	
	public static int binarySearch(int []arr, int start, int end, int key){
		int mid = (start+end) / 2;
		if(arr[mid] == key) {
			return key;
		} else if(arr[mid] > key) {
			return binarySearch(arr, start, mid-1, key);
		} else if(arr[mid] < key){
			return binarySearch(arr, mid+1, end, key);
		} else {
			return -1;	
		}
		
		
		
	}

}
