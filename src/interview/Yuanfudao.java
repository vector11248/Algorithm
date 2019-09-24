package interview;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;

/**
 * @program: Leetcode
 * @description:
 * @author: Wangky
 * @create: 2019-09-16 17:27
 **/
public class Yuanfudao {
    public static void main(String[] args) {
        int N,M;
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt(); // 出勤记录
        M = sc.nextInt(); // M个班级
        yuanbanji[] banjis = new yuanbanji[M];
        HashSet<Integer> teachersIds = new HashSet<>();

        HashMap<Integer,String> stu_class = new HashMap<>(); // stu --class
        HashMap<Integer,Integer> stu_teacher = new HashMap<>(); // stu --class

        for(int i=0;i<M;i++){
            banjis[i].k = sc.nextInt();
            banjis[i].teacher_id = sc.nextInt();
            teachersIds.add(banjis[i].teacher_id );
            banjis[i].className = sc.next();
            for(int j=0;j<banjis[i].k;j++){
                int a = sc.nextInt();
                banjis[i].stu_id.add(a);
                stu_class.put(a,banjis[i].className);
                stu_teacher.put(a,banjis[i].teacher_id);
            }
        }

        record[] records = new record[N];

        HashMap<Integer,Integer> user_time = new HashMap<>(); // id--time
        HashMap<Integer,Integer> teacher_time = new HashMap<>(); // id--time
        HashMap<Integer,Integer> teacher_temp_time = new HashMap<>(); // id--time




        for(int k=0;k<N;k++){
            records[k].cmd = sc.next();
            records[k].user_id = sc.nextInt();
            records[k].time = sc.nextInt();
            // 如果是老师，就给统计一下
            if (teachersIds.contains(records[k].user_id)){
                // 如果是老师
                if (records[k].cmd == "IN" && teacher_time.get(records[k].user_id)==null){
                    teacher_time.put(records[k].user_id,records[k].time);
                    teacher_temp_time.put(records[k].user_id,0);
                }else if (records[k].cmd == "IN" && teacher_time.get(records[k].user_id)!=null){
//                    teacher_time.put(records[k].user_id,records[k].time)
                   teacher_temp_time.put(records[k].user_id,teacher_time.get(records[k].user_id));
                    teacher_time.put(records[k].user_id,records[k].time);

                }else if (records[k].cmd == "OUT"){
                    // 出来
                    teacher_temp_time.put(records[k].user_id,
                            teacher_temp_time.get(records[k].user_id)+records[k].time-
                    teacher_time.get(records[k].user_id));
                }
            }else {
                // 如果是学生







            }
        }



        double[] chuqinlv = new double[M];
        int[] teachers_time = new int[M];










    }

    private class yuanbanji{
        int k;// 人数
        int teacher_id ;
        String className;
        HashSet<Integer> stu_id = new HashSet<>();
    }

    private class record{
        String cmd;
        int user_id;
        int time;
    }


}
