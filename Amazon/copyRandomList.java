package amazon;

import java.util.HashMap;
import java.util.Map;

class RandomListNode {
     int label;
     RandomListNode next, random;
     RandomListNode(int x) { this.label = x; }
 };

public class copyRandomList {

	public RandomListNode _copyRandomList(RandomListNode head){
		if(head == null) return head;
		HashMap<RandomListNode, RandomListNode> map = new HashMap<>();
		
		RandomListNode node = head;
		while(node != null)
			map.put(node, new RandomListNode(node.label));
		
		node = head;
		while(node != null){
			if(node.next != null) map.get(node).next = map.get(node.next);
			if(node.random != null) map.get(node).random = map.get(node.random);
			node = node.next;
		}
		
		return map.get(head);
	}
	
}
