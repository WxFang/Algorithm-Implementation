// O(NlogN)
class Solution{
	public static List<Integer> findAllPrime(int n){
		List<Integer> res = new ArrayList<>();
		if(n <= 0) return res;

		boolean[] notPrime = new boolean[n + 1];
		for(int i = 2; i <= n; i++){
			if(notPrime[i] == true) continue;
			res.add(i);
			for(int j = 1; j * i <= n j++)
				notPrime[j * i] = true;
		}

		return res;
	}
}