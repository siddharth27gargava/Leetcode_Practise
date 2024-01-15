class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        Deque<Integer> q = new LinkedList<>();
        ArrayList<Integer> al = new ArrayList<>();

        int i = 0;

        for(i = 0; i < k; i++){
            

            while (!q.isEmpty() && nums[i] > nums[q.getLast()]) {
                q.removeLast();
            }

            q.addLast(i);
        }

        for(;i < nums.length; i++){

            al.add(nums[q.getFirst()]);

            while (!q.isEmpty() && q.getFirst() <= i-k) {
                q.removeFirst();
            }

            while (!q.isEmpty() && nums[i] > nums[q.getLast()]) {
                q.removeLast();
            }

            q.addLast(i);
        }

        al.add(nums[q.getFirst()]);

        int[] ans = new int[al.size()];

        for (int j = 0; j < ans.length; j++) {
            ans[j] = al.get(j);
        }

        return ans;
    }
}