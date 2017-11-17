class Solution {
    public List<Integer> diffWaysToCompute(String input) {
        List<Integer> res = new ArrayList<>();
        if(input == null || input.length() == 0) return res;
        boolean flag = false;
        List<Integer> leftL = new ArrayList<>();
        List<Integer> rightL = new ArrayList<>();
        for(int i = 0; i < input.length(); i++){
            if(input.charAt(i) <= '9' && input.charAt(i) >= '0') continue;
            flag = true;
            leftL = diffWaysToCompute(input.substring(0, i));
            rightL = diffWaysToCompute(input.substring(i + 1));
            for(int l: leftL)
                for(int r: rightL)
                    res.add(operator(input.charAt(i), l, r));
        }
        if(flag == false)
            res.add(Integer.parseInt(input));
        return res;
    }
    
    private int operator(char c, int left, int right){
        if(c == '+')
            return left + right;
        else if(c == '-')
            return left - right;
        else if(c == '*')
            return left * right;
        else return 0;
    }
}


class Solution {
    public List<Integer> diffWaysToCompute(String input) {
        if(input == null || input.length() == 0) return new ArrayList<>();
        return helper(input, 0, input.length() - 1);
    }
    
    private List<Integer> helper(String input, int left, int right){
        List<Integer> res = new ArrayList<>();
        if(left > right) res.add(0);
        else{
            boolean flag = false;
            List<Integer> leftL = new ArrayList<>();
            List<Integer> rightL = new ArrayList<>();
            for(int i = left; i <= right; i++){
                if(input.charAt(i) <= '9' && input.charAt(i) >= '0') continue;
                flag = true;
                leftL = helper(input, left, i - 1);
                rightL = helper(input, i + 1, right);
                for(int l: leftL)
                    for(int r: rightL)
                        res.add(operator(input.charAt(i), l, r));
            }
            if(flag == false)
                res.add(Integer.parseInt(input.substring(left, right + 1)));
        }
        return res;
    }
    
    private int operator(char c, int left, int right){
        if(c == '+')
            return left + right;
        else if(c == '-')
            return left - right;
        else if(c == '*')
            return left * right;
        else return 0;
    }
}