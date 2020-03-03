package com.enumerated.unit02addnewmethod;


/**
 * 覆盖方法 -- toString()
 */
public enum  SpaceShip {
    SCOUT, CARGO, TRANSPORT, CRUISER, BATTLESHIP, MOTHERSHIP;

    /**
     * 重写toString，输出只有首字母大写的格式
     * 原方法输出 name();
     * @return
     */
    @Override
    public String toString() {
        return name().charAt(0) + name().substring(1).toLowerCase();
    }

    public static void main(String[] args) {
        for (SpaceShip s : values()) {
            System.out.println(s);
        }
    }
}
