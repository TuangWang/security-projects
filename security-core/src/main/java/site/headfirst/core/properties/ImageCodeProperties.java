package site.headfirst.core.properties;

public class ImageCodeProperties {

    // 验证码高度
    private int height = 23;
    // 验证码宽度
    private int width = 67;
    // 验证码长度
    private int length = 4;
    // 验证码过期时间
    private int expiredIn = 60;


    private String url;

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public int getExpiredIn() {
        return expiredIn;
    }

    public void setExpiredIn(int expiredIn) {
        this.expiredIn = expiredIn;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
