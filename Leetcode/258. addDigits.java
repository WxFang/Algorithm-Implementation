// without loop or recursion O(1)
class Solution {
    public int addDigits(int num) {
        return 1 + (num - 1) % 9;
    }
}

// with recursion
class Solution {
    public int addDigits(int num) {
        if(num < 10) return num;
        int res = 0;
        while(num > 0){
            res += num % 10;
            num /= 10;
        }
        return addDigits(res);
    }
}