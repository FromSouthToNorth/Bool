package com.hy.blog.vo;

public class UserVO {

    private Long id;
    private String nickname;
    private String avatar;
    private String loginTime;

    public UserVO() {
    }

    public UserVO(Long id, String nickname, String avatar, String loginTime) {
        this.id = id;
        this.nickname = nickname;
        this.avatar = avatar;
        this.loginTime = loginTime;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public String getLoginTime() {
        return loginTime;
    }

    public void setLoginTime(String loginTime) {
        this.loginTime = loginTime;
    }
}
