class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> result = new ArrayList<>();

        if (s.length() == 0 || s == null || p.length() > s.length()){
            return result;
        }

        HashMap<Character,Integer> smap = new HashMap<>();
        HashMap<Character,Integer> pmap = new HashMap<>();

        for (int i = 0; i < p.length(); i++) {
            char cc = s.charAt(i);
            if (smap.containsKey(cc)){
                int of = smap.get(cc);
                int nf = of+1;
                smap.put(cc,nf);
            } else {
                smap.put(cc,1);
            }
        }

        for (int i = 0; i < p.length(); i++) {
            char cc = p.charAt(i);
            if (pmap.containsKey(cc)){
                int of = pmap.get(cc);
                int nf = of+1;
                pmap.put(cc,nf);
            } else {
                pmap.put(cc,1);
            }
        }

        int left = 0;
        int right = p.length();

        //SLIDING WINDOW STARTS

        while (right < s.length()){
            //COMPARE and ADD
            if (compare(smap,pmap)){
                result.add(left);
            }

            //ACQUIRE NEW
            char aqch = s.charAt(right);
            if (smap.containsKey(aqch)){
                int of = smap.get(aqch);
                int nf = of + 1;
                smap.put(aqch,nf);
            } else {
                smap.put(aqch,1);
            }

            //REMOVE OLD
            char rch = s.charAt(left);
            if (smap.get(rch) == 1){
                smap.remove(rch);
            } else {
                int of = smap.get(rch);
                int nf = of - 1;
                smap.put(rch,nf);
            }

            left++;
            right++;
        }

        if (compare(smap,pmap)){
            result.add(left);
        }

        return result;
    }
    
    public boolean compare(HashMap<Character,Integer> smap, HashMap<Character,Integer> pmap){
        boolean flag = true;

        Set<Character> keys = smap.keySet();
        for (char key : keys){
            if (!pmap.containsKey(key)){
                flag = false;
            }

            if (pmap.containsKey(key)){
                if (pmap.get(key) != smap.get(key)){
                    flag = false;
                }
            }

        }

        return flag;
    }
}