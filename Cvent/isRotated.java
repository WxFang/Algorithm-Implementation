// KMP for strstr O(N)
class Problem{
	public boolean isRotated(String str1, String str2){
		if(str1.length() != str2.length()) return false;
		str1 += str1;
		if(str1.indexOf(str2) > -1) return true;
		else return false;
	}
}

// O(N^2)
class Problem{
	public boolean isRotated(String str1, String str2){
		if(str1.length() != str2.length()) return false;
		int len = str1.length();
		for(int i = 0; i < len; i++){
			if(str1.charAt(i) != str2.charAt(0)) continue;
			boolean flag = false;
			for(int j = 1; j < len; j++){
				if(str1.charAt((i + j + len) % len) != str2.charAt(j)) {
					flag = true;
					break;
				}
			}
			if(flag == false)
				return true;
		}
		return false;
	}
}
