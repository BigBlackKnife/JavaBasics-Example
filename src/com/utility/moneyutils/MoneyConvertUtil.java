package com.utility.moneyutils;

import java.math.BigDecimal;

/**
 * @author Blaife
 * @description 金额转换工具
 *      阿拉伯数字转中文大写，转英文大写
 * @date 2021/1/5 21:58
 */
public class MoneyConvertUtil {
    /**
     * 金额转换中文大写 精确到元
     * @param bd 金额
     * @return
     */
    public static String toCNYStrAndDecimal_0(BigDecimal bd) {
        return MoneyConvertForCNY.moneyCover(bd, MoneyConvertForCNY.CN_MONEY_PRECISION_ZERO);
    }

    /**
     * 金额转换中文大写 精确到角
     * @param bd 金额
     * @return
     */
    public static String toCNYStrAndDecimal_1(BigDecimal bd) {
        return MoneyConvertForCNY.moneyCover(bd, MoneyConvertForCNY.CN_MONEY_PRECISION_ONE);
    }

    /**
     * 金额转换中文大写 精确到分
     * @param bd 金额
     * @return
     */
    public static String toCNYStrAndDecimal_2(BigDecimal bd) {
        return MoneyConvertForCNY.moneyCover(bd, MoneyConvertForCNY.CN_MONEY_PRECISION_TWO);
    }

    /**
     * 金额转换中文大写 精确到厘
     * @param bd 金额
     * @return
     */
    public static String toCNYStrAndDecimal_3(BigDecimal bd) {
        return MoneyConvertForCNY.moneyCover(bd, MoneyConvertForCNY.CN_MONEY_PRECISION_THREE);
    }

    /**
     * 金额转换中文大写 精确到毫
     * @param bd 金额
     * @return
     */
    public static String toCNYStrAndDecimal_4(BigDecimal bd) {
        return MoneyConvertForCNY.moneyCover(bd, MoneyConvertForCNY.CN_MONEY_PRECISION_FOUR);
    }

    /**
     * 金额转换英文大写 美分形式
     * @param bd 金额
     * @return
     */
    public static String toUSDStrAndDecimal_cents(BigDecimal bd) {
        return MoneyConvertForUSD.moneyCover(bd, MoneyConvertForUSD.EN_PRESENTATION_CENTS);
    }

    /**
     * 金额转换英文大写 美点形式
     * @param bd 金额
     * @return
     */
    public static String toUSDStrAndDecimal_point(BigDecimal bd) {
        return MoneyConvertForUSD.moneyCover(bd, MoneyConvertForUSD.EN_PRESENTATION_POINT);
    }

    /**
     * 金额转换英文大写 分数形式
     * @param bd 金额
     * @return
     */
    public static String toUSDStrAndDecimal_grade(BigDecimal bd) {
        return MoneyConvertForUSD.moneyCover(bd, MoneyConvertForUSD.EN_PRESENTATION_GRADE);
    }

}
