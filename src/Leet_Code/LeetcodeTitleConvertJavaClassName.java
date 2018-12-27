package Leet_Code;

import java.util.Scanner;

/**
 * @program: Leetcode
 * @description:
 * @author: Wangky
 * @create: 2018-12-20 20:11
 **/
public class LeetcodeTitleConvertJavaClassName {

    // just convert the leetcode title to java class to paste conveniently.

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String leetcode_title = sc.nextLine();
        String new_title =
                leetcode_title.replace(" ","_")
                        .replace(".","");
        new_title = "No_"+new_title ;
        System.out.println(new_title);
//        105. Construct Binary Tree from Preorder and Inorder Traversal
    }

}
