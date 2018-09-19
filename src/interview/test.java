package interview;

import java.util.ArrayList;
import java.util.List;

/**
 * @program: Leetcode
 * @description:
 * @author: Wangky
 * @create: 2018-09-08 16:04
 **/
public class test {
    private int i;
    private int incre(){
        try{
            return ++i;
        }catch (Exception e){
            i=5;
            return i++;
        }finally {
            i=10;
        }
    }

//    public static void test1(){
//        List list = new ArrayList<>();
//        list.add(1L);
//        list.add(2L);
//        list.add(3L);
//        for (Long aLong :list){
//            if (aLong ==1L){
//                list.remove(aLong);
//            }
//        }
//        System.out.println(list);
//    }

    public static void main(String[] args) {
        test t= new test();
        System.out.println(t.incre());
//        test1();
    }
}
