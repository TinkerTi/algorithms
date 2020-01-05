package com.tinker.algorithms.find_key_in_two_dimension;

public class FindKeyInTwoDimension {

    private static boolean findKey(int[][] data, int key) {
        if (data == null) {
            return false;
        }
        int i = 0;
        int j = data[0].length - 1;
        while (i < data.length && j >= 0) {
            if (data[i][j] < key) {
                i++;
            } else if (data[i][j] > key) {
                j--;
            } else {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[][] data = {{1, 2, 8, 9}, {3, 4, 10, 23}};
        System.out.println(findKey(data, 10));
    }
}
