package org.zerock.myapp.domain;


import lombok.Value;

@Value
public class BoardVO {
    private Long seq;
    private String title;
    private String writer;
    private String content;

} // end class
