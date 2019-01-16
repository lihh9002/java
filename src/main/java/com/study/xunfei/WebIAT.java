package com.study.xunfei;

import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;

import org.apache.commons.codec.binary.Base64;
import org.apache.commons.codec.digest.DigestUtils;
import org.apache.commons.io.FileUtils;


/**
 * 语音听写 WebAPI 接口调用示例
 *
 * 运行方法：直接运行 main() 即可
 *
 * 结果： 控制台输出语音听写结果信息
 *
 * @author iflytek
 *
 */
public class WebIAT {
    // 合成webapi接口地址
    private static final String WEBIAT_URL = "http://api.xfyun.cn/v1/service/v1/iat";
    // 应用ID
    private static final String APPID = "5c3dac09";


    // 接口密钥
    private static final String API_KEY = "89897537389f38af9a362cc33d5aec63";

    // 音频编码
    private static final String AUE = "speex-wb";
    // 引擎类型
    private static final String ENGINE_TYPE = "sms8k";

    // 后端点
    private static final String VAD_EOS = "10000";

    // 音频文件地址
    private static final String AUDIO_PATH = "C:\\study\\workspace\\java\\src\\main\\java\\com\\study\\xunfei\\test.m4a";

    /**
     * 听写 WebAPI 调用示例程序
     *
     * @param args
     * @throws IOException
     */
    public static void main(String[] args) throws IOException {
        Map<String, String> header = buildHttpHeader();
        byte[] audioByteArray = FileUtils.readFileToByteArray(new File(AUDIO_PATH));
        String audioBase64 = new String(Base64.encodeBase64(audioByteArray), "UTF-8");
        String body = "audio=" + URLEncoder.encode(audioBase64, "UTF-8");
        System.out.println(body);
        String result = HttpUtil.doPost1(WEBIAT_URL, header, body);
        System.out.println("听写 WebAPI 接口调用结果：" + result);
    }

    /**
     * 组装http请求头
     */
    private static Map<String, String> buildHttpHeader() throws UnsupportedEncodingException {
        String curTime = System.currentTimeMillis() / 1000L + "";
        String param = "{\"aue\":\""+AUE+"\""+", \"speex_size\":\"68\",\"engine_type\":\"" + ENGINE_TYPE + "\""+",\"vad_eos\":\"" + VAD_EOS + "\"}";
//        String param = "{\"aue\":\""+AUE+"\""+", \"engine_type\":\"" + ENGINE_TYPE + "\""+",\"vad_eos\":\"" + VAD_EOS + "\"}";
        String paramBase64 = new String(Base64.encodeBase64(param.getBytes("UTF-8")));
        String checkSum = DigestUtils.md5Hex(API_KEY + curTime + paramBase64);
        Map<String, String> header = new HashMap<>();
        header.put("Content-Type", "application/x-www-form-urlencoded; charset=utf-8");
        header.put("X-Param", paramBase64);
        header.put("X-CurTime", curTime);
        header.put("X-CheckSum", checkSum);
        header.put("X-Appid", APPID);
        System.out.println(header);
        return header;
    }
}
