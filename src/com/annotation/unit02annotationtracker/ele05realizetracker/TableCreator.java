package com.annotation.unit02annotationtracker.ele05realizetracker;

import com.annotation.unit02annotationtracker.ele03generateexternalfiles.Constraints;
import com.annotation.unit02annotationtracker.ele03generateexternalfiles.DBTable;
import com.annotation.unit02annotationtracker.ele03generateexternalfiles.SQLInteger;
import com.annotation.unit02annotationtracker.ele03generateexternalfiles.SQLString;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

/**
 * 实现注解处理器（生成sql命令）
 *
 * 现在这种方法是很幼稚的，，如果修改表的名字就必须重新编译java代码
 */
public class TableCreator {

    public static void main(String[] args) throws ClassNotFoundException {
        // args : com.annotation.unit02annotationtracker.ele03generateexternalfiles.Member
        if(args.length < 1) {
            System.out.println("请填入注解类");
            System.exit(0);
        }

        // ①： 反射得到一个类并获取类上的注解
        // 对类进行循环，案例中仅循环一次
        for (String className : args) {
            // 通过反射得到class对象
            Class<?> cl = Class.forName(className);
            // 获取类中的DBTable注解
            DBTable dbTable = cl.getAnnotation(DBTable.class);
            if (dbTable == null) {
                System.out.println("在" + className + "类中没有DBTable注解");
                continue;
            }
            // ②： 将表名存储起来
            // 获取表名
            String tableName = dbTable.name();
            if (tableName.length() < 1) {
                tableName = cl.getName().toUpperCase();
            }
            // ③： 得到这个类的所有属性字段
            // 表中的列集合
            List<String> columnDefs = new ArrayList<>();
            // 当前列名
            String columnName = null;
            // 组装句
            StringBuilder createCommand = new StringBuilder("CREATE TABLE " + tableName + "(");
            /* getDeclaredFields()：返回一个{@code Field}对象数组 该数组反映由该类声明的所有字段或由它表示的intenface声明的所有字段{@code类}对象。
             这包括公共、受保护、默认(包)访问和私有字段，但不包括继承字段
             如果这个代码类对象表示一个没有声明字段的类或接口，那么这个方法返回一个长度为e的数组。
             如果这个{@code Field}对象表示一个数组类型、一个基本类型或void，那么这个方法返回一个长度为e的数组。
             返回数组中的元素没有排序，也没有任何特定的顺序。*/
            for (Field field : cl.getDeclaredFields()) {
                // 获取当前字段上的所有注解
                // ④： 获取当前属性上的所有注解
                Annotation[] anns = field.getDeclaredAnnotations();
                if (anns.length < 1) {
                    continue;
                }
                // ⑤： 根据类型分别处理，得到当前列信息
                // 注解继承自SQLInteger
                if (anns[0] instanceof SQLInteger) {
                    SQLInteger sInt = (SQLInteger) anns[0];
                    if (sInt.name().length() < 1) {
                        columnName = field.getName().toUpperCase();
                    } else {
                        columnName = sInt.name();
                    }
                    columnDefs.add(columnName + ": INT" + getConstraints(sInt.constraints()));
                }
                // 注解继承自SQLString
                if (anns[0] instanceof SQLString) {
                    SQLString sString = (SQLString) anns[0];
                    if (sString.name().length() < 1) {
                        columnName = field.getName().toUpperCase();
                    } else {
                        columnName = field.getName();
                    }
                    columnDefs.add(columnName + ": VARCHAR(" +sString.value() + ")" + getConstraints(sString.constraints()));
                }
            }
            // ⑥： 循环组装文本信息
            for (String columDef : columnDefs) {
                createCommand.append("\n    " + columDef + ",");
            }
            String tableCreate = createCommand.substring(0, createCommand.length() - 1) + ");";
            System.out.println("Table Create SQL for " + className + " is : \n" +tableCreate);
        }
    }

    /**
     * 组装列的约束
     * @param con “ NOT NULL PRIMARY KEY UNIQUE”
     * @return
     */
    private static String getConstraints(Constraints con) {
        String constraints = "";
        if (!con.allowNull()) {
            constraints += " NOT NULL";
        }
        if (con.primaryKey()) {
            constraints += " PRIMARY KEY";
        }
        if(con.unique()) {
            constraints += " UNIQUE";
        }
        return constraints;
    }

}
