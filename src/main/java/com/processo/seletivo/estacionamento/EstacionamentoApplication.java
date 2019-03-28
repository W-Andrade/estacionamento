package com.processo.seletivo.estacionamento;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import springfox.documentation.annotations.ApiIgnore;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@EnableSwagger2
@SpringBootApplication
public class EstacionamentoApplication {

	@Value("${swagger.path}")
	private String swaggerPath;

	public static void main(String[] args) {
		SpringApplication.run(EstacionamentoApplication.class, args);
	}
	
	@Bean
    public Docket allApi() {
        return new Docket(DocumentationType.SWAGGER_2).host(swaggerPath)
                .groupName("All")
                .apiInfo(apiInfo())
                .select()
                .paths(PathSelectors.any())
                .build()
                .ignoredParameterTypes(ApiIgnore.class)
                .enableUrlTemplating(true);
    }

	private ApiInfo apiInfo() {
		return new ApiInfoBuilder()
				.title("Estacionamento")
				.description("Estacionamento")
				.termsOfServiceUrl("http://estacionamento.com.br")
				.license("")
				.licenseUrl("https://estacionamento.com.br")
				.version("2.0")
				.build();
	}


}
