package Leet_Code;

import java.util.Arrays;

/**
 * @program: Leetcode
 * @description:
 * @author: Wangky
 * @create: 2018-12-29 15:02
 **/
public class No_475_Heaters {

    public static int findRadius(int[] houses, int[] heaters) {
        Arrays.sort(houses);
        Arrays.sort(heaters);
        int n = houses.length;
        int radio = 0;
        for (int i=0 ;i<n;i++){
            int lo = 0;
            int hi = heaters.length-1;
            if (houses[i] <= heaters[0]){
                radio = Math.max(radio,Math.abs(heaters[0]-houses[i]));
            }else if (houses[i] >= heaters[hi]){
                radio = Math.max(radio,Math.abs(heaters[hi]-houses[i]));
            }else {
                while (lo<=hi){
                    int mid = lo + (hi-lo)/2;
                    if ( heaters[mid] > houses[i] ){
                        hi = mid-1;
                    }else if (heaters[mid] < houses[i]){
                        lo = mid+1;
                    }else {
                        lo = mid;
                        hi = mid;
                        break;
                    }
                }

                int min = Math.min(Math.abs(heaters[lo]-houses[i]),Math.abs(heaters[hi]-houses[i]));
                radio = Math.max(radio,min);
            }
        }
        return radio;
    }

    public static void main(String[] args) {
        int[] houses={1,2,3,4};
        int[] heaters={1,4};
        System.out.println(findRadius(houses,heaters));
    }

}
