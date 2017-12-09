/*
Puzzle
给你一个数，找数字中的圈，规定1，2，3，5，7没有圈，4，6，9，0有一个圈，8有两个圈
样例：输入1234， 输出1（因为4有一个圈)。
*/

public class Solution{

 	public static void main(String []args){
		System.out.println(puzzle(1234));
 	}
     
 	public static int puzzle(int input){
		if(input == 0) return 1;
		int res = 0;
		while(input > 0){
			int residue = input % 10;
			if(residue == 8) res += 2;
			else if(residue == 4 || residue == 6 || residue == 9 || residue == 0) res += 1;
			input /= 10;
		}
		return res;
	}

}