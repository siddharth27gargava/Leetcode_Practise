class Solution {
    public int[] platesBetweenCandles(String s, int[][] queries) {
        int n = s.length();
        int[] leftCandle = new int[n];
        int[] rightCandle = new int[n];
        int[] platesPrefixSum = new int[n];

        // Initialize leftCandle array
        int lastCandle = -1;
        for (int i = 0; i < n; i++) {
            if (s.charAt(i) == '|') {
                lastCandle = i;
            }
            leftCandle[i] = lastCandle;
        }

        // Initialize rightCandle array
        lastCandle = -1;
        for (int i = n - 1; i >= 0; i--) {
            if (s.charAt(i) == '|') {
                lastCandle = i;
            }
            rightCandle[i] = lastCandle;
        }

        // Initialize platesPrefixSum array
        int platesCount = 0;
        for (int i = 0; i < n; i++) {
            if (s.charAt(i) == '*') {
                platesCount++;
            }
            platesPrefixSum[i] = platesCount;
        }

        // Process each query
        int[] result = new int[queries.length];
        for (int i = 0; i < queries.length; i++) {
            int left = queries[i][0];
            int right = queries[i][1];

            // Find the positions of the nearest candles within the range
            int initialCandleposition = rightCandle[left];
            int finalCandleposition = leftCandle[right];

            if (initialCandleposition == -1 || finalCandleposition == -1 || initialCandleposition >= finalCandleposition) {
                result[i] = 0;
            } else {
                result[i] = platesPrefixSum[finalCandleposition] - platesPrefixSum[initialCandleposition];
            }
        }

        return result;
    }
}