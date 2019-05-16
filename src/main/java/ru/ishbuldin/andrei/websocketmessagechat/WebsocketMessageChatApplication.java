package ru.ishbuldin.andrei.websocketmessagechat;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class WebsocketMessageChatApplication {

	public static void main(String[] args) {
		for (String arg:args) {
			System.out.println(arg);
		}
		SpringApplication.run(WebsocketMessageChatApplication.class, args);
	}

}