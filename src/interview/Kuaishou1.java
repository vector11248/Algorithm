package interview;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @program: Leetcode
 * @description:
 * @author: Wangky
 * @create: 2019-09-16 21:28
 **/
public class Kuaishou1 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String s = in.nextLine();
        helper(s);
    }

    public static void helper(String s) {
        String RegexIpv4 = "^(((\\d{1,2})|(1\\d{2})|(2[0-4]\\d)|(25[0-5]))\\.){3}((\\d{1,2})|(1\\d{2})|(2[0-4]\\d)|(25[0-5]))$";
        String RegexIpv6 = "^([\\da-fA-F]{1,4}:){7}[\\da-fA-F]{1,4}$";
        Pattern PatternOfIpv4 = Pattern.compile(RegexIpv4);
        Pattern PatternOfIpv6 = Pattern.compile(RegexIpv6);
        Matcher MatcherOfIpv4 = PatternOfIpv4.matcher(s);
        Matcher MatcherOfIpv6 = PatternOfIpv6.matcher(s);
        if (MatcherOfIpv4.find()) {
            System.out.println("IPv4");
        } else if (MatcherOfIpv6.find()) {
            System.out.println("IPv6");
        } else {
            System.out.println("Neither");
        }
    }
}
