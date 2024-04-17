class Solution {
    public int maxNumberOfBalloons(String text) {
        String balloon = "balloon";
        HashMap<Character, Integer> bmap = new HashMap<>();

        for (int i = 0; i < balloon.length(); i++) {
            char cc = balloon.charAt(i);

            bmap.put(cc, bmap.getOrDefault(cc, 0) + 1);
        }

        HashMap<Character, Integer> tmap = new HashMap<>();
        for (int i = 0; i < text.length(); i++) {
            char cc = text.charAt(i);

            tmap.put(cc, tmap.getOrDefault(cc, 0) + 1);
        }
        int min = text.length();
        for(Character c : bmap.keySet()){
            min = Math.min(min, tmap.getOrDefault(c,0)/bmap.get(c));
        }

        return min;
    }
}