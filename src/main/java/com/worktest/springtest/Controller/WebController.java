package com.worktest.springtest.Controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class WebController {

    @GetMapping("/")
    public ResponseEntity<String> getMessage() {
        return new ResponseEntity<>("Hello Alexey, it's Nikita", HttpStatus.OK);
    }
}
