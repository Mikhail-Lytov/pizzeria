package com.example.pizzeria.swagger;

import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class SwaggerController {
    @GetMapping(value = "/swagger")
    public void root(HttpServletResponse rsp) throws IOException {
        rsp.sendRedirect("swagger-ui/index.html");
    }
}
