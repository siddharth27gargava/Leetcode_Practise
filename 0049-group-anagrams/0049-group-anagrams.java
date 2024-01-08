class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String, List<String>> wordmap = new HashMap<>();

        for(String word : strs){
            char[] chvals = word.toCharArray();

            Arrays.sort(chvals);

            String keywd = new String(chvals);

            if(!wordmap.containsKey(keywd)){
                wordmap.put(keywd, new ArrayList<>());
            }

            wordmap.get(keywd).add(word);
        }

        return new ArrayList<>(wordmap.values());
    }
}