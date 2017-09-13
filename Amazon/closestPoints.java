package amazon;

import java.util.PriorityQueue;

class Point 
{
	double x;
	double y;
	public Point(double x, double y){
		this.x = x;
		this.y = y;
	}
}

public class closestPoints {
	
	private static double distance(Point a, Point b){
		return Math.pow(a.x - b.x, 2) + Math.pow(a.y - b.y, 2);
	}
	
	public static Point[] _closestPoints(Point[] array, final Point origin, int k){
		Point[] res = new Point[k];
		PriorityQueue<Point> pq = new PriorityQueue<>((a, b) -> (int)(distance(b, origin) - distance(a, origin)));
		for(Point point: array){
			pq.offer(point);
			if(pq.size() > k) pq.poll();
		}
		for(int i = 0; i < k; i++)
			res[i] = pq.poll();
		return res;
	}
	
    public static void main(String[] args)
    {
        Point origin = new Point(0, 0);
        Point[] input = new Point[]{new Point(0.5, 2), new Point(1, 1), new Point(-1, 0), new Point(2, 0), new Point(3, 0)};
        Point[] output = _closestPoints(input, origin, 3);
        System.out.println("input");
        for(Point i : input) System.out.print("("+i.x+", "+i.y+") ");
        System.out.println("");
        System.out.println("output");
        for(Point i : output) System.out.print("("+i.x+", "+i.y+") ");
         
         
    }
}
