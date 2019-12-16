package com.leiduanchn.sort;

import java.util.Arrays;

/**
 * 冒泡排序
 * 冒泡排序只会操作相邻的两个数据。每次冒泡操作都会对相邻的两个元素进行比较，看是否满足大小关系要求。
 * 如果不满足就让它俩互换。一次冒泡会让至少一个元素移动到它应该在的位置，重复 n 次，就完成了 n 个数据的排序工作。
 *
 * @author leiduanchn
 * @create 2019-12-16 12:26 p.m.
 */
public class BubbleSortSolution {

    public static void main(String[] args) {
        int[] a = {4, 5, 6, 3, 2, 1, 10, 0, 34, 7, 2, 23};
        BubbleSortSolution solution = new BubbleSortSolution();
        solution.bubbleSort(a, a.length);
        System.out.println(Arrays.toString(a));
    }

    // 冒泡排序，a表示数组，n表示数组大小
    public void bubbleSort(int[] a, int n) {
        if (a == null || n <= 1) return;

        for (int i = 0; i < n; i++) {
            // 提前退出冒泡循环的标志位
            boolean flag = false;
            for (int j = 0; j < n - 1 - i; j++) {
                if (a[j] > a[j + 1]) {      // 交换
                    swap(a, j, j + 1);
                    flag = true;            // 表示有数据交换
                }
            }

            if (!flag) break;               // 没有数据交换，提前退出
        }
    }

    private void swap(int[] a, int i, int j) {
        if (i != j) {               //不相等才交换
            int tmp = a[i];
            a[i] = a[j];
            a[j] = tmp;
        }
    }
}
