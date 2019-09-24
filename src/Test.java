import java.util.ArrayList;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

public class Test {
    private static class Stu{
        private int total;
        private int goals;

        public Stu(int total, int goals) {
            this.total = total;
            this.goals = goals;
        }
    }



    public static void main(String[] args) {
       /* int shite;

        Stu stu1 = new Stu(3,5);
        Stu stu2 = new Stu(3,3);
        Stu stu3 = new Stu(5,3);
        List<Stu> stus = new ArrayList();
        stus.add(stu1);
        stus.add(stu2);
        stus.add(stu3);

        stus.sort(new Comparator<Stu>() {
            @Override
            public int compare(Stu o1, Stu o2) {
                if(o1.total!=o2.total){
                    return o2.total-o1.total;
                }else if(o1.goals!=o2.goals){
                    return o2.goals-o1.goals;
                }else
                    return -1;
            }
        });
        for (Stu stu : stus){
            System.out.println(stu.total +"  "+stu.goals);
        }
//        test(true);
//        private void test(boolean b){
//          shite = 0;
//        }
*/
        //List<List<Integer>> list = new ArrayList<>();
        LinkedList<Integer>[] adj = new LinkedList[5];
        LinkedList<Integer> l1 =new LinkedList<>();
        l1.add(2);
        l1.add(4);
        LinkedList<Integer> l2 =new LinkedList<>();
        l2.add(3);
        adj[0] = l1;
        adj[1] = l2;

        for(int i=0;i<2;i++){
            if (adj[i].size() != 0){
                //System.out.println(adj[i]);
                for(int j=0;j<adj[i].size();j++){
                    System.out.print(adj[i].get(j));
                }
            }
            System.out.println();
        }

    }


}
