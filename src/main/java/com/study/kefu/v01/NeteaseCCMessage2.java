package com.study.kefu.v01;

import com.study.kefu.v1.entity.message.AbstractCCMessage;

/**
 * 网易云信抄送的消息
 * 1.4.5.1、P2P：文本消息
 * {"attach":"","body":"文字消息","convType":"PERSON","eventType":"1","fromAccount":"zhangsan","fromClientType":"IOS","fromDeviceId":"B0BFF2EB-E2E1-4063-9E73-92FB926BF388","fromNick":"zhangsan","msgTimestamp":"1456888017105","msgType":"TEXT","msgidClient":"f33f0716-6027-47de-a582-37a8dc2d217c","msgidServer":"8364607","resendFlag":"0","to":"lisi","yidunRes":"{\"yidunBusType\":0,\"action\":0,\"labels\":[]}"}
 *
 * 1.4.5.2、P2P：图片消息
 * {"attach":"{\"md5\":\"d0323f8d447abf3df7256bd66f9d5b62\",\"h\":500,\"ext\":\"jpg\",\"size\":9093,\"w\":500,\"name\":\"图片发送于2016-03-02 11:09\",\"url\":\"http:\\/\\/b12026.nos.netease.com\\/MTAxMTAxMA==\\/bmltYV8xNDI5MTVfMTQ1NTY4NzIxMDkyOF8wOWE1ZmVlMS1lOGQ4LTQwMzItOGZkMS0yMWE1ODBjYjA1MWE=\"}","body":"","convType":"PERSON","eventType":"1","fromAccount":"zhangsan","fromClientType":"IOS","fromDeviceId":"B0BFF2EB-E2E1-4063-9E73-92FB926BF388","fromNick":"zhangsan","msgTimestamp":"1456888195062","msgType":"PICTURE","msgidClient":"472f2f50-2b00-4d7b-8b8d-d8870daa0dbd","msgidServer":"8364613","resendFlag":"0","to":"lisi","yidunRes":"{\"yidunBusType\":1,\"labels\":[{\"level\":0,\"rate\":0.0,\"label\":100},{\"level\":0,\"rate\":0.0,\"label\":200},{\"level\":0,\"rate\":0.0,\"label\":110},{\"level\":0,\"rate\":0.0,\"label\":400},{\"level\":0,\"rate\":0.0,\"label\":300},{\"level\":0,\"rate\":0.0,\"label\":210}]}"}
 * {
 *   "md5":"xxxxxxxx",      //图片的md5值
 *   "h":500,               //图片的高
 *   "w":500,               //图片的宽
 *   "size":9093,           //图片的大小
 *   "name":"xxxxxxxx",     //图片的名称
 *   "url":"xxxxxxxx",      //图片的url
 *   "ext":"jpg"            //图片格式
 * }
 *
 * 1.4.5.3、P2P：音频消息
 * {"attach":"{\"size\":14181,\"ext\":\"aac\",\"dur\":3900,\"url\":\"http:\\/\\/b12026.nos.netease.com\\/MTAxMTAxMA==\\/bmltYV8xNDI5MTVfMTQ1NTY4NzIxMDkyN18xYjRlOTc4My0zYzFkLTQ5NzUtOTY2NC1hOTkzMzAzOGZiZjc=\",\"md5\":\"4c5cc81dd00817b548b5eef42eac4d11\"}","body":"发来了一段语音","convType":"PERSON","eventType":"1","fromAccount":"zhangsan","fromClientType":"IOS","fromDeviceId":"B0BFF2EB-E2E1-4063-9E73-92FB926BF388","fromNick":"zhangsan","msgTimestamp":"1456888940830","msgType":"AUDIO","msgidClient":"b0b703ea-3e10-453e-8650-e3a2802130bd","msgidServer":"8364635","resendFlag":"0","to":"lisi"}
 * {
 *   "size":14181,          //音频的大小
 *   "ext":"aac",           //音频的格式
 *   "dur":3900,            //音频的时长
 *   "url":"xxxxxxxx",      //音频的url
 *   "md5":"xxxxxxxx"       //音频的md5值
 * }
 *
 * 1.4.5.4、P2P：视频消息
 * {"attach":"{\"url\":\"http:\\/\\/b12026.nos.netease.com\\/MTAxMTAxMA==\\/bmltYV8xNDI5MTVfMTQ1NTY4NzIxMDkyN18xZGNkMjQzNi02OTg2LTQxNGEtYWE5ZC04ZDhmYjQyMTE2OTQ=\",\"md5\":\"c2f2e15af1c9e341187f81e5f8453399\",\"ext\":\"mp4\",\"h\":480,\"size\":114347,\"w\":360,\"name\":\"视频发送于2016-03-02 11:16\",\"dur\":1456}","body":"","convType":"PERSON","eventType":"1","fromAccount":"zhangsan","fromClientType":"IOS","fromDeviceId":"B0BFF2EB-E2E1-4063-9E73-92FB926BF388","fromNick":"zhangsan","msgTimestamp":"1456888595916","msgType":"VIDEO","msgidClient":"57a33622-cd80-4c65-b8d3-15f3c2bb128f","msgidServer":"8364616","resendFlag":"0","to":"lisi"}
 * attach字段释义：
 * {
 *   "url":"xxxxxxxx",      //视频的url
 *   "md5":"xxxxxxxx",      //视频的md5值
 *   "ext":"mp4",           //视频的格式
 *   "h":"480",             //视频的高
 *   "w":"360",             //视频的宽
 *   "size":14181,          //视频的大小
 *   "name":"xxxxxxxx",     //视频的名称
 *   "dur":1456             //视频的时长
 * }
 *
 * 1.4.5.5、P2P：地理位置信息
 * {"attach":"{\"lat\":30.18704515647036,\"lng\":120.1908686708565,\"title\":\"中国 浙江省 杭州市 网商路 599号\"}","body":"","convType":"PERSON","eventType":"1","fromAccount":"zhangsan","fromClientType":"REST","fromDeviceId":"","fromNick":"zhangsan","msgTimestamp":"1456897243862","msgType":"LOCATION","msgidClient":"6f9804ac-d584-422e-85a2-5f0167df65cf","msgidServer":"8364682","resendFlag":"0","to":"lisi"}
 * attach字段释义：
 * {
 *   "lat":30.18704515647036,   //纬度
 *   "lng":120.1908686708565,   //经度
 *   "title":"xxxxxxxx"         //地理位置的title
 * }
 *
 * 1.4.5.6、P2P：文件消息
 * {"attach":"{\"ext\":\"ttf\",\"md5\":\"79d62a35fa3d34c367b20c66afc2a500\",\"name\":\"BlizzardReg.ttf\",\"size\":\"91680\",\"url\":\"http:\\/\\/nimtest.nos.netease.com\\/08c9859d-183f-4daa-9904-d6cacb51c95b\"}","body":"","convType":"PERSON","eventType":"1","fromAccount":"zhangsan","fromClientType":"IOS","fromDeviceId":"E8977274-3CD1-494D-95C4-EA633G63B5B5","fromNick":"zhangsan","msgTimestamp":"1456897960993","msgType":"FILE","msgidClient":"e1177d7c-c693-4a91-b0ef-f47f48793d9e","msgidServer":"8364686","resendFlag":"0","to":"lisi"}
 * attach字段释义：
 * {
 *   "ext":"xxxxxxxx",          //文件的类型
 *   "md5":"xxxxxxxx",          //文件的md5值
 *   "name":"xxxxxxxx",         //文件名
 *   "size":"xxxxxxxx",         //文件的大小
 *   "url":"xxxxxxxx"           //文件的URL
 * }
 *
 * 1.4.5.7、P2P：自定义消息（msgType类型为CUSTOM）
 * {"attach":"{"myKey1":\"myValue1\",\"myKey2\":2}","body":"","convType":"PERSON","eventType":"1","fromAccount":"zhangsan","fromClientType":"REST","fromDeviceId":"","fromNick":"zhangsan","msgTimestamp":"1456898248757","msgType":"CUSTOM","msgidClient":"1f929f45-1b5e-495e-b76c-465a4187be52","msgidServer":"8364702","resendFlag":"0","to":"lisi"}
 * attach字段释义：由第三方自己定义并解析相应的Key-Value值
 *
 * 1.4.5.8、P2P：自定义系统通知
 * {"attach":"{\"myKey1\":\"myValue1\",\"myKey2\":10}","body":"","convType":"CUSTOM_PERSON","customApnsText":"","customSafeFlag":"0","eventType":"1","fromAccount":"zhangsan","msgTimestamp":"1456913798613","msgType":"CUSTOM_P2P_MSG","msgidServer":"381209","to":"lisi"}
 */
