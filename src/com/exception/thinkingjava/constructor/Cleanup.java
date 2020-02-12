package com.exception.thinkingjava.constructor;

public class Cleanup {

    public static void main(String[] args) {
        try {
            InputFile in = new InputFile("src\\com\\exception\\thinkingjava\\constructor\\Cleanup.java");
            try {
                String s;
                int i = 1;
                while ((s = in.getLine()) != null) {
                    System.out.println(s);
                };
            } catch (Exception e) {
                System.out.println("Caught Exception in main");
                e.printStackTrace(System.out);
            } finally {
                in.dispose();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
