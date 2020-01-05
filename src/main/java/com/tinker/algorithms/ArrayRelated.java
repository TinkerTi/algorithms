package com.tinker.algorithms;

public class ArrayRelated {

    public static void main(String[] args) {
//        int[] data = {2, 1, 4, 3, 7, 6, 9};
//        data = reconstruct(data);
        testPrintCircle();
    }

    private static void testPrintCircle() {
        int[][] data = {{1, 2, 3}, {8, 9, 4}, {7, 6, 5}};
        printCircle(data);
    }

    /**
     * 顺时针打印二位数组；
     * @param data
     */
    private static void printCircle(int[][] data) {
        if (data == null) {
            return;
        }
        int circle = Math.min(data.length, data[0].length);
        circle = (circle & 1) == 1 ? (circle >> 1) + 1 : circle >> 1;
        int count = 0;
        int row = data.length;
        int col = data[0].length;
        //TODO 待完成，此打印结果不正确；
        while (circle > 0) {
            for (int i = count; i < col - count * 2; i++) {
                System.out.print(data[count][i]);
            }
            for (int i = count+1; i < row - count * 2-1; i++) {
                System.out.print(data[i][col - count-1]);
            }
            for (int i = col - count * 2 +1; i >= count ; i--) {
                System.out.print(data[row - count-1][i]);
            }
            for (int i = count+1; i < row - count * 2-1; i++) {
                System.out.print(data[i][count]);
            }
            System.out.println("");
            count++;
            circle--;
        }
    }

    /**
     * 给定数组，使得最终奇数全部在偶数的左边
     * @param data
     * @return
     */
    // 双指针，头尾开始，左边指针左边的是奇数，右边指针右边的是偶数，
    // 左右指针当前的数奇偶不确定；
    private static int[] reconstruct(int[] data) {
        if (data == null || data.length <= 1) {
            return data;
        }
        int left = 0;
        int right = data.length - 1;
        while (left < right) {
            if ((data[left] & 1) == 1) {
                left++;
            } else {
                if ((data[right] & 1) == 1) {
                    swap(data, left, right);
                    right--;
                } else {
                    right--;
                }
            }
        }
        return data;
    }

    private static void swap(int[] data, int i, int j) {
        int tmp = data[i];
        data[i] = data[j];
        data[j] = tmp;
    }
}
