/**
 * 
 */
package com.gl.api.core.customer;

import org.slf4j.Logger;

import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;


/**
 * @author saurabh.malik
 *
 */
@EnableDiscoveryClient
@SpringBootApplication
public class CustomerCoreServiceApplication {
    private static final Logger LOGGER = LoggerFactory.getLogger(CustomerCoreServiceApplication.class);

    /**
     * @param args
     */
    public static void main(String[] args) {
        LOGGER.info("Microservice service started-----");
        SpringApplication.run(CustomerCoreServiceApplication.class, args);

    }

    /**
     * @return
     */
    @Bean
    public RestTemplate tpRestTemplate() {
        return new RestTemplate();

    }
}
