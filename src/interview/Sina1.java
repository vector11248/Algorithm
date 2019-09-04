package interview;

/**
 * @program: Leetcode
 * @description:
 * @author: Wangky
 * @create: 2019-08-31 16:09
 **/
public class Sina1 {
    public static void main(String[] args) {
        String[] aa = {"3","4.3.5.4","2.10.3","2.4"};
        System.out.println(getMinVersion(aa));

    }
    public static String getMinVersion(String[] list) {
        // 在这里编写代码
        if (list == null || list.length == 0){
            return null;
        }
        int minIndex = -1;
        int min = 999999999;
        for( int i=0;i<list.length;i++ ){
            int num = 0;
            String[] nums = list[i].split(".");
            for(int j=0;j<nums.length;j++){
                int a = Integer.parseInt(nums[j]);
                num = num * 10 + a;

            }
            if (num < min){
                min = num;
                minIndex = i;
            }
        }
        return list[minIndex];

    }

}
