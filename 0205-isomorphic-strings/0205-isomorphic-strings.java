class Solution {
    public boolean isIsomorphic(String s, String t) {
        
        if(s.length() != t.length()){
            return false;
        }
        
        HashMap<Character, Character> smap = new HashMap<>();
        HashMap<Character, Character> tmap = new HashMap<>();
        int spointer = 0;
        int tpointer = 0;

        while (spointer < s.length() && tpointer < t.length()) {
            if ( (smap.containsKey(s.charAt(spointer)) && smap.get(s.charAt(spointer)) != t.charAt(spointer)) ||  
            (tmap.containsKey(t.charAt(tpointer)) && tmap.get(t.charAt(tpointer)) != s.charAt(tpointer)) ) {
                return false;
            }

            smap.put(s.charAt(spointer), t.charAt(spointer));
            tmap.put(t.charAt(tpointer), s.charAt(tpointer));

            spointer++;
            tpointer++;
        }

        return true;
    }
}