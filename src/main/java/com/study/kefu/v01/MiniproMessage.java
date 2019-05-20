package com.study.kefu.v01;

/**
 * 小程序发送消息
 *
 * 1、发送文本消息
 * {
 *     "touser":"OPENID",
 *     "msgtype":"text",
 *     "text":
 *     {
 *          "content":"Hello World"
 *     }
 * }
 * 发送文本消息时，支持添加可跳转小程序的文字链：
 * 文本内容....<a href="http://www.qq.com" data-miniprogram-appid="appid" data-miniprogram-path="pages/index/index">点击跳小程序</a>
 * 链接说明：
 * data-miniprogram-appid 项，填写小程序appid，则表示该链接跳转小程序；
 * data-miniprogram-path项，填写小程序路径，路径与app.json中保持一致，可带参数；
 * 对于不支持data-miniprogram-appid 项的客户端版本，如果有herf项，则仍然保持跳href中的链接；
 * 小程序发带小程序文字链的文本消息，data-miniprogram-appid必须是该小程序的appid。
 *
 * 2、发送图片消息
 * {
 *     "touser":"OPENID",
 *     "msgtype":"image",
 *     "image":
 *     {
 *       "media_id":"MEDIA_ID"
 *     }
 * }
 *
 * 3、发送图文链接
 * 每次可以发送一个图文链接
 * {
 *
 *     "touser": "OPENID",
 *     "msgtype": "link",
 *     "link": {
 *           "title": "Happy Day",
 *           "description": "Is Really A Happy Day",
 *           "url": "URL",
 *           "thumb_url": "THUMB_URL"
 *     }
 * }
 *
 * 4、发送小程序卡片
 * {
 * 	"touser":"OPENID",
 * 	"msgtype":"miniprogrampage",
 * 	"miniprogrampage":{
 * 		"title":"title",
 * 		"pagepath":"pagepath",
 * 		"thumb_media_id":"thumb_media_id"
 *        }
 * }
 *
 */
public class MiniproMessage {
    private String from;
    //普通用户(openid)
    private String touser;
    //text, image, link, miniprogrampage
    private String msgtype;
    //文本消息内容
    private String content;
    //发送的图片的媒体ID，通过新增素材接口上传图片文件获得。
    private String mediaId;
    //消息标题
    private String title;
    //图文链接消息
    private String description;
    //图文链接消息被点击后跳转的链接
    private String url;
    //图文链接消息的图片链接，支持 JPG、PNG 格式，较好的效果为大图 640 X 320，小图 80 X 80
    private String picurl;
    //小程序的页面路径，跟app.json对齐，支持参数，比如pages/index/index?foo=bar
    private String pagepath;
    //小程序消息卡片的封面， image类型的media_id，通过新增素材接口上传图片文件获得，建议大小为520*416
    private String thumbMediaId;

    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public String getTouser() {
        return touser;
    }

    public void setTouser(String touser) {
        this.touser = touser;
    }

    public String getMsgtype() {
        return msgtype;
    }

    public void setMsgtype(String msgtype) {
        this.msgtype = msgtype;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getMediaId() {
        return mediaId;
    }

    public void setMediaId(String mediaId) {
        this.mediaId = mediaId;
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

    public String getPicurl() {
        return picurl;
    }

    public void setPicurl(String picurl) {
        this.picurl = picurl;
    }

    public String getPagepath() {
        return pagepath;
    }

    public void setPagepath(String pagepath) {
        this.pagepath = pagepath;
    }

    public String getThumbMediaId() {
        return thumbMediaId;
    }

    public void setThumbMediaId(String thumbMediaId) {
        this.thumbMediaId = thumbMediaId;
    }
}
