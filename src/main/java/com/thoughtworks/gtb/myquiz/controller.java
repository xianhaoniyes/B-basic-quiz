package com.thoughtworks.gtb.myquiz;


import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class controller {
    @CrossOrigin
    @GetMapping("/:{id}")
    public String getUserName(@PathVariable int id){
        return "hello,this is xianhao";
    }


}
