class Solution {
    public int countComponents(int n, int[][] edges) {
        HashMap<Integer, List<Integer>> map = new HashMap<>();
        for(int i = 0; i < n; i++){
            map.put(i, new ArrayList());
        }
        
        for(int[] edge : edges){
            map.get(edge[0]).add(edge[1]);
            map.get(edge[1]).add(edge[0]);
        }
        
        HashSet<Integer> visit = new HashSet<>();
        
        int count = 0;
        
        for(int i = 0; i < n; i++){
            if(visit.add(i)){
                count++;
                dfs(i,map,visit);
            }
        }
        
        return count;
    }
    
    public void dfs(int i, HashMap<Integer, List<Integer>> map, HashSet<Integer> visit){
        for(int j : map.get(i)){
            if(visit.add(j)){
                dfs(j,map,visit);
            }
        }
    }
}