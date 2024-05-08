class Solution {
    public long flowerGame(int n, int m) {
        // Alice can only win when total odd number of flowers
        long res = 0l;
        long oddn = (n + 1) * 1l / 2l, oddm = (m + 1) * 1l / 2l;
        long evenn = n * 1l / 2l, evenm = m * 1l / 2l;

        return (evenn * oddm) + (evenm * oddn);

    }
}