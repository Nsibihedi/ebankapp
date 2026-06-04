package com.pfe.ebankapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;

@SpringBootApplication
@EnableAsync
//@RequiredArgsConstructor

public class EbankappApplication {

	//private final NotificationService notificationService;

	public static void main(String[] args) {
		SpringApplication.run(EbankappApplication.class, args);
	}

	/*	@Bean
		CommandLineRunner runner() {
			return args -> {
				NotificationDTO notificationDTO = NotificationDTO.builder()
						.recipient("hedi.nsibi@gmail.com")
						.subject("Hello testing Email")
						.body("Hey There")
						.type(NotificationType.EMAIL)
						.build();

				notificationService.sendEmail(notificationDTO, new User());
			};
	}*/

}
