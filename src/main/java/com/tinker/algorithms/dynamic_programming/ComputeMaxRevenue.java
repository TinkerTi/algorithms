package com.tinker.algorithms.dynamic_programming;

public class ComputeMaxRevenue {


    public static void main(String[] args) {
        int[] price = {0, 1, 5, 8, 9, 10, 17, 17, 20, 24, 30};
        int[] temp = new int[price.length];
        System.out.println(getMaxRevenue(price, 4));

        System.out.println(getMaxRevenue(price, 3, temp));
    }

    private static int getMaxRevenue(int[] price, int size) {
        if (size == 0) {
            return 0;
        }
        int current = -1;
        for (int i = 1; i <= size; i++) {
            current = Math.max(current, price[i] + getMaxRevenue(price, size - i));
        }
        return current;
    }

    private static int getMaxRevenue(int[] price, int size, int[] temp) {
        if (size == 0) {
            return 0;
        }
        if(temp[size]>0){
            return temp[size];
        }
        int current = -1;
        for (int i = 1; i <= size; i++) {
            current = Math.max(current, price[i] + getMaxRevenue(price, size - i, temp));
        }
        temp[size] = current;
        return current;
    }
}
