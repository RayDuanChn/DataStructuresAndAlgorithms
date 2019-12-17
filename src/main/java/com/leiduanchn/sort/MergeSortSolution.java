package com.leiduanchn.sort;

import java.util.Arrays;

/**
 * 归并排序
 * 归并排序的核心思想是，如果要排序一个数组，我们先把数组从中间分成前后两部分，然后对前后两部分分别排序，
 * 再将排好序的两部分合并在一起，这样整个数组就都有序了。
 *
 * 递推公式：merge_sort(p…r) = merge(merge_sort(p…q), merge_sort(q+1…r))
 * 终止条件：p >= r 不用再继续分解
 *
 * 最好情况、最坏情况，还是平均情况，时间复杂度都是 O(nlogn)。
 * 归并排序是一个稳定的排序算法
 * 归并排序不是原地排序算法， 空间复杂度是 O(n)。
 *
 * @author leiduanchn
 * @create 2019-12-17 2:20 p.m.
 */
public class MergeSortSolution {

    public static void main(String[] args) {
        int[] a = {4, 5, 6, 3, 2, 1, 10, 0, 34, 7, 2, 23};
        MergeSortSolution solution = new MergeSortSolution();
        solution.mergeSort(a, a.length);
        System.out.println(Arrays.toString(a));
    }

    // 归并排序算法, A是数组，n表示数组大小
    public void mergeSort(int[] a, int n) {
        if (a == null || n <= 1) return;

        // 递归调用函数
        sort(a, 0, n - 1);
    }

    private void sort(int[] a, int p, int r) {
        // 递归终止条件
        if (p >= r) return;

        // 取p到r之间的中间位置q
        int q = (r + p) >> 1;
        // 分治递归
        sort(a, p, q);
        sort(a, q + 1, r);

        // 将A[p...q]和A[q+1...r]合并为A[p...r]
        merge(a, p, q, r);
    }

    private void merge(int[] a, int p, int q, int r) {
        int i = p, j = q + 1, k = 0;        // 初始化变量i, j, k
        int[] tmp = new int[r - p + 1];     // 申请一个大小跟A[p...r]一样的临时数组

        while (i <= q && j <= r) {
            if (a[i] <= a[j]) {
                tmp[k++] = a[i++];          // i++等于i:=i+1
            } else {
                tmp[k++] = a[j++];
            }
        }

        // 判断哪个子数组中有剩余的数据
        int star = i, end = q;
        if (j <= r) {
            star = j;
            end = r;
        }

        // 将剩余的数据拷贝到临时数组tmp
        while (star <= end) {
            tmp[k++] = a[star++];
        }

        // 将tmp中的数组拷贝回A[p...r]
        if (r - p + 1 >= 0)
            System.arraycopy(tmp, 0, a, p, r - p + 1);

    }
}
