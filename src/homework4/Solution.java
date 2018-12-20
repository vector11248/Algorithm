package homework4;

import java.io.*;
import java.util.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;



public class Solution {

    public static class StudentPriorityQueue{

        public StudentPriorityQueue() {

        }

        private static int size = 0;
        Student[] queue = new Student[100];
        public boolean insert(String id,double gpa){

            int i = size;
            size = i + 1;
            if (i == 0)
                queue[0] = new Student(id,gpa);
            else
                shift_up(i, new Student(id,gpa));
            return true;
        }

        private void shift_up(int k, Student student) {

            while (k > 0) {
                int parent = (k - 1) >>> 1;
                Student par = queue[parent];
                if (student.compareTo(par) < 0)
                    break;
                queue[k] = par;
                k = parent;
            }
            queue[k] = student;
        }

        private void shift_Down(int k, Student student) {
            int l = 2 * k + 1;
            int r = 2 * k + 2;
            int largest;
            if (l < size && student.compareTo(queue[l]) < 0) { //the root less than its left children node
                largest = l;
            } else largest = k;
            if (r < size && student.compareTo(queue[r]) < 0) {
                largest = r;
            }
            if (largest != k) {
                Student temp = queue[k];
                queue[k] = queue[largest];
                queue[largest] = temp;
                shift_Down(largest, queue[largest]);
            }
        }

            public Student extract_first () {
                Student result = (Student) queue[0];
                // Element is null if deque empty
                if (result == null)
                    return null;
                //queue[h] = null;     // Must null out slot
                //h = (h + 1) & (queue.length - 1);
                queue[0] = queue[size - 1];
                queue[size - 1] = null;
                size--;
                shift_Down(0, queue[0]);
                return result;
            }

        }



    public static Object createPriorityQueue() {

        return new StudentPriorityQueue();
    }
    public static void addStudent(Object priority_queue, String id, double gpa) {
        // Your code goes here
        StudentPriorityQueue studentPriorityQueue = (StudentPriorityQueue) priority_queue;
        studentPriorityQueue.insert(id,gpa);
    }
    public static String invite(Object priority_queue) {
        // Your code goes here
//        return null;
        StudentPriorityQueue studentPriorityQueue = (StudentPriorityQueue) priority_queue;
        Student s = studentPriorityQueue.extract_first();
        if(s != null){
            return s.id;
        }
        return "";
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
//        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));
        String fileName = "/Users/wky/Documents/output.txt";
        File file = new File(fileName);
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(file));
        int n = Integer.parseInt(bufferedReader.readLine().trim());
        List<String> inputs = IntStream.range(0, n).mapToObj(i -> {
            try {
                return bufferedReader.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return null;
        }).filter(x -> x != null).map(Object::toString).collect(toList());
        Object priority_queue = createPriorityQueue();
        int invites = 0;
        for (String line : inputs) {
            String[] parts = line.split(" ");
            if (parts[0].equals("ADD_STUDENT")) {
                addStudent(priority_queue, parts[1],
                        Double.parseDouble(parts[2]));
            } else {
                invite(priority_queue);
                invites += 1; }
        }
        bufferedWriter.write(IntStream.range(0, n - 2 * invites).mapToObj(i ->
                invite(priority_queue))
                .map(Object::toString).collect(joining("\n")) + "\n");
        bufferedReader.close();
        bufferedWriter.close(); }

}

/*
9
ADD_STUDENT turing 3.8
ADD_STUDENT neumann 3.5
INVITE
ADD_STUDENT church 3.7
INVITE
ADD_STUDENT knuth 3.2
ADD_STUDENT cook 3.6
INVITE
ADD_STUDENT levin 3.3
*/