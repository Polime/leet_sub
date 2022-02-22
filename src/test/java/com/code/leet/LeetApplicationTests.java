package com.code.leet;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class LeetApplicationTests {
    @Test
    void contextLoads() {
        pancakeSort();
    }

    void summaryRanges() {
        int[] nums = new int[]{0, 1, 2, 4, 5, 6};
        List<String> strings = Solution.summaryRanges(nums);
        System.out.println(strings);
    }

    void truncateSentence() {
        String s = "eET YZfz Y VHpNQunwl HQU F gD LOqW snNPzZA Ts av Wbbm h p Sbv BnOSq";
        int k = 2;
        String s1 = Solution.truncateSentence(s, k);
        System.out.println(s1);
    }

    void merge() {
        int[] num1 = new int[]{0};
        int m = 0;
        int[] num2 = new int[]{1};
        int n = 1;
        Solution.merge(num1, m, num2, n);
        System.out.println(Arrays.toString(num1));
    }

    void minCostClimbingStairs() {
//        int[] n = new int[]{1, 100, 1, 1, 1, 100, 1, 1, 100, 1};
//        int[] n = new int[]{10,15,20};
        int[] n = new int[]{0, 2, 2, 1};
        int i = Solution.minCostClimbingStairs(n);
        System.out.println(i);
    }

    void shortestCompletingWord() {
        String[] words = new String[]{"sadf", "sdf", "asdfqwe"};
        String l = "asdf1234 qw12ez";
        Solution.shortestCompletingWord(l, words);
    }

    void numWaterBottles() {
        int numWaterBottles = Solution.numWaterBottles(9,3);
        System.out.println(numWaterBottles);
    }

    void isUnique(){
        System.out.println(Solution.isUnique("leetcode"));
    }

    void luckyNumbers(){
        int[][] matrix = {{3, 7, 8}, {9, 11, 13}, {15, 16, 17}};
        Solution.luckyNumbers(matrix);
    }

    void findCenter(){
        int[][] matrix = {{1,2}, {2,3}, {4,2}};
        Solution.findCenter(matrix);
    }

    void longestCommonPrefix(){
        String[] strs = {"flower","floweqr","flish","flo"};
        String s = Solution.longestCommonPrefix(strs);
        System.out.println(s);
    }

    void pancakeSort(){
        int[] arr = {3,2,4,1};
        List<Integer> list = Solution.pancakeSort(arr);
        System.out.println(list);
    }

    void isOneBitCharacter(){
        int[] arr = {1,1,0};
        System.out.println(Solution.isOneBitCharacter(arr));
    }
}
