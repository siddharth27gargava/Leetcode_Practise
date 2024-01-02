class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        
        //1) Create a result list
        List<int[]> res = new ArrayList<>();
        
        int i = 0;
        int n = intervals.length;
        
        //2) When new interval is totally greater than previous intervals
        while(i < n && intervals[i][1] < newInterval[0]){
            res.add(intervals[i]);
            i++;
        }
        
        //3) when new interval overlaps which means new interval end is greater than prev interval start
        while(i < n && intervals[i][0] <= newInterval[1]){
            newInterval[0] = Math.min(intervals[i][0], newInterval[0]);
            newInterval[1] = Math.max(intervals[i][1], newInterval[1]);
            i++;
        }
        
        //4) after modifying the new interval, add it
        res.add(newInterval);
        
        //5) add the remaining intervals left
        while(i < n){
            res.add(intervals[i]);
            i++;
        }
        
        return res.toArray(new int[res.size()][2]);
        
        
    }
}