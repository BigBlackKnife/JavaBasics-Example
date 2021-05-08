package com.io.practice.PictureToCharacterPattern;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

/**
 * @author blaife
 * @description 图片转字符图案的手动实现
 * @data 2021/5/8 8:57
 */
public class GeneratorTextImage {

    private static final char[] PIXEL = {'@', '#', '8', '&', 'o', ':', '*', '.', ' '};


    public static void main(String[] args) {
        BufferedImage bufferedImage = makeSmallImage("C:\\Users\\blaife\\Desktop\\1.png", 90, -1);
        if (bufferedImage != null) {
            printImage(bufferedImage);
        }
    }

    /**
     * 图片缩放
     * @param srcImage 图片地址
     * @param width 宽度
     * @param height 高度
     * @return BufferedImage
     *
     * 1. 若宽高任一设置为-1时，则保持原宽高比例，
     * 2. 若都为-1时，则宽高比例不进行处理
     * 3. 若都不为-1时，这指定宽高进行缩放
     */
    public static BufferedImage makeSmallImage(String srcImage, int width, int height) {
        File srcImageFile = new File(srcImage);
        if (!srcImageFile.exists()) {
            System.out.println("文件不存在");
            return null;
        }
        BufferedImage tagImage;
        Image image;

        try {
            image = ImageIO.read(srcImageFile);
            // 获取原图片宽高
            int srcWidth = image.getWidth(null);
            int srcHeight = image.getHeight(null);
            if (width == -1 && height == -1) {
                width = srcWidth;
                height = srcHeight;
            } else if (width == -1) {
                width = (int) ((float)srcWidth * (float)height / (float)srcHeight);
            } else if (height == -1) {
                height = (int) ((float)srcHeight * (float)width / (float)srcWidth);
            }
            tagImage = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
            tagImage.getGraphics().drawImage(image, 0, 0, width, height, null);
            return tagImage;
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            System.gc();
        }
        return null;
    }


    /**
     * 输出字符图案
     * @param image BufferedImage
     */
    public static void printImage(BufferedImage image) {
        int width = image.getWidth();
        int height = image.getHeight();
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                int rgb = image.getRGB(j, i);
                Color color = new Color(rgb);
                int red = color.getRed();
                int green = color.getGreen();
                int blue = color.getBlue();
                // 一个用于计算RGB像素点亮度的公式
                double luminance = 0.2126 * red + 0.7152 * green + 0.0722 * blue;
                double index = luminance / (Math.ceil(255 / PIXEL.length) + 0.5);
                System.out.print(PIXEL[(int)(Math.floor(index))]);
            }
            System.out.println();
        }
    }
}
