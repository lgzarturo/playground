package com.playground.alg.fundamentos.controller

import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.ResponseBody

@Controller
class HomeController {
    @RequestMapping
    @ResponseBody
    ResponseEntity<String> home() {
        return new ResponseEntity<String>("Hola mundo desde el controller home", HttpStatus.OK)
    }
}
