class Solution {
    public int[][] merge(int[][] intervals) {
        //concept is that if your start of next element is less than end of prev element
        // then the end of prev element becomes max of end of prev and next element 

        Arrays.sort(intervals, (a,b) -> Integer.compare(a[0], b[0]));

        List<int[]> ans = new ArrayList<>();

        ans.add(intervals[0]);

        for (int i = 1; i < intervals.length; i++) {
            
            int[] start = intervals[i];
            //action here
            int[] prev = ans.get(ans.size() - 1);
            if (prev[1] >= start[0]) {
                prev[1] = Math.max(start[1], prev[1]);
            } else{
                ans.add(start);
            }
        }

        int[][] res = new int[ans.size()][2];

        for (int i = 0; i < res.length; i++) {
            res[i][0] = ans.get(i)[0];
            res[i][1] = ans.get(i)[1];
        }

        return res;   
    }
}