package com.code.leet;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.*;
import java.util.stream.Collectors;

class Solution {
    //88. 合并两个有序数组
    public static void merge(int[] nums1, int m, int[] nums2, int n) {
        while (m != 0 || n != 0) {
            if (m == 0) {
                nums1[m + n - 1] = nums2[n - 1];
                n--;
            } else if (n == 0) {
                nums1[m + n - 1] = nums1[m - 1];
                m--;
            } else {
                if (nums1[m - 1] > nums2[n - 1]) {
                    nums1[m + n - 1] = nums1[m - 1];
                    m--;
                } else {
                    nums1[m + n - 1] = nums2[n - 1];
                    n--;
                }
            }

        }
    }

    //1816. 截断句子
    public static String truncateSentence(String s, int k) {
//        String[] split = s.split(" ");
//        split = Arrays.copyOf(split, k);
//        return String.join(" ", split);
//        -------------------------------------
        for (int i = 0; i < s.length(); i++) {
            if (k == 0) {
                return s.substring(0, i - 1);
            }
            if (s.charAt(i) == ' ') {
                k--;
            }
        }
        return s;

    }

    //228. 汇总区间
    public static List<String> summaryRanges(int[] nums) {
//        List<String> result = new ArrayList<>();
//        List<Integer> r = new ArrayList<>();
//        int i = 0;
//        while (i < nums.length) {
//            if (i != nums.length - 1 && nums[i] + 1 == nums[i + 1]) {
//                r.add(nums[i]);
//            } else {
//                if (r.size() == 0) {
//                    result.add(String.valueOf(nums[i]));
//                } else {
//                    r.add(nums[i]);
//                    result.add(r.get(0) + "->" + r.get(r.size() - 1));
//                }
//                r.clear();
//            }
//            i++;
//        }
//        return result;
//        --------------------------------------------
        List<String> result = new ArrayList<>();
        if (nums.length == 0) return result;
        int min = nums[0];
        int max = nums[0];
        int i = 1;
        while (i < nums.length) {
            if (max + 1 == nums[i]) {
                max = nums[i];
            } else {
                if (max == min) {
                    result.add(String.valueOf(min));
                } else {
                    result.add(min + "->" + max);
                }
                max = nums[i];
                min = nums[i];
            }
            i++;
        }
        if (max == min) {
            result.add(String.valueOf(min));
        } else {
            result.add(min + "->" + max);
        }
        return result;
//        --------------------------------------------
    }

    //242. 有效的字母异位词
    public static boolean isAnagram(String s, String t) {
//        if (s.length() != t.length()) {
//            return false;
//        }
//        char[] sArr = s.toCharArray(); //1，把sortStr转换为字符数组
//        Arrays.sort(sArr);
//        char[] tArr = t.toCharArray(); //1，把sortStr转换为字符数组
//        Arrays.sort(tArr);
//        int num = 0;
//        while (num < sArr.length) {
//            if (sArr[num] != tArr[num]) {
//                return false;
//            }
//            num++;
//        }
//        return true;
//        --------------------------------------------
//        if (s.length() != t.length()) {
//            return false;
//        }
//        Map<String, Integer> map = new HashMap<>();
//        int num = 0;
//        while (num < s.length()) {
//            if (map.containsKey(String.valueOf(s.charAt(num)))) {
//                map.put(String.valueOf(s.charAt(num)), map.get(String.valueOf(s.charAt(num))) + 1);
//            } else {
//                map.put(String.valueOf(s.charAt(num)), 1);
//            }
//            if (map.containsKey(String.valueOf(t.charAt(num)))) {
//                map.put(String.valueOf(t.charAt(num)), map.get(String.valueOf(t.charAt(num))) - 1);
//            } else {
//                map.put(String.valueOf(t.charAt(num)), -1);
//            }
//            num++;
//        }
//        for (Map.Entry<String, Integer> entry : map.entrySet()) {
//            if (entry.getValue() != 0) {
//                return false;
//            }
//        }
//        return true;
//        --------------------------------------------
//        char[] sArr = s.toCharArray(); //1，把sortStr转换为字符数组
//        Arrays.sort(sArr);
//        char[] tArr = t.toCharArray(); //1，把sortStr转换为字符数组
//        Arrays.sort(tArr);
//        return Arrays.toString(sArr).equals(Arrays.toString(tArr));
//        --------------------------------------------
//        if (s.length() != t.length()) {
//            return false;
//        }
//        char[] sArr = s.toCharArray(); //1，把sortStr转换为字符数组
//        Arrays.sort(sArr);
//        char[] tArr = t.toCharArray(); //1，把sortStr转换为字符数组
//        Arrays.sort(tArr);
//        return Arrays.equals(sArr,tArr);
//        --------------------------------------------
        if (s.length() != t.length()) {
            return false;
        }
        int[] result = new int[26];
        for (int i = 0; i < s.length(); i++) {
            result[s.charAt(i) - 97] += 1;
            result[t.charAt(i) - 97] -= 1;
        }
        for (int i : result) {
            if (i != 0) {
                return false;
            }
        }
        return true;
    }

