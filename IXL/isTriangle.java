/*
给你三个数组，A,B,C，A\B\C代表第i个三角形的三条边，让你判断这三条边能不能组成合理的三角形，
能就Yes,不能就No。最后return是一个string数组。
*/

public class Solution{

	public static void main(String[] args){
		int[] A = {2, 3, 4};
		int[] B = {5, 3, 7};
		int[] C = {6, 1, 2};
		String[] res = isTriangle(A, B, C);
		for(String s: res)
			System.out.println(s);
	}

	public static String[] isTriangle(int[] A, int[] B, int[] C){
		String[] res = new String[A.length];
		if(A.length != B.length || A.length != C.length) return res;
		for(int i = 0; i < A.length; i++){
			int a = A[i], b = B[i], c = C[i];
			if(a + b <= c || a + c <= b || b + c <= a) res[i] = "No";
			else res[i] = "Yes";	
		}
		return res;
	}

}