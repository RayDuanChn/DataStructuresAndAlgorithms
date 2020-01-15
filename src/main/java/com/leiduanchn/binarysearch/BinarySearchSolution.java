package com.leiduanchn.binarysearch;

/**
 * 二分查找（Binary Search）算法
 * 1. 二分查找针对的是一个有序的数据集合，查找思想有点类似分治思想。每次都通过跟区间的中间元素对比，将待查找的区间缩小为之前的一半，
 *      直到找到要查找的元素，或者区间被缩小为 0。
 *
 * 2. O(logn) 对数时间复杂度， 惊人的查找速度
 *
 * 3.二分查找应用场景的局限性：
 *  首先，二分查找依赖的是顺序表结构，简单点说就是数组。
 *      数组按照下标随机访问数据的时间复杂度是 O(1)，而链表随机访问的时间复杂度是 O(n)。所以，如果数据使用链表存储，二分查找的时间复杂就会变得很高。
 *  其次，二分查找针对的是有序数据。
 *      二分查找的数据必须是有序的。如果数据没有序，我们需要先排序。所以，二分查找只能用在插入、删除操作不频繁，一次排序多次查找的场景中。针对动态变化的数据集合，二分查找将不再适用。
 *  再次，数据量太小不适合二分查找。
 *      如果要处理的数据量很小，完全没有必要用二分查找，顺序遍历就足够了。
 *      不过，这里有一个例外。如果数据之间的比较操作非常耗时，我们需要尽可能地减少比较次数，不管数据量大小，我都推荐使用二分查找。
 *  最后，数据量太大也不适合二分查找。.
 *      二分查找的底层需要依赖数组这种数据结构，而数组为了支持随机访问的特性，要求内存空间连续，对内存的要求比较苛刻。所以太大的数据用数组存储就比较吃力了，也就不能用二分查找了。
 *
 * @author leiduanchn
 * @create 2020-01-13 12:35 p.m.
 *
 */
public class BinarySearchSolution {

    public static void main(String[] args) {
        int[] a = {1, 2, 4, 5, 6, 8, 10, 13, 18, 23, 26, 34};

        BinarySearchSolution solution = new BinarySearchSolution();
        int i = solution.binarySearch(a, 12, 10);
        int i1 = solution.recursionBinarySearch(a, 12, 10);

        int[] a1 = {1, 2, 4, 5, 6, 8, 8, 8, 18, 23, 26, 34};
        int i2 = solution.bSearchFindFirstValue(a1, 12, 8);
        int i3 = solution.bSearchFindLastValue(a1, 12, 8);
        int i4 = solution.bSearchFindFistGreaterOrEqualToValue(a1, 12, 8);
        int i5 = solution.bSearchFindLastLessOrEqualToValue(a1, 12, 18);
        System.out.println(i);
        System.out.println(i1);
        System.out.println(i2);
        System.out.println(i3);
        System.out.println(i4);
        System.out.println(i5);
    }

    public int binarySearch(int[] a, int n, int value) {

        int low = 0;
        int high = n - 1;

        while (low <= high) {
            int mid = low + ((high - low) >> 1);       //mid 表示 [low, high] 的中间位置, 防止两者之和的可能会溢出

            if (a[mid] == value) {
                return mid;
            } else if (a[mid] < value) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        return -1;
    }


    //递归实现
    public int recursionBinarySearch(int[] a, int n, int val) {
        return bSearchInternally(a, 0, n - 1, val);
    }

    private int bSearchInternally(int[] a, int low, int high, int value) {
        if (low > high) return -1;
        int mid = low + ((high - low) >> 1);

        if (a[mid] == value) {
            return mid;
        } else if (a[mid] < value) {
            return bSearchInternally(a, mid + 1, high, value);
        } else {
            return bSearchInternally(a, low, mid - 1, value);
        }

    }

    //变体一：查找第一个值等于给定值的元素
    public int bSearchFindFirstValue(int[] a, int n, int value) {
        int low = 0;
        int high = n - 1;

        while (low <= high) {
            int mid = low + ((high - low) >> 1);

            if (a[mid] > value) {
                high = mid - 1;
            } else if (a[mid] < value) {
                low = mid + 1;
            } else {
                if (mid == 0 || a[mid - 1] != value) {
                    return mid;
                } else {
                    //如果经过检查之后发现 a[mid] 前面的一个元素 a[mid-1] 也等于 value，那说明此时的 a[mid] 肯定不是我们要查找的第一个值等于给定值的元素。
                    //那我们就更新 high=mid-1，因为要找的元素肯定出现在 [low, mid-1] 之间。
                    high = mid - 1;
                }
            }
        }

        return -1;
    }


    //变体二：查找最后一个值等于给定值的元素
    public int bSearchFindLastValue(int[] a, int n, int value) {
        int low = 0;
        int high = n - 1;

        while (low <= high) {
            int mid = low + ((high - low) >> 1);
            if (a[mid] > value) {
                high = mid - 1;
            } else if (a[mid] < value) {
                low = mid + 1;
            } else {
                if (mid == n - 1 || a[mid + 1] != value) {
                    return mid;
                } else {
                    //要找的元素肯定出现在 [mid+1, high] 之间
                    low = mid + 1;

                }
            }
        }

        return -1;
    }


    //变体三：查找第一个大于等于给定值的元素
    private int bSearchFindFistGreaterOrEqualToValue(int[] a, int n, int value) {
        int low = 0;
        int high = n - 1;

        while (low <= high) {
            int mid = low + ((high - low) >> 1);

            if (a[mid] >= value) {
                //如果 a[mid] 前面已经没有元素，或者前面一个元素小于要查找的值 value，那 a[mid] 就是我们要找的元素
                if (mid == 0 || a[mid - 1] < value) {
                    return mid;
                } else {
                    //如果 a[mid-1] 也大于等于要查找的值 value，那说明要查找的元素在 [low, mid-1] 之间，所以，我们将 high 更新为 mid-1。
                    high = mid - 1;
                }
            } else {
                //a[mid] 小于要查找的值 value，那要查找的值肯定在 [mid+1, high] 之间，所以，我们更新 low=mid+1。
                low = mid + 1;
            }
        }
        return -1;
    }

    public int bSearchFindLastLessOrEqualToValue(int[] a, int n, int value) {
        int low = 0;
        int high = n - 1;

        while (low <= high) {
            int mid = low + ((high - low) >> 1);

            if (a[mid] > value) {
                //如果 a[mid] 大于要查找的值 value，那说明要查找的元素在 [low, mid-1] 之间，所以，我们将 high 更新为 mid-1。
                high = mid - 1;
            } else {
                //如果 a[mid] 是最后一个元素，或者后面一个元素大于要查找的值 value，那 a[mid] 就是我们要找的元素
                if (mid == n - 1 || a[mid + 1] > value) {
                    return mid;
                } else {
                    //如果 a[mid+1] 也小于要查找的值 value，那说明要查找的元素在 [low, mid+1] 之间，所以，我们将 low 更新为 mid + 1;
                    low = mid + 1;
                }
            }
        }
        return -1;
    }

}
