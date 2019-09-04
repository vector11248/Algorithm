package interview;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.LinkedList;

/**
 * @program: Leetcode
 * @description:
 * @author: Wangky
 * @create: 2019-08-31 16:32
 **/
public class Sina2 {

    int cap;
    HashMap<Integer,Integer> values = new HashMap<>();
    HashMap<Integer,Boolean> exist = new HashMap<>();
    LinkedList<Integer> queue = new LinkedList<>();

    public Sina2(int capacity) {
        this.cap = capacity;
    }

    public int get(int key) {
        if (exist.get(key)){
            int temp = values.get(key);
            queue.remove((Integer) key);
            queue.addFirst((Integer) key);
            System.out.println(temp);
            return temp;
        }else {
            System.out.println(-1);
            return -1;
        }
    }


    public void put(int key, int value) {
        if (queue.size()  == cap){
            int kk = queue.get(cap-1);
            //exist.remove(kk);
            exist.put(kk,false);
            values.put(key,value);
            exist.put(key,true);
            queue.removeLast();
            queue.addFirst(key);
        }else {
            queue.addFirst(key);
            values.put(key,value);
            exist.put(key,true);
        }

    }

    public static void main(String[] args) {
        Sina2  sina2 = new Sina2(2);
        sina2.put(1,1);
        sina2.put(2,2);
        sina2.get(1);
        sina2.put(3,3);
        sina2.get(2);
        sina2.put(4,4);
        sina2.get(1);
        sina2.get(3);
        sina2.get(4);

    }
}
