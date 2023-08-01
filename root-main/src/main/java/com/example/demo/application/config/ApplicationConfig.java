package com.example.demo.application.config;

import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Log4j2
@Configuration
@Import(DAOConfig.class)

public class ApplicationConfig {

}
