class Solution {
    public boolean validTree(int n, int[][] edges) {
        
        if(edges == null){
            return true;
        }
        
        HashMap<Integer, List<Integer>> map = new HashMap<>();
        
        for(int i = 0; i < n; i++){
            map.put(i,new ArrayList());
        }
        
        for(int[] edge : edges){
            map.get(edge[0]).add(edge[1]);
            map.get(edge[1]).add(edge[0]);
        }
        
        HashSet<Integer> visit = new HashSet<>();
        
        return dfs(0,-1,map,visit) && visit.size() == n;
        
    }
    
    public boolean dfs(int i, int prev, HashMap<Integer,List<Integer>> map,HashSet<Integer> visit){
        if(visit.contains(i)){
            return false;
        }
        
        visit.add(i);
        
        for(int j : map.get(i)){
            if(prev == j){
                continue;
            }
            
            if(dfs(j,i,map,visit) == false){
                return false;
            }
        }
        
        return true;
    }
}