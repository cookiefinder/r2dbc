package com.maple.r2dbc;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.data.annotation.Id;

@Data
@AllArgsConstructor
class User {
    @Id
    private Long id;
    private String name;
}
