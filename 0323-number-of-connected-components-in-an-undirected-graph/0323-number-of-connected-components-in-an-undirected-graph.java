class Solution {
    public int countComponents(int n, int[][] edges) {
        
        int count = 0;
        
        HashMap<Integer, List<Integer>> map = new HashMap<>();

        for (int i = 0; i < n; i++) {
            map.put(i, new ArrayList<>());
        }

        //adj list undirected
        for (int[] edge : edges) {
            map.get(edge[0]).add(edge[1]);
            map.get(edge[1]).add(edge[0]);
        }

        //list done

        HashSet<Integer> visit = new HashSet<>();

        for (int i = 0; i < n; i++) {
            if (!visit.contains(i)) {
                visit.add(i);
                count++;
                dfs(i, map, visit);
            }
        }

        return count;
    }

    public void dfs(int i, HashMap<Integer, List<Integer>> map, HashSet<Integer> visit){
        for (int nbr : map.get(i)) {
            if(!visit.contains(nbr)){
                visit.add(nbr);
                dfs(nbr, map, visit);
            }
        }
    }
}