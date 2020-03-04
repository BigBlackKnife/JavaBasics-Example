package com.enumerated.unit04mysticalvalues;

/**
 * enum向上转型为Enum，使用getEnumConstans代替values
 * 通过class对象屈的所有enum实例
 */
enum Search { HITHER, YOW }
public class UpcastEnum {
    public static void main(String[] args) {
        Search[] vals = Search.values();
        Enum e = Search.HITHER;
        for (Enum en : e.getClass().getEnumConstants()) {
            System.out.println(en);
        }
    }
}
