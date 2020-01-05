package com.tinker.algorithms.ValidParentheses;

import java.util.Stack;

public class Solutions {

    public static void main(String[] args){
        String input="()";
        System.out.println(new Solutions().isValid(input));
    }

    public boolean isValid(String s) {
        if (s == null) {
            return false;
        } else if (s.length() == 0) {
            return true;
        } else {
            Stack<Character> chStack = new Stack<>();
            for (int i = 0; i < s.length(); i++) {
                char ch = s.charAt(i);
                if (isOpen(ch)) {
                    chStack.push(ch);
                } else {
                    char temp = chStack.pop();
                    char op = getOp(ch);
                    if (op != temp) {
                        return false;
                    }
                }
            }
        }
        return true;
    }

    private boolean isOpen(char ch) {
        return ch == '(' || ch == '{' || ch == '[';
    }

    private char getOp(char ch) {
        char result = '(';
        switch (ch) {
            case ')':
                result = '(';
                break;
            case '}':
                result = '{';
                break;
            case ']':
                result = '[';
        }
        return result;
    }
}
