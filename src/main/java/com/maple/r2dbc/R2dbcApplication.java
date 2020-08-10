package com.maple.r2dbc;

import io.r2dbc.spi.ConnectionFactory;
import lombok.RequiredArgsConstructor;
import org.flywaydb.core.Flyway;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.core.env.Environment;
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
    private final Environment env;

    public static void main(String[] args) {
        SpringApplication.run(R2dbcApplication.class, args);
    }

    @GetMapping("/users/{id}")
    public Mono<String> getUserById(@PathVariable Long id) {
        // this will return empty; flatMap() isn't execute when mono is void
//        Mono<Void> mono = Mono.empty();
//        return mono.flatMap(v -> Mono.just("success"));

        return service.test().map(Foo::getName);
    }

    @Bean
    public ConnectionFactoryInitializer initializer(ConnectionFactory connectionFactory) {
        ConnectionFactoryInitializer initializer = new ConnectionFactoryInitializer();
        initializer.setConnectionFactory(connectionFactory);
        return initializer;
    }

    // because can't config spring.datasource, so we must inject bean Flyway
    @Bean(initMethod = "migrate")
    public Flyway flyway() {
        return new Flyway(Flyway.configure()
                .baselineOnMigrate(true)
                .dataSource(
                        env.getRequiredProperty("spring.flyway.url"),
                        env.getRequiredProperty("spring.flyway.user"),
                        env.getRequiredProperty("spring.flyway.password"))
        );
    }
}
