class Solution {
    public String reverseWords(String s) {
        //break down s into different words
        String[] words = s.split(" +");
        
        //StringBuilder
        StringBuilder sb = new StringBuilder();
        
        //run an opposite loop
        for(int i = words.length - 1; i >= 0; i--){
            sb.append(words[i]);
            sb.append(" ");
        }
        
        return sb.toString().trim();
    }
}