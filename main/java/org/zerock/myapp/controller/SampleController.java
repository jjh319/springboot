package org.zerock.myapp.controller;


import lombok.NoArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.zerock.myapp.domain.SampleDTO;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

@Log4j2
@NoArgsConstructor

@RequestMapping("/sample/*")        // Base URI
@Controller
public class SampleController {


    //---------------------------------------//
    // 상세 URI : @RequestMapping or @RequestMapping("")
    //---------------------------------------//
    // "/sample/" + "" = "/sample/"
//    @RequestMapping("")
//    @RequestMapping            // Detail URI
    public String handlerMethod1() {  // Request Handler Method
        log.trace("handlerMethod1() invoked.");

        return "handlerMethod1";   // 뷰 이름을 반환
    } // handlerMethod1


    //---------------------------------------//
    // 상세 URI : @RequestMapping or @RequestMapping("")
    //---------------------------------------//
    @RequestMapping(
            path = "/handlerMethod2",
            method = { RequestMethod.GET, RequestMethod.POST }
    )
    public String handlerMethod2() {
        log.trace("handlerMethod2() invoked.");

        return "handlerMethod2";   // 뷰 이름을 반환
    } // handlerMethod2



    //---------------------------------------//
    // 단축형 어노테이션으로 메핑하자! - @GetMapping
    //---------------------------------------//

    @GetMapping("/handlerMethod3")
    public String handlerMethod3() {
        log.trace("handlerMethod3() invoked.");

        return "handlerMethod3";   // 뷰 이름을 반환
    } // handlerMethod3


    //---------------------------------------//
    // 단축형 어노테이션으로 메핑하자! - @PostMapping
    //---------------------------------------//

    @PostMapping("/handlerMethod4")
    public String handlerMethod4() {
        log.trace("handlerMethod4() invoked.");

        return "handlerMethod4";   // 뷰 이름을 반환
    } // handlerMethod4


    //---------------------------------------//
    // @GetMapping with Request Parameters
    //---------------------------------------//
    @GetMapping("/handlerMethod5")
    public String handlerMethod5(SampleDTO dto) {
        log.trace("handlerMethod5({}) invoked.",dto);

        return "handlerMethod5";   // 뷰 이름을 반환
    } // handlerMethod5


    //---------------------------------------//
    // DTO with Request Parameters
    //---------------------------------------//


    @GetMapping("/handlerMethod6")
    public String handlerMethod6( @RequestParam("name") String name1, @RequestParam("age") String age1) {
        log.trace("handlerMethod6({},{}) invoked.",name1,age1);

        return "handlerMethod6";   // 뷰 이름을 반환
    } // handlerMethod6



    //---------------------------------------//
    // Primitive Type Parameters with Request Parameters
    //---------------------------------------//

    @GetMapping("/handlerMethod7")
    public String handlerMethod7( String name, Integer age) {
        log.trace("handlerMethod7({},{}) invoked.",name,age);

        return "handlerMethod7";   // 뷰 이름을 반환
    } // handlerMethod7


    //---------------------------------------//
    // Multi-Values Request Parameters
    //---------------------------------------//

    @GetMapping("/handlerMethod8")
    public String handlerMethod8( @RequestParam("ages") ArrayList<Integer> ages) {
        log.trace("handlerMethod8({}) invoked.", ages);

        return "handlerMethod8";   // 뷰 이름을 반환
    } // handlerMethod8


    //---------------------------------------//
    // Request Parameters with Date & Time
    //---------------------------------------//
    @DateTimeFormat
    @GetMapping("/handlerMethod9")
    public String handlerMethod9(@DateTimeFormat(
//            iso = DateTimeFormat.ISO.DATE_TIME
            pattern = "yyyy-MM-ddTHH:mm"
    ) Date birthDay ) {
        log.trace("handlerMethod9({}) invoked.", birthDay);

        return "handlerMethod9";   // 뷰 이름을 반환
    } // handlerMethod9


    //---------------------------------------//
    // If return type is void
    //---------------------------------------//
    @DateTimeFormat
    @GetMapping("/handlerMethod10")
    public void handlerMethod10() {
        log.trace("handlerMethod10() invoked." );

        // View Name = Bese URI + Detail URI = "/sample/handlerMethod10"
    } // handlerMethod10


    //---------------------------------------//
    // To redirect using 'RedirectAttributes"
    //---------------------------------------//
    @GetMapping("/redirectAttributes")
    String redirectAttributes(String name, Integer age, RedirectAttributes rttrs) {
        log.trace("redirectAttributes({},{},{}) invoked.",name, age,rttrs);

        /*

         * rttrs.addFlashAttribute("name", name);
         * rttrs.addFlashAttribute("age", age);
         */

        rttrs.addAttribute("name", name);
        rttrs.addAttribute("age", age);

        return "redirect:targetURI";
    } // redirectAttributes

    @GetMapping(path="/targetURI", params = { "name","age" })
    String targetURI(String name, Integer age) {
        log.trace("targetURI({},{}) invoked.",name,age);

        return "targetURI";
    } // targetURI




} // end class
