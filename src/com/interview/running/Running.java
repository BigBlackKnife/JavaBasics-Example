package com.interview.running;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.concurrent.CountDownLatch;

/**
 * @author Blaife
 * @description 跑步
 * @date 2021/5/11 22:51
 *
 * 3个小朋友参加百米跑步比赛，A小朋友每秒跑5米，B小朋友每秒跑4米，C小朋友每秒跑3米。
 * 大家做好准备之后喊一声“我准备好了”，然后在听到发令枪响后一起起步，并在开始跑步时喊一声“我开始跑步了”，
 * 当一个小朋友跑到终点时，喊一声“我到终点了”，此时记录跑了多久。
 * 其他小朋友停止跑步，并报出自己跑了多少米，例如“x小朋友跑了yy米”。
 */
public class Running {

    private static CountDownLatch cld = new CountDownLatch(3);
    private static final int[] speedPerSecond = {5,4,3};
    private static final String[] childrenFlag = {"A", "B", "C"};
    private static final Integer totalLength = 100;
    private static volatile Boolean destinationFlag = false;

    public static void main(String[] args) {
        for (int i = 0; i < 3; i++) {
            int finalI = i;

            Thread t = new Thread(new Runnable() {
                @Override
                public void run() {
                    int currentLength = 0;
                    int currentSecond = 0;
                    int currentChildrenSpeedPerSecond = speedPerSecond[finalI];
                    String currentChildrenName = childrenFlag[finalI];

                    System.out.println(currentChildrenName + "： 我准备好了" + System.currentTimeMillis());
                    try {
                        cld.await();//将线程阻塞在此，等待所有线程都调用完start()方法，一起执行
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println(currentChildrenName + "： 我开始跑步了" + System.currentTimeMillis());

                    while (true) {
                        try {
                            Thread.sleep(100);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        if (!destinationFlag) {
                            currentSecond ++;
                            currentLength += currentChildrenSpeedPerSecond;
                            if (currentLength >= totalLength) {
                                System.out.println(currentChildrenName + "：我到终点了，跑了" + currentSecond + "秒");
                                destinationFlag = true;
                                break;
                            }
                        } else {
                            System.out.println(currentChildrenName + "：我跑了" + currentLength + "米");
                            break;
                        }
                    }
                }
            });
            t.start();
            cld.countDown();
        }
    }
}
