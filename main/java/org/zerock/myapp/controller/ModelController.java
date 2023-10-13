package org.zerock.myapp.controller;

import lombok.NoArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.support.SessionStatus;
import org.zerock.myapp.domain.SampleDTO;
import org.zerock.myapp.domain.User;

@Log4j2
@NoArgsConstructor

@SessionAttributes({"__CREDENTIAL__"})
@Controller
public class ModelController {

    @GetMapping(path="/authenticate", params = {"username", "password"})
    String authenticate(String username, String password, Model model) {
        log.trace("======================================");
        log.trace("authenticate({}, {}) invoked.", username, password);
        log.trace("======================================");

        // Step1. 인증검사결과 인증에 성공
        Boolean isAuthenticated = true;

        // Step2. 세션스콥(금고상자)에 넣을 인증정보(Credential) 생성
        User user = new User();
        user.setUsername(username);
        user.setPassword(password);

        // Step3. Model 상자 안에 인증 정보 객체를 넣는다.
        model.addAttribute("__CREDENTIAL__", user);

        return "void";
    } // authenticate

    @GetMapping("/logout")
    String logout(SessionStatus sessionStatus) {
        log.trace("==========================");
        log.trace("logout({}) invoked.", sessionStatus);
        log.trace("===========================");

        // SessionStatus 객체의 메소드를 이용해서 현재 브라우저에 할당된 세션(금고상자) 파괴
        sessionStatus.setComplete();

        return "redirect:/";
    } // logout

    @GetMapping(path="/transfer/{money}", params={"targetAccount"})
    String transfer(
            @PathVariable("money")
            Integer transferMoney,

            String targetAccount,
//            @ModelAttribute("__CREDENTIAL__") User user
            @SessionAttribute(name="__CREDENTIAL__", required = false) User user
    ) {
        log.trace("transfer({},{},{}) invoked.", transferMoney, targetAccount, user);

        if(user != null) { // 인증성공한 브라우저 요청이다!
            //계좌이체 로직 수행

            return "transfer";
        } else {
            return "redirect:/";
        } // if-else


    } // transfer


    @ModelAttribute("__KEY__")
    public SampleDTO callback() {
        log.trace("**************************");
        log.trace("callback() invoked.");
        log.trace("*************************");

        SampleDTO dto = new SampleDTO();
        dto.setName("apple");
        dto.setAge(30);

        return dto;
    }

    @GetMapping("/returnModel")
    String returnModel(Model model) {
        log.trace("returnModel({}) invoked.", model);

        SampleDTO dto = new SampleDTO();
        dto.setName("apple");
        dto.setAge(40);

        model.addAttribute("__MODEL__", dto);

        return "returnModel";
    } // returnModel

    @GetMapping("/modelAttribute")
    String modelAttributeAnnotation(@ModelAttribute("name") String name2) {
        log.trace("modelAttributeAnnotation({}) invoked.", name2);

        return "returnModelAttribute";
    } // modelAttributeAnnotation

} // end class