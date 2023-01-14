package com.example.accounts.controller;

import com.example.accounts.feign.CardsFeign;
import io.github.resilience4j.retry.annotation.Retry;
import io.micrometer.core.annotation.Timed;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@RestController
@Slf4j
public class AccountsController {

    @Autowired
    CardsFeign cardsFeign;

    @GetMapping(value = "/sayHello")
    public String sayHello (HttpServletRequest request){
        return "Say Hello from Accounts";
    }

    @GetMapping(value="/sayHelloWithCards")
    public String sayHelloWithCards (HttpServletRequest request){
        String str = cardsFeign.sayHello();
        return "Say Hello from Accounts2 " + str;
    }

    @GetMapping(value = "/sayHello2WithCardsPV/{pv}")
    public Map<String, Object> sayHello2WithCardsPV (HttpServletRequest request, @PathVariable("pv") String pv){
        log.info("[sayHello2WithCardsPV] start function with pv = " + pv);
        Map<String, Object> mapToReturn = new HashMap<>();
        mapToReturn.put("list", new ArrayList<>());
        mapToReturn.put("name", "MapNamePV " + pv);
        mapToReturn.put("id", "MapIdPV");
        log.info("[sayHello2WithCardsPV] generateMap Done PV");
        return mapToReturn;
    }

    @GetMapping(value = "/sayHello2WithCards")
    @Retry(name = "sayHello2WithCards", fallbackMethod = "sayHello2WithCardsFallback")
    @Timed(value = "sayhello.time", description = "Time taken to return sayHello2WithCards")
    public Map<String, Object> sayHello2WithCards (HttpServletRequest request, @RequestParam( name = "id") String id){
        log.info("[sayHello2WithCards] start function with id = " + id);
        List<String> arr = cardsFeign.sayHello2();
        Map<String, Object> mapToReturn = new HashMap<>();
        mapToReturn.put("list", arr);
        mapToReturn.put("name", "MapName");
        mapToReturn.put("id", "MapId");
        log.info("[sayHello2WithCards] generateMap Done");
        return mapToReturn;
    }

    private Map<String, Object> sayHello2WithCardsFallback (Throwable throwable){
        log.info("[sayHello2WithCardsFallback] start function");
        Map<String, Object> mapToReturn = new HashMap<>();
        mapToReturn.put("list", null);
        mapToReturn.put("name", "MapNameFallback");
        mapToReturn.put("id", "MapIdFallback");
        return mapToReturn;
    }


}
