package hihocoder;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @program: Leetcode
 * @description:
 * @author: Wangky
 * @create: 2019-03-09 14:47
 **/
public class Constraint_Checker {

    public static int[] data = new int[26];
    public static int countLetter(List<String> constraints){
        boolean[] hasLetter = new boolean[26];
        for (int i = 0;i<constraints.size();i++){
            for(int j= 0;j<constraints.get(i).length();j++){
                if(constraints.get(i).charAt(j) >= 'A' && constraints.get(i).charAt(j)<='Z'){
                    hasLetter[constraints.get(i).charAt(j) - 'A'] = true;
                }
            }
        }
        int cnt = 0;
        for(int i=0;i<26;i++){
            if(hasLetter[i]){
                cnt++;
            }
        }
        return cnt;
    }

    public static int getValue(String s){
        if(s.charAt(0) == '='){
            s = s.substring(1);
        }
        if(s.length() > 1){
            return Integer.parseInt(s);
        }
        int id = s.charAt(0) - 'A';
        if(id>=0){
            return data[id];
        }else {
            return s.charAt(0) - '0';
        }
    }
    public static boolean checkString(String s){
        String[] splited_array = s.split("<");
        for(int i=0;i<splited_array.length-1;i++){
            boolean equal = false;
            if(splited_array[i+1].charAt(0) == '=' ){
                equal = true;
            }
            int v1 = getValue(splited_array[i]);
            int v2 = getValue(splited_array[i+1]);
            if(v1 > v2){
                return false;
            }
            if((v1 == v2) && !equal){
                return false;
            }

        }
        return true;
    }

    public static boolean check(List<String> constraints){
        for(String s:constraints){
            if (!checkString(s)){
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N;
        N = sc.nextInt();
        List<String> constrains = new ArrayList<>();
        int k = 0;
        while (N-- != 0){
            constrains.add(sc.next());
        }
        int K = countLetter(constrains);
        int T;
        T = sc.nextInt();
        while (T-- != 0){
            for(int i:data){
                i=0;
            }
            for(int i=0;i<K;i++){
                char valueName;
                int value;
                valueName = sc.next().charAt(0);
                value = Integer.parseInt(sc.next());
                data[valueName - 'A'] = value;
            }
            if(check(constrains)){
                System.out.println("Yes");
            }else {
                System.out.println("No");
            }
        }
        return;
    }

    
}
