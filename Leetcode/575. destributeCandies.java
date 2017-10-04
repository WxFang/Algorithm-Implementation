class Solution {
    public int distributeCandies(int[] candies) {
        HashSet<Integer> set = new HashSet<>();
        for(int candy: candies)
            set.add(candy);
        if(set.size() > candies.length / 2) 
            return candies.length / 2;
        else 
            return set.size();
    }
}