    //509. 斐波那契数
    public static int fib(int n) {
//        if (n == 0) {
//            return 0;
//        } else if (n == 1) {
//            return 1;
//        } else {
//            return fib(n - 1) + fib(n - 2);
//        }
//        --------------------------------------------
        if (n == 0) {
            return 0;
        } else if (n == 1) {
            return 1;
        } else {
            int n1 = 0;
            int n2 = 1;
            int result = 0;
            while (n > 1) {
                result = n1 + n2;
                n1 = n2;
                n2 = result;
                n--;
            }
            return result;
        }
    }

    //1137. 第 N 个泰波那契数
    public static int tribonacci(int n) {
        if (n == 0) {
            return 0;
        } else if (n == 1 || n == 2) {
            return 1;
        } else {
            int n1 = 0;
            int n2 = 1;
            int n3 = 1;
            int result = 0;
            while (n > 1) {
                result = n1 + n2 + n3;
                n2 = n1;
                n2 = n3;
                n3 = result;
                n--;
            }
            return result;
        }
    }

    //746. 使用最小花费爬楼梯
    public static int minCostClimbingStairs(int[] cost) {
        int step1 = 0;
        int step2 = 0;
        for (int i = 2; i < cost.length + 1; i++) {
            int step3 = Math.min(step1 + cost[i - 2], step2 + cost[i - 1]);
            step1 = step2;
            step2 = step3;
        }
        return step2;
    }

    //748. 最短补全词
    public static String shortestCompletingWord(String licensePlate, String[] words) {
        licensePlate = licensePlate.toLowerCase();
        char[] chars = licensePlate.toCharArray();
//        char[] nums = new char[];
        Arrays.sort(words);
        Arrays.sort(chars);
        for (char aChar : chars) {
            if (aChar < 97 || aChar > 124) {
                continue;
            }
        }
        for (String word : words) {

        }
        return "1";
    }

    //28. 实现 strStr()
    public static int strStr(String haystack, String needle) {
        return 0;
    }

    //1518. 换酒问题
    public static int numWaterBottles(int numBottles, int numExchange) {
        int num = 0;
        while (true) {
            if (numBottles < numExchange) {
                return num + numBottles;
            }
            num += numBottles - (numBottles % numExchange);
            numBottles = (numBottles / numExchange) + (numBottles % numExchange);
        }
    }

    //997. 找到小镇的法官
    public static int findJudge(int n, int[][] trust) {
        int[] result = new int[n];
        for (int[] ints : trust) {
            result[ints[0] - 1] = 1;
        }
        for (int i = 0; i < result.length; i++) {
            if (result[i] == 0) {
                return i + 1;
            }
        }
        return -1;
    }

    //167. 两数之和 II - 输入有序数组
    public static int[] twoSum(int[] numbers, int target) {
        return null;
    }

    //面试题 01.01. 判定字符是否唯一
    public static boolean isUnique(String astr) {
        int[] res = new int[26];
        for (char aChar : astr.toCharArray()) {
            if (res[aChar - 97] == 1) {
                return false;
            }
            res[aChar - 97] = 1;
        }
        return true;
    }

    //面试题 01.02. 判定是否互为字符重排
    public static boolean CheckPermutation(String s1, String s2) {
        if (s1.length() != s2.length()) {
            return false;
        }
        int[] result = new int[26];
        char[] s1Arr = s1.toCharArray();
        char[] s2Arr = s2.toCharArray();
        for (int i = 0; i < s1Arr.length; i++) {
            result[s1Arr[i] - 97] += 1;
            result[s2Arr[i] - 97] -= 1;
        }
        for (int i : result) {
            if (i != 0) {
                return false;
            }
        }
        return true;
    }

    //面试题 01.03. URL化
    public static String replaceSpaces(String S, int length) {
        StringBuilder stringBuilder = new StringBuilder();
        char[] chars = S.toCharArray();
        for (int i = 0; i < length; i++) {
            if (chars[i] == 32) {
                stringBuilder.append("%20");
            } else {
                stringBuilder.append(chars[i]);
            }
        }
        return stringBuilder.toString();
    }

    //面试题 01.06. 字符串压缩
    public static String compressString(String S) {
        if (S.length() == 1 || S.length() == 0) {
            return S;
        }
        char[] chars = S.toCharArray();
        StringBuilder stringBuilder = new StringBuilder();
        String target = String.valueOf(chars[0]);
        int n = 0;
        int num = 0;
        while (n < S.length() - 1) {
            if (String.valueOf(chars[n]).equals(target)) {
                num++;
            } else {
                stringBuilder.append(target);
                stringBuilder.append(num);
                num = 1;
                target = String.valueOf(chars[n]);
            }
            n++;

        }
        return stringBuilder.toString().length() < S.length() ? stringBuilder.toString() : S;

    }

