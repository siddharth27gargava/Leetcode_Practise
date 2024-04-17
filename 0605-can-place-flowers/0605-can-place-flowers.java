class Solution {
    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        // loop
        if (n == 0) {
            return true;
        }

        if (flowerbed.length == 0) {
            return false;
        }

        if (flowerbed.length == 1) {
            if (flowerbed[0] == 0) {
                return true;
            } else {
                return false;
            }
        }

        if (flowerbed.length < n) {
            return false;
        }

        for (int i = 0; i < flowerbed.length; i++) {

            if (i == 0) {
                if (flowerbed[i] == 0) {
                    if (flowerbed[i + 1] == 0) {
                        flowerbed[i] = 1;
                        n--;
                    }
                }
                continue;
            }

            if (i == flowerbed.length - 1) {
                if (flowerbed[i] == 0) {
                    if (flowerbed[i - 1] == 0) {
                        flowerbed[i] = 1;
                        n--;
                    }
                }
            }

            if (flowerbed[i] == 0) {
                if (flowerbed[i - 1] == 0 && flowerbed[i + 1] == 0) {
                    flowerbed[i] = 1;
                    n--;
                }
            }
        }

        if (n <= 0) {
            return true;
        }

        return false;
    }
}