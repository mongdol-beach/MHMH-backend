package com.mondol.mhmh.topic.rqrs;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;

@Getter
@JsonFormat(shape = JsonFormat.Shape.OBJECT)
public enum SituationCardColor {
    COMPANY("E8EEFF", "5881F3", "97B2FF", "2D56CA"),
    COFFEE("FFE5DF", "F1805D", "FFAA98", "C34415"),
    TOGETHER("F1EDFF", "957AFA", "BCA9FF", "6240DE"),
    DATE("FFE9E9", "F27878", "FFB2B4", "CE383A"),
    SMALL("E7F5FF", "54ABE9", "A8DAFE", "1E81C8"),
    COUPLE("FFE5F1", "ED79AC", "FFB4D5", "CB3979"),

    COLLEAGUE("E8EEFF", "5881F3", "97B2FF", "2D56CA"),
    SENIORITY("FFE5DF", "F1805D", "FFAA98", "C34415"),
    CLUB("F1EDFF", "957AFA", "BCA9FF", "6240DE"),
    OLD_FRIEND("FFE9E9", "F27878", "FFB2B4", "CE383A"),
    FAMILY("E7F5FF", "54ABE9", "A8DAFE", "1E81C8"),
    FIRST_FRIEND("FFE5F1", "ED79AC", "FFB4D5", "CB3979");

    @JsonProperty("backgroundColor")
    private final String backgroundColor;

    @JsonProperty("mainCardColor")
    private final String mainCardColor;

    @JsonProperty("backCardColor")
    private final String backCardColor;

    @JsonProperty("boldColor")
    private final String boldColor;

    SituationCardColor(String backgroundColor, String mainCardColor, String backCardColor, String boldColor) {
        this.backgroundColor = backgroundColor;
        this.mainCardColor = mainCardColor;
        this.backCardColor = backCardColor;
        this.boldColor = boldColor;
    }

}
