package cloud.gateway.config;


import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FilterConfig {

    @Bean
    public RouteLocator gatewayRoutes(RouteLocatorBuilder builder) {
        return builder.routes()
                // router 등록
                .route(r -> r.path("/first-service/**")
                             .filters(f -> f.addRequestHeader("first-req","first-req-header")
                                            .addResponseHeader("first-res","first-res-header"))
                            // 목적지 url
                             .uri("http://localhost:8081"))
                .route(r -> r.path("/second-service/**")
                             .filters(f -> f.addRequestHeader("sec-req","sec-req-header")
                                            .addResponseHeader("sec-res","sec-res-header"))
                             .uri("http://localhost:8082")
                )
                .build();
    }
}
