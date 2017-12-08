// Queue
// Time getHits O(N), N: # of total hits 
// Space O(N)
// If huge amount of hits happened at the same timestamp, this solution will takes too much 
// memory. So this solution is not time efficient nor space efficient.
// It's better to map timestamp to the number of hits at this timestamp.
class HitCounter {
    
    private Queue<Integer> q;

    public HitCounter() {
        this.q = new LinkedList<>();
    }
    
    public void hit(int timestamp) {
        q.offer(timestamp);
    }
    
    public int getHits(int timestamp) {
        while(!q.isEmpty() && timestamp - q.peek() >= 300)
            q.poll();
        return q.size();
    }
}


// Queue and HashMap for scability
// We can use hashmap, key is timestamp, value is total hits at timestamp
// Then queue only restores timestamp number increasingly.
// Both time and space complexity would be linear time of timestamp
class HitCounter {
    private Map<Integer, Integer> map;
    private Queue<Integer> q;
    private int count;

    public HitCounter() {
        q = new LinkedList<>();
        map = new HashMap<>();
        count = 0;
    }
    
    public void hit(int timestamp) {
        count++;
        if(map.containsKey(timestamp))
            map.put(timestamp, map.get(timestamp) + 1);
        else{
            map.put(timestamp, 1);
            q.offer(timestamp);
            while(!q.isEmpty() && timestamp - q.peek() >= 300){
                count -= map.get(q.peek());
                map.remove(q.poll());
            }
        }
    }
    
    public int getHits(int timestamp) {
        while(!q.isEmpty() && timestamp - q.peek() >= 300){
                count -= map.get(q.peek());
                map.remove(q.poll());
        }
        return count;
    }
}


// Two arrays of size 300: hits and stamps
// hits array is used to track hits and timestamps array is used to track timestamp of the hits.
// Since total size is 300, we only store timestamp within 300 seconds using mod. 
// Whenever there is a new hit, we check if the cooresbonding cell in timestamps array stores 
// the same timestamp as current one. If does, we increment hits array. Otherwise it means we have 
// exceeded 300 seconds limit, so we need to reset this cell in hits array to 1 and update the 
// timestamp. 
// When calling getHits, it's a bit tricky. Not every cell in timestamps array has been updated.
// So we need to go through the array to find all hits that are within 300 seconds.
// Time Complexity would be hit O(1), get O(300)
// Space Complexity would be O(300)
// compared to hashmap method, query time is almost same, but insert time is reduced
class HitCounter {
    private int[] hits;
    private int[] timestamps;

    public HitCounter() {
        hits = new int[300];
        timestamps = new int[300];
    }
    
    public void hit(int timestamp) {
        int residue = timestamp % 300;
        if(timestamps[residue] == timestamp)
            hits[residue]++;
        else{
            timestamps[residue] = timestamp;
            hits[residue] = 1;
        }
    }
    
    public int getHits(int timestamp) {
        int count = 0;
        for(int i = 0; i < 300; i++)
            if(timestamp - timestamps[i] < 300)
                count += hits[i];
        return count;
    }
}