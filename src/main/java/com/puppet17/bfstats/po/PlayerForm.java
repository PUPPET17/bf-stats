package com.puppet17.bfstats.po;

/**
 * @author PUPPET17
 * @version 1.0
 * @date 2024/1/6
 */
public class PlayerForm {

    private String userId;

    private String avatar;

    private String userName;

    private String id;

    public PlayerForm() {
    }

    public PlayerForm(String userId, String avatar, String userName, String id) {
        this.userId = userId;
        this.avatar = avatar;
        this.userName = userName;
        this.id = id;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
