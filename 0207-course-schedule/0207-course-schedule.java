class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        HashMap<Integer, List<Integer>> preMap = new HashMap<>();
        //[[1,0]]
        //premap
        // 1 --> {0}
        // 0 --> {}
        for(int[] pair : prerequisites){ //Creating Adj. map by adding each int[] against key
            if(preMap.containsKey(pair[0])){//Why 0th, because 0 requires pair[1] position as prereq
                preMap.get(pair[0]).add(pair[1]);
            } else {
                List<Integer> nL = new ArrayList<>();
                nL.add(pair[1]);
                preMap.put(pair[0],nL);
            }
        }
        
        //Check and add nodes touched
        HashSet<Integer> visit = new HashSet<>();
        
        //Manually iterate through every course and check since there can be unconnected graphs.
        for(int i = 0; i < numCourses; i++){
            if(!dfs(i,preMap,visit)){
                return false;
            }
        }
        
        return true;
    }
    
    public boolean dfs(int crs,  HashMap<Integer, List<Integer>> preMap, HashSet<Integer> visit){
        //check if crs is in set
        if(visit.contains(crs)){
            return false;
        }
        
        if(preMap.get(crs) == null){
            return true;
        }
        
        visit.add(crs);
        
        for(int prereqListMembers : preMap.get(crs)){
            if(!dfs(prereqListMembers,preMap,visit)){
                return false;
            }
        }
        
        //Remove this crs since we have already visited it
        visit.remove(crs);
        
        //change the prereq list for course to empty so that next time we directly return true
        preMap.put(crs, new ArrayList<>());
        
        return true;
    }
}