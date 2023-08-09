package COM.TY.SpringBoot_FoodApp.config;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.service.VendorExtension;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class ApplicaionConfig {

	@Bean
	public Docket getDocket() {
		Contact contact = new Contact("TCS", "www.tcs.com", "tcs@gmail.co");
		List<VendorExtension> vendorExtensions = new ArrayList<>();
		ApiInfo apiInfo = new ApiInfo("FoodApp", "to provide for in house order", "1.01", " One  year of free service",
				contact, "www.tcs.com", "www.tcs.com", vendorExtensions);
		return new Docket(DocumentationType.SWAGGER_2).select()
				.apis(RequestHandlerSelectors.basePackage("COM.TY.SpringBoot_FoodApp")).build().apiInfo(apiInfo)
				.useDefaultResponseMessages(false);
	}
}
