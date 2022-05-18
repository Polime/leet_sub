package com.code.leet;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

/**
 * @author Hao
 * @date 2022/3/11 15:50
 */
public class Divination {
    /**
     * 随机获取硬币正反面
     *
     * @return true-正面，false-反面
     */
    private static boolean getRandomCoin() {
        Random random = new Random();
        return random.nextInt(2) == 0;
    }

    /**
     * 获取三枚硬币的投掷结果
     * 正面为3，反面为2
     *
     * @return 三枚硬币投掷的结果
     */
    private static int getThrowing() {
        int result = 0;
        for (int i = 0; i < 3; i++) {
            result += getRandomCoin() ? 3 : 2;
        }
        return result;
    }

    /**
     * 从投掷的结果判断是阴还是阳
     *
     * @return 结果，true为阳，false为阴
     */
    private static boolean explainResult() {
        int throwing = getThrowing();
        return throwing == 9 || throwing == 7;
    }

    /**
     * 获取卦象
     *
     * @return 结果
     */
    public static String getToddler() {

        StringBuilder result = new StringBuilder();
        for (int i = 0; i < 6; i++) {
            String explain = explainResult() ? "1" : "0";
            result.append(explain);
        }
        System.out.println(result);
        return toddlerMap().get(result.toString());
    }

    private static Map<String,String> toddlerMap(){
        Map<String,String> toddler = new HashMap<>();
        toddler.put("111111","乾为天");
        toddler.put("000000","坤为地");
        toddler.put("010001","水雷屯");
        toddler.put("100010","山水蒙");
        toddler.put("010111","水天需");
        toddler.put("111010","天水讼");
        toddler.put("000010","地水师");
        toddler.put("010000","水地比");
        toddler.put("110111","风天小畜");
        toddler.put("111011","天泽履");
        toddler.put("000111","地天泰");
        toddler.put("111000","天地否");
        toddler.put("111101","天火同人");
        toddler.put("101111","火天大有");
        toddler.put("000100","地山谦");
        toddler.put("001000","雷地豫");
        toddler.put("011001","泽雷随");
        toddler.put("100110","山风蛊");
        toddler.put("000011","地泽临");
        toddler.put("110000","风地观");
        toddler.put("101001","火雷噬嗑");
        toddler.put("100101","山火贲");
        toddler.put("100000","山地剥");
        toddler.put("000001","地雷复");
        toddler.put("111001","天雷无妄");
        toddler.put("100111","山天大畜");
        toddler.put("100001","山雷颐");
        toddler.put("011110","泽风大过");
        toddler.put("010010","坎为水");
        toddler.put("101101","离为火");
        toddler.put("011100","泽山咸");
        toddler.put("001110","风雷恒");
        toddler.put("111100","天地遁");
        toddler.put("001111","雷天大壮");
        toddler.put("101000","火地晋");
        toddler.put("000101","地火明夷");
        toddler.put("110101","风火家人");
        toddler.put("101011","火泽睽");
        toddler.put("010100","水山鎺");
        toddler.put("001010","雷水解");
        toddler.put("100011","山泽损");
        toddler.put("110001","风雷益");
        toddler.put("011111","择天区");
        toddler.put("111110","天风后");
        toddler.put("011000","泽地萃");
        toddler.put("000110","地风升");
        toddler.put("011010","泽水困");
        toddler.put("010110","水风井");
        toddler.put("011101","泽火革");
        toddler.put("101110","火风鼎");
        toddler.put("001001","震为雷");
        toddler.put("100100","艮为山");
        toddler.put("110100","风山渐");
        toddler.put("001011","雷泽归妹");
        toddler.put("001101","雷火丰");
        toddler.put("101100","火山旅");
        return toddler;
    }

    public static Map<Integer, Integer> getProbability() {
        Map<Integer,Integer> result = new HashMap<>();
        int count = 0;
        int num = 0;
        int time = 0;
        while (num < 10001) {
            count += getRandomCoin() ? 1 : 0;
            if(num == 4){
                result.put(num,(int) ((float) count/num*100));
            }
            num++;
        }
        System.out.println(result);
        return result;
    }
}
