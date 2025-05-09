package com.example.myapplication.model;

public class TfQuestion {
    private String questionText;
    private String thinkingOption;
    private String feelingOption;

    public TfQuestion(String questionText, String thinkingOption, String feelingOption) {
        this.questionText = questionText;
        this.thinkingOption = thinkingOption;
        this.feelingOption = feelingOption;
    }

    public String getQuestionText() {
        return questionText;
    }

    public String getThinkingOption() {
        return thinkingOption;
    }

    public String getFeelingOption() {
        return feelingOption;
    }
}
