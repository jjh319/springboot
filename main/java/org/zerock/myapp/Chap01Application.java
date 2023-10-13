package org.zerock.myapp;

import lombok.NoArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;


@Log4j2
@NoArgsConstructor

@ServletComponentScan

@RestController
@SpringBootApplication
public class Chap01Application
		extends ServletInitializer
		implements ApplicationListener<ApplicationEvent> {

	public static void main(String[] args) {
		SpringApplication.run(Chap01Application.class, args);

		log.trace("main({}) invoked.", Arrays.toString(args));
	} // main

	@GetMapping("/")
	List<String> hello() {
		log.trace("hello() invoked.");

		return List.<String>of("NAME_1","NAME_2","NAME_3");
	} // hello

	@Override
	public void onApplicationEvent(ApplicationEvent event) {
//		log.trace("onApplicationEvent({}) invoked.", event);

	} // onApplicationEvent

} // end class
