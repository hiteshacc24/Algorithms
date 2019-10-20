package com.company;
import java.util.ArrayList;

public class Board {
    public static ArrayList<String> printPaths(char[][] board){
        ArrayList<String> out = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        search(0,0, board, sb, out);
        return out;

    }

    public static void search(int i, int j, char[][] board, StringBuilder sb, ArrayList out) {
        int rows = board.length;
        int cols = board[0].length;
        if(i > rows -1 || j > cols - 1 ) return;
        sb.append(board[i][j]);
        if(i == rows-1 && j == cols - 1) {
            out.add(sb.toString());
            sb.deleteCharAt(sb.length() -1);
            return;
        }
        search(i+1,j,board,sb,out);
        search(i,j+1,board,sb,out);
        sb.deleteCharAt(sb.length()-1);
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
