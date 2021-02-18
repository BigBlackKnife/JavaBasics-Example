# 泛型

泛型的作用是为了突破具体类型的刻板束缚，是一种泛化机制。

- 如果方法接收基类的话，确实更加通用一点，但除了final类之外，其他任何类都可以进行扩展，存在一定的性能损耗。
- 如果方法接受接口的话，这就包括了暂时不存在的类，但这样对程序的约束也还是太强了，要求代码必须使用特定的接口。

## 简单泛型

泛型实现了参数化类型的概念，可暂时不指定类型，在使用时确定要使用的类型。

促进泛型出现的一个重要原因是为了创造容器类。

### 元组类库

- 将一组对象直接打包存储于单一对象中。可以从该对象读取其中的元素，但不允许向其中存储新对象
- 元组可以具有任意长度，元组中的对象可以是不同类型的。

有了泛型，你可以很容易地创建元组，令其返回一组任意类型的对象。

### 堆栈类

- 内部链式存储
- 内部类 Node 也是一个泛型，它拥有自己的类型参数。

### 持有特定类型对象的列表

- 列表可以适用于各种类型，就需要使用泛型

## 泛型接口

接口使用泛型和类使用泛型没什么区别

## 泛型方法

---
是否拥有泛型方法，与其所在的类是否是泛型类没有关系。

---
泛型方法基本指导原则：
- 无论何时，尽量使用泛型方法，即如果使用泛型方法可以取代整个类泛型化，那么应该只使用泛型方法。
- 对于static方法，无法访问泛型类的类型参数，所以如果static方法需要使用泛型能力，就必须成为泛型方法。

---
类型推断：
- 如： `ArrayList<String> list = new ArrayList<>;`
- 类型推断仅对赋值操作有效。
- 将一个泛型方法调用的结果当作参数传递给另一个方法，这时编译器并不会执行类型推断。（编译器认为其赋给Object变量）。

---
泛型方法和可变参数列表可以很好的共存。
```java
public static <T> List<T> makeList(T... arg) {
    List<T> result = new ArrayList<T>();
    for (T item : arg) {
        result.add(item);
    }
    return result;
}
```

---
Supplier
- 这是一个为任意具有无参构造方法的类生成 Supplier 的类

---
简化元组的使用
- 使用泛型类时，必须在创建对象的时候指定类型参数的值，而使用泛型方法时，通常不需要指明参数类型。
```java
public class Tuple {
    public static <A, B> Tuple2<A, B> tuple(A a, B b) {
        return new Tuple2<>(a, b);
    }
    // ... 
}
```
```java
import static com.generics.method_generice.Tuple.tuple;
public class TupleTest2 {
    static Tuple2<String, Integer> f() {
        return tuple("hi", 47);
    }
}
```

---
一个 Set 工具

- Sets 表达数学中的关系式
```java

// ...

public static <T> Set<T> difference(Set<T> superset, Set<T> subset) {
    Set<T> result = new HashSet<>(superset);
    result.removeAll(subset);
    return result;
}

// ...
```

配合枚举使用非常的方便

- 展示 java.util 包中各种 Collection 和 Map 类之间的方法差异
```java
package com.generics.method_generice;

import java.lang.reflect.Method;
import java.util.*;
import java.util.stream.Collectors;

/**
 * @author Blaife
 * @description Collection 和 map 的差异
 * @date 2020/11/12 22:16
 */
public class CollectionMethodDifferences {
    /**
     * 将类中所有方法转为 map ， 再转为 set.
     * @param type class
     * @return Set
     */
    static Set<String> methodSet(Class<?> type) {
        return Arrays.stream(type.getMethods())
                .map(Method::getName)
                .collect(Collectors.toCollection(TreeSet::new));
    }

    /**
     * 输出当前类的接口 并输出其实现类
     * @param type class
     */
    static void interfaces(Class<?> type) {
        System.out.print("Interfaces in " + type.getSimpleName() + ": ");
        System.out.println(
                Arrays.stream(type.getInterfaces())
                        .map(Class::getSimpleName)
                        .collect(Collectors.toList()));
    }

    static Set<String> object = methodSet(Object.class);

    static {
        object.add("clone");
    }

    /**
     * 获取两个类之间的不同之处 - 两个类中的不同方法
     * @param superset class 1
     * @param subset class 2
     */
    static void difference(Class<?> superset, Class<?> subset) {
        System.out.print(superset.getSimpleName() + " extends " + subset.getSimpleName() + ", adds: ");
        Set<String> comp = Sets.difference(methodSet(superset), methodSet(subset));
        comp.removeAll(object);
        System.out.println(comp);
        interfaces(superset);
    }

    public static void main(String[] args) {
        System.out.println("Collection: " + methodSet(Collection.class));
        interfaces(Collection.class);
        difference(Set.class, Collection.class);
        difference(HashSet.class, Set.class);
        difference(LinkedHashSet.class, HashSet.class);
        difference(TreeSet.class, Set.class);
        difference(List.class, Collection.class);
        difference(ArrayList.class, List.class);
        difference(LinkedList.class, List.class);
        difference(Queue.class, Collection.class);
        difference(PriorityQueue.class, Queue.class);
        System.out.println("Map: " + methodSet(Map.class));
        difference(HashMap.class, Map.class);
        difference(LinkedHashMap.class, HashMap.class);
        difference(SortedMap.class, Map.class);
        difference(TreeMap.class, Map.class);
    }
}
```

## 构建复杂模型

- 泛型能够简单安全地创建复杂模型

