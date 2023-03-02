class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);
        generate(0, nums, result, new ArrayList());
        return result;
    }
    
    public void generate(int idx, int[] nums, List<List<Integer>> res, List<Integer> subs){
       if(idx == nums.length){
           res.add(new ArrayList(subs));
           return;
       }
        
        //All subsets which include nums[i]
        subs.add(nums[idx]);
        generate(idx + 1, nums, res, subs);
        subs.remove(subs.size()-1);
        
        //All subsets which don't include nums[i]
        while(idx + 1 < nums.length && nums[idx] == nums[idx+1]){
            idx++;
        }
        generate(idx + 1, nums, res, subs);
    }
}