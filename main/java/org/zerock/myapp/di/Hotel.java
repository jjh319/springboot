package org.zerock.myapp.di;


import lombok.Data;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Log4j2
@Data

@Component
public class Hotel {
    @Autowired
    private Chef chef;
} // end class
