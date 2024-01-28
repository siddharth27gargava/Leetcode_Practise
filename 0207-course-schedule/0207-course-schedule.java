class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        //aim is to check gor cyclic in a directed graph
        //lets first build directed adjacency list
        HashMap<Integer, List<Integer>> premap = new HashMap<>();

        //1 -> {0}
        //0 -> {}
        for (int[] pre_mem : prerequisites) {
            //check if map already has members 0th element
            if (premap.containsKey(pre_mem[0])) {
                premap.get(pre_mem[0]).add(pre_mem[1]);
            } else{
                ArrayList<Integer> nal = new ArrayList<>();
                nal.add(pre_mem[1]);
                premap.put(pre_mem[0], nal);
            }
        }

        //create a hashset of visited to keep count of cyclicity
        HashSet<Integer> visit = new HashSet<>();

        //check for all numcourses including the unconnected ones
        for (int i = 0; i < numCourses; i++) {
            if(!dfs(i,premap,visit)){
                return false;
            }
        }

        return true;
    }

    public boolean dfs(int crs, HashMap<Integer, List<Integer>> premap, HashSet<Integer> visit){

        //check if it is in set - then cyclic graph
        if(visit.contains(crs)){
            return false;
        }

        //check if crs doesn't has a null arraylist associated - meaning no dependancy
        if(premap.get(crs) == null){
            return true;
        }

        //add the crs in set
        visit.add(crs);

        //check for all neighbors of crs
        for (Integer crs_nbr : premap.get(crs)) {
            if (!dfs(crs_nbr,premap,visit)) {
                return false;
            }
        }

        //remove the crs from set since we have traversed it
        visit.remove(crs);

        //save time put an empty list against it
        premap.put(crs, new ArrayList<>());

        return true;

    }
}