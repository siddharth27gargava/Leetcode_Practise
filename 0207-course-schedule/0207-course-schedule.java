class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        //creating directed adj. list
        //pre-requisite map
        // 1 -> {0}
        // 0 -> {}
        HashMap<Integer, List<Integer>> premap = new HashMap<>();
        for (int[] prereq_member : prerequisites) {
            if(premap.containsKey(prereq_member[0])){
                premap.get(prereq_member[0]).add(prereq_member[1]);
            } else{
                ArrayList<Integer> nal = new ArrayList<>();
                nal.add(prereq_member[1]);
                premap.put(prereq_member[0], nal);
            }
        }

        HashSet<Integer> visit = new HashSet<>();

        for (int i = 0; i < numCourses; i++) {
            if (!dfs(premap,i,visit)) {
                return false;
            }
        }

        return true;
    }

    public boolean dfs(HashMap<Integer, List<Integer>> premap, int crs, HashSet<Integer> visit){
        if (visit.contains(crs)) {
            return false;
        }

        if (premap.get(crs) == null) {
            return true;
        }

        visit.add(crs);

        for (int prereqmember : premap.get(crs)) {
            if (!dfs(premap,prereqmember,visit)) {
                return false;
            }
        }

        visit.remove(crs);

        premap.put(crs, new ArrayList<>());

        return true;
    }
}