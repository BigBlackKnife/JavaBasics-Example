package com.reuse.agency;

/**
 * @author Blaife
 * @description 复用 -- 委托
 * @data 2020/4/3 22:21
 */
public class DerivedSpaceShip extends SpaceShipControls {
    private String name;
    public DerivedSpaceShip(String name) {
        this.name = name;
    }
    @Override
    public String toString() { return name; }
    public static void main(String[] args) {
        DerivedSpaceShip protector = new DerivedSpaceShip("NSEA Protector");
        protector.forward(100);
    }
}
