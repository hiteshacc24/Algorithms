package com.company;
import java.util.*;
public class CourseSchedule {
    public static List<Integer> result;
    public static boolean canFinish(int numCourses, int[][] prerequisites) {
        result = new ArrayList<>();
        int[][] matrix = new int[numCourses][numCourses]; // i -> j
        int[] indegree = new int[numCourses];

        for (int i=0; i<prerequisites.length; i++) {
            int ready = prerequisites[i][0];
            int pre = prerequisites[i][1];
            if (matrix[pre][ready] == 0)
                indegree[ready]++; //duplicate case
            matrix[pre][ready] = 1;
        }

        int count = 0;
        Queue<Integer> queue = new LinkedList();
        for (int i=0; i<indegree.length; i++) {
            if (indegree[i] == 0) queue.offer(i);
        }
        while (!queue.isEmpty()) {
            int course = queue.poll();
            result.add(course);
            count++;
            for (int i=0; i<numCourses; i++) {
                if (matrix[course][i] != 0) {
                    if (--indegree[i] == 0)
                        queue.offer(i);
                }
            }
        }
        return count == numCourses;
    }
    public static void main(String[] args) {
        boolean a = canFinish(6, new int[][]{{5, 2}, {5,0},{4,0},{4,1},{2,3},{3,1}});
        //boolean b = canFinish(2, new int[][]{{1,0}});
        System.out.println(a);
        System.out.println(result);
    }
}

