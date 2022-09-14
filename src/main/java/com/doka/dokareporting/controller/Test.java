package com.doka.dokareporting.controller;



import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.sql.Array;


@RequiredArgsConstructor
@RestController
@RequestMapping("/test")
public class Test {

    @GetMapping("/{id}")
    Long[] test(@PathVariable Long id) {
        return new Long[]{id};
    }
}
