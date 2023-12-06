class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);
        //Loop and binary search
        for(int i = 0; i < nums.length - 2; i++){
            if(i == 0 || (i > 0 && nums[i]!=nums[i-1])){
                int target = 0 - nums[i];
                int lt = i+1;
                int rt = nums.length - 1;
                
                while(lt < rt){
                    if(nums[lt] + nums[rt] == target){
                        res.add(Arrays.asList(nums[i],nums[lt],nums[rt]));
                        
                        while(lt < rt && nums[lt]==nums[lt+1]){
                            lt++;
                        }
                        
                        while(lt < rt && nums[rt]==nums[rt-1]){
                            rt--;
                        }
                        lt++;
                        rt--;
                    } else if(nums[lt] + nums[rt] < target){
                        lt++;
                    } else if(nums[lt] + nums[rt] > target){
                        rt--;
                    }
                }
            }
        }
        
        return res;
    }
}