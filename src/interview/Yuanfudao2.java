package interview;

import java.util.Scanner;

/**
 * @program: Leetcode
 * @description:
 * @author: Wangky
 * @create: 2019-09-16 18:23
 **/
public class Yuanfudao2 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int s = in.nextInt();
        int[] courses = new int[n];

        for (int i = 0; i < n; i++) {
            courses[i] = in.nextInt();
        }

        int preSum = 0, preLen = 0, maxLen = 0;
        for (int i = 0; i < n; i++) {
            int current = courses[i];
            if (preSum + current <= s) {
                preSum = preSum + current;
                preLen++;
            } else {
                preSum = current;
                preLen = 1;
                int j = i - 1;
                while (j >= 0 && preSum + courses[j] <= s) {
                    preSum += courses[j];
                    preLen++;
                }
            }
            maxLen = maxLen > preLen ? maxLen : preLen;
        }

        System.out.println(maxLen);
    }
}


