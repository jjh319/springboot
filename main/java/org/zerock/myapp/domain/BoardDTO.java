package org.zerock.myapp.domain;


import lombok.Data;

@Data
public class BoardDTO {
    private Long seq;
    private String title;
    private String writer;
    private String content;

} // end class
