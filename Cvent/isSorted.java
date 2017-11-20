// recursion
// time O(N) space O(N) for recursion call stack
class Solution{
	public static boolean arraySortedOrNot(int arr[], int n){
		if(n <= 1) return true;
		if(arr[n - 1] < arr[n - 2]) return false;
		return arraySortedOrNot(arr, n - 1); 
	}
}

// iterative
// time O(N) space O(1)
class Solution{
	public static boolean arraySortedOrNot(int arr[], int n){
		if(n <= 1) return true;
		for(int i = 2; i < n; i++)
			if(arr[i] < arr[i - 1])
				return false;
		return true;
	}
}