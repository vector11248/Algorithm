package interview;

import java.util.Scanner;
import java.util.*;
import java.util.stream.IntStream;

/**
 * @program: Leetcode
 * @description:
 * @author: Wangky
 * @create: 2019-09-11 20:20
 **/
public class Xiaomi3 {
    private static int num = 0;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] a = new int[n];
        for(int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
        }
        int num1 = getMinSwaps(a, true);
        int num2 = getMinSwaps(a, false);
        System.out.println(Math.min(num1, num2));

    }

    static int getMinSwaps(int[] nums, boolean flag) {
        int[] o = Arrays.copyOf(nums, nums.length);
        if(flag)
            Arrays.sort(nums);
        else
            nums = IntStream.of(nums)
                    .boxed()
                    .sorted(Comparator.reverseOrder())
                    .mapToInt(Integer::intValue)
                    .toArray();
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++)
            map.put(nums[i], i);

        int cnt = 0;
        for (int i = 0; i < nums.length;i++)
        {
            if (i == map.get(o[i]))continue;
            swap(o, i,  map.get(o[i]));
            cnt++;
        }
        return cnt;
    }

    static void swap(int[] a, int i , int j) {
        int tmp = a[i];
        a[i] = a[j];
        a[j] = tmp;
    }




}
