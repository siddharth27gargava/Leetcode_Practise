class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int i = 0;
        int j = 0;
        int k = 0;
        int[] ans = new int[nums1.length];
        while (i < m && j < n) {
            if (nums1[i] >= nums2[j]) {
                ans[k] = nums2[j];
                j++;
            } else{
                ans[k] = nums1[i];
                i++;
            }
            k++;   
        }

        if (i == m) {
            while (j < n) {
                ans[k] = nums2[j];
                j++;
                k++;
            }
        }

        if (j == n) {
            while (i < m) {
                ans[k] = nums1[i];
                i++;
                k++;
            }
        }

        for (int l = 0; l < ans.length; l++) {
            nums1[l] = ans[l];
        }
    }
}