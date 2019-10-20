package com.company;

import java.util.*;

public class Test {
    public static String[] reorderLogFiles(String[] logs) {

//        Comparator<String> myComp = new Comparator<String>() {
//            @Override
//            public int compare(String s1, String s2) {
//                int s1si = s1.indexOf(' ');
//                int s2si = s2.indexOf(' ');
//                char s1fc = s1.charAt(s1si+1);
//                char s2fc = s2.charAt(s2si+1);
//
//                if (s1fc <= '9') {
//                    if (s2fc <= '9') return 0;
//                    else return 1;
//                }
//                if (s2fc <= '9') return -1;
//
//                int preCompute = s1.substring(s1si+1).compareTo(s2.substring(s2si+1));
//                if (preCompute == 0) return s1.substring(0,s1si).compareTo(s2.substring(0,s2si));
//                return preCompute;
//            }
//        };
//
//        Arrays.sort(logs, myComp);
//        return logs;
        Arrays.sort(logs, (log1, log2) -> {
            String[] split1 = log1.split(" ", 2);
            String[] split2 = log2.split(" ", 2);
            boolean b1 = Character.isDigit(split1[1].charAt(0));
            boolean b2 = Character.isDigit(split2[1].charAt(0));
            if(!b1 && !b2) {
                int cmp = split1[1].compareTo(split2[1]);
                if(cmp != 0) {
                    return cmp;
                }
                return split1[0].compareTo(split2[0]);
            }
            return b1 ? (b1 ? 0 : 1) : -1;
        });
        return logs;
    }
    public static void main(String[] args) {
        String[] input= {"dig1 8 1 5 1","let1 art can","dig2 3 6","let2 own kit dig","let3 art zero"};
        String[] res = reorderLogFiles(input);
        for(String s : res ) {
            System.out.print(s);
        }
    }
}
