/* The isBadVersion API is defined in the parent class VersionControl.
      boolean isBadVersion(int version); */

/*Iterative*/
public class Solution extends VersionControl {
    public int firstBadVersion(int n) {
        int i=1, j=n;
        while(i<j){
            int m=i+(j-i)/2;
            if(isBadVersion(m)){
                j=m;
			}
            else{
                i=m+1;
			}
        }
        if(isBadVersion(i)){
            return i;
		}
        return j;
    }
}
/*Recursive*/
public class Solution extends VersionControl {
    public int firstBadVersion(int n) {
        return helper(1,n);
    }
    
    public int helper(int i, int j){
        int m=i+(j-i)/2;
        
        if(i>=j){
            return i;
        }
        
        if(isBadVersion(m)){
            j=m;
        }else{
            i=m+1;
        }
        
        return helper(i,j);
        
    }
}