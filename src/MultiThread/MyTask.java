package MultiThread;

/**
 * @program: Leetcode
 * @description: This is a class implement runnable interface
 * @author: Wangky
 * @create: 2018-04-23 12:57
 **/
public class MyTask implements Runnable {

    @Override
    public void run() {
        for (int i = 0; i <1000 ; i++) {
            System.out.println(i);
        }
    }

}
