package com.leiduanchn.sort;

import java.util.Random;

/**
 * [LeetCode]215 Kth Largest Element in an Array(数组第k大的数)
 *
 * Find the kth largest element in an unsorted array. Note that it is the kth largest element in the sorted order,
 * not the kth distinct element.
 *
 * For example,
 * Given [3,2,1,5,6,4] and k = 2, return 5.
 *
 * @author leiduanchn
 * @create 2019-12-18 2:27 p.m.
 */
public class LeetCode215KthLargestElementInAnArray {

    //借助 partition 操作定位到最终排定以后索引为 k-1 的那个元素
    //注意：本题必须随机初始化 pivot 元素，否则通过时间会很慢，因为测试用例中有极端测试用例。
    private static Random random = new Random(System.currentTimeMillis());

    public static void main(String[] args) {
        int[] a = {4, 5, 6, 3, 2, 1, 10, 0, 34, 7, 2, 23};
        LeetCode215KthLargestElementInAnArray solution = new LeetCode215KthLargestElementInAnArray();
        int i = solution.solution(a, a.length, 2);
        System.out.println(i);
    }

    public int solution(int[] a, int n, int k) {
        int p = 0, r = n-1;
       int target = k-1;

       while (true){
           int q = partition(a, p, r);
           if (q == target) return a[q];

           if(q > target){
               r = q-1;
           }else{
               p = q+1;
           }
       }
    }

    // 在区间 [p, r] 这个区间执行 partition 操作
    private int partition(int[] a, int p, int r) {
        // 在区间随机选择一个元素作为标定点
        if (r > p) {
            int randomIndex = p + 1 + random.nextInt(r - p);
            swap(a, p, randomIndex);
        }

        int i = p;
        int pivot = a[r];

        for (int j = p; j < r; j++) {
            // 大于 pivot 的元素都被交换到前面
            if (a[j] > pivot) {
                swap(a, i, j);
                i++;
            }
        }

        swap(a, i, r);
        return i;
    }

    private void swap(int[] a, int i, int j) {
        if (i == j) return;

        int tmp = a[i];
        a[i] = a[j];
        a[j] = tmp;
    }
}
