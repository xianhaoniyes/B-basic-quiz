package com.thoughtworks.gtb.myquiz;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class controller {

    @GetMapping("/:{id}")
    public String getUserName(@PathVariable int id){
        return "hello,this is xianhao";
    }


}
