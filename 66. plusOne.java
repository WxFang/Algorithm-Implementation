public int[] plusOne(int[] digits) {
        for(int i = digits.length-1; i>=0; i--){
            digits[i] += 1;
            if(digits[i] == 10)
                digits[i] = 0;
            else
                return digits;
        }
        
        // Overflow Case: first digit = 0
        
        int[] newDigits = new int[digits.length+1];
        newDigits[0] = 1;
        for(int j = 1; j<=digits.length; j++){
            newDigits[j] = digits[j-1];
        }
        return newDigits;
}