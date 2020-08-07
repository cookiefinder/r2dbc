package com.maple.r2dbc;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class R2dbcService {

    private final FooRepository repository;

    @Transactional
    public void test() {
        repository.save(new Foo("foo")).subscribe(System.out::println);
        Long id  = null;
        repository.deleteById(id).subscribe(System.out::println);
    }
}
