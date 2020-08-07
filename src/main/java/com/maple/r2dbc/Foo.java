package com.maple.r2dbc;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.data.annotation.Id;

@Data
@RequiredArgsConstructor
class Foo {
    @Id
    private Long id;
    private String name;

    public Foo(String name) {
        this.name = name;
    }
}
