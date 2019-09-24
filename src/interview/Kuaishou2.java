package interview;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @program: Leetcode
 * @description:
 * @author: Wangky
 * @create: 2019-09-16 21:17
 **/
public class Kuaishou2 {
        private static final String[] mapping = {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};

        public static void main(String[] args) {
            Scanner scanner = new Scanner(System.in);
            String input = scanner.nextLine();

            List<String> result = new ArrayList<>();
            if (input != null || input.length() > 0) {
                backTracking(new StringBuilder(), result, input);
            }
            System.out.println(result);
        }

        private static void backTracking(StringBuilder str, List<String> result, final String input) {
            if (str.length() == input.length()) {
                result.add(str.toString());
                return;
            }
            int current = input.charAt(str.length()) - '0';
            String letters = mapping[current];
            for (char c : letters.toCharArray()) {
                str.append(c);
                backTracking(str, result, input);
                str.deleteCharAt(str.length() - 1);
            }
        }

}
