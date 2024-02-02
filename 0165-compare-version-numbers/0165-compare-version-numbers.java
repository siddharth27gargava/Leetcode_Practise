class Solution {
    public int compareVersion(String version1, String version2) {
        //convert string to char string array
        //choose each array element of string from left and compare
        //if 001 and 01 - convert string to number
        String[] vst1 = version1.split("\\.");
        String[] vst2 = version2.split("\\.");
        // for (String str : vst1) {
        //     System.out.print(str + " ");
        // } 
        int i = 0;
        int j = 0;
        while (i < vst1.length && j < vst2.length) {
            int vst1el = Integer.parseInt(vst1[i]);
            int vst2el = Integer.parseInt(vst2[j]);

            if (vst1el > vst2el) {
                return 1;
            } else if(vst1el < vst2el){
                return -1;
            }
            i++;
            j++;
        }

        if (i == vst1.length) {
            while (j < vst2.length) {
                int vst2el = Integer.parseInt(vst2[j]);
                if (vst2el > 0) {
                    return -1;
                }
                j++;
            }
        }

        if (j == vst2.length) {
            while (i < vst1.length) {
                int vst1el = Integer.parseInt(vst1[i]);
                if (vst1el > 0) {
                    return 1;
                }
                i++;
            }
        }

        return 0;
    }
}