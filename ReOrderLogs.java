package com.company;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;

public class ReOrderLogs {
    public static String[] reorderLogFiles(String[] logs) {
        Arrays.sort(logs, (log1, log2) -> {
            String[] split1 = log1.split(" ", 2);
            String[] split2 = log2.split(" ", 2);
            boolean isDigit1 = Character.isDigit(split1[1].charAt(0));
            boolean isDigit2 = Character.isDigit(split2[1].charAt(0));
            if(!isDigit1 && !isDigit2) {
                int comp = split1[1].compareTo(split2[1]);
                if(comp != 0) return comp;
                return split1[0].compareTo(split2[0]);
            }
            return isDigit1 ? (isDigit2 ? 0 : 1  ) : -1;
        });
        return logs;
    }
    public static int connectSticks(int[] sticks) {
        Queue<Integer> queue = new PriorityQueue<>();
        for (int i : sticks) {
            queue.add(i);
        }
        int ans = 0;
        while (queue.size() > 1) {
            int a = queue.poll();
            int b = queue.poll();
            ans += a + b;
            queue.add(a + b);
        }
        return ans;
    }
    public static void main(String[] args) {
//        String[] input = {"dig1 8 1 5 1","let1 art can","dig2 3 6","let2 own kit dig","let3 art zero"};
//        String[] output = reorderLogFiles(input);
//        for(String s: output) {
//            System.out.print(s + " ");
//        }
        int[] arr = {2,4,3};
        System.out.print(connectSticks(arr));
    }
}
