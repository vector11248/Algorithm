package Leet_Code;

/**
 * @program: Leetcode
 * @description:
 * @author: Wangky
 * @create: 2019-01-02 15:21
 **/
public class No_733_Flood_Fill {

    private  void dfs(int[][] image,int i,int j,int newColor){
        if ( i<0 || j<0 || i >=image.length || j>=image[0].length ) return;
        image[i][j]=newColor;
        dfs(image,i,j-1,newColor);
        dfs(image,i,j+1,newColor);
        dfs(image,i+1,j,newColor);
        dfs(image,i-1,j,newColor);
    }

    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        dfs(image,sr,sc,newColor);
        return image;
    }

}
