public class MovingAverage {
    LinkedList<Integer> queue;
    int size = 0;
    int sum = 0;
    
    /** Initialize your data structure here. */
    public MovingAverage(int size) {
        this.size = size;
        this.queue = new LinkedList<Integer>();
    }
    
    public double next(int val) {
        queue.offer(val);
        sum += val;
        if(queue.size() > size){
            sum -= queue.poll();
        }
        return (double)sum/queue.size();
    }
}

/**
 * Your MovingAverage object will be instantiated and called as such:
 * MovingAverage obj = new MovingAverage(size);
 * double param_1 = obj.next(val);
 */