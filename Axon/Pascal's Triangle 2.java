public class Solution {
    public List<Integer> getRow(int rowIndex) {
    	int[] res = new int[rowIndex + 1];
    	for(int i = 0; i <= rowIndex; i++){
    		res[0] = 1;
    		res[i] = 1;
    		for(int j = i - 1; j > 0; j--)
    			res[j] += res[j - 1];
    	}
    	List<Integer> list = new LinkedList<>();
    	for(int n: res)
    		list.add(n);
    	return list;
    }
}