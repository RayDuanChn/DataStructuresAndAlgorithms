package com.leiduanchn.sort;

import java.util.Arrays;

/**
 * 选择排序算法的实现思路有点类似插入排序，也分已排序区间和未排序区间。
 * 但是选择排序每次会从未排序区间中找到最小的元素，将其放到已排序区间的末尾。
 *
 * @author leiduanchn
 * @create 2019-12-16 3:44 p.m.
 */

public class SelectionSortSolution {

    public static void main(String[] args) {
        int[] a = {4, 5, 6, 3, 2, 1, 10, 0, 34, 7, 2, 23};
        SelectionSortSolution solution = new SelectionSortSolution();
        solution.selectionSort(a, a.length);
        System.out.println(Arrays.toString(a));
    }

    public void selectionSort(int[] a, int n) {
        if (a == null || n <= 1) return;

        for (int i = 0; i < n; i++) {
            int min = i;                // 最小值的index

            for (int j = i + 1; j < n; j++) {
                if (a[j] < a[min]) {
                    min = j;
                }
            }

            swap(a, i, min);            //交换
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
