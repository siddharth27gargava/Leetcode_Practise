class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        //Let's create an adjacency hashmap list
        HashMap<Integer, List<Integer>> preMap = new HashMap<>();
        //[[1,0]]
        // 1 --> {0}
        // 0 --> {}
        //populate the hashmap
        for(int eachPairInPrereq[] : prerequisites){
            if(preMap.containsKey(eachPairInPrereq[0])){
                preMap.get(eachPairInPrereq[0]).add(eachPairInPrereq[1]);
            } else {
                List<Integer> nL = new ArrayList<>();
                nL.add(eachPairInPrereq[1]);
                preMap.put(eachPairInPrereq[0],nL);
            }
        }
        
        List<Integer> ans = new ArrayList<>();
        
        //visit set to track visited nodes
        HashSet<Integer> visit = new HashSet<>();
        
        //cycle set - if it's along the given path
        HashSet<Integer> cycle = new HashSet<>();
        
        for(int i = 0; i < numCourses; i++){
            if(!dfs(i,preMap,visit,cycle,ans)){
                return new int[0];
            }
        }
        
        int[] output = new int[ans.size()];
        for(int i = 0; i < ans.size(); i++){
            output[i] = ans.get(i);
        }
        
        return output;
    }
    
    public boolean dfs(int crs, HashMap<Integer, List<Integer>> preMap, HashSet<Integer> visit, HashSet<Integer> cycle, List<Integer> ans){
        
        //present in cycle set
        if(cycle.contains(crs)){
            return false;
        }
        
        //don't need to visit twice
        if(visit.contains(crs)){
            return true;
        }
        
        cycle.add(crs);
        
        for(int prereqListMemeber : preMap.getOrDefault(crs, new ArrayList<>())){
            if(!dfs(prereqListMemeber,preMap,visit,cycle,ans)){
                return false;
            }
        }
        
        //no longer along the path that we were going
        cycle.remove(crs);
        
        //add it to visit
        visit.add(crs);
        
        //add it to ans
        ans.add(crs);
        
        
        return true;
    }
}