package com.tinker.algorithms;

public class CommonDivisor {

    public static void main(String[] args) {
//        System.out.println(commonDivisor(4,5));
                System.out.println("4200000462201911098570410466".length());

    }

    private static int commonDivisor(int p, int q) {
        if (q == 0)
            return p;
        int r = p % q;
        return commonDivisor(q, r);
    }
}
