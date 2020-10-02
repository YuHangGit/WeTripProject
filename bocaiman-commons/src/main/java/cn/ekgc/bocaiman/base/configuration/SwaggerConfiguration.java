package cn.ekgc.bocaiman.base.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

/**
 * <b>菠菜侠旅游租赁平台-基础功能-Swagger 配置类</b>
 * @author zyh
 * @version 1.0.0
 * @since 1.0.0
 */

@Configuration
public class SwaggerConfiguration {
	/**
	 * <b>创建Swagger 和核心对象Docket</b>
	 * @return
	 */
	@Bean
	public Docket createRestApi(){
		Docket docket = new Docket(DocumentationType.SWAGGER_2)
				//设定需要Swagger 所显示的信息
				.apiInfo(apiInfo())
				//设定Swagger 框架扫描注解的基础位置
				.select()
				.apis(RequestHandlerSelectors.basePackage("cn.ekgc.bocaiman"))
				.paths(PathSelectors.any())
				.build();
		return docket;
	}

	/**
	 * <b>Swagger 在生成文档时，所需要的一些相关信息对象</b>
	 * @return
	 */
	private ApiInfo apiInfo(){
		//创建联系人信息
		Contact contact = new Contact("张宇航","http://www.bocaiman.cn","1031689260@qq.com");
		ApiInfo apiInfo = new ApiInfoBuilder()
				//设定在生成文档时，所显示的标题
				.title("菠菜侠旅游租赁平台-交互接口文档")
				//设定文档描述信息
				.description("Spring Cloud | Swagger2")
				//设定联系人信息
				.contact(contact)
				//设定版本信息
				.version("1.0.0")
				.build();
		return apiInfo;
	}
}
