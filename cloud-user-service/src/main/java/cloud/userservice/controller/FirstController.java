package cloud.userservice.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/first-service")
@RequiredArgsConstructor
public class FirstController {

    private final Environment environment;

    @GetMapping("/test")
    public String first() {
        return "Welcome to the First service";
    }

    @GetMapping("/filter")
    public String filter(@RequestHeader("first-req") String header) {
        System.out.println("header = " + header);
        return "req header : " + header;
    }

    @GetMapping("/envCheck")
    public String envCheck() {
        return String.format(
          "port local.server.port : " + environment.getProperty("local.server.port")
        + "port server.port : " + environment.getProperty("server.port")
        + "token with secret : " + environment.getProperty("token.secret")
        + "token with time : " + environment.getProperty("token.expiration_time"));
    }
}
