class Solution {
    public boolean validTree(int n, int[][] edges) {
       
        //time and space complex O(n)
        if(n == 0){
            return true;
        }
        
        //Let's create adj. list for undirected graph
        HashMap<Integer, List<Integer>> adMap = new HashMap<>();
        
        for(int i = 0; i < n; i++){
            adMap.put(i, new ArrayList<>());
        }
        
        for(int[] edgeMember: edges){
            adMap.get(edgeMember[0]).add(edgeMember[1]);
            adMap.get(edgeMember[1]).add(edgeMember[0]);
        }
        
        HashSet<Integer> visit = new HashSet<>();
        
        //number of nodes matches with the visited values and check for loop
        
        return dfs(0,-1,adMap,visit) && (n == visit.size());
    }
    
    public boolean dfs(int i, int prev, HashMap<Integer, List<Integer>> adMap, HashSet<Integer> visit){
        if(visit.contains(i)){
            return false;
        }
        
        visit.add(i);
        for(int j : adMap.get(i)){
            if(j == prev){
                continue;
            }
            
            if(!dfs(j,i,adMap,visit)){
                return false;
            }
        }
        
        return true;
    }
}