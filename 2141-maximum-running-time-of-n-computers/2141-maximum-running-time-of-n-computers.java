class Solution {

    // This method is designed to find the maximum running time for 'n' computers using given batteries
    public long maxRunTime(int n, int[] batteries) {
        long left = 0; // Initialize the lower bound of binary search
        long right = 0; // Initialize the upper bound of binary search

        // Calculate the sum of all the batteries which will be the upper bound
        for (int battery : batteries) {
            right += battery;
        }
      
        // Use binary search to find the maximum running time
        while (left < right) {
            // Calculate the middle point, leaning towards the higher half
            long mid = (left + right + 1) >> 1;
            long sum = 0; // Sum of the minimum of mid and the battery capacities

            // Calculate the sum of the minimum of mid or the battery capacities
            for (int battery : batteries) {
                sum += Math.min(mid, battery);
            }

            // If the sum is sufficient to run 'n' computers for 'mid' amount of time
            if (sum >= n * mid) {
                // We have enough capacity, so try a longer time in the next iteration
                left = mid;
            } else {
                // Otherwise, try a shorter time in the next iteration
                right = mid - 1;
            }
        }
        // Return the maximum running time found through binary search
        return left;
    }
}