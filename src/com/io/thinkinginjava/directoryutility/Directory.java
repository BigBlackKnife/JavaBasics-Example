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
     *
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
    // Overloaded
    public static File[] local(String path, final String regex) {
        return local(new File(path), regex);
    }

    public static class TreeInfo implements Iterable<File> {
        private List<File> files = new ArrayList<File>();
        private List<File> dirs = new ArrayList<File>();


        @Override
        public Iterator<File> iterator() {
            return files.iterator();
        }

        void addAll(TreeInfo other){
            files.addAll(other.files);
            dirs.addAll(other.dirs);
        }

        @Override
        public String toString() {
            return "dirs: " + PPrint.pformat(dirs) + "\n\nfiles: " + PPrint.pformat(files);
        }
    }

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

    static TreeInfo recurseDirs(File startDir, String regex) {
        TreeInfo result = new TreeInfo();
        for (File item : startDir.listFiles()) {
            if (item.isDirectory()){
                result.dirs.add(item);
                recurseDirs(item, regex);
            } else {
                System.out.println(item.getName() + "-" + regex + ":" +item.getName().matches(regex));
                if (item.getName().matches(regex)){
                    result.files.add(item);
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        if (args.length == 0) {
            System.out.println(walk("F:\\javaBasicsTest"));
        } else {
            for (String arg : args){
                System.out.println(walk("F:\\javaBasicsTest", arg));
            }
        }
    }
}
