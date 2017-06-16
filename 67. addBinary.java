public String addBinary(String a, String b) {
        StringBuilder newString = new StringBuilder();
        int i=a.length()-1, j=b.length()-1, carry=0;
        while(i>=0 || j>=0){
            int sum=carry;
            if(i>=0) sum+=a.charAt(i--)-'0'; // subtraction of two chars' ASCII
            if(j>=0) sum+=b.charAt(j--)-'0';
            newString.append(sum%2); // add '0' when both a[i] and b[i] are '1'
            carry = sum/2; // carry 1 when both a[i] and b[i] are '1'
        }
        if(carry!=0) newString.append(carry);
        return newString.reverse().toString();
}