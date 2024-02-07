class Solution {
    public int romanToInt(String s) {
        HashMap<Character, Integer> map = new HashMap<>();

        map.put('I', 1);
        map.put('V', 5);
        map.put('X', 10);
        map.put('L', 50);
        map.put('C', 100);
        map.put('D', 500);
        map.put('M', 1000);

        char[] charray = s.toCharArray();
        int sum = 0;
        int chval = 0;
        for (int i = charray.length - 1; i >= 0; i--) {
            if (i > 0 && charray[i-1] == 'I' && (charray[i] == 'V')) {
                chval = 4;
                i--;
            } else if(i > 0 && charray[i-1] == 'I' && (charray[i] == 'X')){
                chval = 9;
                i--;
            } else if(i > 0 && charray[i-1] == 'X' && (charray[i] == 'L')){
                chval = 40;
                i--;
            } else if(i > 0 && charray[i-1] == 'X' && (charray[i] == 'C')){
                chval = 90;
                i--;
            } else if(i > 0 && charray[i-1] == 'C' && (charray[i] == 'D')){
                chval = 400;
                i--;
            } else if(i > 0 && charray[i-1] == 'C' && (charray[i] == 'M')){
                chval = 900;
                i--;
            } else {
                chval = map.get(charray[i]);
            }
            
            //int chval = map.get(charray[i]);
            sum += chval;
        }

        return sum;
    }
}