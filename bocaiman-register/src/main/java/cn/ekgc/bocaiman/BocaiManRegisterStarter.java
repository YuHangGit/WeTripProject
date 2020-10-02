package cn.ekgc.bocaiman;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class BocaiManRegisterStarter {
	public static void main(String[] args) {
		SpringApplication.run(BocaiManRegisterStarter.class, args);
	}
}
