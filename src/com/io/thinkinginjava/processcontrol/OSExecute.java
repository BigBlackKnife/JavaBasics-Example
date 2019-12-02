package com.io.thinkinginjava.processcontrol;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 进程控制 -- 主要逻辑
 */
public class OSExecute {
    public static void command(String command) {
        boolean err = false;
        try {
            // process类提供获取子进程的输入流、子进程的输出流、子进程的错误流、等待进程完成、检查进程的推出状态以及销毁进程的方法；
            // 流程生成器 程序及其参数的字符串数组
            Process process = new ProcessBuilder(command.split(" ")).start();

            // getInputStream 返回连接到子进程的正常输出的输入流
            BufferedReader results = new BufferedReader(
                new InputStreamReader(process.getInputStream())
            );
            String s ;
            while ((s = results.readLine()) != null) {
                System.out.println(s);
            }
            // getErrorStream：返回连接到子进程的错误输出的输入流
            BufferedReader errors = new BufferedReader(
                new InputStreamReader(process.getErrorStream())
            );
            while ((s = results.readLine()) != null) {
                System.out.println(s);
                err = true;
            }
        } catch (IOException e) {
            e.printStackTrace();
            if (!command.startsWith("CMD /C")) {
                command("CMD /C" + command);
            } else {
                throw new RuntimeException(e);
            }
        }
        if (err) {
            throw new OSExecuteException("Errors eexecuting" + command);
        }
    }
}
