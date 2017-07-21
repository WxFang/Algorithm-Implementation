/*Given a string, determine if it is a palindrome, considering only alphanumeric characters and ignoring cases.

For example,
"A man, a plan, a canal: Panama" is a palindrome.
"race a car" is not a palindrome. 
*/

/*8ms*/
public class Solution {
    public boolean isPalindrome(String s) {
        if(s.length()==0) return true;
        int head=0, tail=s.length()-1;
        while(head<tail){
            if(!Character.isLetterOrDigit(s.charAt(head))){
                head++;
            }
            else if(!Character.isLetterOrDigit(s.charAt(tail))){
                tail--;
            }
            else{
                if(Character.toLowerCase(s.charAt(head))!=Character.toLowerCase(s.charAt(tail)))
                    return false;
                head++;
                tail--;
            }
        }
        return true;
    }
}
