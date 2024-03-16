class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();

        Arrays.sort(nums);

        //-1,-1,0,0,1,2,-1,4

        for (int i = 0; i < nums.length - 2; i++) {
            //constraint of not including duplicate
            if (i == 0 || (nums[i-1] != nums[i])) {
                int left = i+1;
                int right = nums.length - 1;
                int target = 0 - nums[i];
                while (left < right) {
                    if(nums[left] + nums[right] == target){
                        ans.add(Arrays.asList(nums[i], nums[left], nums[right]));
                        //skip duplicates
                        while ((left < right) && nums[left] == nums[left+1]) {
                            left++;
                        }

                        while ((left < right) && nums[right] == nums[right - 1]) {
                            right--;
                        }

                        left++;
                        right--;
                    } else if(nums[left] + nums[right] < target){
                        left++;
                    } else {
                        right--;
                    }
                }
                // ---3------**7**-------10--------16
            }
        }

        return ans;
    }
}