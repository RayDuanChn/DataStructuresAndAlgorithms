package com.leiduanchn.sort;

import java.util.Arrays;

/**
 * 快速排序算法（Quicksort）
 *
 * 快排的思想是这样的：如果要排序数组中下标从 p 到 r 之间的一组数据，我们选择 p 到 r 之间的任意一个数据作为 pivot（分区点）。
 * 我们遍历 p 到 r 之间的数据，将小于 pivot 的放到左边，将大于 pivot 的放到右边，将 pivot 放到中间。
 * 经过这一步骤之后，数组 p 到 r 之间的数据就被分成了三个部分，前面 p 到 q-1 之间都是小于 pivot 的，中间是 pivot，后面的 q+1 到 r 之间是大于 pivot 的。
 *
 * 根据分治、递归的处理思想，我们可以用递归排序下标从 p 到 q-1 之间的数据和下标从 q+1 到 r 之间的数据，直到区间缩小为 1，就说明所有的数据都有序了。
 *
 * 递推公式：quick_sort(p…r) = quick_sort(p…q-1) + quick_sort(q+1… r)
 * 终止条件：p >= r
 *
 *
 * 快排是一种原地、不稳定的排序算法。
 * 快排的最好情况时间复杂度 O(nlogn)， 最坏情况时间复杂度O(n2)， 平均情况时间复杂度是O(nlogn)
 *
 * @author leiduanchn
 * @create 2019-12-17 3:14 p.m.
 */
public class QuickSortSolution {

    public static void main(String[] args) {
        int[] a = {4, 5, 6, 3, 2, 1, 10, 0, 34, 7, 2, 23};
        QuickSortSolution solution = new QuickSortSolution();
        solution.quickSort(a, a.length);
        System.out.println(Arrays.toString(a));
    }

    // 快速排序，A是数组，n表示数组的大小
    public void quickSort(int[] a, int n) {
        if (a == null || n <= 1) return;

        sort(a, 0, n - 1);

    }

    // 快速排序递归函数，p,r为下标
    private void sort(int[] a, int p, int r) {
        // 递归终止条件
        if (p >= r) return;

        // 获取分区点
        int q = partition(a, p, r);

        sort(a, p, q - 1);
        sort(a, q + 1, r);
    }


    /*
    通过游标 i 把 A[p…r-1] 分成两部分。A[p…i-1] 的元素都是小于 pivot 的，我们暂且叫它“已处理区间”，A[i…r-1] 是“未处理区间”。
    我们每次都从未处理的区间 A[i…r-1] 中取一个元素 A[j]，与 pivot 对比，如果小于 pivot，则将其加入到已处理区间的尾部，也就是 A[i] 的位置。
     */
    private int partition(int[] a, int p, int r) {
        int i = p, j = p;

        // 优化选择pivot，采用三数中值分割法
        int mid = p + (r - p) / 2;
        // 交换中值和最后一个值， 然后按照选最后值处理
        swap(a, mid, r);
        int pivot = a[r];

        for (; j < r; j++) {        // loop： p to r-1
            if (a[j] < pivot) {
                swap(a, i, j);      //交换
                i++;
            }
        }

        //将i位置设置为pivot， i位置就是pivot的正确位置
        swap(a, i, r);

        return i;
    }

    //交换
    private void swap(int[] a, int i, int j) {
        if (i == j) return;
        int tmp = a[i];
        a[i] = a[j];
        a[j] = tmp;
    }
}
