class Solution {
    public int minRefuelStops(int target, int startFuel, int[][] stations) {
        //initialise pq-fuel
        PriorityQueue<Integer> fuelq = new PriorityQueue<>((a,b) -> b - a);
        int stops = 0;

        //add target and 0 in the stations list
        int[][] updatedstations = new int[stations.length + 1][2];

        for (int i = 0; i < stations.length; i++) {
            updatedstations[i][0] = stations[i][0];
            updatedstations[i][1] = stations[i][1];
        }

        updatedstations[updatedstations.length - 1][0] = target;
        updatedstations[updatedstations.length - 1][1] = 0;

        int curr_fuel = startFuel;
        int prevPosition = 0;

        for (int i = 0; i < updatedstations.length; i++) {
            //track of distance between stations
            int distance = updatedstations[i][0] - prevPosition;

            //update curr fuel accordingly
            curr_fuel = curr_fuel - distance;
            
            while (curr_fuel < 0 && !fuelq.isEmpty()) {
                curr_fuel += fuelq.poll();
                stops++;
            }

            if (curr_fuel < 0) {
                return -1;
            }

            fuelq.add(updatedstations[i][1]);
            prevPosition = updatedstations[i][0];
        }

        return stops;
    }
}