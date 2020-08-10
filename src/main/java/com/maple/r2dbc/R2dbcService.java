package com.maple.r2dbc;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import reactor.core.publisher.Mono;

@Service
@RequiredArgsConstructor
public class R2dbcService {

    private final FooRepository repository;

    @Transactional
    public Mono<Foo> test() {
        Long id = 1L;
        return repository.deleteById(id).then(repository.save(new Foo("foo")));
    }
}
