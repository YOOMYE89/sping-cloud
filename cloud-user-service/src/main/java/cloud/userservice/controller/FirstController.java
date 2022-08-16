package cloud.userservice.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/first-service")
public class FirstController {

    @GetMapping("/test")
    public String first() {
        return "Welcome to the First service";
    }

    @GetMapping("/filter")
    public String filter(@RequestHeader("first-req") String header) {
        System.out.println("header = " + header);
        return "req header : " + header;
    }
}
