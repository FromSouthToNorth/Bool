package com.hy.blog.entity;

import java.util.Date;

public class Log {

    private Long id;
    private String url;
    private String ip;
    private String classMethod;
    private Object[] objects;

    private Date accessTime;

    public Log() {
    }

    public Log(Long id, String url, String ip, String classMethod, Object[] objects, Date accessTime) {
        this.id = id;
        this.url = url;
        this.ip = ip;
        this.classMethod = classMethod;
        this.objects = objects;
        this.accessTime = accessTime;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public String getClassMethod() {
        return classMethod;
    }

    public void setClassMethod(String classMethod) {
        this.classMethod = classMethod;
    }

    public Object[] getObjects() {
        return objects;
    }

    public void setObjects(Object[] objects) {
        this.objects = objects;
    }

    public Date getAccessTime() {
        return accessTime;
    }

    public void setAccessTime(Date accessTime) {
        this.accessTime = accessTime;
    }

}
