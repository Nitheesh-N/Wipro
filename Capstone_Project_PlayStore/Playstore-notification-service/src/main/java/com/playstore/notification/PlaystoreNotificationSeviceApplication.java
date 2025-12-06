package com.playstore.notification;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class PlaystoreNotificationSeviceApplication {

	public static void main(String[] args) {
		SpringApplication.run(PlaystoreNotificationSeviceApplication.class, args);
	}

}
