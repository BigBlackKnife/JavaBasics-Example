package com.enumerated.unit07useinterfacestoorganize;

import com.utility.enumutils.Enums;

/**
 * 将一个enum嵌套在另一个enum中
 * enum中包含内部接口，内部接口包含enum
 *
 * 依旧是随机获取，在指向性获取方面依旧不方便，
 */
public enum SecurityCategory {
    STOCK(Security.Stock.class),
    BOND(Security.Bond.class);

    Security[] values;
    SecurityCategory(Class<? extends Security> kind) {
        values = kind.getEnumConstants();
    }

    public Security randomSelection() {
        return Enums.random(values);
    }

    /**
     * 将其所包含的enum组成一个公共类型，这样SecurityCategory才能将Security中的enum
     */
    interface Security {
        enum Stock implements Security { SHORT, LONG, MARGIN }
        enum Bond implements Security { MUNICIPAL, JUNK }
    }

    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            SecurityCategory category = Enums.random(SecurityCategory.class);
            System.out.println(category + ": " + category.randomSelection());
        }
    }
}
