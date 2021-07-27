package com.imooc.auth.auth.model;

import java.io.Serializable;
import java.util.Date;

/**
 * user_info
 * @author 
 */
public class UserInfo implements Serializable {
    private String id;

    private String username;

    private String password;

    /**
     * 微信openid
     */
    private String openid;

    /**
     * 1买家2卖家
     */
    private Boolean role;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 修改时间
     */
    private Date updateTime;

    private static final long serialVersionUID = 1L;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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

    public String getOpenid() {
        return openid;
    }

    public void setOpenid(String openid) {
        this.openid = openid;
    }

    public Boolean getRole() {
        return role;
    }

    public void setRole(Boolean role) {
        this.role = role;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }
}