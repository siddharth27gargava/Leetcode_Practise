class Solution {
    public List<String> summaryRanges(int[] nums) {
        List<String> ans = new ArrayList<>();
        int start = 0;
        int end = 0;

        HashSet<Integer> set = new HashSet<>();
        for(int num : nums){
            set.add(num);
        }

        // for(int num: nums){
        //     start = num;
        //     int count = 0;
        //     while(set.contains(num+1)){
        //         count++;
        //         num++;
        //     }
        //     end = start + count;
        //     if (count == 0) {
        //         ans.add("" + start);
        //         continue;
        //     }
        //     ans.add(start + "->" + end);
        // }

        for (int i = 0; i < nums.length; i++) {
            start = nums[i];
            int count = 0;
            while(set.contains(nums[i] + 1) && nums[i] != Integer.MAX_VALUE){
                count++;
                i++;
            }
            end = start + count;
            if(count == 0){
                ans.add("" + nums[i]);
                continue;
            }
            ans.add(start + "->" + end);
        }

        return ans;
    }
}