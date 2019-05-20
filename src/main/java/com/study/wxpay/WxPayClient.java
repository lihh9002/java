package com.study.wxpay;

import com.study.util.SecurityUtil;

import java.util.Map;
import java.util.TreeMap;
import java.util.UUID;

public class WxPayClient {

    public static final String mch_id = "1515168261";
    public static final String appid = "wxee57a7fd13a751de";
    public static final String nonce_str = SecurityUtil.getUUIDStr();
    public static final String sign_type = "MD5";
    public static final String spbill_create_ip = "115.238.62.171";
    public static final String notify_url = "https://www.tenbent.com";
    public static final String trade_type = "JSAPI";
    public static final String openid = "ocxBs5QAkX207a3kJC5_mE0w71QI";
    public static final String sign_key = "LFYutenbent3L70KoOuCQG8jZZm6XHk3";

    public static void main(String...args)throws Exception{
        String body = "保大师—测试商品";
        String outTradeNo = SecurityUtil.getUUIDStr();
        int totalFee = 888;
        TreeMap<String, Object> params = new TreeMap<>();
        params.put("appid", appid);
        params.put("mch_id", mch_id);
        params.put("nonce_str", nonce_str);
        params.put("sign_type", sign_type);
        params.put("body", body);
        params.put("out_trade_no", outTradeNo);
        params.put("total_fee", totalFee);
        params.put("spbill_create_ip", spbill_create_ip);
        params.put("notify_url", notify_url);
        params.put("trade_type", trade_type);
        params.put("openid", openid);
        //签名
        String sign = sign(params, sign_key);
        params.put("sign", sign);

        String xml = toXML(params);
        System.out.println(xml);

    }

    public static String toXML(TreeMap<String, Object> params){
        StringBuffer buffer = new StringBuffer();
        buffer.append("<xml>");
        for (String s : params.keySet()) {
            buffer.append("<").append(s).append(">");
            buffer.append(params.get(s));
            buffer.append("</").append(s).append(">");
        }
        buffer.append("</xml");
        return buffer.toString();
    }

    public static String originStr(TreeMap<String, Object> params){
        StringBuffer buffer = new StringBuffer();
        for (String p : params.keySet()) {
            buffer.append(p).append("=").append(params.get(p)).append("&");
        }
        int length = buffer.length();
        buffer.delete(length - 2, length - 1);
        String content = buffer.toString();
        return content;
    }

    public static String sign(TreeMap<String, Object> params, String key){
        StringBuffer buffer = new StringBuffer();
        for (String p : params.keySet()) {
            buffer.append(p).append("=").append(params.get(p)).append("&");
        }
        buffer.append(key);
        String content = buffer.toString();
        return SecurityUtil.md5(content).toUpperCase();
    }
}
