package com.hy.blog.vo;

public class DataStringValue {

    private Long id;
    private String name;
    private String tagColour;
    private Integer value;

    public DataStringValue() {
    }

    public DataStringValue(Long id, String name, String tagColour, Integer value) {
        this.id = id;
        this.name = name;
        this.tagColour = tagColour;
        this.value = value;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTagColour() {
        return tagColour;
    }

    public void setTagColour(String tagColour) {
        this.tagColour = tagColour;
    }

    public Integer getValue() {
        return value;
    }

    public void setValue(Integer value) {
        this.value = value;
    }

}