    //539. 最小时间差
    public static int findMinDifference(List<String> timePoints) {
        int min1 = Math.min(getTime(timePoints.get(1)), getTime(timePoints.get(0)));
        int min2 = Math.max(getTime(timePoints.get(1)), getTime(timePoints.get(0)));
        for (int i = 2; i < timePoints.size(); i++) {
            int time = getTime(timePoints.get(i));
            if (time < min1 && time < min2) {
                min1 = time;
            } else if (time < min2) {
                min2 = time;
            }
        }
        if (min1 == 0) {
            if (min2 > 12 * 60) {
                return 24 * 60 - min2;
            } else {
                return min2;
            }
        } else {
            return min2 - min1;
        }
    }

    private static Integer getTime(String timePoint) {
        String[] split = timePoint.split(":");
        return Integer.parseInt(split[0]) * 60 + Integer.parseInt(split[1]);
    }

    //14. 最长公共前缀
    public static String longestCommonPrefix(String[] strs) {
//        String prefix = "";
//        for (int i = 0; i < strs.length; i++) {
//            if (i == 0) {
//                prefix = strs[i];
//            } else {
//                StringBuilder stringBuilder = new StringBuilder();
//                char[] chars = strs[i].toCharArray();
//                char[] preChars = prefix.toCharArray();
//                int length = Math.min(chars.length, preChars.length);
//                for (int j = 0; j < length; j++) {
//                    if (chars[j] == preChars[j]) {
//                        stringBuilder.append(chars[j]);
//                    } else {
//                        break;
//                    }
//                }
//                prefix = stringBuilder.toString();
//            }
//        }
//        return prefix;
        if (strs.length == 1) {
            return strs[0];
        }
        StringBuilder res = new StringBuilder();
        StringBuilder prefix = new StringBuilder();
        for (int i = 0; i < strs[0].toCharArray().length; i++) {
            prefix.append(strs[0].toCharArray()[i]);
            for (int j = 1; j < strs.length; j++) {
                if (strs[j].length() < prefix.length() ||
                        !strs[j].substring(0, i + 1).equals(prefix.toString())) {
                    return res.toString();
                }
            }
            res.append(strs[0].toCharArray()[i]);
        }
        return res.toString();
    }

    //1380. 矩阵中的幸运数
    public static List<Integer> luckyNumbers(int[][] matrix) {
        int y = matrix.length;
        int x = matrix[0].length;
        int min;
        List<String> xMins = new ArrayList<>();
        String xMin;
        for (int i = 0; i < y; i++) {
            min = matrix[i][0];
            xMin = i + "," + 0;
            for (int j = 0; j < x; j++) {
                if (matrix[i][j] < min) {
                    min = matrix[i][j];
                    xMin = j + "," + i;
                }
            }
            xMins.add(xMin);
        }
        int max;
        List<String> yMaxs = new ArrayList<>();
        String yMax;
        for (int i = 0; i < y; i++) {
            max = matrix[0][i];
            yMax = 0 + "," + i;
            for (int j = 0; j < x; j++) {
                if (matrix[j][i] > max) {
                    max = matrix[j][i];
                    yMax = i + "," + j;
                }
            }
            yMaxs.add(yMax);
        }
        xMins.retainAll(yMaxs);
        List<Integer> res = new ArrayList<>();
        for (String s : xMins) {
            String[] split = s.split(",");
            res.add(matrix[Integer.parseInt(split[0])][Integer.parseInt(split[1])]);
        }
        return res;
    }

    //169. 多数元素
    public static int majorityElement(int[] nums) {
        return 1;

    }

    //540. 有序数组中的单一元素
    public static int singleNonDuplicate(int[] nums) {
//        int num = 0;
//        if(nums.length == 1){
//            return nums[0];
//        }
//        while (num < nums.length) {
//            if (nums[num] != nums[num + 1]) {
//                break;
//            }
//            num += 2;
//        }
//        return nums[num];

//        Set<Integer> arr = new HashSet<>();
//        int count = 0;
//        for (int num : nums) {
//            arr.add(num);
//            count += num;
//        }
//        return arr.stream().reduce(Integer::sum).orElse(0) * 2 - count;

        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            count += Math.pow(-1, i) * nums[i];
        }
        return count;
    }

    //1791. 找出星型图的中心节点
    public static int findCenter(int[][] edges) {
//        int[] arr = new int[100];
//        for (int[] edge : edges) {
//            arr[edge[0]] += 1;
//            arr[edge[1]] += 1;
//        }
//
//        for (int i = 0; i < arr.length; i++) {
//            if (arr[i] == edges.length) {
//                return i;
//            }
//        }
//        return 0;
        int res = 0;
        if (edges[0][0] == edges[1][0] || edges[0][0] == edges[1][1]) {
            res = edges[0][0];
        } else if (edges[0][1] == edges[1][0] || edges[0][1] == edges[1][1]) {
            res = edges[0][1];
        }
        if (edges.length == 2) {
            return res;
        }
        for (int i = 2; i < edges.length; i++) {
            if (edges[i][0] != res) {
                res = edges[i][1];
            }
        }
        return res;
    }

    //969. 煎饼排序
    public List<Integer> pancakeSort(int[] arr) {
//    1.检测是否排完序
//    2.获取子数组中最大的数字
//    3.子数组反转
    }
}