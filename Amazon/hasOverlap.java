package amazon;

class Node {
	int x;
	int y;
	public Node(int x, int y){
		this.x = x;
		this.y = y;
	}
}

public class hasOverlap {
	// A & C is bottom-left, B & D is top-right
	public static boolean hasOverlap(Node A, Node B, Node C, Node D){
		
		int l1_x = Math.min(A.x, B.x);
		int l1_y = Math.min(A.y, B.y);
		int r1_x = Math.max(A.x, B.x);
		int r1_y = Math.max(A.y, B.y);
		
		int l2_x = Math.min(C.x, D.x);
		int l2_y = Math.min(C.y, D.y);
		int r2_x = Math.max(C.x, D.x);
		int r2_y = Math.max(C.y, D.y);
		
		if(r1_x <= l2_x || r1_y <= l2_y || r2_x <= l1_x || r2_y <= l1_y) return true;
		return false;
	}
	
	
	public static void main(String[] args) {
		Node A = new Node(0, 0), B = new Node(2, 2), C = new Node(1, 0), D = new Node(4, 4);
		System.out.println(hasOverlap(A, B, C, D));
	}

}
