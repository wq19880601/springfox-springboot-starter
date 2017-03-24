package com.dwb.middware.springboot;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * Created by walis on 2017/3/24.
 */
@Configuration
@Import(SpringFoxConfiguration.class)
@EnableSwagger2
public class SpringFoxAutoConfiguration {

}
