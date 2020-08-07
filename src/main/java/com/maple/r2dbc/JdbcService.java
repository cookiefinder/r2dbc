package com.maple.r2dbc;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class JdbcService {

//    private final NamedParameterJdbcTemplate jdbcTemplate;
//
//    @Transactional
//    public void test() {
//        String id = UUID.randomUUID().toString().replaceAll("-", "");
//        jdbcTemplate.update("insert into foo(id, foo) values (:id, :foo)",
//                new MapSqlParameterSource().addValue("id", id)
//                        .addValue("foo", "foo"));
//
//        User user = jdbcTemplate.queryForObject("select * from user where id = :id",
//                new MapSqlParameterSource().addValue("id", 1),
//                (rs, rowNum) -> {
//                    long id1 = rs.getLong(1);
//                    String name = rs.getString(2);
//                    return new User(id1, name);
//                });
//
//        System.out.println(user);
//    }
}

