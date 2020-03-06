package com.enumerated.unit09enummap;

import com.enumerated.unit08enumset.AlarmPoints;

import java.util.EnumMap;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import static com.enumerated.unit08enumset.AlarmPoints.*;

/**
 * EnumMap<enum, Object> -- 命令设计模式
 * EnumMap操作与一般Map差不多
 * EnumMap中的key（键）必须来自同一个enum
 * enum中的每一个实例总是存在的，如果没有为这个键调用put()方法来存入相应值，其对应值是null
 *
 * 命令模式需要一个只有单一方法的接口，从该接口实现各自不同的行为的多个子类
 */
interface Command{ void action(); };

public class EnumMaps {
    public static void main(String[] args) {
        // 创建这个EnumMap
        EnumMap<AlarmPoints, Command> em = new EnumMap<AlarmPoints, Command>(AlarmPoints.class);
        // 对数据进行复制
        em.put(KITCHEN, new Command() {
            @Override
            public void action() {
                System.out.println("Kitchen fire!");
            }
        });
        em.put(BATHROOM, new Command() {
            @Override
            public void action() {
                System.out.println("Bathroom alert!");
            }
        });
        // entrySet：返回这个enum映射中包含的映射的集合视图 Set<Map.Entry<K,V>>
        for (Map.Entry<AlarmPoints, Command> e : em.entrySet()) {
            System.out.print(e.getKey() + ": ");
            e.getValue().action();
        }
        System.out.println("没有调用put方法的enum实例的键所对应的值为：" + em.get(UTILITY));
    }
}
