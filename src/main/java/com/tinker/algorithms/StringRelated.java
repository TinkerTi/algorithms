package com.tinker.algorithms;

public class StringRelated {

    public static void main(String[] args) {
        testPermutationPrintRepeat();
    }

    private static void testPermutationPrint() {
        try {
            permutationPrint("abc".toCharArray(), 0);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void testPermutationPrintRepeat() {
        try {
            permutationPrintRepeat("ab".toCharArray(),new char[3], 0);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 给定几个字符，字符可以重复的排列
     * 注意点：如果代码中使用了throw Exception，方法签名中要 throws Exception；
     * 符合打印条件之后，需要 return；
     * @param input
     * @param data
     * @param start
     * @throws Exception
     */
    private static void permutationPrintRepeat(char[] input, char[] data, int start) throws Exception {
        if (input == null) {
            return;
        }
        if (start < 0) {
            throw new Exception();// 抛出异常时，方法签名中也要抛
        }
        if (start == input.length) {
            System.out.println(new String(data));
            return; // 返回不能少，终止递归过程，否则无法结束递归；
        }
        for (int i = 0; i < input.length; i++) {// i 从 0 开始取值，表示字符可以重复排列；
            data[start] = input[i];
            permutationPrintRepeat(input, data, start + 1);
        }
    }

    /**
     * 给定一个字符串，打印出它的全排列；
     *
     * @param input
     * @param start
     * @throws Exception
     */
    private static void permutationPrint(char[] input, int start) throws Exception {
        if (input == null) {
            return;
        }
        if (start < 0) {
            throw new Exception();
        }

        if (start == input.length - 1) {
            System.out.println(new String(input));
            return;
        }

        for (int i = start; i < input.length; i++) { // i 从第 start 个字符开始取值，表示字符不能重复；
            swap(input, start, i);
            permutationPrint(input, start + 1);
            swap(input, start, i);
        }
    }

    private static void swap(char[] data, int i, int j) {
        char tmp = data[i];
        data[i] = data[j];
        data[j] = tmp;
    }
}
