class Solution {
    public String minWindow(String s, String t) {
        //Step-0 Initialise ans as empty string
        //Step-1 create hashmap for mct and fill values
        //Step-2 put left and right as -1
        //Step-2.5 initialise mct as 0, and dmct as t.length
        //Step-3 not a typical while loop instead have while(true)
        //declare two : flags

        //Step-4 acquire by checking right < s.length-1 and mct < dmct
        //Increment right, put it in smap
        //Check if the char is needed in tmap and update mct accordingly
        //Change the boolean value fo flag to true

        //Step-5 contract the string by checking left < right and mct == dmct
        //Step-6 get the potential ans as substr(l+1,r+1)
        //update ans by checking potans length less than ans or ans = 0

        //Step-7  incr left, remove it from smap in two way of -1 or remove
        //Step-8 subtract value from mct
        //Change the boolean to true
        //If both booleans are false, then break

        String ans = "";
        HashMap<Character,Integer> tMap = new HashMap<>();
        for (int i = 0; i < t.length(); i++) {
            tMap.put(t.charAt(i), tMap.getOrDefault(t.charAt(i), 0) + 1);
        }

        HashMap<Character,Integer> sMap = new HashMap<>();
        int left = -1;
        int right = -1;

        int mct = 0;
        int dmct = t.length();

        while (true) {
            boolean l1 = false;
            boolean l2 = false;

            while (right < s.length() - 1 && mct < dmct) {
                right++;

                char scc = s.charAt(right);

                sMap.put(scc, sMap.getOrDefault(scc, 0) + 1);

                if (sMap.getOrDefault(scc, 0) <= tMap.getOrDefault(scc, 0)) {
                    mct++;
                }

                l1 = true;
            }

            while (left < right && mct == dmct) {
                String potans = s.substring(left + 1, right + 1);
                if(potans.length() < ans.length() || ans.length() == 0){
                    ans = potans;
                }

                left++;

                char scc = s.charAt(left);

                if(sMap.get(scc) > 1){
                    sMap.put(scc, sMap.get(scc) - 1);
                } else {
                    sMap.remove(scc);
                }

                if (sMap.getOrDefault(scc, 0) < tMap.getOrDefault(scc, 0)) {
                    mct--;
                }

                l2 = true;
            }

            if (l1 == false && l2 == false) {
                break;
            }
        }

        return ans;
    }
}