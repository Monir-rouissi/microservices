/*
package com.order.order.config;


import io.github.resilience4j.circuitbreaker.CircuitBreaker;
import org.springframework.context.annotation.Bean;

import java.time.Duration;

@Configuration
public class CircuitBreakerConfig {

    @Bean
    public CircuitBreaker circuitBreaker() {
        CircuitBreakerConfig config = CircuitBreakerConfig.custom()
                .failureRateThreshold(50) // Define your failure rate threshold
                .waitDurationInOpenState(Duration.ofMillis(1000)) // Time to wait in Open state
                .ringBufferSizeInClosedState(5) // Maximum number of successful calls to consider
                .build();

        return CircuitBreaker.of("myCircuitBreaker", config);
    }
}
*/
