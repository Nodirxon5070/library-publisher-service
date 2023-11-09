package com.company.publisherservice.dto.request;

import com.fasterxml.jackson.annotation.JsonInclude;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class PublisherRequestDto {

    @NotBlank(message = "Publisher cannot be null or empty")
    private String publisher;
    @NotBlank(message = "Location cannot be null or empty")
    private String location;

}
