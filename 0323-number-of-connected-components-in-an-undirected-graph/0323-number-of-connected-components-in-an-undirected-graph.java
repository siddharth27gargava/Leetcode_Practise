class Solution {
    public int countComponents(int n, int[][] edges) {
        //Creating an adj. list in undirected graph
        HashMap<Integer,List<Integer>> adMap = new HashMap<>();
        
        for(int i = 0; i < n; i++){
            adMap.put(i, new ArrayList<>());
        }
        
        for(int[] edgeMember: edges){
            adMap.get(edgeMember[0]).add(edgeMember[1]);
            adMap.get(edgeMember[1]).add(edgeMember[0]);
        }
        
        HashSet<Integer> visit = new HashSet<>();
        
        int count = 0;
        
        for(int i = 0; i < n; i++){
            if(!visit.contains(i)){
                visit.add(i);
                count++;
                dfs(i,adMap,visit);
            }
        }
        
        return count;
    }
    
    public void dfs(int i, HashMap<Integer,List<Integer>> adMap, HashSet<Integer> visit){
        for(int j : adMap.get(i)){
            if(!visit.contains(j)){
                visit.add(j);
                dfs(j,adMap,visit);
            }
        }
    }
}