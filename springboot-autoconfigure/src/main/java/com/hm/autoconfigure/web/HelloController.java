package com.hm.autoconfigure.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/hello")
public class HelloController {

  @GetMapping("/sayhi")
  @ResponseBody
  public String hello() {
    return "hi";
  }

}
