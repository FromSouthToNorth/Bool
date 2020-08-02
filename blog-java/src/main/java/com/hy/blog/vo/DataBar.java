package com.hy.blog.vo;

import java.util.List;

public class DataBar {

    private List<String> names;
    private List<Integer> values;

    public DataBar() {
    }

    public DataBar(List<String> names, List<Integer> values) {
        this.names = names;
        this.values = values;
    }

    public List<String> getNames() {
        return names;
    }

    public void setNames(List<String> names) {
        this.names = names;
    }

    public List<Integer> getValues() {
        return values;
    }

    public void setValues(List<Integer> values) {
        this.values = values;
    }

}
