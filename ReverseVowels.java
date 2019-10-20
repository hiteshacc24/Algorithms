package com.company;

public class ReverseVowels {
    public String reverseVowels(String s) {
        int i = 0;
        int j = s.length() - 1;
        char[] ch = s.toCharArray();
        while(i < j) {
            while(i < j && !isVowel(ch[i])) {
                i++;
            }
            while(i < j && !isVowel(ch[j])) {
                j--;
            }
            if(i < j) {
                char temp = ch[i];
                ch[i] = ch[j];
                ch[j] = temp;
                i++;
                j--;
            }


        }
        String result = new String(ch);
        return result;
    }
    boolean isVowel(char ch) {
        return ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u' || ch == 'A' ||       ch == 'E' || ch == 'I' || ch == 'O' || ch == 'U';
    }
    public static void main(String[] args) {
        String s = "hello";
        ReverseVowels r = new ReverseVowels();
        String out = r.reverseVowels(s);
        System.out.print(out);
    }
}
