// O(logN)
public class Solution {
    public boolean isPalindrome(int x) {
    	if(x < 0 || x != 0 && x % 10 == 0) return false;
    	int ret = 0;
    	while(x > ret){
    		ret = 10 * ret + x % 10;
    		x /= 10;
    	}
    	return (x == ret || ret / 10 == x) ? true : false;
    }
}

// reverse number O(logN)
// no need to consider overflow
public class Solution {
    public boolean isPalindrome(int x) {
    	if(x < 0 || x != 0 && x % 10 == 0) return false;
    	int p = x, q = 0;
    	while(p > 0){
    		q = q * 10 + p % 10;
    		p /= 10;
    	}
    	return q == x ? true : false;
    }
}