便利店模型
- 便利店，走廊，货架，商品
- 便利店包含多个走廊
- 走廊包含多个货架
- 货架包含多个商品
- 商品类中包含id, 描述，价格

## 泛型擦除

`Class.getTypeParameters()` 得到一个TypeVariable对象数组。泛型类只能得到用作参数占位符的标识符。即：***在泛型代码内部，无法得到任何有关参数类型的信息***

你可以知道***类型参数标识符***和***泛型边界***信息，但无法得知某个特定实例的实际类型参数。

Java泛型是使用擦除实现的，***作何理解***？

### C++的方式

- 对于泛型参数的内部方法
    - C++在编译期判断，因为在C++中,当模板那被实例化时，模板代码知道其模板参数的类型
    - java则需要给定泛型边界（重用extends关键字）
- 泛型类型参数将擦除到它的第一个边界（可能存在多个边界）
- 希望代码能跨多类工作时，泛型才是有用的。

### 迁移兼容性

- 泛型擦除是Java泛型实现中的一种折中，因为泛型不是Java的初始组成部分。
- *具体化*： 使类型参数保持为*第一类实体*，因此你就能够在类型参数上执行基于此类型的语言操作和反射操作。
- *第二类类型* ： 不能在某些重要的上下文环境中使用的类型。
- 泛型类型只有在静态类型检查期间才出现，在此之后，程序中的所有泛型类型都将被擦除，替换为它们的非泛型上界。
- Java设计者及相关团队一致认为,擦除是唯一可行的方案，Java泛型必须要支持向后兼容性和迁移兼容性。
    - 向后兼容性：现有代码和类文件依旧合法，并且继续保持其当前的含义。
    - 迁移兼容性：使类库按照它们自己的步调变为泛型的，并且当某个类库变为泛型时，不会破坏依赖于它的代码和应用程序。

### 擦除的问题

- 擦除主要的正当理由是从非泛化到泛化代码的转变过程，以及在不破坏现有类库的情况下，将泛型融入Java。
- 在编写泛型代码时，要时刻提醒自己，他只是好像拥有有关参数的类型信息而已，实际上，它只是一个Object。
- 如果希望将类型参数不仅仅当作Object处理时，需要付出额外的努力来管理边界。

### 边界处的动作

- 泛型最令人困惑的方面，即可以表示没有任何意义的事物。
    - `(T[]) Array.newInstance(String.class, 3);` `Array.newInstance()` 实际上并未拥有对应参数中所蕴含的类型信息，所以必须强制转型。
- 边界：对象进入和离开方法的地点，这也正是编译器在编译期执行类型检查并插入转型代码的地点。

## 擦除补偿

- 擦除导致在运行时，对于一个泛型对象我们无法知道任何有关它的确切的类型信息。
- 引入类型标签来对擦除进行补偿：显式地传递类型的Class对象，以便在类型表达中使用它。

### 创建类型实例

- new T() 无法实现是由于擦除以及编译器不能验证 T 具有默认构造器。
- 使用工厂对象创造新的实例。( `Class.newInstance()` );
    - 使用显式的工厂，并限制其类型，使得只能接受实现了这个工厂的类。
    - 另外也可以使用 `模板方法` 设计模式创建类型实例

### 泛型数组

- 创建泛型数组
    - 在任何想创建泛型数据的地方使用 `ArrayList` (一般的解决方法，太畸形。)
    - 按照编译器的喜好来定义应用，但无法创建确切类型数组 (错误方式)
    - 创造一个被擦除类型的新数组，然后对其转型。 (正确方式)
- 在内部将array当作 Object[] 而不是 T[] 处理的优势是： 我们不太可能忘记这个数组的运行时类型，从而意外地引入缺陷。

## 边界

- 边界使得你可以在用于泛型的阐述类型上设置限制条件，以便于按照自己的边界类型来调用方法。
- 无界 `<T>` 泛型参数调用的方法只是那些可以用Object调用的方法。
- java泛型重用了 `extends` 关键字，但需要注意的式， `extends` 关键字在泛型边界的上下文环境中和普通环境下所具有的意义式完全不同的。

## 通配符

> 在泛型参数表达式中的问号

### 基本


***数组的特殊行为，可以向导出类型的数组赋予基类型的数据引用，但此时，数据类型会编程引用数据类型。***
```java

Fruit[] fruit = new Apple[10];
// 运行时类型为 Apple 而非Fruit

fruit[0] = new Apple();
fruit[0] = new Fruit(); 
// 此时异常出现 ArrayStoreException
```

---
***使用泛型容器来代替数组时，编译错误***
```java
// Compile Error: incompatible types:
List<Fruit> flist = new ArrayList<Apple>();
```

---
***使用泛型通配符形式***
```java
List<? extends Fruit> flist = new ArrayList<>();

// Compile Error: can't add any type of object:
// flist.add(new Apple());
// flist.add(new Fruit());
// flist.add(new Object());
// 这并不意味着你可以使用符合类型的对象，你并不能添加任意类型的对象

List<? extends Fruit> flist2 = new ArrayList<Apple>();
// 正确的用法时将符合类型的集合对象，赋值于它。
```

### 编译器有多聪明

- 编译器将检查代码，以查看是否有某个特定的方法修改了他的对象？ (并非如此)
- 编译器会直接拒绝对阐述列表中涉及通配符的方法（例如add()）的调用
    - contains和indexOf参数类型都是Object，所以编译器允许
    - add不允许
- 意味着由泛型类的设计者来决定哪些调用时安全的