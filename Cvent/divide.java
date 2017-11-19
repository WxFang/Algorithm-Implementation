public class Solution {
    public int divide(int dividend, int divisor) {
        long res = ldivide(dividend, divisor);
        // corner case for overflow:
        // when dividend = Integer.MIN_VALUE, divisor = -1
        // then result would be bigger than Integer.MAX_VALUE
        return (res > Integer.MAX_VALUE) ? Integer.MAX_VALUE : (int)res;
    }
    private long ldivide(long dividend, long divisor){
        
        boolean flag = false;
        if(dividend < 0 && divisor > 0 || dividend > 0 && divisor < 0) flag = true;
        if(dividend < 0) dividend = - dividend;
        if(divisor < 0) divisor = - divisor;
        if(dividend < divisor) return 0;
        
        long count = 1;
        long sum = divisor;
        while(sum + sum <= dividend){
            sum += sum;
            count += count;
        }
        
        if(flag) return - (count += ldivide(dividend - sum, divisor));
        else return count += ldivide(dividend - sum, divisor);
    }
}

// O(logN)
public class Solution {
    public int divide(int dividend, int divisor) {
        if(dividend == Integer.MIN_VALUE && divisor == -1) return Integer.MAX_VALUE;
        
        long ldividend = Math.abs((long)dividend);
        long ldivisor = Math.abs((long)divisor);

        int res = 0;
        while(ldividend >= ldivisor){
            int count = 0;
            while(ldividend >= (ldivisor << count))
                count++;
            count--;
            ldividend -= (ldivisor << count);
            res += (1 << count);
        }

        if((dividend > 0 && divisor < 0) || (dividend < 0 && divisor > 0)) 
            return -res;
        else
            return res;
    }
}