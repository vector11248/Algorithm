package MultiThread;

/**
 * @program: Leetcode
 * @description: call other thread
 * @author: Wangky
 * @create: 2018-04-23 12:56
 **/
public class MainThread {
    public static void main(String[] args) {
        Runnable thread1 = new MyTask();
        Runnable thread2 = new MyTask();
        thread1.run();
        thread2.run();

    }
}