public class NeteaseCCMessage2 extends AbstractCCMessage {
    //PERSON或CUSTOM_PERSON
    private String convType;
    //消息发送者的用户账号，字符串类型
    private String fromAccount;
    //发送方昵称，字符串类型
    private String fromNick;
    //消息发送时间，字符串类型
    private String msgTimestamp;
    //TEXT、
    //PICTURE、
    //AUDIO、 //后续支持
    //VIDEO、
    //LOCATION 、 //后续支持
    //NOTIFICATION、  //后续支持
    //FILE、 //文件消息  //后续支持
    //其他类型不支持，直接置为不识别类型
    private String msgType;
    //	消息内容，字符串类型
    private Object body;
    //附加消息，字符串类型
    private Object attach;
    //服务端生成的消息id，可转为Long型数据
    private String msgidServer;
    //消息扩展字段
    private Object ext;

    public String getConvType() {
        return convType;
    }

    public void setConvType(String convType) {
        this.convType = convType;
    }

    public String getFromAccount() {
        return fromAccount;
    }

    public void setFromAccount(String fromAccount) {
        this.fromAccount = fromAccount;
    }

    public String getFromNick() {
        return fromNick;
    }

    public void setFromNick(String fromNick) {
        this.fromNick = fromNick;
    }

    public String getMsgTimestamp() {
        return msgTimestamp;
    }

    public void setMsgTimestamp(String msgTimestamp) {
        this.msgTimestamp = msgTimestamp;
    }

    public String getMsgType() {
        return msgType;
    }

    public void setMsgType(String msgType) {
        this.msgType = msgType;
    }

    @Override
    public long getId() {
        return 0;
    }

    @Override
    public String getFromId() {
        return null;
    }

    @Override
    public String getToId() {
        return null;
    }

    @Override
    public String getType() {
        return null;
    }

    public Object getBody() {
        return body;
    }

    @Override
    public long getTimestamp() {
        return 0;
    }

    public void setBody(Object body) {
        this.body = body;
    }

    public Object getAttach() {
        return attach;
    }

    public void setAttach(Object attach) {
        this.attach = attach;
    }

    public String getMsgidServer() {
        return msgidServer;
    }

    public void setMsgidServer(String msgidServer) {
        this.msgidServer = msgidServer;
    }

    public Object getExt() {
        return ext;
    }

    public void setExt(Object ext) {
        this.ext = ext;
    }
}
