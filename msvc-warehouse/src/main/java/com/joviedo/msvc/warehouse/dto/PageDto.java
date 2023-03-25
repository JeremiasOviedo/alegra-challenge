package com.joviedo.msvc.warehouse.dto;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PageDto <T>{
    private List<T> content;
    private Map<String,String> links = new HashMap<>();

    public List<T> getContent() {
        return content;
    }

    public void setContent(List<T> content) {
        this.content = content;
    }

    public Map<String, String> getLinks() {
        return links;
    }

    public void setLinks(Map<String, String> links) {
        this.links = links;
    }

}
