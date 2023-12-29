package com.max.util;

public enum Languages {
    EN("English","en"),
    ID("Indonesian","id"),
    ES("Spanish", "es"),
    FR("Franch","fr"),
    KO("Korean","ko");

    private final String code;
    private final String title;


    Languages(String title, String code) {
        this.title = title;
        this.code = code;
    }

    public String getCode() {
        return code;
    }

    public String getTitle() {
        return title;
    }
}
