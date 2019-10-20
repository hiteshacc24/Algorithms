package com.company;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class BoardPractise {
    public static ArrayList<String> printPaths(char[][] board) {
        ArrayList<String> res = new ArrayList<>();
        if(board == null) return res;
        StringBuilder sb = new StringBuilder();
        helper(board, res, sb, 0, 0);
        return res;

    }
    static void helper(char[][] board, ArrayList<String> res, StringBuilder sb, int i, int j) {
        int rows = board.length;
        int cols = board[0].length;
        if(i > rows - 1 || j > cols - 1) return;
        sb.append(board[i][j]);
        if(i == rows -1 && j == cols - 1) {
            res.add(sb.toString());
            sb.deleteCharAt(sb.length() - 1);
            return;
        }
        helper(board, res, sb, i + 1, j);
        helper(board, res, sb, i , j + 1);
        sb.deleteCharAt(sb.length() - 1);

    }
    public static void main(String[] args) {
        char[][] board = {
                {'A','X','Y'},
                {'D', 'E', 'F'},
                {'R','T','V'},
        };
        ArrayList<String> result = printPaths(board);
        System.out.println(result);
    }
}
