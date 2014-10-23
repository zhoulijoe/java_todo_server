package com.zli.todo.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/echo")
public class EchoController {

   @RequestMapping(method= RequestMethod.GET)
   public @ResponseBody
   String echo(@RequestParam(value="message", required=false, defaultValue="ECHO") String message) {
      return message;
   }
}
