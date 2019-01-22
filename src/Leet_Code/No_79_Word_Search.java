package Leet_Code;

/**
 * @program: Leetcode
 * @description:
 * @author: Wangky
 * @create: 2019-01-17 12:42
 **/
public class No_79_Word_Search {


    public static boolean exist(char[][] board, String word) {
        if (word == null) return false;
        boolean[][] visited = new boolean[board.length][board[0].length];
        int row = board.length;
        int column = board[0].length;
        for (int i=0;i<row;i++){
            for (int j=0;j<column;j++){
                if (board[i][j] == word.charAt(0)){
                    if(dfs(i,j,visited,board,0,word)){
                        return true;
                    }
                }else {
                    continue;
                }
            }
        }
        return false;
    }

    // nth 代表word 的第n个字母。
    public static boolean dfs(int i,int j,boolean[][] visited,char[][] board,int nth,String word){
        if ( i<0 || j<0 || i >=board.length || j>=board[0].length
                || visited[i][j]==true || board[i][j] != word.charAt(nth)) return false;
        if (nth == word.length()-1){
            return true;
        }
        visited[i][j] = true;
        int[] x = {1,-1,0,0};
        int[] y = {0,0,1,-1};
        for (int k = 0;k<4;k++){
            if( dfs(i+x[k],j+y[k],visited,board,nth+1,word)){
                return true;
            }
        }
        visited[i][j] = false;
        return false;
    }

    public static void main(String[] args) {
        char[][] board = {{'A','B','C','E'},{'S','F','C','S'},{'A','D','Q','E'}};
        String word = "ABCCED";
//        char[][] board = {{'a'}};
//        String word =  "ab";
        System.out.println(exist(board,word));
    }


}
