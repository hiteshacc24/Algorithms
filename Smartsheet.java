/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.company;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

/**
 *
 * @author kshitiz
 */
public class Smartsheet {

    StringBuilder buffer1 = new StringBuilder();
    StringBuilder buffer2 = new StringBuilder();
    HashMap<String, Integer> wordIndexTracker = new HashMap<>();
    HashMap<String, Integer> subsequentWordTracker = new HashMap<>();
    Set<String> set = new HashSet<>();

    public String codeMinimizer(String s) {

        String[] arr = s.split("[^a-zA-Z]+");
        boolean flag = false;
       

        for (int i = 0; i < arr.length; i++) {
           // System.out.println(arr[i]);
             if (arr[0].equals("")) {

                if (wordIndexTracker.containsKey(arr[i])) {
                    continue;
                }
                wordIndexTracker.put(arr[i], i - 1);

            } else {
                if (wordIndexTracker.containsKey(arr[i])) {
                    continue;
                }
                wordIndexTracker.put(arr[i], i);

            }
        }

        //System.out.println(wordIndexTracker);

        for (int i = 0; i < s.length(); i++) {
            if (!Character.isLetter(s.charAt(i))) {
                if (!subsequentWordTracker.isEmpty() && subsequentWordTracker.containsKey(buffer2.toString()) && subsequentWordTracker.get(buffer2.toString()) == 2) {
                    buffer1.append("$" + wordIndexTracker.get(buffer2.toString()));
                    buffer1.append(s.charAt(i));
                    buffer2.setLength(0);
                    continue;
                }
                if (buffer2.length() > 0) {
                    subsequentWordTracker.put(buffer2.toString(), 1);

                    
                        buffer1.append(buffer2);
                        subsequentWordTracker.put(buffer2.toString(), 2);
                        buffer2.setLength(0);
                        buffer1.append(s.charAt(i));
                        continue;
                    
                }

                buffer2.setLength(0);
                buffer1.append(s.charAt(i));
            } else if (Character.isLetter(s.charAt(i))) {

                buffer2.append(s.charAt(i));
            }

        }

        return buffer1.toString();
    }

    public static void main(String args[]) {

        String input = "you say yes, I say no you say stop and I say go go go​";

        Smartsheet smartsheet = new Smartsheet();
        String result = smartsheet.codeMinimizer(input);

        System.out.println(result);
    }
}
