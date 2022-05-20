package com.exam.booking;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.data.jpa.JpaRepositoriesAutoConfiguration;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
//(scanBasePackages = {"com.exam.booking.*"},exclude={DataSourceAutoConfiguration.class,JpaRepositoriesAutoConfiguration.class})
//@EnableJpaRepositories(basePackages = {"com.exam.booking.repository"})
public class ExamSlotBookingApplication {

	public static void main(String[] args) {
		SpringApplication.run(ExamSlotBookingApplication.class, args);
	}

}
