class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        HashMap<Integer, List<Integer>> premap = new HashMap<>();
        
        for(int[] relation : prerequisites){
            if(premap.containsKey(relation[0])){
                premap.get(relation[0]).add(relation[1]);
            } else {
                List<Integer> newList = new ArrayList();
                newList.add(relation[1]);
                premap.put(relation[0],newList);
            }
        }
        
        HashSet<Integer> visited = new HashSet<>();
        
        for(int i = 0; i < numCourses; i++){
            if(!(isCyclic(i,premap,visited))){
                return false;
            }
        }
        
        return true;
        
    }
    
    public boolean isCyclic(Integer crs, HashMap<Integer, List<Integer>> premap, HashSet<Integer> visited){
        if(visited.contains(crs)){
            return false;
        }
        
        if(premap.get(crs) == null){
            return true;
        }
        
        visited.add(crs);
        
        for(int req : premap.get(crs)){
            if(!isCyclic(req,premap,visited)){
                return false;
            }
        }
        
        visited.remove(crs);
        premap.put(crs,new ArrayList<>());
        
        return true;
    }
}