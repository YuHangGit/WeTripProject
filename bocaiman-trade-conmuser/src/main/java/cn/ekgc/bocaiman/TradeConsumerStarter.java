package cn.ekgc.bocaiman;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 *菠菜侠旅游租赁平台-支付管理-Consumer 启动器
 * @author zyh
 * @version 1.0.0
 * @since 1.0.0
 */
//启动文本框架
@EnableSwagger2
//启动Cloud 的EurekaClient
@EnableEurekaClient
//提供给前端远程调用
@EnableFeignClients
//启动类注解
@SpringBootApplication
public class TradeConsumerStarter {
	public static void main(String[] args) {
		SpringApplication.run(TradeConsumerStarter.class, args);
	}
}
