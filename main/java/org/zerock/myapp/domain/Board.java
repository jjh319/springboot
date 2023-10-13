package org.zerock.myapp.domain;


import lombok.Data;

@Data
public class Board {
    private Long seq;
    private String title;
    private String writer;
    private String content;

} // end class
