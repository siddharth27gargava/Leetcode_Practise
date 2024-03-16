class Solution {
    public int maxArea(int[] height) {
        //two pointers
        int left = 0;
        int right = height.length - 1;
        int max = 0;
        int area = 0;

        while (left < right) {
            if (height[left] >= height[right]) {
                area = (right - left) * height[right];
                right--;
            } else{
                area = (right - left) * height[left];
                left++;
            }

            max = Math.max(area, max);
        }

        return max;
    }
}