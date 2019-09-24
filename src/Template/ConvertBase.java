package Template;

/**
 * @program: Leetcode
 * @description:
 * @author: Wangky
 * @create: 2019-09-14 20:52
 *
 * 进制转换的题目
 **/
public class ConvertBase {

    public String convertToBaseN(int num, int base) {
        boolean flag = false;
        if(num < 0) {
            num *= -1;
            flag = true;
        }
        StringBuilder sb = new StringBuilder("");
        int remainder = 0;
        do {
            remainder = num % base; // 先取余数，再相除
            num /= base;
            sb.append(remainder);
        } while(num!=0);
        if (flag){
            sb.append("0");
        }
        sb.reverse();
        return sb.toString();
    }

    public static String toHex(int num) {
        StringBuilder sb = new StringBuilder();

        if(num == 0){
            return "0";
        }else {
            while(num != 0){
                int mod = num & 15 ;
                if(mod >= 10){
                    sb.append((char) (mod - 10 + 'a'));
                }else{
                    sb.append(mod);
                }
                num = num >>> 4;
            }
        }
        return sb.reverse().toString();

    }

    public static void main(String[] args) {
//        System.out.println(0%7);
        System.out.println(toHex(26));
    }
}
