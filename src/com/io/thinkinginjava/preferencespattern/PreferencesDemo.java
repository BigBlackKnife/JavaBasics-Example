package com.io.thinkinginjava.preferencespattern;

import java.util.prefs.BackingStoreException;
import java.util.prefs.Preferences;

/**
 * Preferences与对象持久性更密切，可以自动存储和读取信息，
 * 但它只能用于小的，受限的数据集合————只能存储基本的类型和字符串，并且每个字符串的长度不能超过8K
 * 用户存储用户的偏好以及程序配置项的设置
 * Preferences利用合适的系统资源完成任务，根据操作系统的不同而不同，在windows中就使用注册表
 */
public class PreferencesDemo {
    public static void main(String[] args) throws BackingStoreException {
        // userNodeForPackage和systemNodeForPackage
        // user用于个别用户偏好，system用于通用安装配置
        Preferences prefs = Preferences.userNodeForPackage(Preferences.class);
        prefs.put("location", "Oz");
        prefs.put("Footwear", "Ruby Slippers");
        prefs.putInt("Companions", 4);
        prefs.putBoolean("Are there witches?", true);
        int usageCount = prefs.getInt("UsageCount", 0);
        usageCount++; // 每次运行usageCount都会+1
        prefs.putInt("UsageCount", usageCount);
        for (String key : prefs.keys()) {
            System.out.println(key + ":" + prefs.get(key, null));
        }
        System.out.println("How many companions does Dorothy have? " + prefs.getInt("Companions", 0));
    }
}
