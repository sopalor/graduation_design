package com.cly.app;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@ComponentScan("com.cly.service")
@Configuration
@Import(Appconfig2.class)
public class Appconfig {
}
