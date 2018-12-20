package Leet_Code;

import java.io.*;
import java.util.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;



public class Solution {

    public static class StudentPriorityQueue{

        public StudentPriorityQueue() {

        }

        private int size = 0;
        Object[] queue;
        public boolean insert(String id,double gpa){

            int i = size;
            size = i + 1;
            if (i == 0)
                queue[0] = new Object();
//            else
//                siftUp(i, e);
            return true;
        }



    }



    public static Object createPriorityQueue() {

        return new StudentPriorityQueue();
    }
    public static void addStudent(Object priority_queue, String id, double gpa) {
        // Your code goes here
//        priority_queue

    }
    public static String invite(Object priority_queue) {
        // Your code goes here
        return null;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
//        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));
        String fileName = "/Users/wky/Documents/output.txt";
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(fileName));
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