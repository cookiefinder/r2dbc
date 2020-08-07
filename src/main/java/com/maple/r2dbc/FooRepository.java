package com.maple.r2dbc;

import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;

@Repository
interface FooRepository extends ReactiveCrudRepository<Foo, Long> {
}
