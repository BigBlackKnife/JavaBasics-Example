package com.io.thinkinginjava.practicaltool;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.TreeSet;

public class TextFile extends ArrayList<String> {

    public static String read(String name){
        StringBuilder sb = new StringBuilder();
        BufferedReader br = null;
        try {
            br = new BufferedReader(new FileReader(new File(name).getAbsoluteFile()));
            String s;
            while ((s = br.readLine()) != null) {
                sb.append(s);
                sb.append("\n");
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (br != null){
                try {
                    br.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return sb.toString();
    }

    public static void write(String fileName, String text) {
        PrintWriter out = null;
        try {
            out = new PrintWriter(new File(fileName).getAbsoluteFile());
            out.print(text);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } finally {
            if (out != null) {
                out.close();
            }
        }
    }

    public TextFile(String fileName, String splitter) {
        super(Arrays.asList(read(fileName).split(splitter)));
        if (get(0).equals("")) {
            remove(0);
        }
    }

    public TextFile(String fileName) {
        this(fileName, "\n");
    }

    public void write(String fileName) {
        PrintWriter out = null;
        try {
            out = new PrintWriter(new File(fileName).getAbsoluteFile());
            for (String item : this) {
                out.println(item);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } finally {
            if (out != null) {
                out.close();
            }
        }
    }


    public static void main(String[] args) {
        String file = read("src\\com\\io\\thinkinginjava\\practicaltool\\TextFile.java");
        write("test.txt", file);
        TextFile text = new TextFile("test.txt");
        text.write("test2.txt");
        TreeSet<String> words = new TreeSet<String>(new TextFile("src\\com\\io\\thinkinginjava\\practicaltool\\TextFile.java", "\\w+"));
        System.out.println(words.headSet("a"));
    }
}
