// one pass O(n) without using %
class Solution {
    public List<String> fizzBuzz(int n) {
        List<String> res = new ArrayList<>(n);
        if(n <= 0) return res;
        for(int i = 1, buzz = 0, fizz = 0; i <= n; i++){
            buzz++;
            fizz++;
            if(fizz == 3 && buzz == 5){
                res.add("FizzBuzz");
                buzz = 0;
                fizz = 0;
            }
            else if(fizz == 3){
                res.add("Fizz");
                fizz = 0;
            }
            else if(buzz == 5){
                res.add("Buzz");
                buzz = 0;
            }
            else
                res.add(Integer.toString(i));
        }
        return res;
    }
}

// three pass O(n) without using %
class Solution {
    public List<String> fizzBuzz(int n) {
        List<String> res = new ArrayList<>(n);
        if(n <= 0) return res;
        int[] arr = new int[n + 1];
        int i = 1;
        while(i * 3 <= n)
            arr[3 * i++] += 3;
        i = 1;
        while(i * 5 <= n)
            arr[5 * i++] += 5;
        for(int j = 1; j <= n; j++){
            if(arr[j] == 3)
                res.add("Fizz");
            else if(arr[j] == 5)
                res.add("Buzz");
            else if(arr[j] == 8)
                res.add("FizzBuzz");
            else
                res.add(Integer.toString(j));
        }
        return res;
    }
}