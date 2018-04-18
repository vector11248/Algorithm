import java.util.ArrayList;
import java.util.List;
import java.lang.annotation.ElementType;

/**
 * @program: Leetcode
 * @description: 列表内元素全排列
 * @author: Wangky
 * @create: 2018-04-18 22:44
 **/
public class Perm {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < 3 ; i++) {
            list.add(i);
        }
        perm(list,0,list.size()-1);
    }
    private static void swap(List<Integer> list,int k,int m){
        int temp ;
        temp = list.get(k);
        list.set(k,list.get(m));
        list.set(m,temp);
    }

    //[k,m]递归法求全排列
    private static void perm(List<Integer> list,int k,int m){
        if(k == m){
            for (int x:list) {
                System.out.print(x);
            }
            System.out.println();
        }else{
            for (int i=k;i<=m;i++){
                swap(list,k,i);
                perm(list,k+1,m);
                swap(list,k,i);
            }
        }
    }
}
