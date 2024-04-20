class Solution {
    public int leastBricks(List<List<Integer>> wall) {
        //hashmap
        //initialise with all gaps
        HashMap<Integer, Integer> countmap = new HashMap<>();

        //int widthlength = getWidthLength(wall);
        int wallHeight = wall.size();

        // for (int i = 1; i < widthlength; i++) {
        //     countmap.put(i, 0);
        // }

        
        //update HashMap
        for (int i = 0; i < wall.size(); i++) {
            int gap = 0;
            for (int j = 0; j < wall.get(i).size() - 1; j++) {
                gap = gap + wall.get(i).get(j);
                countmap.put(gap, countmap.getOrDefault(gap, 0) + 1); 
                
            }
        }

        int maxval = 0;

        

        for(int val : countmap.values()){
            maxval = Math.max(maxval, val);
        }

        return wallHeight - maxval;

    }

    public int getWidthLength(List<List<Integer>> nums){
        int sum = 0;
        //int rows = nums.size();
        int cols = nums.get(0).size();
        for (int i = 0; i < cols; i++) {
            sum += nums.get(0).get(i);
        }

        return sum;
    }
}