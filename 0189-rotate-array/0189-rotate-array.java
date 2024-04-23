class Solution {
    public void rotate(int[] nums, int k) {
        int n = nums.length;
        k = k % n;
        int i = 0;
        // 1,2,3,4,5,6 -> 4,5,6,1,2,3
        int[] res = new int[nums.length];
        // i + k %n position par you'll have ith value
        while (i < n) {
            int places = (i + k) % n;
            res[places] = nums[i];
            i++;
        }

        for (int j = 0; j < res.length; j++) {
            nums[j] = res[j];
        }
    }
}