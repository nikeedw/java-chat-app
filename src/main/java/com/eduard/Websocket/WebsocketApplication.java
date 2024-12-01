package com.eduard.Websocket;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.CrossOrigin;

@SpringBootApplication
@CrossOrigin(origins = "http://localhost:8088")
public class WebsocketApplication {

	public static void main(String[] args) {

		SpringApplication.run(WebsocketApplication.class, args);
	}

}
