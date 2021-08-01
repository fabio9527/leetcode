package cfx20210801;

public class Offer47 {

    /**
     * 在一个 m*n 的棋盘的每一格都放有一个礼物，每个礼物都有一定的价值（价值大于 0）。
     * 你可以从棋盘的左上角开始拿格子里的礼物，并每次向右或者向下移动一格、直到到达棋盘的右下角。
     * 给定一个棋盘及其上面的礼物的价值，请计算你最多能拿到多少价值的礼物？
     *
     * @param grid
     * @return
     */
    public int maxValue_0(int[][] grid) {
        if (grid.length == 0 || grid[0].length == 0) {
            return 0;
        }
        int[] value = new int[1];
        getValue(grid, value, grid[0][0], 0, 0);
        return value[0];
    }

    private void getValue(int[][] garid, int[] value, int curretValue, int x, int y) {
        if (x == garid.length - 1 && y == garid[0].length - 1) {
            if (curretValue > value[0]) {
                value[0] = curretValue;
            } else {
                return;
            }
        }
        // 向右
        if (y + 1 < garid[0].length) {
            getValue(garid, value, curretValue + garid[x][y + 1], x, y + 1);
        }
        // 向下
        if (x + 1 < garid.length) {
            getValue(garid, value, curretValue + garid[x + 1][y], x + 1, y);
        }
    }

    public int maxValue(int[][] grid) {
        if (grid.length == 0 || grid[0].length == 0) {
            return 0;
        }
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (i != 0 && j != 0) {
                    grid[i][j] = Math.max(grid[i - 1][j], grid[i][j - 1]) + grid[i][j];
                } else if (i == 0 && j != 0) {
                    grid[i][j] = grid[i][j - 1] + grid[i][j];
                } else if (j == 0 && i != 0) {
                    grid[i][j] = grid[i - 1][j] + grid[i][j];
                } else {
                    continue;
                }
            }
        }

        return grid[grid.length - 1][grid[0].length - 1];
    }

    public static void main(String[] args) {
        Offer47 offer47 = new Offer47();
        int[][] nums = new int[][]{
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        };
        System.out.println(offer47.maxValue(nums));
    }
}
