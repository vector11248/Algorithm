package interview;

/**
 * @program: Leetcode
 * @description:
 * @author: Wangky
 * @create: 2018-09-08 16:26
 **/

class Fruit{}
class Apple extends Fruit{}
class Jona extends Apple{}
class Orange extends Fruit{}

public class Main {
    public static void main(String[] args) {
        Fruit[] fruits = new Apple[10];
        fruits[0] = new Apple();
        fruits[1] = new Jona();
        try{
            fruits[0] = new Fruit();
            System.out.println("add fruit in index 0");
        }catch (Exception e){
            System.out.println("cannot ");
        }
        try{
            fruits[0] = new Orange();
            System.out.println("add org");
        }catch (Exception e){
            System.out.println("cnnot ");
        }

    }
}
