class Solution {

    boolean[][] visited;

    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int rows = image.length;
        int cols = image[0].length;

        visited = new boolean[rows][cols];

        //get the color
        int curr_color = image[sr][sc];

        dfs(sr,sc,rows,cols,image,visited,curr_color,color);

        return image;
    }

    public void dfs(int r, int c, int rows, int cols, int[][] image, boolean[][] visited, int curr_color, int color){

        //base case
        if(r < 0 || r >= rows || c < 0 || c >= cols || visited[r][c] || image[r][c] != curr_color){
            return;
        }

        image[r][c] = color;
        visited[r][c] = true;

        dfs(r + 1, c, rows, cols, image, visited, curr_color, color);
        dfs(r - 1, c, rows, cols, image, visited, curr_color, color);
        dfs(r, c + 1, rows, cols, image, visited, curr_color, color);
        dfs(r, c - 1, rows, cols, image, visited, curr_color, color);
    }
}