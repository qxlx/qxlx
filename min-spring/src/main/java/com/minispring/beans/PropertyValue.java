package com.minispring.beans;


import lombok.Data;

@Data
public class PropertyValue {
    private final String name;
    private final Object value;

    public PropertyValue(String name, Object value) {
        this.name = name;
        this.value = value;
    }
//省略getter
}