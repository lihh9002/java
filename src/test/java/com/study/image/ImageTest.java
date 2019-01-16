package com.study.image;

import org.junit.Test;
//import org.springframework.web.client.RestTemplate;
import sun.security.util.Length;

import java.io.FileInputStream;

public class ImageTest {

    @Test
    public void cropImage(){
        double wr = 5, hr = 4;//比例
        double width = 2001, height = 1000;//原宽高

        double nw, nh;//新宽高
        double uw = width / wr, uh = height / hr;//原单位宽高
        double x1, x2, y1, y2;
        if (uw > uh){ //减宽度，高度不变
            nh = height;
            nw = uh * wr;

            y1 = 0;
            y2 = nh;
            x1 = width / 2 - nw / 2;
            x2 = width / 2 + nw / 2;
        }else {//减高度，宽度不变
            nw = width;
            nh = uw * hr;

            x1 = 0;
            x2 = nw;
            y1 = height / 2 - nh / 2;
            y2 = height / 2 + nh / 2;
        }
        System.out.println("x1 = " + x1);
        System.out.println("x2 = " + x2);
        System.out.println("y1 = " + y1);
        System.out.println("y2 = " + y2);
    }

    @Test
    public void fileType()throws Exception{
        String[] urls = new String[]{
                "https://mmbiz.qpic.cn/mmbiz_jpg/GRGakqeVeWgA8Ssg9z0HJbwe8UFMeoB5QB3XWpNWsOsKsVfJGAdy8GS7knptZwR8yQxgpCZZzBSibXEybnVyJuA/0?wx_fmt=jpeg",
                "https://mmbiz.qpic.cn/mmbiz_jpg/ow6przZuPIEibsCq169pG96WA5ADPGJWuyZZ4bXcnPO1DA4nA7chRPH3eCZ1dB10GmX8uupaj6Z1ia8o3mrXAobg/0?wx_fmt=jpeg",
                "https://mmbiz.qpic.cn/mmbiz_jpg/Pn4Sm0RsAuiazdM9uetcB9v7Wibvtz2qLYtke7cOMxVNXW72GsCWavpLvGvrDM8IL5lgKU60IyIofjcT9Y668bFA/0?wx_fmt=jpeg",
                "https://mmbiz.qpic.cn/mmbiz_jpg/GvTBMVQQEZ5KJCYWpHGh2tE9MP9kuHvuAvOyibicfp21IqALuoCm4uloWzDPdvo8c9xl35pHuA1fmeVv9ia5fP8Jw/0?wx_fmt=jpeg",
                "https://mmbiz.qpic.cn/mmbiz_jpg/3t47UkBibQ1icTAXMTPlTTXdKuLm1EqHKet9icWsPEDohs0x9MqPlxtYp9ZYKa8EGqw6yRpBO7fas2Lktu3Vfa34g/0?wx_fmt=jpeg",
                "https://mmbiz.qpic.cn/mmbiz_jpg/NiaQJEVlDibOysaDpEoTRUH3cIvr4iaNJCVaUKVIibyWK8TpUhmpI1dLCTOVoMKqERYpibGrnWOboQG8zOcUCv51Zkg/0?wx_fmt=jpeg",
                "https://mmbiz.qpic.cn/mmbiz_jpg/ePTzepwoNWO2rF2oreYhXV4lMO9LhiaweJyo4HTWfWzoVn7ib3p3AiaI69s8lCzIC9Syc6Cz6FSyPAZG4iaoFuBWNg/0?wx_fmt=jpeg",
                "https://mmbiz.qpic.cn/mmbiz_jpg/LINwapK6P39xSy4Libjv9o6wuCspa0ANfRRArToraI4YIsOkDJIh0VBMZHzlXDhdTeoHb3OPObIokvM8icIzTicxQ/0?wx_fmt=jpeg",
                "https://mmbiz.qpic.cn/mmbiz_jpg/q7BkUhvic1Q9oYibAgiaH3QXVQXZfuCG0CaZcGYLSuWTWbYb0WvFy9KovC42rZ6tooHFWPhicKW6VhyNEu3ib6WlPicQ/0?wx_fmt=jpeg",
                "https://mmbiz.qpic.cn/mmbiz_jpg/GRGakqeVeWgA8Ssg9z0HJbwe8UFMeoB5nRvKupWS6ibHa1Bk3p9ibyhPdIBicSCab3BKdpn4XCiaaJGIgXMJAiamKbw/0?wx_fmt=jpeg",
                "https://mmbiz.qpic.cn/mmbiz_jpg/r9TKn8V2Ob0jnewkVgG8EWP7RXWkf5rQib8MNtD5S2I3jj9Ng9GibBETZLlBH5C8255lVbuZ5ibUs383605ibeaKIA/0?wx_fmt=jpeg",
                "https://mmbiz.qpic.cn/mmbiz_jpg/gcMaXJKVPm85OMpJPjjxhAuwyGe0KK4R0bG17y7ico52Ho9lGFqYl9OKQgdicob5P1y96gJb1PWJk9vZMib3gyibAg/0?wx_fmt=jpeg",
                "https://mmbiz.qpic.cn/mmbiz_jpg/gcMaXJKVPm85OMpJPjjxhAuwyGe0KK4RDuPvvmia0NibicqAxfUrSMhmT1iauce9ibZ9MQcrrKRzibzAIKUe6tN843sw/0?wx_fmt=jpeg",
                "https://mmbiz.qpic.cn/mmbiz_jpg/8pI4eRLkIlk9k4y93Au0m9RQYJweQARzb8nOaY8ibfoRLwaaJWB62GffJ5x5TOTy8LHLv1tZqXpKJdX6AEYX7yg/0?wx_fmt=jpeg",
                "https://mmbiz.qpic.cn/mmbiz_jpg/KO7NNP0BFL0D4yiaJtsp0TbwZwpLQHALH3MQbQ3SsCHKO2AdxYxhep0E1icwhibYLnHBwy5jCaibYgQyYqdgd2KBEA/0?wx_fmt=jpeg",
                "https://mmbiz.qpic.cn/mmbiz_jpg/GRGakqeVeWhxD2y7wXdbCjvgiaMQxr1521kdMkEmpicuerx0eIvklfnnkGf6VrC90XXSiaFCblO8ebn5r0wGdxp4A/0?wx_fmt=jpeg",
                "https://mmbiz.qpic.cn/mmbiz_jpg/GRGakqeVeWj2CaMm3SrGLtNqzLSj8s8CNetv81zuUkM4ZXIIHxcwxE9ibL5M1zTJTPJuGiaLn3IXyEmcCicuh2Exg/0?wx_fmt=jpeg",
                "https://mmbiz.qpic.cn/mmbiz_jpg/FLjMqvsF5ibfzYcOUDEbM3XDsOPib4DySl4M4FBq0OoOfWagibyJ7yXPZUe0Gibk7oKEribZUf1JrSe6j1ibt8CzfhKg/0?wx_fmt=jpeg"
        };
//        RestTemplate template = new RestTemplate();
//        for (String url : urls) {
//            byte[] bytes = template.getForObject(url, byte[].class);
//            String xxx = bytesToHexString(bytes, 3);
//            xxx = xxx.toUpperCase();
//            System.out.println(url);
//            System.out.println("头文件是：" + xxx);
//            String ooo = checkType(xxx);
//            System.out.println("后缀名是：" + ooo);
//        }
    }

