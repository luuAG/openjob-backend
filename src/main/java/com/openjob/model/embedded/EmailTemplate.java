package com.openjob.model.embedded;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class EmailTemplate {
    private String templateName;
    private String subject;
    private String from;
    private String to;
    private String content;

    private List<String> variables;

}
