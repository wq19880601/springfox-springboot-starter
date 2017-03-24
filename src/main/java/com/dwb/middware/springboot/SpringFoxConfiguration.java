package com.dwb.middware.springboot;

import static com.google.common.collect.Lists.newArrayList;

import com.google.common.base.Predicate;
import com.google.common.base.Strings;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMethod;
import springfox.documentation.RequestHandler;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.builders.ResponseMessageBuilder;
import springfox.documentation.schema.ModelRef;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * Created by walis on 2017/3/24.
 */
@Configuration
@ConditionalOnClass({Docket.class})
@EnableConfigurationProperties(SpringFoxProperties.class)
@EnableSwagger2
public class SpringFoxConfiguration {

  @Autowired
  private SpringFoxProperties springFoxProperties;

  @Bean
  public Docket init() {
    return new Docket(DocumentationType.SWAGGER_2).select().apis(getApis())
        .paths(pathMatch()).build().pathMapping(springFoxProperties.getPathMapping())
        .apiInfo(createApiInfo())
        .genericModelSubstitutes(ResponseEntity.class).useDefaultResponseMessages(false)
        .globalResponseMessage(RequestMethod.GET,
            newArrayList(new ResponseMessageBuilder().code(500)
                .message("500 message").responseModel(new ModelRef("Error")).build()))
        .enableUrlTemplating(true);

  }


  private ApiInfo createApiInfo() {
    Contact contact = new Contact(springFoxProperties.getContactName(), null,
        springFoxProperties.getEmail());
    return new ApiInfoBuilder().title(springFoxProperties.getTitle())
        .description(springFoxProperties.getDescription()).version(springFoxProperties.getVersion())
        .contact(contact).license("Apache License Version 2.0").build();
  }


  private Predicate<RequestHandler> getApis() {
    return springFoxProperties.isDocSwitch() ? RequestHandlerSelectors.any()
        : RequestHandlerSelectors.none();
  }

  private Predicate<String> pathMatch() {
    boolean matchedPath = Strings.isNullOrEmpty(springFoxProperties.getPathMatch());
    return matchedPath ? PathSelectors.any()
        : PathSelectors.regex(springFoxProperties.getPathMatch());
  }

}
