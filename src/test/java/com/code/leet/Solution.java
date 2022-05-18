package com.code.leet;

import com.sun.deploy.util.StringUtils;

import java.io.Serializable;
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
    public static List<Integer> pancakeSort(int[] arr) {
//    1.检测是否排完序
//    2.获取子数组中最大的数字的位置
//    3.子数组反转
//        3.1 将最大值反转到第一位
//        3.2 将最大值反转到所在长度的最后一位
//    4.长度减少一位
        List<Integer> resultList = new ArrayList<>();
        int length = arr.length;
        while (!checkSort(arr)) {
            //最大值位置
            int index = maxNumber(arr, length);
            resultList.add(index);
            //最大值放置第一位
            arr = arrReversal(arr, index);
            resultList.add(length);
            //最大值放置最后一位
            arr = arrReversal(arr, length);
            length -= 1;
        }
        return resultList;
    }

    //检测是否排完序
    private static boolean checkSort(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            if (arr[i - 1] > arr[i]) {
                return false;
            }
        }
        return true;
    }

    //获取子数组中最大的数字的位置
    private static int maxNumber(int[] arr, int length) {
        int max = 0;
        int index = 0;
        for (int i = 0; i < length; i++) {
            if (max < arr[i]) {
                max = arr[i];
                index = i;
            }
        }
        return index + 1;
    }

    //子数组反转
    private static int[] arrReversal(int[] arr, int index) {
        int n = 0;
        int[] res = new int[arr.length];
        for (int i = index - 1; i >= 0; i--) {
            res[n] = arr[i];
            n++;
        }
        for (int i = index; i < arr.length; i++) {
            res[n] = arr[i];
            n++;
        }
        return res;
    }

    //717. 1 比特与 2 比特字符
    public static boolean isOneBitCharacter(int[] bits) {
        if (bits.length == 1) {
            return true;
        }
        int num = 0;
        while (num < bits.length) {
            if (bits[num] == 0) {
                num += 1;
            }
            if (bits[num] == 1) {
                num += 2;
            }
            if (num == bits.length - 1) {
                return true;
            }
        }
        return false;
    }

    //剑指 Offer 64. 求1+2+…+n
    public static int sumNums(int n) {
        return n + sumNums(n - 1);
    }

    //面试题 10.02. 变位词组
    public static List<List<String>> groupAnagrams(String[] strs) {
//        Map<String, List<String>> temp = new HashMap<>();
//        List<List<String>> res = new ArrayList<>();
//        for (String str : strs) {
//            List<String> strings = new ArrayList<>();
//            char[] chars = str.toCharArray();
//            Arrays.sort(chars);
//            String string = Arrays.toString(chars);
//            if (temp.containsKey(string)) {
//                strings = temp.get(string);
//            }
//            strings.add(str);
//            temp.put(string, strings);
//        }
//        temp.keySet().forEach(e -> res.add(temp.get(e)));
//        return res;

        Map<String, List<String>> map = new HashMap<>();
        for (String str : strs) {
            char[] array = str.toCharArray();
            Arrays.sort(array);
            String key = new String(array);
            List<String> list = map.getOrDefault(key, new ArrayList<>());
            list.add(str);
            map.put(key, list);
        }
        return new ArrayList<>(map.values());

//        List<List<String>> res = new ArrayList<>();
//        List<String> tempStr = new ArrayList<>();
//        for (String str : strs) {
//            char[] chars = str.toCharArray();
//            Arrays.sort(chars);
//            String string = Arrays.toString(chars);
//            if (tempStr.contains(string)) {
//                res.get(tempStr.indexOf(string)).add(str);
//            } else {
//                res.add(new ArrayList<String>() {{
//                    add(str);
//                }});
//                tempStr.add(string);
//            }
//        }
//        return res;
    }

    //917. 仅仅反转字母
    public static String reverseOnlyLetters(String s) {
//        int num = s.length();
//        char[] resArr = new char[s.length()];
//        char[] chars = s.toCharArray();
//        for (int i = 0; i < chars.length; i++) {
//            if ((chars[i] > 64 && chars[i] < 91) || (chars[i] > 96 && chars[i] < 123)) {
//                while (true) {
//                    num--;
//                    if ((chars[num] > 64 && chars[num] < 91) || (chars[num] > 96 && chars[num] < 123)) {
//                        resArr[i] = chars[num];
//                        break;
//                    }
//                }
//            } else {
//                resArr[i] = chars[i];
//            }
//        }
//        return new String(resArr);

        char[] chars = s.toCharArray();
        int num = s.length();
        char temp;
        for (int i = 0; i < chars.length; i++) {
            if (i >= num) {
                break;
            }
            if ((chars[i] > 64 && chars[i] < 91) || (chars[i] > 96 && chars[i] < 123)) {
                while (true) {
                    num--;
                    if ((chars[num] > 64 && chars[num] < 91) || (chars[num] > 96 && chars[num] < 123)) {
                        temp = chars[i];
                        chars[i] = chars[num];
                        chars[num] = temp;
                        break;
                    }
                }
            }
        }
        return new String(chars);

        //双指针试试
    }

    //537. 复数乘法
    public static String complexNumberMultiply(String num1, String num2) {
//        String[] split1 = num1.split("\\+");
//        String[] split2 = num2.split("\\+");
//        int imaginary1 = Integer.parseInt(split1[1].replace("i", ""));
//        int imaginary2 = Integer.parseInt(split2[1].replace("i", ""));
//        int real = Integer.parseInt(split1[0]) * Integer.parseInt(split2[0]);
//        int imaginary = imaginary1 * Integer.parseInt(split2[0]) + imaginary2 * Integer.parseInt(split1[0]);
//        int imagNum = imaginary1 * imaginary2;
//        return (real - imagNum) + "+" + imaginary + "i";

        String[] split1 = num1.split("\\+");
        String[] split2 = num2.split("\\+");
        int imaginary = Integer.parseInt(split1[1].replace("i", "")) * Integer.parseInt(split2[0]) +
                Integer.parseInt(split2[1].replace("i", "")) * Integer.parseInt(split1[0]);
        int imagNum = Integer.parseInt(split1[1].replace("i", "")) * Integer.parseInt(split2[1].replace("i", ""));
        return (Integer.parseInt(split1[0]) * Integer.parseInt(split2[0]) - imagNum) + "+" + imaginary + "i";
    }

    //1282. 用户分组
    public static List<List<Integer>> groupThePeople(int[] groupSizes) {
//        Map<Integer, List<Integer>> map = new HashMap<>();
//        List<List<Integer>> res = new ArrayList<>();
//        for (int i = 0; i < groupSizes.length; i++) {
//            List<Integer> orDefault = map.getOrDefault(groupSizes[i], new ArrayList<>());
//            orDefault.add(i);
//            if (orDefault.size() == groupSizes[i]) {
//                res.add(orDefault);
//                map.remove(groupSizes[i]);
//            } else {
//                map.put(groupSizes[i], orDefault);
//            }
//        }
//        return res;


        //哈希计数
        Map<Integer, List<Integer>> map = new HashMap<>();
        List<List<Integer>> res = new ArrayList<>();
        for (int i = 0; i < groupSizes.length; i++) {
            List<Integer> orDefault = map.getOrDefault(groupSizes[i], new ArrayList<>());
            orDefault.add(i);
            map.put(groupSizes[i], orDefault);
        }
        map.forEach((key, value) -> {
            int i = value.size() / key;
            if (i == 1) {
                res.add(value);
            } else {
                for (int j = 0; j < i; j++) {
                    res.add(value.subList(j * key, (j + 1) * key));
                }
            }
        });
        return res;
    }

    //807. 保持城市天际线
    public static int maxIncreaseKeepingSkyline(int[][] grid) {
//        int[] heightMaxArr = new int[grid.length];
//        int[] weightMaxArr = new int[grid[0].length];
//        for (int i = 0; i < grid.length; i++) {
//            int heightMax = 0;
//            int weightMax = 0;
//            for (int j = 0; j < grid.length; j++) {
//                if (heightMax < grid[i][j]) {
//                    heightMax = grid[i][j];
//                }
//                if (weightMax < grid[j][i]) {
//                    weightMax = grid[j][i];
//                }
//            }
//            heightMaxArr[i] = heightMax;
//            weightMaxArr[i] = weightMax;
//        }
//        int count = 0;
//        for (int i = 0; i < grid.length; i++) {
//            for (int j = 0; j < grid.length; j++) {
//                int min = Math.min(heightMaxArr[i], weightMaxArr[j]);
//                count += min-grid[i][j];
//            }
//        }
//        return count;

        int count = 0;
        int[] heightMaxArr = new int[grid.length];
        int[] weightMaxArr = new int[grid.length];
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid.length; j++) {
                heightMaxArr[i] = Math.max(heightMaxArr[i], grid[i][j]);
                weightMaxArr[i] = Math.max(weightMaxArr[i], grid[j][i]);

            }
        }
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid.length; j++) {
                int min = Math.min(heightMaxArr[i], weightMaxArr[j]);
                count += min - grid[i][j];
            }
        }
        return count;
    }

    //22. 括号生成
    public static List<String> generateParenthesis(int n) {
        return null;
    }

    //2016. 增量元素之间的最大差值
    public static int maximumDifference(int[] nums) {
        int max = 0;
        boolean flag = true;
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] < nums[j] && max < (nums[j] - nums[i])) {
                    max = (nums[j] - nums[i]);
                    flag = false;
                }
            }
        }
        return flag ? -1 : max;

        //找到最小值，然后向后减，获得最大值，一次循环
