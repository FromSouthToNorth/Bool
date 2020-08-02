package com.hy.blog.vo;

public class TypeRoTagRoBlogTotal {

    private Integer typeTotal;
    private Integer tagTotal;
    private Integer blogTotal;

    public TypeRoTagRoBlogTotal() {
    }

    public TypeRoTagRoBlogTotal(Integer typeTotal, Integer tagTotal, Integer blogTotal) {
        this.typeTotal = typeTotal;
        this.tagTotal = tagTotal;
        this.blogTotal = blogTotal;
    }

    public Integer getTypeTotal() {
        return typeTotal;
    }

    public void setTypeTotal(Integer typeTotal) {
        this.typeTotal = typeTotal;
    }

    public Integer getTagTotal() {
        return tagTotal;
    }

    public void setTagTotal(Integer tagTotal) {
        this.tagTotal = tagTotal;
    }

    public Integer getBlogTotal() {
        return blogTotal;
    }

    public void setBlogTotal(Integer blogTotal) {
        this.blogTotal = blogTotal;
    }
}
