/*
 * Copyright 2017 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package sjph.life.friendship;

import javax.servlet.Filter;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
//import org.springframework.context.annotation.Bean;
//import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.sleuth.Sampler;
import org.springframework.cloud.sleuth.sampler.AlwaysSampler;
import org.springframework.cloud.stream.messaging.Source;
import org.springframework.context.annotation.Bean;

import sjph.life.friendship.utils.UserContextFilter;

/**
 * Spring Boot application for friendship service.
 *
 * @author Shaohui Guo
 */
@SpringBootApplication
@RefreshScope
@EnableEurekaClient
@EnableBinding(Source.class)
//@EnableResourceServer
public class Application {

    @Bean
    public Sampler defaultSampler() {
        return new AlwaysSampler();
    }
    
    @Bean
    public Filter userContextFilter() {
        UserContextFilter userContextFilter = new UserContextFilter();
        return userContextFilter;
    }
    
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}
