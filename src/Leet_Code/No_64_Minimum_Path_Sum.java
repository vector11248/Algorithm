package Leet_Code;

/**
 * @program: Leetcode
 * @description:
 * @author: Wangky
 * @create: 2019-01-18 13:15
 **/
public class No_64_Minimum_Path_Sum {

    public int minPathSum(int[][] grid) {
        int row = grid.length;
        int column = grid[0].length;
        int[][] pathSum = new int[row][column];
        pathSum[0][0] = grid[0][0];
        for (int i = 1;i<row;i++){
            pathSum[i][0] = pathSum[i-1][0];
        }
        for (int j=1;j<column;j++){
            pathSum[0][j] = pathSum[0][j-1];
        }
        for (int i=1;i<row;i++){
            for (int j= 1;j<column;j++){
                pathSum[i][j] = Math.min(pathSum[i-1][j],pathSum[i][j-1]) + grid[i][j];
            }
        }
        return pathSum[row-1][column-1];
    }

}
