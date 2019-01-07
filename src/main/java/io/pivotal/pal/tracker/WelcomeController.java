package io.pivotal.pal.tracker;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WelcomeController {


    private String message;


    public WelcomeController( @Value("${WELCOME_MESSAGE}") String message) {
        this.message = message;
    }


    @GetMapping("/")
    public ResponseEntity<String> sayHello() {
        return new ResponseEntity<>(message, HttpStatus.OK);
    }
}
