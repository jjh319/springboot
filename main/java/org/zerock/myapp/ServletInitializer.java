package org.zerock.myapp;

import lombok.NoArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;


@Log4j2
@NoArgsConstructor

public class ServletInitializer extends SpringBootServletInitializer {

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		log.trace("configure({}) invoked.", application);

		// 실행클래스 이름이 변경되면, 아래 코드의 Clazz 객체도 그에 맞게 수정
		return application.sources(Chap01Application.class);
	} // configure

} // end class
