class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        if (sumA(gas) < sumA(cost)) {
            return -1;
        }
        int start = 0;
        int total = 0;

        for (int i = 0; i < cost.length; i++) {
            total += gas[i] - cost[i];

            if (total < 0) {
                total = 0;
                start = i+1;
            }
        }

        return start;
    }

    public int sumA(int[] nums){
        int sum = 0;

        for (int num : nums) {
            sum += num;
        }

        return sum;
    }
}