class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
        double[][] ltarr = new double[speed.length][2];
        for (int i = 0; i < ltarr.length; i++) {
            ltarr[i][0] = position[i] * 1d;
            ltarr[i][1] = (target - position[i]  * 1d)/speed[i];
        }

        Arrays.sort(ltarr, (a,b) -> (Double.compare(a[0], b[0])));

        int nof = 1;
        double timeTakenUpdated = ltarr[position.length - 1][1];

        for (int i = position.length - 2; i >= 0; i--) {
            //what I was forgetting was that I am talking of a scenario where I have to increase the fleet number which means behind car has to be slower(has to have greater time to reach) than the updatedTime car
            if (timeTakenUpdated < ltarr[i][1]) {
                nof++;
                timeTakenUpdated = ltarr[i][1];
            }
        }

        return nof;

    }
}