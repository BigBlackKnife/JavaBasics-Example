package com.utility.moneyutils;

import java.math.BigDecimal;

/**
 * @author Blaife
 * @description 人名币金额转换类 - 金额数字转中文大写
 * @date 2020/12/30 21:10
 */
public class MoneyConvertForCNY {

    /**
     * 汉语中数字大写
     */
    private static final String[] CN_UPPER_NUMBER = { "零", "壹", "贰", "叁", "肆", "伍", "陆", "柒", "捌", "玖" };

    /** 整数部分的单位 */
    private static final String[] CN_INTEGER_UNIT = { "元", "拾", "佰", "仟", "万", "拾", "佰", "仟", "亿", "拾", "佰", "仟", "万", "拾", "佰", "仟" };

    /** 小数部分的单位 */
    private static final String[] CN_DECIMAL_UNIT = { "角", "分", "厘", "毫"};

    /**
     * 金额的精度 [0-4]
     */
    private static final int CN_MONEY_PRECISION_ZERO = 0;
    private static final int CN_MONEY_PRECISION_ONE = 1;
    private static final int CN_MONEY_PRECISION_TWO = 2;
    private static final int CN_MONEY_PRECISION_THREE = 3;
    private static final int CN_MONEY_PRECISION_FOUR = 4;
    private static final int CN_MONEY_PRECISION_DEFAULT = 4;

    /**
     * 特殊字符：整
     */
    private static final String CN_FULL = "整";

    /**
     * 特殊字符：负
     */
    private static final String CN_NEGATIVE = "负";

    /**
     * 特殊字符：零元整
     */
    private static final String CN_ZEOR_FULL = "零元" + CN_FULL;

    public static String moneyCover(BigDecimal numberOfMoney) {
        return moneyCover(numberOfMoney, CN_MONEY_PRECISION_DEFAULT);
    }

    public static String moneyCover(BigDecimal numberOfMoney, int precision) {
        if (precision < 0 || precision > 4) {
            return "错误：精度只能选择区间[0,4]范围内的整数";
        }
        StringBuffer sb = new StringBuffer();
        // 判断其是负数、0、正数
        int signum = numberOfMoney.signum();
        // 为0的情况，输出 CN_ZEOR_FULL （零元整）
        if (signum == 0) {
            return CN_ZEOR_FULL;
        }
        // 去掉多余位数，求绝对值后转为 long 类型
        String number = numberOfMoney.setScale(precision, BigDecimal.ROUND_HALF_UP).abs().toString();
        // 对此数字字符串分割
        String[] numberArr = number.split("\\.");
        String integerPortion = numberArr[0];
        String decimalPortion = "";
        if (numberArr.length > 1) {
            decimalPortion = numberArr[1];
        }
        // overflow超出处理能力，直接返回
        if (integerPortion.length() > CN_INTEGER_UNIT.length) {
            return number + ":超出处理能力";
        }
        // 获取整数位字符串
        String integerStr = getChineseInteger(integerPortion);
        // 获取小数位字符串
        String decimalStr = getChineseDecimal(decimalPortion);
        // 结果小于0
        if ("".equals(integerStr)) {
            if (CN_UPPER_NUMBER[0].equals(String.valueOf(decimalStr.charAt(0)))) {
                return decimalStr.substring(1, decimalStr.length());
            }
        }
        // 小数位为空
        if ("".equals(decimalStr)) {
            return integerStr + CN_FULL;
        }
        // 整数与小数交接位置上零的处理
        if ("0".equals(String.valueOf(integerPortion.charAt(integerPortion.length()-1)))) {
            if (!CN_UPPER_NUMBER[0].equals(String.valueOf(decimalStr.charAt(0)))) {
                return integerStr + CN_UPPER_NUMBER[0] + decimalStr;
            }
        }
        // 一般结果
        return integerStr + decimalStr;
    }

