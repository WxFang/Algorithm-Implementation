
public class Solution {
    public ListNode findMidNode(ListNode node) {
    	if(node == null)
    		return null;
    	ListNode slow = node, fast = node;
    	while(fast != null && fast.next != null){
    		fast = fast.next.next;
    		slow = slow.next;
    	}
    	return slow;
    }
}