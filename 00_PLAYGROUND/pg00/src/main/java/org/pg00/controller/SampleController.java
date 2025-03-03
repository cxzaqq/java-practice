package org.pg00.controller;


import java.util.Arrays;
import lombok.extern.log4j.Log4j2;
import org.pg00.domain.SampleDTO;
import org.pg00.domain.SampleDTOList;
import org.pg00.domain.TodoDTO;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@Log4j2
@RequestMapping("/sample")
public class SampleController {

    // /sample/basic
    @GetMapping("/basic")
    public void basic() {
        log.info("basic---------------------");
    }

    // /sample/ex01?name=AAA&age=13
    @GetMapping("/ex01")
    public void ex1(SampleDTO sampleDTO) {
        log.info("ex1---------------------");
        log.info(sampleDTO);
    }

    // /sample/ex02Array?ids=A&ids=B&ids=C
    @GetMapping("/ex02Array")
    public String ex02Array(String[] ids) {
        log.info("ex02Array-------------------");
        log.info(Arrays.toString(ids));
        return "/sample/ex2";
    }

    // /sample/ex02Bean?list%5B0%5D.name=A&list%5B0%5D.age=10&list%5B1%5D.name=A&list%5B1%5D.age=10
    // url에서 대괄호([]) 사용 불가 따라서 %5B([), %5D(]) 사용
    @GetMapping("/ex02Bean")
    public void ex02Bean(SampleDTOList list) {
        log.info(list);
    }

    @GetMapping("/ex03")
    public void ex03(TodoDTO todoDTO) {
        log.info("--------------");
        log.info(todoDTO);
    }
}
