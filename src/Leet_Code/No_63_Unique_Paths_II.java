package Leet_Code;

/**
 * @program: Leetcode
 * @description:
 * @author: Wangky
 * @create: 2019-01-18 12:54
 **/
public class No_63_Unique_Paths_II {

    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int row = obstacleGrid.length;
        int column = obstacleGrid[0].length;
        int[][] path = new int[row][column];
        for(int i=0;i<column;i++){
            if (obstacleGrid[0][i]==0){
                path[0][i] = 1;
            }else {
                for (int j=i;j<column;j++){
                    path[0][j] = 0; // 0代表不能通行,同时在加法累计的时候可以不计入结果
                }
                break;
            }
        }
        for(int i=0;i<row;i++){
            if (obstacleGrid[0][i]==0){
                path[i][0] = 1;
            }else {
                for (int j=i;j<row;j++){
                    path[i][0] = 0; // 0代表不能通行
                }
                break;
            }
        }

        for (int i=1;i<row;i++){
            for (int j=1;j<column;j++){
                if (obstacleGrid[i][j] == 1){
                    path[i][j] = 0;
                }else {
                    path[i][j] = path[i-1][j]+path[i][j-1];
                }
            }
        }
        return path[row-1][column-1];
    }
}
