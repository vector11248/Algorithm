package interview;

import java.util.Scanner;

public class Yuanfudaoo {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[][] input = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                input[i][j] = sc.nextInt();
            }
        }

        int[] res = helper(input,n,m);
        for (int i = 0; i < n * m; i++) {
            System.out.print(res[i] + " ");
        }
    }

    public static int[] helper (int[][] input, int n, int m) {
        int startX = 0;
        int startY = 0;
        int endX = m-1;
        int endY = n-1;
        int idx = 0;
        int[] res = new int[n*m];

        while (startX <= endX && startY <= endY) {
            if (startY <= endY) {
                for (int i = startY; i <= endY; i++) {
                    res[idx++] = input[i][startX];
                }
            }

            if (startX < endX) {
                for (int i = startX+1; i <= endX; i++) {
                    res[idx++] = input[endY][i];
                }
            }
            if (startX < endX && startY < endY) {
                for (int i = endY-1; i >= startY; i--) {
                    res[idx++] = input[i][endX];
                }
            }
            if (startX < endX-1 && startY < endY) {
                for (int i = endX-1; i >= startX+1; i--) {
                    res[idx++] = input[startY][i];
                }
            }
            startX++;
            startY++;
            endX--;
            endY--;

        }
        return res;
    }
}