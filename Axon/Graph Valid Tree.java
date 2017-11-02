// Union Find
public class Solution {
    public boolean validTree(int n, int[][] edges) {
        int[] parent = new int[n];
        Arrays.fill(parent, -1);
        
        for(int i = 0; i < edges.length; i++){
            int x = find(parent, edges[i][0]);
            int y = find(parent, edges[i][1]);
            
            if(x == y)
                return false;
            else
                parent[y] = x;
        }
        return edges.length == n - 1;
    }
    
    private int find(int[] parent, int i){
        if(parent[i] == -1)
            return i;
        else
            return find(parent, parent[i]);
    }
}

// DFS
public class Solution {
    public boolean validTree(int n, int[][] edges) {
        boolean[] visited = new boolean[n];
        List<List<Integer>> adjList = new LinkedList<>();
        
        for(int i = 0; i < n; i++)
            adjList.add(new LinkedList<>());
        
        for(int[] edge: edges){
            adjList.get(edge[0]).add(edge[1]);
            adjList.get(edge[1]).add(edge[0]);
        }
        
        if(hasCycle(adjList, visited, 0, -1))
            return false;
        for(int i = 0; i < n; i++)
            if(visited[i] == false)
                return false;
        return true;
    }
    
    private boolean hasCycle(List<List<Integer>> adjList, boolean[] visited, int cur, int prev){
        visited[cur] = true;
        for(int n: adjList.get(cur)){
            if(visited[n] == true && n != prev) return true;
            if(visited[n] == false && hasCycle(adjList, visited, n, cur))
                return true;
        }
        return false;
    }
}