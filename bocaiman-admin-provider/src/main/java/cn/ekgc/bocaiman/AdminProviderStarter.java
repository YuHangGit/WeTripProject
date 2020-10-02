package cn.ekgc.bocaiman;


import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 *菠菜侠旅游租赁平台-后台管理-Provider 启动器
 * @author zyh
 * @version 1.0.0
 * @since 1.0.0
 */

//启动Cloud 微服务的EurekaClient
@EnableEurekaClient
//启动时扫描这个包下面的所有接口，防止接口没有实现
@MapperScan("cn.bocaiman.*.dao")
//标注这个是类是一个启动类
@SpringBootApplication
public class AdminProviderStarter {
	public static void main(String[] args) {
		SpringApplication.run(AdminProviderStarter.class, args);
	}
}
