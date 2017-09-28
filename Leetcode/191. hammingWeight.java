// Corner case:
// n > Integer.MAX_VALUE, then n = - Integer.MAX_VALUE
// there is no unsigned int in java, then unsigned int would turn into signed 
// int. So we should use >>> unsinged shift.

public class Solution {
    // you need to treat n as an unsigned value
    public int hammingWeight(int n) {
        int res = 0;
        while(n != 0){
            res += n & 1;
            // >>>: unsigned shift, zero-extension
            // >>: signed shift, sign-extention
            n = n >>> 1;
        } 
        return res;
    }
}