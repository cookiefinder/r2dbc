package com.maple.r2dbc;

import lombok.Data;
import org.springframework.data.annotation.Id;

@Data
class Foo {
    @Id
    private Long id;
    private String name;

    Foo(String name) {
        this.name = name;
    }
}
