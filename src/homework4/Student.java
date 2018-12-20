package homework4;


import java.util.Comparator;

public class Student implements Comparable {
    String id;
    double gpa;

    public Student(String id, double gpa) {
        this.id = id;
        this.gpa = gpa;
    }

    @Override
    public int compareTo(Object o) {
        Student stu = (Student)o;
        if(this.gpa > stu.gpa){
            return 1;
        }else if(this.gpa < stu.gpa){
            return -1;
        }else {
            return 0;
        }
    }
}
