package Leet_Code;

/**
 * @program: Leetcode
 * @description:
 * @author: Wangky
 * @create: 2019-02-25 17:27
 **/
public class No_130_Surrounded_Regions {

    public static void dfs(char[][] board,boolean[] flag,int i,int j,int n,int m){

        int[][] dir = {{1,0},{-1,0},{0,1},{0,-1}};
        int x,y;
        for (int[] d:dir){
            x = i + d[0];
            y = j + d[1];
            if (x < 0 || y<0 || x>=n || y>=m){
                continue;
            }
            if (!flag[x*m + y] && board[x][y]=='o'){
                flag[x*m + y] = true;
                dfs(board,flag,x,y,n,m);
            }
        }

    }

    public void solve(char[][] board) {
        if (board.length == 0 || board[0].length==0) return;
        int n = board.length;
        int m = board[0].length;
        boolean[] flag = new boolean[n*m];
        // 遍历边界，先左右，后上下
        for (int i=0;i<n;i++){
            if (!flag[i*m] && board[i][0] == 'o'){
                flag[i*m] = true;
                dfs(board,flag,i,0,n,m);
            }
            if (!flag[i*m + m-1] && board[i][m-1] == 'o'){
                flag[i*m + m-1] = true;
                dfs(board,flag,i,m-1,n,m);
            }
        }
        for (int j=0;j<m;j++){
            if (!flag[j] && board[0][j] == 'o'){
                flag[j] = true;
                dfs(board,flag,0,j,n,m);
            }
            if (!flag[(n-1)*m + j] && board[n-1][j]=='o'){
                flag[(n-1)*m+j]=true;
                dfs(board,flag,n-1,j,n,m);
            }
        }
        for (int i=0;i<n;i++){
            for (int j=0;j<m;j++){
                if (board[i][j] == 'o' && !flag[i*m + j]){
                    board[i][j] = 'X';
                }
            }
        }


    }

}
