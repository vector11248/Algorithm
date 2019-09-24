package interview;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;


public class ByteDance03 {

    public static void main(String[] args) {
        int[][] matrix = buildMatrix();
        List<Integer> resList = sort(matrix.length - 1, matrix);
        for (int i : resList) {
            System.out.print(i + " ");
        }
    }

    public static int[][] buildMatrix() {
        Scanner scanner = new Scanner(System.in);
        List<List<String>> list = new ArrayList<>();
        int num = scanner.nextInt();
        scanner.nextLine();
        while (num-- > 0) {
            String line = scanner.nextLine();
            List<String> lineList = Arrays.asList(line.split(" "));
            list.add(lineList);
        }
        int n = list.size();
        int[][] matrix = new int[n + 1][];
        for (int i = 0; i < n; i++) {
            List<String> lineList = list.get(i);
            int index = Integer.valueOf(lineList.get(0));
            int m = lineList.size() - 1;
            int[] array = new int[m];
            for (int j = 0; j < m; j++) {
                int value = Integer.valueOf(lineList.get(j + 1));
                array[j] = value;
            }
            matrix[index] = array;
        }

       /* for (int i = 1; i < matrix.length; i++) {
            int[] a = matrix[i];
            for (int j = 0; j < a.length; j++) {
                System.out.print(a[j] + " ");
            }
            System.out.println();
        }
        System.out.println(matrix);*/
        return matrix;
    }

    public static List<Integer> sort(int n, int[][] martrix) {

        List<Integer> resList = new ArrayList<>();
        int[] inDegree = new int[n];
        for (int i = 1; i < martrix.length; i++) {
            int[] lineArray = martrix[i];
            for (int index : lineArray) {
                inDegree[index]++;
            }
        }
        Queue<Integer> queue = new LinkedList<>();

        for (int i = 0; i < n; i++) {
            if (inDegree[i] == 0)
                queue.add(i);
        }

        while (!queue.isEmpty()) {
            int current = queue.poll();
            resList.add(current);
            for (int index : martrix[current]) {
                inDegree[index]--;
                if (inDegree[index] == 0) {
                    queue.add(index);
                }
            }
        }

        Collections.reverse(resList);
        return resList.size() == n ? resList : new ArrayList<>();
    }

}