package com.interview.eatanorange;

import java.util.concurrent.CountDownLatch;

/**
 * @author Blaife
 * @description 吃橘子
 * @date 2021/5/11 22:25
 *
 * 共计9个桔子，有3个小朋友，小朋友A每次拿2个桔子，小朋友B每次拿3个桔子，小朋友C每次拿1个桔子，
 * 小朋友10s吃1个桔子，吃完后继续去拿。
 * 小朋友每次拿桔子之前和拿了桔子之后，都会对桔子数量进行报数。
 * 如果剩余的桔子不够小朋友每次拿的数量，小朋友停止拿桔子，喊一声“不拿了”并退出游戏。
 *
 * 请用java多线程程序表述上面的过程。
 */
public class EatAnOrange {

    private static CountDownLatch cld = new CountDownLatch(3);
    private static final int[] eatNumFlag = {2,3,1};
    private static final String[] childrenFlag = {"A", "B", "C"};
    private static Integer orangeNumFlag = 9;

    public static void main(String[] args) {
        for (int i = 0; i < 3; i++) {
            int finalI = i;
            Thread t = new Thread(new Runnable() {
                @Override
                public void run() {
                    try {
                        cld.await();//将线程阻塞在此，等待所有线程都调用完start()方法，一起执行
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    int currentChildrenOrageNum = eatNumFlag[finalI];
                    String currentChildrenName = childrenFlag[finalI];
                    while (true) {
                        synchronized (orangeNumFlag) {
                            System.out.println(currentChildrenName + ": 当前橘子剩余数量" + orangeNumFlag);
                            if (orangeNumFlag >= currentChildrenOrageNum) {
                                orangeNumFlag -= currentChildrenOrageNum;
                                System.out.println(currentChildrenName + ": 当前橘子剩余数量" + orangeNumFlag);
                            } else {
                                System.out.println(currentChildrenName + ": 不拿了！");
                                break;
                            }
                        }
                        try {
                            Thread.sleep(10 * 1000 * currentChildrenOrageNum);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
            });
            t.start();
            cld.countDown();
        }
    }
}
