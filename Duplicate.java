package com.company;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.TreeSet;

public class Duplicate {
    public int removeDuplicates(int[] nums) {
        if (nums == null || nums.length==0) return 0;
        int i=0;
        for(int p=1; p<nums.length; ++p){
            if(nums[p]!=nums[p-1]){
                ++i;
                nums[i]=nums[p];
            }
        }
        return i+1;
    }
    public static void main(String[] args) {
        Duplicate d = new Duplicate();
        int[] arr = {1,1,2};
        int res = d.removeDuplicates(arr);
        for(int i = 0; i < arr.length; i++)
            System.out.println(arr[i]);
    }
}
