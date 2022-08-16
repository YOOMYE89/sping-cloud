package cloud.userservice.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/second-service")
public class SecondController {

    @GetMapping("/test")
    public String second() {
        return "Welcome to the Second Service";
    }

    @GetMapping("/filter")
    public String filter(@RequestHeader("sec-req") String header) {
        System.out.println("header = " + header);
        return "req header : " + header;
    }
}
