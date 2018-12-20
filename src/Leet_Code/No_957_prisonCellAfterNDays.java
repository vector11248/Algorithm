package Leet_Code;

/**
 * @program: Leetcode
 * @description:
 * @author: Wangky
 * @create: 2018-12-18 11:16
 **/
public class No_957_prisonCellAfterNDays {

    public static int[] changePerDay(int[] cells){

        int length = cells.length;
        int[] new_cells = new int[length];
        for (int i = 1; i < 7; i++) { // 第一个和第八个单独固定赋值；
            new_cells[i] = (cells[i-1]^cells[i+1]^1);
        }
        new_cells[0] = 0;
        new_cells[7] = 0;
        return new_cells;
    }


    public static int[] prisonAfterNDays(int[] cells, int N) {
        for (int i = 0; i < N ; i++) {
            cells = changePerDay(cells);
            System.out.println("i= "+i +" ...");
        }
        return cells;
    }


    public static void main(String[] args) {

        int[] cells = {0,1,0,1,1,0,0,1};
        cells = prisonAfterNDays(cells,1000000000);
        for (int i = 0; i < 8 ; i++) {
            System.out.print(cells[i]+"  ");
        }
    }
}
