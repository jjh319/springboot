package org.zerock.myapp.controller;


import lombok.NoArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.zerock.myapp.domain.SampleDTO;

@Log4j2
@NoArgsConstructor

@RequestMapping("/returnTypes/*")
@Controller
public class ReturnTypesController {
    //---------------------------------------//
    // 1. void return type
    //---------------------------------------//

    @GetMapping("/void")
    public void returnVoid() {
        log.trace("returnVoid() invoked.");

        // if void return type, View Name is equals to Request URI.
        // ex) http://localhost:8080/returnTypes/void?name=wlgns&age=23
        // returned view name is "/returnTypes/void"
        // View Resolver: /templates/returnTypes/void.html
    } // returnVoid


    //---------------------------------------//
    // 2. String return type
    //---------------------------------------//

    @GetMapping("/String")
    String returnString() {
        log.trace("returnString() invoked.");

        return "returnTypes/String";
    } // returnString



    //---------------------------------------//
    // 3. String return type -Request Forwarding
    //---------------------------------------//

    @GetMapping("/forward")
    String returnForwarding() {
        log.trace("returnForwarding() invoked.");

//        return "forward:void";  // target = /returnTypes/void
//        return "forward:/returnTypes/void.html";
//        return "forward:http://localhost:8080/returnTypes/void";
        return "forward:http://localhost:7777";
    } // returnForwarding


    //---------------------------------------//
    // 3. String return type - Redirection
    //---------------------------------------//

    @GetMapping("/redirect")
    String returnRedirect() {
        log.trace("returnRedirect() invoked.");

        return "redirect:void";
    } // returnRedirect


    //---------------------------------------//
    // Object return type using 'ResponseBody'
    //---------------------------------------//
    @ResponseBody
    @GetMapping("/object")
    SampleDTO returnObject() {
        log.trace("returnObject() invoked.");

//        return "hello,world!!";      // Convert String To JSON string
        SampleDTO dto = new SampleDTO();
        dto.setName("wlgns");
        dto.setAge(23);

        return dto;
    } // returnObject


    //---------------------------------------//
    // Object return type using 'ResponseEntity<T>' Class
    //---------------------------------------//

    @GetMapping("/responseEntity")
    ResponseEntity<SampleDTO> returnResponseEntity() {
        log.trace("returnResponseEntity() invoked.");

        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Type", "application/json; charset=utf8");

        String jsonBody = """
                {"name":"wlgns","age":23}
                """;

//        return new ResponseEntity<>(jsonBody,headers, HttpStatus.OK);
        SampleDTO dto = new SampleDTO();
        dto.setName("wlgns");
        dto.setAge(24);

        return new ResponseEntity<>(dto,headers,HttpStatus.OK);
    } // returnResponseEntity


    @GetMapping("/returnModelAttribute")
    String modelAttributeAnnotation(
            @ModelAttribute("name")
            String name2) {
        log.trace("modelAttributeAnnotation({}) invoked.", name2);


        return "returnModelAttribute";
    } // modelAttributeAnnotation


} // end class
