// Add space to every even digits, "12233456666" => "12 23346 6 6 6"

public class Solution{
	public static String addSpaceBetweenEvenDigits(String s){
		StringBuilder sb = new StringBuilder("");
		if(s == null || s.length() == 0) return "";

		for(int i = 0; i < s.length(); i++){
			sb.append(s.charAt(i));
			if((s.charAt(i) - '0') % 2 == 1 || (i < s.length() - 1 && (s.charAt(i + 1) - '0') % 2 == 1))
				continue;
			sb.append(" ");
		}

		return sb.toString();
	}
	public static void main(String[] args){
		System.out.println("1223434485556666596788644433");
	}
}