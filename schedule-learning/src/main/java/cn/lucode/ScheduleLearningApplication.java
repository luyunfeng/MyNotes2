package cn.lucode;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author lucode
 */
@SpringBootApplication
@RestController
@RequestMapping("/s")
@EnableScheduling
public class ScheduleLearningApplication {

	public static void main(String[] args) {
		SpringApplication.run(ScheduleLearningApplication.class, args);
	}
	@GetMapping("/hello/{cron}")
	public String hello(@PathVariable String cron){

		return "hello";
	}
}
