package com.max.util;

public class TranslationRequest {
    private String input;
    private String source;
    private String target;

    public TranslationRequest(String input, String source, String target) {
        this.input = input;
        this.source = source;
        this.target = target;
    }

    public String getInput() {
        return input;
    }

    public void setInput(String input) {
        this.input = input;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public String getTarget() {
        return target;
    }

    public void setTarget(String target) {
        this.target = target;
    }
}
