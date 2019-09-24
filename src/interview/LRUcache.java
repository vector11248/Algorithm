package interview;

import java.util.HashMap;
import java.util.LinkedList;

/**
 * @program: Leetcode
 * @description:
 * @author: Wangky
 * @create: 2019-09-05 09:52
 **/
public class LRUcache {

    int cap;
    HashMap<Integer,Integer> cache = new HashMap<>();
    HashMap<Integer,Boolean> exist = new HashMap<>();
    LinkedList<Integer> list = new LinkedList<>();


    public LRUcache(int capacity) {
        this.cap = capacity;
    }

    public int get(int key) {
        if(exist.get(key)!=null && exist.get(key) != false){
            // 不但要取出来，还要在list里面调整到最前边
            list.remove((Integer)key);
            list.addFirst((Integer)key);
            System.out.println(cache.get(key));
            return cache.get(key);
        }else{
            System.out.println(-1);
            return -1;
        }

    }

    public void put(int key, int value) {
        int size = list.size();
        if(size == cap){
            // 假设当前已经满了
            if ( exist.get(key) == null ){
                // 里面没有这个元素
                int last = list.get(size-1);
                exist.put(last,false);
                list.removeLast();
                // 往里放新的，放在最前边
                cache.put(key,value);
                exist.put(key,true);
                list.addFirst(key);
            }else if (exist.get(key) != null && exist.get(key)  ){
                // 假设里面有这个元素了
                // 那就在cache里更新一遍，同时在list里面提到最前边
                cache.put(key,value);
                exist.put(key,true);
                list.remove((Integer) key);
                list.addFirst((Integer) key);
            }
        }else {
            if (exist.get(key) != null && exist.get(key)){
                // 如果里边有这个元素了，并且这个元素还是true
                // 往里放新的，放在最前边
                cache.put(key,value);
                exist.put(key,true);
                list.remove((Integer) key);
                list.addFirst(key);
            }else {
                // 否则直接往里怼
                cache.put(key,value);
                exist.put(key,true);
                list.addFirst(key);
            }

        }





    }

    public static void main(String[] args) {
        LRUcache  LRUcache2 = new LRUcache(10);
//        sina2.get(0);
//        LRUcache2.put(1,1);
//        LRUcache2.put(2,2);
//        LRUcache2.get(1);
//        LRUcache2.put(3,3);
//        LRUcache2.get(2);
//        LRUcache2.put(4,4);
//        LRUcache2.get(1);
//        LRUcache2.get(3);
//        LRUcache2.get(4);
        LRUcache2.put(10,13);
        LRUcache2.put(3,17);
        LRUcache2.put(6,11);
        LRUcache2.put(10,5);
        LRUcache2.put(9,10);
        LRUcache2.get(13);
        LRUcache2.put(2,19);
        LRUcache2.get(2);
        LRUcache2.get(3);
        LRUcache2.put(5,25);
        LRUcache2.get(8);
        LRUcache2.put(9,22);
        LRUcache2.put(5,5);
        LRUcache2.put(1,30);
        LRUcache2.get(11);
        LRUcache2.put(9,12);
        LRUcache2.get(7);
        LRUcache2.get(5);
        LRUcache2.get(8);
        LRUcache2.get(9);
        LRUcache2.put(4,30);
        LRUcache2.put(9,3);
        LRUcache2.get(9);
        LRUcache2.get(10);
        LRUcache2.get(10);

    }
//       ["LRUCache","put","put","put","put","put","get","put","get","get","put","get","put","put","put","get","put","get","get","get","get","put","put","get","get","get","put","put","get","put","get","put","get","get","get","put","put","put","get","put","get","get","put","put","get","put","put","put","put","get","put","put","get","put","put","get","put","put","put","put","put","get","put","put","get","put","get","get","get","put","get","get","put","put","put","put","get","put","put","put","put","get","get","get","put","put","put","get","put","put","put","get","put","put","put","get","get","get","put","put","put","put","get","put","put","put","put","put","put","put"]
//        [[10],[10,13],[3,17],[6,11],[10,5],[9,10],[13],[2,19],[2],[3],[5,25],[8],[9,22],[5,5],[1,30],[11],[9,12],[7],[5],[8],[9],[4,30],[9,3],[9],[10],[10],[6,14],[3,1],[3],[10,11],[8],[2,14],[1],[5],[4],[11,4],[12,24],[5,18],[13],[7,23],[8],[12],[3,27],[2,12],[5],[2,9],[13,4],[8,18],[1,7],[6],[9,29],[8,21],[5],[6,30],[1,12],[10],[4,15],[7,22],[11,26],[8,17],[9,29],[5],[3,4],[11,30],[12],[4,29],[3],[9],[6],[3,4],[1],[10],[3,29],[10,28],[1,20],[11,13],[3],[3,12],[3,8],[10,9],[3,26],[8],[7],[5],[13,17],[2,27],[11,15],[12],[9,19],[2,15],[3,16],[1],[12,17],[9,1],[6,19],[4],[5],[5],[8,1],[11,7],[5,2],[9,28],[1],[2,2],[7,4],[4,22],[7,24],[9,26],[13,28],[11,26]]
//    [null,null,null,null,null,null,-1,null,19,17,null,-1,null,null,null,-1,null,-1,5,-1,12,null,null,3,-1,-1,null,null,1,null,-1,null,30,5,30,null,null,null,-1,null,-1,24,null,null,-1,null,null,null,null,-1,null,null,-1,null,null,-1,null,null,null,null,null,-1,null,null,24,null,4,-1,-1,null,12,-1,null,null,null,null,29,null,null,null,null,17,22,-1,null,null,null,24,null,null,null,20,null,null,null,29,-1,-1,null,null,null,null,20,null,null,null,null,null,null,null]
//    [null,null,null,null,null,null,-1,null,19,17,null,-1,null,null,null,-1,null,-1,5,-1,12,null,null,3,5,5,null,null,1,null,-1,null,30,5,30,null,null,null,-1,null,-1,24,null,null,18,null,null,null,null,-1,null,null,18,null,null,-1,null,null,null,null,null,18,null,null,-1,null,4,29,30,null,12,-1,null,null,null,null,29,null,null,null,null,17,22,18,null,null,null,-1,null,null,null,20,null,null,null,-1,18,18,null,null,null,null,20,null,null,null,null,null,null,null]
}
