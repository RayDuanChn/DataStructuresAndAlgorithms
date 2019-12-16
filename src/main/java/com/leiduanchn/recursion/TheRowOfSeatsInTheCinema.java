package com.leiduanchn.recursion;

/**
 * What is the row of seats in the cinema?
 * @author leiduanchn
 * @create 2019-12-14 11:29 p.m.
 */

/*
    周末你带着女朋友去电影院看电影，女朋友问你，咱们现在坐在第几排啊？电影院里面太黑了，看不清，没法数，现在你怎么办？
        你就问前面一排的人他是第几排，你想只要在他的数字上加一，就知道自己在哪一排了。但是，前面的人也看不清啊，所以他也问他前面的人。
        就这样一排一排往前问，直到问到第一排的人，说我在第一排，然后再这样一排一排再把数字传回来。直到你前面的人告诉你他在哪一排，于是你就知道答案了。
        这就是一个非常标准的递归求解问题的分解过程，去的过程叫“递”，回来的过程叫“归”。

        f(n)=f(n-1)+1 其中，f(1)=1
        -- f(n) 表示你想知道自己在哪一排，f(n-1) 表示前面一排所在的排数，f(1)=1 表示第一排的人知道自己在第一排。
        -- 公式解析：f(n-1) 前面的排 + 1 就是自己想知道的排f(n)
 */
public class TheRowOfSeatsInTheCinema {

    public int theRowOfSeats(int n){

        if(n == 1) return 1;
        return theRowOfSeats(n-1) + 1;
    }

    public static void main(String[] args) {

        TheRowOfSeatsInTheCinema theCinema = new TheRowOfSeatsInTheCinema();

        int row = theCinema.theRowOfSeats(6);
        System.out.println(row);
    }


}
