package com.study.img;


import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URL;

public class TestImg {

    public static void main(String[] args) throws IOException {
        String filePath = "C:\\Users\\21697\\Desktop\\abc.png";
        String outPath = "C:\\Users\\21697\\Desktop\\abc_java.png";

        drawTextInImg(filePath, outPath);
    }

    public static void drawTextInImg(String filePath,String outPath) throws IOException {
//        BufferedImage srcImg = ImageIO.read(new File(filePath));
        BufferedImage srcImg = ImageIO.read(new URL("https://jdstatic.tenbent.com//minipro/user/bground/1545965400368"));
        int width = srcImg.getWidth();
        int height = srcImg.getHeight();
        double ratio = 1.0 * height * 0.8 / 400;
        System.out.println(ratio);
        // 在新建一个图像缓冲区
        BufferedImage destImg = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
        Graphics2D gp;
        // 画原图像
        gp = destImg.createGraphics();
        gp.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC, 1));
        gp.drawImage(srcImg, 0, 0, null);
        gp.dispose();
        // 画阴影部分
        BufferedImage yy = ImageIO.read(new File("C:\\Users\\21697\\Desktop\\yy2.png"));
        gp = destImg.createGraphics();
        gp.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, 1f));
        gp.drawImage(yy, 0, (int) (height * 0.8 - yy.getHeight() * ratio), width,
                (int) (yy.getHeight() * ratio), null);
        gp.dispose();
        // 写文字
        float x = (float) (35 * ratio);
        System.out.println(x);
        gp = destImg.createGraphics();

        Font font = new Font("微软雅黑", Font.PLAIN, 36);
        gp.setColor(Color.WHITE);
        gp.setFont(font);
        gp.drawString("叶杭杰", x, (float) (251 * ratio));

        font = new Font("微软雅黑", Font.PLAIN, 28);
        gp.setFont(font);
        gp.drawString("产品经理", x, (float) (305 * ratio));
        gp.drawString("腾保保险", x, (float) (344 * ratio));
        gp.dispose();

        try {
            FileOutputStream out = new FileOutputStream(outPath);
            ImageIO.write(destImg, "png", out);
            out.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}