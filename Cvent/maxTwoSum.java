class Solution{
	public static int findLargestSumPair(int[] arr){
		if(arr.length < 2) return 0;
		int first, second;
		first = (arr[0] < arr[1]) ? arr[1] : arr[0];
		second = (arr[0] < arr[1]) ? arr[0] : arr[1];
		for(int i = 2; i < arr.length; i++){
			if(arr[i] > first){
				second = first;
				first = arr[i];
			}
			else if(arr[i] <= first && arr[i] > second)
				second = arr[i];
		}
		return first + second;
	}
}