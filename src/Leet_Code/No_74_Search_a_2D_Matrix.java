package Leet_Code;

/**
 * @program: Leetcode
 * @description: No_74_Search_a_2D_Matrix
 * @author: Wangky
 * @create: 2019-01-09 20:33
 **/
public class No_74_Search_a_2D_Matrix {

    public boolean searchMatrix(int[][] matrix, int target) {
        int row = matrix.length;
        if (row == 0) return false;
        if(row > 0){
            int col = matrix[0].length;
        }

        int start = 0;
        int end = row - 1;
        while (start < end){
            int mid = start + (end-start)/2;
            if (matrix[mid][0] < target ){

            }else if (matrix[mid][0] > target){

            }else{
                return true;
            }
        }
        return true;

    }



}
