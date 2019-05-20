package com.study.util;

import org.apache.commons.codec.digest.DigestUtils;

import java.security.MessageDigest;
import java.util.UUID;

/**
 * 安全相关的工具类
 */
public class SecurityUtil {

    /**
     * 混淆密码算法
     *
     * @param salt
     * @param inputPassword
     * @return
     */
    public static String confusePassword(String salt, String inputPassword) {
        return DigestUtils.md5Hex(salt + DigestUtils.md5Hex(inputPassword));
    }
    /**
     * MD5的算法在RFC1321 中定义 在RFC 1321中，给出了Test suite用来检验你的实现是否正确：<BR />
     * MD5 ("") = d41d8cd98f00b204e9800998ecf8427e <BR />
     * MD5 ("a") = 0cc175b9c0f1b6a831c399e269772661 <BR />
     * MD5 ("abc") = 900150983cd24fb0d6963f7d28e17f72 <BR />
     * MD5 ("message digest") = f96b697d7cb7938d525a2f31aaf161d0 <BR />
     * MD5 ("abcdefghijklmnopqrstuvwxyz") = c3fcd3d76192e4007dfb496cca67e13b
     * <p>
     * 传入参数：一个字节数组 传出参数：字节数组的 MD5 结果字符串
     */
    public static String md5(String sourceStr) {
        byte[] source = sourceStr.getBytes();
        String s = null;
        char hexDigits[] = { // 用来将字节转换成 16 进制表示的字符
                '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            md.update(source);
            // MD5 的计算结果是一个 128 位的长整数，用字节表示就是 16 个字节
            byte tmp[] = md.digest();
            // 每个字节用 16 进制表示的话，使用两个字符，所以表示成 16 进制需要 32 个字符
            char str[] = new char[16 * 2];
            // 表示转换结果中对应的字符位置
            int k = 0;
            // 从第一个字节开始，对 MD5 的每一个字节转换成 16 进制字符的转换
            for (int i = 0; i < 16; i++) {
                // 取第 i 个字节
                byte byte0 = tmp[i];
                // 取字节中高 4位的数字转换, >>> 为逻辑右移，将符号位一起右移
                str[k++] = hexDigits[byte0 >>> 4 & 0xf];
                // 取字节中低 4 位的数字转换
                str[k++] = hexDigits[byte0 & 0xf];
            }
            // 换后的结果转换为字符串
            s = new String(str);

        } catch (Exception e) {
            e.printStackTrace();
        }
        return s;
    }

    public static String getUUIDStr() {
        UUID uuid = UUID.randomUUID();
        String str = uuid.toString();
        str = str.replaceAll("-", "");
        return str;
    }

    public static String[] shortUrl(String url) {
        // 可以自定义生成 MD5 加密字符传前的混合 KEY
        String key = "mengdelong";
        // 要使用生成 URL 的字符
        String[] chars = new String[]{"a", "b", "c", "d", "e", "f", "g", "h",
                "i", "j", "k", "l", "m", "n", "o", "p", "q", "r", "s", "t",
                "u", "v", "w", "x", "y", "z", "0", "1", "2", "3", "4", "5",
                "6", "7", "8", "9", "A", "B", "C", "D", "E", "F", "G", "H",
                "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T",
                "U", "V", "W", "X", "Y", "Z"

        };
        // 对传入网址进行 MD5 加密
        String sMD5EncryptResult = md5(key + url);
        String hex = sMD5EncryptResult;

        String[] resUrl = new String[4];
        for (int i = 0; i < 4; i++) {

            // 把加密字符按照 8 位一组 16 进制与 0x3FFFFFFF 进行位与运算
            String sTempSubString = hex.substring(i * 8, i * 8 + 8);

            // 这里需要使用 long 型来转换，因为 Inteper .parseInt() 只能处理 31 位 , 首位为符号位 , 如果不用 long ，则会越界
            long lHexLong = 0x3FFFFFFF & Long.parseLong(sTempSubString, 16);
            String outChars = "";
            for (int j = 0; j < 8; j++) {
                // 把得到的值与 0x0000003D 进行位与运算，取得字符数组 chars 索引
                long index = 0x0000003D & lHexLong;
                // 把取得的字符相加
                outChars += chars[(int) index];
                // 每次循环按位右移 5 位
                lHexLong = lHexLong >> 4;
            }
            // 把字符串存入对应索引的输出数组
            resUrl[i] = outChars;
        }
        return resUrl;
    }

    public static String generateStr(int length) {
        return String.valueOf(Math.round((Math.random() * 9 + 1) * Math.pow(10, length-1)));
    }

}
