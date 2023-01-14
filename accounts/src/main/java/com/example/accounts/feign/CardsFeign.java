package com.example.accounts.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@FeignClient("cards")
public interface CardsFeign {
    @RequestMapping(value = "/sayHello", method = RequestMethod.GET)
    public String sayHello ();

//    @PostMapping(value="/sayHello2")
//    public List<String> sayHello2(){
//
//    }

    @RequestMapping(value="/sayHello2", method = RequestMethod.POST)
    public List<String> sayHello2();
}
