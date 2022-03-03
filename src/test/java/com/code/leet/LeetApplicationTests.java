package com.code.leet;

import org.junit.jupiter.api.Test;

import javax.xml.transform.Source;
import java.util.Arrays;
import java.util.List;

class LeetApplicationTests {
    @Test
    void contextLoads() {
        addDigits();
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
        int numWaterBottles = Solution.numWaterBottles(9, 3);
        System.out.println(numWaterBottles);
    }

    void isUnique() {
        System.out.println(Solution.isUnique("leetcode"));
    }

    void luckyNumbers() {
        int[][] matrix = {{3, 7, 8}, {9, 11, 13}, {15, 16, 17}};
        Solution.luckyNumbers(matrix);
    }

    void findCenter() {
        int[][] matrix = {{1, 2}, {2, 3}, {4, 2}};
        Solution.findCenter(matrix);
    }

    void longestCommonPrefix() {
        String[] strs = {"flower", "floweqr", "flish", "flo"};
        String s = Solution.longestCommonPrefix(strs);
        System.out.println(s);
    }

    void pancakeSort() {
        int[] arr = {3, 2, 4, 1};
        List<Integer> list = Solution.pancakeSort(arr);
        System.out.println(list);
    }

    void isOneBitCharacter() {
        int[] arr = {1, 1, 0};
        System.out.println(Solution.isOneBitCharacter(arr));
    }

    void sumNums() {
        System.out.println(Solution.sumNums(9));
    }

    void groupAnagrams() {
        String[] strs = new String[]{"eat", "tea", "tan", "ate", "nat", "bat"};
        System.out.println(Solution.groupAnagrams(strs));
    }

    void majorityElement() {
        int[] arr = new int[]{1, 2, 5, 9, 5, 9, 5, 5, 5};
        System.out.println(Solution.majorityElement(arr));
    }

    void reverseOnlyLetters() {
        String s = "az-cd";
        String s1 = "a-bC-dEf-ghIj";
        String s2 = "-a-bC-dfhj";
        String s3 = "azAZ-bC-";
        String s4 = "7_28]";
        System.out.println(Solution.reverseOnlyLetters(s2));
    }

    void complexNumberMultiply() {
        String num1 = "78+-76i";
        String num2 = "-86+72i";
        System.out.println(Solution.complexNumberMultiply(num1, num2));
    }

    void groupThePeople() {
        int[] group = new int[]{2, 2, 1, 1, 1, 1, 1, 1};
        System.out.println(Solution.groupThePeople(group));
    }

    void maxIncreaseKeepingSkyline() {
        int[][] num = new int[][]{{3, 0, 8, 4}, {2, 4, 5, 7}, {9, 2, 6, 3}, {0, 3, 1, 0}};
        System.out.println(Solution.maxIncreaseKeepingSkyline(num));
    }

    void maximumDifference() {
        int[] arr = new int[]{7, 1, 5, 4};
        int[] arr1 = new int[]{9, 4, 3, 2};
        System.out.println(Solution.maximumDifference(arr1));
    }

    //    修改cache
//    public static void main(String[] args) throws NoSuchFieldException, IllegalAccessException {
//
//        Class cache = Integer.class.getDeclaredClasses()[0]; //1
//        Field myCache = cache.getDeclaredField("cache"); //2
//        myCache.setAccessible(true);//3
//
//        Integer[] newCache = (Integer[]) myCache.get(cache); //4
//        newCache[132] = newCache[133]; //5
//
//        int a = 2;
//        int b = a + a;
//        System.out.printf("%d + %d = %d", a, a, b); //
//    }

    void convert() {
        String s = "PAYPALISHIRING";
        int i = 3;
        String s1 = "PAYPALISHIRING";
        int i1 = 4;
        String s2 = "A";
        int i2 = 1;
        String s3 = "AW";
        int i3 = 3;
        System.out.println(Solution.convert(s, i));
    }

    void pivotArray() {
        int[] nums = new int[]{9, 12, 5, 10, 14, 3, 10};
        int pivot = 10;
        System.out.println(Arrays.toString(Solution.pivotArray(nums, pivot)));
    }

    void toGoatLatin() {
        String s = "I am iron man";
        System.out.println(Solution.toGoatLatin(s));
    }

    void maxProfit() {
        int[] num = new int[]{7, 1, 5, 3, 6,};
        int[] num1 = new int[]{7, 6, 4, 3, 1};
        System.out.println(Solution.maxProfit(num1));
    }

    void numberOfBeams() {
        String[] s = new String[]{"011001", "000000", "010100", "001000"};
        System.out.println(Solution.numberOfBeams(s));
    }

    void addDigits() {
        int num = 1239;
        System.out.println(Solution.addDigits(num));
    }
}
