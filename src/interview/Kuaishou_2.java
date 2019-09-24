package interview;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @program: Leetcode
 * @description:
 * @author: Wangky
 * @create: 2019-09-16 21:25
 **/
public class Kuaishou_2 {
    private static final String[] mapOfNumAndAlpha = {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();

        List<String> result = new ArrayList<>();
        if (input != null || input.length() > 0) {
            dfs(new StringBuilder(), result, input);
        }
        System.out.println(result);
    }

    private static void dfs(StringBuilder sb, List<String> result, final String input) {
        if (sb.length() == input.length()) {
            result.add(sb.toString());
            return;
        }
        int current = input.charAt(sb.length()) - '0';
        String letters = mapOfNumAndAlpha[current];
        for (char c : letters.toCharArray()) {
            sb.append(c);
            dfs(sb, result, input);
            sb.deleteCharAt(sb.length() - 1);
        }
    }



}
