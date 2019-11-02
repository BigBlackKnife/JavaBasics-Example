package com.io.thinkinginjava.directoryutility;

import java.io.File;
import java.io.FilenameFilter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.regex.Pattern;

/**
 * 目录实用工具
 * @author Blaife
 */
public final class Directory {

    /**
     * 获取当前目录下符合正则条件的文件
     * @param dir
     * @param regex
     * @return
     */
    public static File[] local(File dir, final String regex) {
        return dir.listFiles(new FilenameFilter() {
            private Pattern pattern = Pattern.compile(regex);
            @Override
            public boolean accept(File dir, String name) {
                return pattern.matcher(new File(name).getName()).matches();
            }
        });
    }
    // Overloaded 获取当前目录下符合正则条件的文件
    public static File[] local(String path, final String regex) {
        return local(new File(path), regex);
    }

    /**
     * 文件集合 实现迭代接口
     */
    public static class TreeInfo implements Iterable<File> {
        private List<File> files = new ArrayList<File>();
        private List<File> dirs = new ArrayList<File>();

        @Override
        public Iterator<File> iterator() {
            return files.iterator();
        }

        /**
         * 此方法的主要作用是 迭代获取的下级对象TreeInfo要把文件内容传递给上级循环
         * @param other 其他目录集合，其实是下一级的文件
         */
        void addAll(TreeInfo other){
            files.addAll(other.files);
            dirs.addAll(other.dirs);
        }

        @Override
        public String toString() {
            return "dirs: " + PPrint.pformat(dirs) + "\n\nfiles: " + PPrint.pformat(files);
        }
    }

    /**
     * 开始方法，做方法重载来进入主方法recurseDirs
     * @param start 开始目录
     * @param regex 正则条件
     * @return TreeInfo
     */
    public static TreeInfo walk(String start, String regex) {
        return recurseDirs(new File(start), regex);
    }

    public static TreeInfo walk(File start, String regex) {
        return recurseDirs(start, regex);
    }

    public static TreeInfo walk(String start) {
        return recurseDirs(new File(start), ".*");
    }

    public static TreeInfo walk(File start) {
        return recurseDirs(start, ".*");
    }

    /**
     * 主方法 迭代获取初始目录下的所有文件
     * @param startDir 目录
     * @param regex 正则条件
     * @return
     */
    static TreeInfo recurseDirs(File startDir, String regex) {
        TreeInfo result = new TreeInfo();
        for (File item : startDir.listFiles()) {
            if (item.isDirectory()){
                result.dirs.add(item);
                result.addAll(recurseDirs(item, regex));
            } else {
                if (item.getName().matches(regex)){
                    result.files.add(item);
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        if (args.length == 0) {
            System.out.println(walk("."));
        } else {
            for (String arg : args){
                System.out.println(arg);
                System.out.println(walk(".", arg));
            }
        }
    }
}
