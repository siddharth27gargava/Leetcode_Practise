class Solution {
    public int countLatticePoints(int[][] circles) {
        //for each circle
        //find the start x to end x
        //find the start y and end y
        //if the x - circlex2 + y - circley2 <= radius2, count++;
        int count = 0;

        HashSet<String> set = new HashSet<>();

        for(int[] circle : circles){
            int circlex = circle[0];
            int circley = circle[1];
            int radius = circle[2];

            int startx = circlex - radius;
            int endx = circlex + radius;
            int starty = circley - radius;
            int endy = circley + radius;
            int rsq = (int)(Math.pow(radius, 2));

            for(int x = startx; x <= endx; x++){
                for (int y = starty; y <= endy; y++) {
                    if (calcSquare(x,y,circlex,circley) <= rsq) {
                        set.add("x: " + x + "y: " + y);
                    }
                }
            }
        }

        return set.size(); 
    }

    public int calcSquare(int x, int y, int circlex, int circley){
        int xdiff = Math.abs(circlex - x);
        int ydiff = Math.abs(circley - y);

        int sum = (int)(Math.pow(xdiff, 2)) + (int)(Math.pow(ydiff, 2));

        return sum;
    }
}