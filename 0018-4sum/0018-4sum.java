class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> ans = new ArrayList<>();

        if (nums == null || nums.length < 4) {
            return ans;
        }

        Arrays.sort(nums);

        for (int fl = 0; fl < nums.length - 3; fl++) {
            if (fl > 0 && (nums[fl] == nums[fl - 1])) {
                continue;
            }
            for (int sl = fl + 1; sl < nums.length - 2; sl++) {
                if (sl > fl+1 && (nums[sl] == nums[sl - 1])) {
                    continue;
                }

                int left = sl + 1;
                int right = nums.length - 1;
                //int val = target - nums[fl] - nums[sl];
                while (left < right) {
                    if (nums[left] + nums[right] + nums[fl] + nums[sl] == target) {
                        ans.add(Arrays.asList(nums[fl], nums[sl], nums[left], nums[right]));
                        while (left < right && nums[left] == nums[left + 1]) {
                            left++;
                        }

                        while (left < right && nums[right] == nums[right - 1]) {
                            right--;
                        }

                        left++;
                        right--;
                    } else if (nums[left] + nums[right] + nums[fl] + nums[sl] > target) {
                        right--;
                    } else {
                        left++;
                    }
                }
            }
        }

        return ans;
    }
}