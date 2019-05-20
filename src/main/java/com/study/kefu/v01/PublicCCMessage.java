package com.study.kefu.v01;

public class PublicCCMessage {
    //消息id，64位整型
    private String msgId;
    //开发者微信号
    private String toUserName;
    //发送方帐号（一个OpenID）
    private String fromUserName;
    //消息创建时间 （整型）
    private long createTime;
    //消息类型，文本为text, 图片为image,语音为voice,视频为video,小视频为shortvideo,地理位置为location,链接为link,事件为event
    private String msgType;
    //文本消息内容
    private String content;
    //图片链接（由系统生成）
    private String picUrl;
    //图片消息媒体id，可以调用获取临时素材接口拉取数据。
    private String mediaId;
    //语音格式，如amr，speex等
    private String format;
    //语音识别结果，UTF8编码
    private String recognition;
    //视频消息缩略图的媒体id，可以调用多媒体文件下载接口拉取数据
    private String thumbMediaId;
    //地理位置纬度
    private String locationX;
    //地理位置经度
    private String locationY;
    //地图缩放大小
    private String scale;
    //地理位置信息
    private String label;
    //消息标题
    private String title;
    //消息描述
    private String description;
    //消息链接
    private String url;
    //事件类型，subscribe(订阅)、unsubscribe(取消订阅)
    private String event;
    //事件KEY值，qrscene_为前缀，后面为二维码的参数值
    private String eventKey;
    //二维码的ticket，可用来换取二维码图片
    private String ticket;

    public String getMsgId() {
        return msgId;
    }

    public void setMsgId(String msgId) {
        this.msgId = msgId;
    }

    public String getToUserName() {
        return toUserName;
    }

    public void setToUserName(String toUserName) {
        this.toUserName = toUserName;
    }

    public String getFromUserName() {
        return fromUserName;
    }

    public void setFromUserName(String fromUserName) {
        this.fromUserName = fromUserName;
    }

    public long getCreateTime() {
        return createTime;
    }

    public void setCreateTime(long createTime) {
        this.createTime = createTime;
    }

    public String getMsgType() {
        return msgType;
    }

    public void setMsgType(String msgType) {
        this.msgType = msgType;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getPicUrl() {
        return picUrl;
    }

    public void setPicUrl(String picUrl) {
        this.picUrl = picUrl;
    }

    public String getMediaId() {
        return mediaId;
    }

    public void setMediaId(String mediaId) {
        this.mediaId = mediaId;
    }

    public String getFormat() {
        return format;
    }

    public void setFormat(String format) {
        this.format = format;
    }

    public String getRecognition() {
        return recognition;
    }

    public void setRecognition(String recognition) {
        this.recognition = recognition;
    }

    public String getThumbMediaId() {
        return thumbMediaId;
    }

    public void setThumbMediaId(String thumbMediaId) {
        this.thumbMediaId = thumbMediaId;
    }

    public String getLocationX() {
        return locationX;
    }

    public void setLocationX(String locationX) {
        this.locationX = locationX;
    }

    public String getLocationY() {
        return locationY;
    }

    public void setLocationY(String locationY) {
        this.locationY = locationY;
    }

    public String getScale() {
        return scale;
    }

    public void setScale(String scale) {
        this.scale = scale;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getEvent() {
        return event;
    }

    public void setEvent(String event) {
        this.event = event;
    }

    public String getEventKey() {
        return eventKey;
    }

    public void setEventKey(String eventKey) {
        this.eventKey = eventKey;
    }

    public String getTicket() {
        return ticket;
    }

    public void setTicket(String ticket) {
        this.ticket = ticket;
    }
}
