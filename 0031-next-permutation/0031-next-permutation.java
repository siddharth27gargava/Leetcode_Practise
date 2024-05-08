class Solution {
    public void nextPermutation(int[] nums) {
        // 4 steps
        // traverse from back and find first index such that a[i] < a[i+1]
        int idx1 = -1;
        for (int i = nums.length - 2; i >= 0; i--) {
            if (nums[i + 1] > nums[i]) {
                idx1 = i;
                break;
            }
        }

        int idxrev = idx1;

        if (idx1 == -1) {
            Arrays.sort(nums);
            return;
        }

        // traverse from back and find first index such that a[i] > idx1
        int idx2 = -1;
        for (int i = nums.length - 1; i >= 0; i--) {
            if (nums[i] > nums[idx1]) {
                idx2 = i;
                break;
            }
        }

        // if (idx1 == -1 || idx2 == -1) {
        //     Arrays.sort(nums);
        //     return;
        // }

        // swap idx1 and idx2
        swap(nums, idx1, idx2);

        // reverse all the values to the right of idx2
        reverseArrayfromx(nums, idxrev);

    }

    public void swap(int[] nums, int a, int b) {
        int temp = nums[a];
        nums[a] = nums[b];
        nums[b] = temp;
    }

    public void reverseArrayfromx(int[] nums, int idx) {
        int start = idx + 1;
        int end = nums.length - 1;
        while (start < end) {
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start++;
            end--;
        }
    }
}