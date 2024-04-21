class Solution {
    public String largestNumber(int[] nums) {
        //create a new string array
        String[] arr = new String[nums.length];

        //add string values in the array
        for(int i = 0; i < nums.length; i++){
            arr[i] = String.valueOf(nums[i]);
        }
        
        //comparator
        Arrays.sort(arr, new Comparator<String>(){
            @Override
            public int compare(String s1, String s2){
                String n1 = s1 + s2; 
                String n2 = s2 + s1;
                //comparator t sort in descending order
                return n2.compareTo(n1);
            }
        });

        //stringbuilder return to String
        StringBuilder sb = new StringBuilder();

        //if 0th element is 0, that means no value in array
        if(arr[0].equals("0")){
            return "0";
        }

        for(String str: arr){
            sb.append(str);
        }

        return sb.toString();    
    }
}