package com.maple.r2dbc;

import io.r2dbc.spi.ConnectionFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.r2dbc.connectionfactory.init.ConnectionFactoryInitializer;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@SpringBootApplication
@RestController
@RequiredArgsConstructor
public class R2dbcApplication {

//    private final JdbcService service;
    private final R2dbcService service;

    public static void main(String[] args) {
        SpringApplication.run(R2dbcApplication.class, args);
    }

    @GetMapping("/users/{id}")
    public Mono<String> getUserById(@PathVariable Long id) {
        // this will return empty; flatMap() isn't execute when mono is void
//        Mono<Void> mono = Mono.empty();
//        return mono.flatMap(a -> Mono.just("s"));

        return service.test().then(Mono.just("success")); // this will return "success"
    }

    @Bean
    public ConnectionFactoryInitializer initializer(ConnectionFactory connectionFactory) {
        ConnectionFactoryInitializer initializer = new ConnectionFactoryInitializer();
        initializer.setConnectionFactory(connectionFactory);
        return initializer;
    }
}
