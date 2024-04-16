class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> res = new ArrayList<>();

        if (numRows == 0) {
            return res;
        }

        res.add(new ArrayList<>(Arrays.asList(1)));

        for (int level = 1; level < numRows; level++) {
            
            List<Integer> row = new ArrayList<>();
            List<Integer> prev_row = res.get(level-1);

            row.add(1);

            for (int i = 1; i < level; i++) {
                row.add(prev_row.get(i-1) + prev_row.get(i));
            }

            row.add(1);
            res.add(row);
        }

        return res;
    }
}