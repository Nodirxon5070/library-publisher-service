package com.company.publisherservice.constants;

import org.springdoc.core.models.GroupedOpenApi;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfig {

    @Bean
    public GroupedOpenApi groupedByPublisherAPI(){
        String[] array = new String[]{"/publisher/create","/publisher/get/{id}","/publisher/update/{id}","/publisher/delete/{id}"};
        return GroupedOpenApi.builder()
                .group("OrdersBooks")
                .pathsToMatch(array)
                .build();
    }


}
