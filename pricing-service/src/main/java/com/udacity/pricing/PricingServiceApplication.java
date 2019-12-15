package com.udacity.pricing;

import com.udacity.pricing.domain.price.Price;
import com.udacity.pricing.domain.price.PriceRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;

import java.math.BigDecimal;

/**
 * Creates a Spring Boot Application to run the Pricing Service.
 * TODO: Convert the application from a REST API to a microservice.
 */
@SpringBootApplication
@EnableEurekaClient
public class PricingServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(PricingServiceApplication.class, args);
    }


    /**
     * Initializes the Prices for few vehicles so as to available to the Vehicle API.
     */
    @Bean
    CommandLineRunner initDatabase(PriceRepository repository) {
        return args -> {
            for(int i=0;i<30;i++) {
                repository.save(new Price("USD", new BigDecimal(i*1000), new Long(i).longValue()));
            }
        };
    }


}