    /**
     * 获取整数位字符串
     * @param integerPortion 整数内容字符串
     * @return 中文大写字符串
     */
    private static String getChineseInteger(String integerPortion) {
        // 整数位为0 返回空字符
        if ("0".equals(integerPortion)) {
            return "";
        }
        // 处理字符容器
        StringBuilder chineseIntegerStr = new StringBuilder("");
        // 数字长度
        int length = integerPortion.length();
        // 当前处理字符数字
        int currNum;
        for (int i = 0; i < length; i++) {
            /* 获取char并转换为int类型 */
            currNum = integerPortion.charAt(i) - 48;
            if (i == length-1) {
                /* 最后一位 */
                if (currNum > 0) {
                    /* 个位大于0 填写具体数值 */
                    chineseIntegerStr.append(CN_UPPER_NUMBER[currNum]);
                } else {
                    /* 个位为0 ，且当前最后一位为 [零]， 删除这个 [零] */
                    if (CN_UPPER_NUMBER[0].equals(String.valueOf(chineseIntegerStr.charAt(chineseIntegerStr.length()-1)))) {
                        chineseIntegerStr.deleteCharAt(chineseIntegerStr.length()-1);
                    }
                }
                /* 添加 [元] 字符 */
                chineseIntegerStr.append(CN_INTEGER_UNIT[length-1-i]);
            } else if (i == length-5 || i == length-9 || i == length-13) {
                /* 对万、亿、万亿单位做处理 */
                if (currNum > 0) {
                    /* 此位大于0 正常处理 */
                    chineseIntegerStr.append(CN_UPPER_NUMBER[currNum]);
                    chineseIntegerStr.append(CN_INTEGER_UNIT[length-1-i]);
                } else {
                    /* 此位为0 ，且当前最后一位为 [零]， 删除这个 [零] */
                    if (CN_UPPER_NUMBER[0].equals(String.valueOf(chineseIntegerStr.charAt(chineseIntegerStr.length()-1)))) {
                        chineseIntegerStr.deleteCharAt(chineseIntegerStr.length()-1);
                    }
                    /* 对于 万 单位来说，如果当前最后一位为 [亿]，就不在处理*/
                    if (i == length-5) {
                        if (!CN_INTEGER_UNIT[8].equals(String.valueOf(chineseIntegerStr.charAt(chineseIntegerStr.length()-1)))){
                            chineseIntegerStr.append(CN_INTEGER_UNIT[length-1-i]);
                        }
                    } else {
                        chineseIntegerStr.append(CN_INTEGER_UNIT[length-1-i]);
                    }
                }
            } else {
                /* 其他单位 */
                if (currNum > 0) {
                    /* 此位大于0 正常处理 */
                    chineseIntegerStr.append(CN_UPPER_NUMBER[currNum]);
                    chineseIntegerStr.append(CN_INTEGER_UNIT[length-1-i]);
                } else {
                    /* 此位位0， 如果当前最后一位为 [零]，就不在处理*/
                    if (!CN_UPPER_NUMBER[0].equals(String.valueOf(chineseIntegerStr.charAt(chineseIntegerStr.length()-1)))) {
                        chineseIntegerStr.append(CN_UPPER_NUMBER[currNum]);
                    }
                }
            }
        }
        return chineseIntegerStr.toString();
    }

    /**
     * 获取小数位字符串
     * @param decimalPortion 小数内容字符串
     * @return 中文大写字符串
     */
    private static String getChineseDecimal(String decimalPortion) {
        // 小数部分为空
        if ("".equals(decimalPortion)) {
            return "";
        }
        // 小数部分为 0
        if (Integer.parseInt(decimalPortion) == 0) {
            return "";
        }
        // 处理字符容器
        StringBuilder chineseIntegerStr = new StringBuilder("");
        // 数字长度
        int length = decimalPortion.length();
        int currNum;
        for (int i = 0; i < length; i++) {
            /* 获取char并转换为int类型 */
            currNum = decimalPortion.charAt(i) - 48;
            if (currNum == 0) {
                // 当前字符为0
                if (i == 0 || !CN_UPPER_NUMBER[0].equals(String.valueOf(chineseIntegerStr.charAt(chineseIntegerStr.length()-1)))){
                    // 如果当球不是第一位，却上一位不为0  添加 [零]
                    chineseIntegerStr.append(CN_UPPER_NUMBER[0]);
                }
            } else {
                // 但前字符不为0，正常执行
                chineseIntegerStr.append(CN_UPPER_NUMBER[currNum]);
                chineseIntegerStr.append(CN_DECIMAL_UNIT[i]);
            }
        }
        // 执行结束后，需要去除最后的 [零]
        if (CN_UPPER_NUMBER[0].equals(String.valueOf(chineseIntegerStr.charAt(chineseIntegerStr.length()-1)))) {
            chineseIntegerStr.deleteCharAt(chineseIntegerStr.length()-1);
        }
        return chineseIntegerStr.toString();
    }

    public static void main(String[] args) {
        System.out.println(moneyCover(new BigDecimal("123124141.031")));
    }
}
