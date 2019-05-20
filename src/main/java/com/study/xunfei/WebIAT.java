package com.study.xunfei;

import org.apache.commons.codec.binary.Base64;
import org.apache.commons.codec.digest.DigestUtils;
import org.apache.commons.io.FileUtils;

import javax.sound.sampled.AudioFileFormat;
import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import java.io.*;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;


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
    private static final String AUE = "raw";
    // 引擎类型
    private static final String ENGINE_TYPE = "sms16k";

    // 后端点
    private static final String VAD_EOS = "10000";



    /**
     * 听写 WebAPI 调用示例程序
     *
     * @param args
     * @throws IOException
     */
    public static void main(String[] args) throws IOException {
        byte[] audioByteArray = FileUtils.readFileToByteArray(new File(AUDIO_PATH));
        audioByteArray = byteToWav(audioByteArray);
        String audioBase64 = new String(Base64.encodeBase64(audioByteArray), "UTF-8");
        String body = "audio=" + URLEncoder.encode(audioBase64, "UTF-8");
        System.out.println(body);
        Map<String, String> header = buildHttpHeader();
//        String result = HttpUtil.doPost1(WEBIAT_URL, header, body);
//        System.out.println("听写 WebAPI 接口调用结果：" + result);
    }

    /**
     * 组装http请求头
     */
    private static Map<String, String> buildHttpHeader() throws UnsupportedEncodingException {
        String curTime = System.currentTimeMillis() / 1000L + "";
//        String param = "{\"aue\":\""+AUE+"\""+", \"speex_size\":\"68\",\"engine_type\":\"" + ENGINE_TYPE + "\""+",\"vad_eos\":\"" + VAD_EOS + "\"}";
        String param = "{\"aue\":\""+AUE+"\""+", \"engine_type\":\"" + ENGINE_TYPE + "\""+",\"vad_eos\":\"" + VAD_EOS + "\"}";
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

    // 音频文件地址
    private static final String AUDIO_PATH = "C:\\study\\workspace\\java\\src\\main\\java\\com\\study\\xunfei\\diushoujuan.mp3";
//    private static final String AUDIO_PATH = "C:\\study\\workspace\\java\\src\\main\\java\\com\\study\\xunfei\\1550125509845.mp3";
//    private static final String AUDIO_PATH = "C:\\study\\workspace\\java\\src\\main\\java\\com\\study\\xunfei\\test.wav";

    public static byte[] byteToWav(byte[] sourceBytes) {
        if (sourceBytes == null || sourceBytes.length == 0) {
            System.out.println("Illegal Argument passed to this method");
            return null;
        }
        try{
            InputStream bais = new ByteArrayInputStream(sourceBytes);
            AudioFileFormat fileFormat = AudioSystem.getAudioFileFormat(bais);
            final AudioInputStream sourceAIS = AudioSystem.getAudioInputStream(bais);
            System.out.println(sourceAIS.getFrameLength());
            // 根据路径生成wav文件
            AudioFormat targetFormat = new AudioFormat(AudioFormat.Encoding.PCM_SIGNED, 8000,
                    16, 1, 2,8000, false);
            AudioInputStream ais = AudioSystem.getAudioInputStream(targetFormat, sourceAIS);

            ByteArrayOutputStream os = new ByteArrayOutputStream();
            AudioSystem.write(ais, AudioFileFormat.Type.WAVE, new FileOutputStream(new File("new.wav")));
            return os.toByteArray();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