//        int max = -1;
//        int min = nums[0];
//        boolean flag = true;
//        for (int num : nums) {
//            if(min > num){
//                min =  num;
//                flag =false;
//            }
//            max = Math.max(max, num - min);
//        }
//        return flag ? -1 : max;
    }

    //6. Z 字形变换
    public static String convert(String s, int numRows) {
        int l = numRows * 2 - 2;
        char[] arr = s.toCharArray();
        String[] resArr = new String[numRows];
        int n = 0;
        if (s.length() == 1 || numRows == 1) {
            return s;
        }
        while (n != s.length()) {
            int k = n % l;
            if (k < numRows) {
                if (resArr[k] == null) {
                    resArr[k] = String.valueOf(arr[n]);
                } else {
                    resArr[k] += arr[n];
                }
            } else {
                int i1 = 2 * numRows - k - 2;
                resArr[i1] += arr[n];
            }
            n++;
        }
        StringBuilder res = new StringBuilder();
        for (String s1 : resArr) {
            if (s1 != null) {
                res.append(s1);
            }
        }
        return res.toString();

        //偶数列正序遍历numRow次，奇数列倒叙numRow-2次，从1开始到numRow-3;
    }

    //2161. 根据给定数字划分数组
    public static int[] pivotArray(int[] nums, int pivot) {
//        Map<Integer, List<Integer>> temp = new HashMap<>();
//        for (int i = 0; i < nums.length; i++) {
//            int n = 0;
//            if (nums[i] == pivot) {
//                n = 1;
//            } else if (nums[i] > pivot) {
//                n = 2;
//            }
//            List<Integer> orDefault = temp.getOrDefault(n, new ArrayList<>());
//            orDefault.add(i);
//            temp.put(n, orDefault);
//        }
//        int[] res = new int[nums.length];
//        int n = 0;
//        for (int i = 0; i < 3; i++) {
//            List<Integer> list = temp.getOrDefault(i, new ArrayList<>());
//            for (Integer integer : list) {
//                res[n] = nums[integer];
//                n++;
//            }
//        }
//        return res;

        //三次遍历
//        int n = nums.length, k = 0;
//        int[] ans = new int[n];
//        for (int num : nums) if (num < pivot) ans[k++] = num;
//        for (int num : nums) if (num == pivot) ans[k++] = num;
//        for (int num : nums) if (num > pivot) ans[k++] = num;
//        return ans;

        //三次遍历-迭代删除
//        int n = nums.length;
//        final int[] k = {0};
//        int[] ans = new int[n];
//        Arrays.stream(nums).filter(e -> e < pivot).forEach(e -> {
//            ans[k[0]] = e;
//            k[0] += 1;
//        });
//        Arrays.stream(nums).filter(e -> e == pivot).forEach(e -> {
//            ans[k[0]] = e;
//            k[0] += 1;
//        });
//        Arrays.stream(nums).filter(e -> e > pivot).forEach(e -> {
//            ans[k[0]] = e;
//            k[0] += 1;
//        });
//        return ans;

//        int min = 0;
//        int x = 0;
//        int max = nums.length - 1;
//        int y = nums.length - 1;
//        int[] res = new int[nums.length];
//        Arrays.fill(res, pivot);
//        while (min <= nums.length - 1 && max >= 0) {
//            if (nums[min] < pivot) {
//                res[x] = nums[min];
//                x++;
//            }
//            if (nums[max] > pivot) {
//                res[y] = nums[max];
//                y--;
//            }
//            min++;
//            max--;
//        }
//        return res;

        int x = 0;
        int y = nums.length - 1;
        int[] res = new int[nums.length];
        Arrays.fill(res, pivot);
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] < pivot) {
                res[x] = nums[i];
                x++;
            }
            if (nums[nums.length - i - 1] > pivot) {
                res[y] = nums[nums.length - i - 1];
                y--;
            }
        }
        return res;
    }

    //824. 山羊拉丁文
    public static String toGoatLatin(String sentence) {
        String[] splits = sentence.split(" ");
        StringBuilder res = new StringBuilder();
        for (int i = 0; i < splits.length; i++) {
            String s = splits[i].substring(0, 1).toLowerCase();
            if (s.equals("a") || s.equals("e") || s.equals("i") || s.equals("o") || s.equals("u")) {
                res.append(splits[i]);
            } else {
                res.append(splits[i].substring(1)).append(splits[i].charAt(0));
            }
            res.append("ma");
            for (int j = 0; j < i + 1; j++) {
                res.append("a");
            }
            if (i != splits.length - 1) {
                res.append(" ");
            }
        }
        return res.toString();
    }

    //剑指 Offer 63. 股票的最大利润
    public static int maxProfit(int[] prices) {
//        int max = 0;
//        for (int i = 0; i < prices.length; i++) {
//            for (int j = i + 1; j < prices.length; j++) {
//                if (prices[i] < prices[j]) {
//                    max = Math.max((prices[j] - prices[i]), max);
//                }
//            }
//        }
//        return max;
        if (prices.length == 0) {
            return 0;
        }
        int min = prices[0];
        int max = 0;
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] < min) {
                min = prices[i];
            } else {
                max = Math.max(prices[i] - min, max);
            }
        }
        return max;
    }

    //2125. 银行中的激光束数量
    public static int numberOfBeams(String[] bank) {
        int count = 0;
        int last = 0;
        for (String s : bank) {
            int n = 0;
            for (char c : s.toCharArray()) {
                if (c == '1') n++;
            }
            if (n != 0) {
                count += last * n;
                last = n;
            }
        }
        return count;
    }

    //258. 各位相加
    public static int addDigits(int num) {
        if (num < 10) {
            return num;
        }
        String s = String.valueOf(num);
        int count = 0;
        for (int i = 0; i < s.length(); i++) {
            count += s.charAt(i) - 48;
        }
        return addDigits(count);
    }

    //504. 七进制数
    public static String convertToBase7(int num) {
        StringBuilder stringBuilder = new StringBuilder();
        boolean flag = false;
        if (num < 0) {
            num = Math.abs(num);
            flag = true;
        }
        if (num < 7) {
            return flag ? "-" + num : String.valueOf(num);
        }
        while (true) {
            int i = num % 7;
            stringBuilder.append(i);
            int j = num / 7;
            if (j < 7) {
                stringBuilder.append(j);
                break;
            }
            num = j;
        }
        if (flag) {
            stringBuilder.append("-");
        }
        return stringBuilder.reverse().toString();
    }

    //205. 同构字符串
    public static boolean isIsomorphic(String s, String t) {
//        //1.长度是否相同
//        if (s.length() != t.length()) {
//            return false;
//        }
//        //2.转数字
//        char[] sChars = s.toCharArray();
//        char[] tChars = t.toCharArray();
//        Map<String, Integer> sMap = new HashMap<>();
//        Map<String, Integer> tMap = new HashMap<>();
//        int sNum = 1;
//        int tNum = 1;
//        StringBuilder sRes = new StringBuilder();
//        StringBuilder tRes = new StringBuilder();
//        for (int i = 0; i < s.length(); i++) {
//            if (sMap.containsKey(String.valueOf(sChars[i]))) {
//                sRes.append(sMap.get(String.valueOf(sChars[i])));
//            } else {
//                sMap.put(String.valueOf(sChars[i]), sNum);
//                sRes.append(sNum);
//                sNum++;
//            }
//            if (tMap.containsKey(String.valueOf(tChars[i]))) {
//                tRes.append(tMap.get(String.valueOf(tChars[i])));
//            } else {
//                tMap.put(String.valueOf(tChars[i]), tNum);
//                tRes.append(tNum);
//                tNum++;
//            }
//        }
//        System.out.println("sRes:" + sRes);
//        System.out.println("tRes:" + tRes);
//        //3.数字是否相同
//        return sRes.toString().equals(tRes.toString());

        if (s.length() != t.length()) {
            return false;
        }
        return isomorphic(s).equals(isomorphic(t));
    }

    private static String isomorphic(String str) {
        //2.转数字
        char[] sChars = str.toCharArray();
        Map<Character, Integer> map = new HashMap<>();
        int sNum = 0;
        StringBuilder count = new StringBuilder();
        for (int i = 0; i < str.length(); i++) {
            if (map.containsKey(sChars[i])) {
                count.append(map.get(sChars[i]));
            } else {
                map.put(sChars[i], sNum);
                count.append(sNum);
                sNum++;
            }
        }
        //3.数字是否相同
        return count.toString();
    }

    //169. 多数元素
    //面试题 17.10. 主要元素
    public static int majorityElement(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            Integer integer = map.getOrDefault(num, 0);
            if (integer >= nums.length / 2) {
                return num;
            }
            map.put(num, integer + 1);
        }
        return 0;
    }
}