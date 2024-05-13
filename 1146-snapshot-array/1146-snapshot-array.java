class SnapshotArray {
    private final List<int[]>[] snapshotArray; // An array of lists to hold the elements at different snapshots
    private int currentSnapId; // To keep track of the current snapshot id

    // Constructor
    public SnapshotArray(int length) {
        // Initialize the array of lists with the given length
        snapshotArray = new List[length];
        // Fill each list within the array
        Arrays.setAll(snapshotArray, k -> new ArrayList<>());
    }

    // Set a value at a particular index
    public void set(int index, int val) {
        /* Add a pair (snapshot id, value) to the corresponding index.
         * If a snapshot is taken after this, it will have the new value. */
        snapshotArray[index].add(new int[] {currentSnapId, val});
    }

    // Take a snapshot of the array and return the current snapshot id
    public int snap() {
        // Increase the snapshot id and return the id of the snapshot taken
        return currentSnapId++;
    }

    // Get the value at a specific index for a given snapshot
    public int get(int index, int snapId) {
        // List for values at the index
        List<int[]> values = snapshotArray[index];
        // Binary search to find the floor entry of the provided snapId
        int left = 0, right = values.size();
        while (left < right) {
            int mid = (left + right) / 2; // mid-point for binary search
            // If the mid snapshot id is greater than snapId, search on the left
            if (values.get(mid)[0] > snapId) {
                right = mid;
            } else {
                // If not, search on the right
                left = mid + 1;
            }
        }
        // If there's no element, return 0. Otherwise, return the value found at the snapId
        return left == 0 ? 0 : values.get(left - 1)[1];
    }
}

/**
 * Usage:
 * SnapshotArray obj = new SnapshotArray(length);
 * obj.set(index, val);
 * int snapId = obj.snap();
 * int value = obj.get(index, snapId);
 */