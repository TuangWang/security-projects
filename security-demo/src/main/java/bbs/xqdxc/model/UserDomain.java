package bbs.xqdxc.model;

public class UserDomain {
    /**
     * 用户id, Primary Key
     * */
    private String userId;

    /**
     * 用户名
     * */
    private String username;

    /**
     * 用户密码
     */
    private String password;

    /**
     * 用户图像
     * */
    private String iconUrl;

    /**
     * 手机号
     * */
    private String phone;

    /**
     * weixin号
     * */
    private String weixin;

    /**
     * qq
     * */
    private String qq;

    /**
     * level
     * */
    private String level;

    /**
     * title
     * */
    private String title;

    /**
     * 学校id
     * */
    private String schoolId;

    /**
     * 学号
     * */
    private String studentNumber;

    /**
     * 账号状态
     * 账号状态\n0 正常\n1 未认证\n2 锁定\n3 删除\n
     * */
    private int status;

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getIconUrl() {
        return iconUrl;
    }

    public void setIconUrl(String iconUrl) {
        this.iconUrl = iconUrl;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getWeixin() {
        return weixin;
    }

    public void setWeixin(String weixin) {
        this.weixin = weixin;
    }

    public String getQq() {
        return qq;
    }

    public void setQq(String qq) {
        this.qq = qq;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSchoolId() {
        return schoolId;
    }

    public void setSchoolId(String schoolId) {
        this.schoolId = schoolId;
    }

    public String getStudentNumber() {
        return studentNumber;
    }

    public void setStudentNumber(String studentNumber) {
        this.studentNumber = studentNumber;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }
}
