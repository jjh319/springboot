package org.zerock.myapp;

import lombok.NoArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.zerock.myapp.di.Hotel;
import org.zerock.myapp.di.Restaurant;

import static org.assertj.core.api.Assertions.assertThat;

@Log4j2
@NoArgsConstructor

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)

@SpringBootTest
class DependencyInjectionTests {
	@Autowired
	private Restaurant restaurant;
	@Autowired
	private Hotel hotel;

	@BeforeAll
	void beforeAll() {
		log.trace("beforeAll() invoked.");

		assertThat(this.restaurant).isNotNull();
		log.info("\t this.restaurant: {}", this.restaurant);

		assertThat(this.hotel).isNotNull();
		log.info("\t this.hotel: {}", this.hotel);
	} // beforeAll


//	@Disabled
	@Tag("fast")
	@Test
	@Order(1)
	@DisplayName("contextLoads")
	@Timeout(1L)
	void contextLoads() {
		log.trace("contextLoads() invoked.");
	}

} // end class
