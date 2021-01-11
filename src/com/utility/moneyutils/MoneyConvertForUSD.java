package com.utility.moneyutils;

import java.math.BigDecimal;

/**
 * @author Blaife
 * @description  金额转换类 - 金额数字转英文大写
 * @date 2021/1/5 22:05
 */
public class MoneyConvertForUSD {

    /**
     * 英文数字 [0-9]
     */
    private static final String[] EN_SMALL_NUMBER = { "ZERO", "ONE", "TWO", "THREE", "FOUR", "FIVE", "SIX", "SEVEN", "EIGHT", "NINE"};

    /**
     * 英文数字 [10-19]
     */
    private static final String[] EN_MEDIUM_NUMBER = {"TEN", "ELEVEN", "TWELVE", "THIRTEEN",  "FOURTEEN",  "FIFTEEN", "SIXTEEN",  "SEVENTEEN",  "EIGHTEEN",  "NINETEEN"};

    /**
     * 英文数字 [0-90]
     */
    private static final String[] EN_TENS_NUMBER = {"ZERO", "TEN", "TWENTY", "THIRTY", "FORTY", "FIFTY", "SIXTY", "SEVENTY", "EIGHTY", "NINETY"};

    /**
     * 英文单位 [ ，千，百万，十亿]
     */
    private static final String[] EN_SCALE_NUMBER = {"", "THOUSAND", "MILLION", "BILLION"};

    /**
     * 表示形式 - 美分
     */
    static final String EN_PRESENTATION_CENTS = "cents";

    /**
     * 表示形式 - 美点
     */
    static final String EN_PRESENTATION_POINT = "point";

    /**
     * 表示形式 - 分数
     */
    static final String EN_PRESENTATION_GRADE = "grade";

    /**
     * 金额转换方法
     * @param numberOfMoney 金额数字 BigDecimal
     * @return 英文大写
     */
    public static String moneyCover(BigDecimal numberOfMoney, String presentation) {
        StringBuilder sb = new StringBuilder();
        String number = numberOfMoney.setScale(2, BigDecimal.ROUND_HALF_UP).toString();
        String[] numberArr = number.split("\\.");
        String integerPortion = numberArr[0];
        String decimalPortion = numberArr[1];
        if (integerPortion.length() > EN_SCALE_NUMBER.length * 3) {
            return number + ":超出处理能力";
        }
        String integerStr = getAmericaInteger(integerPortion);
        sb.append("SAY US DOLLARS ").append(integerStr);
        if (!"00".equals(decimalPortion)) {
            String decimalStr = getAmericaInteger(decimalPortion);
            if (EN_PRESENTATION_CENTS.equals(presentation)) {
                sb.append("AND CENTS ").append(decimalStr);
            } else if (EN_PRESENTATION_POINT.equals(presentation)) {
                sb.append("AND POINT ").append(decimalStr);
            } else if (EN_PRESENTATION_GRADE.equals(presentation)) {
                sb.append("AND ").append(decimalStr).append(decimalPortion).append("/100 ");
            }
        }
        sb.append("ONLY");
        return sb.toString();
    }

    /**
     * 获取[整数/美分形式的小数]内容英文字符串
     * @param integerPortion 整数部分 和 美分形式的小数方式
     * @return 英文大写字符串
     */
    private static String getAmericaInteger(String integerPortion) {
        StringBuilder integerStr = new StringBuilder();
        // 字符总长度
        int length = integerPortion.length();
        // 按每3个字符为一层级分割
        int tire =  (int) Math.ceil(Double.parseDouble(String.valueOf(length)) / 3);
        // 初始位置
        int index = length - tire * 3;
        // 当前层级
        int currTire = 0;
        for (int i = index; i < length; i += 3) {
            // 层级 ++
            ++currTire;
            // 获得当前层级字符
            String currNum = i >= 0 ? integerPortion.substring(i, i + 3) : integerPortion.substring(0, index + 3);
            // 获得当前层级英文大写字符串
            String currStr = getCurrIntegerTire(currNum);
            // 当前层级不为 "", 即不为 000
            if (!"".equals(currStr)) {
                if (integerStr.length() > 0) {
                    integerStr.append(",");
                }
                // 拼接当前字符同时添加层级单位
                integerStr.append(currStr).append(" ").append(EN_SCALE_NUMBER[tire - currTire]);
            }
        }
        return integerStr.toString();
    }

    /**
     * 对数字处理的核心方法 每三个一组
     * @param currNum 当前组内容
     * @return 英文大写字符串
     */
    private static String getCurrIntegerTire(String currNum) {
        StringBuilder thisStr = new StringBuilder();
        // 当前数子为 3 位 且不为 000
        if (currNum.length() == 3 && !currNum.equals("000")) {
            // 第一位字符不为 0 进行处理
            if (!currNum.substring(0, 1).equals("0")) {
                thisStr.append(EN_SMALL_NUMBER[Integer.parseInt(currNum.substring(0, 1))]).append(" HUNDRED");
                // 后两位不为 00， 拼接 AND
                if (!currNum.substring(1, 3).equals("00")) {
                    thisStr.append(" AND ");
                }
            }
            // 处理之后，删除第一位字符
            currNum = currNum.substring(1);
        }
        // 当前数子为 2 位
        if (currNum.length() == 2) {
            if (currNum.substring(0, 1).equals("0")) {
                // 第一位为 0
                currNum = currNum.substring(1);
            } else if (currNum.substring(0, 1).equals("1")) {
                // 第一位为 1
                thisStr.append(EN_MEDIUM_NUMBER[Integer.parseInt(currNum.substring(1, 2))]);
            } else {
                // 大于 19 的数字
                thisStr.append(EN_TENS_NUMBER[Integer.parseInt(currNum.substring(0, 1))]);
                currNum = currNum.substring(1);
                if (!currNum.equals("0")) {
                    thisStr.append("-");
                }
            }
        }
        // 当前数子为 1 位 且不为 0
        if (currNum.length() == 1 && !currNum.equals("0")) {
            thisStr.append(EN_SMALL_NUMBER[Integer.parseInt(currNum)]);
        }
        return thisStr.toString();
    }


    public static void main(String[] args) {
        System.out.println(moneyCover(new BigDecimal("100.00"), EN_PRESENTATION_CENTS));
        System.out.println(moneyCover(new BigDecimal("100.00"), EN_PRESENTATION_POINT));
        System.out.println(moneyCover(new BigDecimal("100.00"), EN_PRESENTATION_GRADE));
    }

}