    public String bytesToHexString(byte[] src, int length) {
        StringBuilder stringBuilder = new StringBuilder();
        if (src == null || src.length <= 0) {
            return null;
        }
        for (int i = 0; i < length; i++) {
            int v = src[i] & 0xFF;
            String hv = Integer.toHexString(v);
            if (hv.length() < 2) {
                stringBuilder.append(0);
            }
            stringBuilder.append(hv);
        }
        return stringBuilder.toString();
    }

    /**
     常用文件的文件头如下：(以前六位为准)
     JPEG (jpg)，文件头：FFD8FF
     PNG (png)，文件头：89504E47
     GIF (gif)，文件头：47494638
     TIFF (tif)，文件头：49492A00
     Windows Bitmap (bmp)，文件头：424D
     CAD (dwg)，文件头：41433130
     Adobe Photoshop (psd)，文件头：38425053
     Rich Text Format (rtf)，文件头：7B5C727466
     XML (xml)，文件头：3C3F786D6C
     HTML (html)，文件头：68746D6C3E
     Email [thorough only] (eml)，文件头：44656C69766572792D646174653A
     Outlook Express (dbx)，文件头：CFAD12FEC5FD746F
     Outlook (pst)，文件头：2142444E
     MS Word/Excel (xls.or.doc)，文件头：D0CF11E0
     MS Access (mdb)，文件头：5374616E64617264204A
     WordPerfect (wpd)，文件头：FF575043
     Postscript (eps.or.ps)，文件头：252150532D41646F6265
     Adobe Acrobat (pdf)，文件头：255044462D312E
     Quicken (qdf)，文件头：AC9EBD8F
     Windows Password (pwl)，文件头：E3828596
     ZIP Archive (zip)，文件头：504B0304
     RAR Archive (rar)，文件头：52617221
     Wave (wav)，文件头：57415645
     AVI (avi)，文件头：41564920
     Real Audio (ram)，文件头：2E7261FD
     Real Media (rm)，文件头：2E524D46
     MPEG (mpg)，文件头：000001BA
     MPEG (mpg)，文件头：000001B3
     Quicktime (mov)，文件头：6D6F6F76
     Windows Media (asf)，文件头：3026B2758E66CF11
     MIDI (mid)，文件头：4D546864
     */
    public String checkType(String xxxx) {

        switch (xxxx) {
            case "FFD8FF": return "jpg";
            case "89504E": return "png";
            case "474946": return "jif";

            default: return "0000";
        }
    }
}
